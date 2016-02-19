package com.sist.server;
import java.util.*;
import java.io.*;
import java.net.*;
import com.sist.common.*;
import com.sist.dao.*;
public class Server implements Runnable{
    // ���� ���� 
	ServerSocket ss;
	// port
	final int PORT=3355;
	// ������ ������ ���� 
	Vector<Client> waitVc=new Vector<Client>();
	// �������� ���� 
	Vector<Room>  roomVc=new Vector<Room>();
	public Server()
	{
		try
		{
			MemberDAO dao=MemberDAO.newInstance();
			dao.memberAllUpdate();
			ss=new ServerSocket(PORT);
			/*
			 *   bind()
			 *   listen()
			 */
			System.out.println("Server Start...");
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	// ���ӽ� ==> ������ ���� (��ſ���)
	public void run()
	{
		try
		{
			while(true)
			{
				Socket s=ss.accept();
				// s=> client�� ����(ip,port)
				// Thread�� ���� => ��� 
				Client client=new Client(s);
				client.start();
				// ��Ž��� 
			}
		}catch(Exception ex){}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Server server=new Server();
        new Thread(server).start();
	}
	// ��� => Server�� ��系���� ���� : ����Ŭ���� 
    class Client extends Thread
    {
    	String id,name,sex,pos;
    	int avata;
    	// ��� 
    	Socket s;
    	BufferedReader in;
    	OutputStream out;
    	public Client(Socket s)
    	{
    		try
    		{
    			this.s=s;
    			in=new BufferedReader(
    					new InputStreamReader(
    							s.getInputStream()));
    			out=s.getOutputStream();
    		}catch(Exception ex){}
    	}
    	// ��� 
    	public void run()
    	{
    		try
    		{
    			while(true)
    			{
    				// Ŭ���̾�Ʈ => ��û���� �޴´�
    				String msg=in.readLine();
    				StringTokenizer st=
    					new StringTokenizer(msg, "|");
    				// 100|id|sex|name|avata
    				int protocol=Integer.parseInt(st.nextToken());
    				switch(protocol)
    				{
	    				case Function.LOGIN:
	    				{
	    					// ������ �����Ѵ�
	    					String userid=st.nextToken();
	    					String pwd=st.nextToken();
	    					
	    					MemberDAO dao=MemberDAO.newInstance();
	    					String res=dao.isLogin(userid, pwd);
	    					if(res.equals("NOID"))
	    					{
	    						messageTo(Function.NOID+"|"+userid);
	    					}
	    					else if(res.equals("NOPWD"))
	    					{
	    						messageTo(Function.NOPWD+"|");
	    					}
	    					else
	    					{
	    					  MemberDTO d=dao.memberInfoData(userid);
	    					  id=d.getId();
	    					  sex=d.getSex();
	    					  name=d.getName();
	    					  avata=d.getAvata();
	    					  pos="����";
	    					  int type=d.getType();
	    					  if(type==0)
	    					  {
	    					    // ���ǿ� �ִ� ������� ���� ����
	    					    messageAll(Function.LOGIN+"|"+id+"|"
	    							+name+"|"+sex+"|"+pos);
	    					    // ����
	    					    waitVc.addElement(this);
	    					    messageTo(Function.MYLOG+"|"+id);
	    					    for(Client client:waitVc)
	    					    {
	    						  messageTo(Function.LOGIN+"|"
	    					            +client.id+"|"
		    							+client.name+"|"
	    					            +client.sex+"|"
		    							+client.pos);
	    					    }
	    					    dao.memberUpdate(id, 1);
	    					  }
	    					  else
	    					  {
	    						 messageTo(Function.MULTIID+"|"); 
	    					  }
	    				
	    					// ������ �� ����
	    					  for(Room room:roomVc)
	    					  {
	    						  messageTo(Function.MAKEROOM+"|"
		    							  +room.roomName+"|"+
		    							  room.roomState+"|"+
		    							  room.current+"/"+room.inwon);
	    					  }
	    					}
	    				}
	    				break;
	    				case Function.WAITCHAT:
	    				{
	    					String data=st.nextToken();
	    					messageAll(Function.WAITCHAT+"|["+name+"]"+data);
	    				}
	    				break;
	    				case Function.CHATEND:
	    				{
	    					messageAll(Function.CHATEND+"|"+id);
	    					messageTo(Function.MYCHATEND+"|");
	    					for(int i=0;i<waitVc.size();i++)
	    					{
	    						Client client=waitVc.elementAt(i);
	    						if(id.equals(client.id))
	    						{
	    							MemberDAO dao=MemberDAO.newInstance();
	    							dao.memberUpdate(id, 0);
	    							waitVc.removeElementAt(i);
	    							in.close();
	    							out.close();
	    							break;
	    						}
	    					}
	    				}
	    				break;
	    				case Function.MAKEROOM:
	    				{
	    					Room room=new Room(st.nextToken(),
	    							  st.nextToken(),st.nextToken(),
	    							  Integer.parseInt(st.nextToken()));
	    					
	    					messageAll(Function.MAKEROOM+"|"
	    							  +room.roomName+"|"+
	    							  room.roomState+"|"+
	    							  room.current+"/"+room.inwon);
	    					messageTo(Function.MYROOMIN+"|");
	    					room.roomBang=id;
	    					pos=room.roomName;
	    					room.userVc.addElement(this);
	    					roomVc.addElement(room);
	    				}
	    				break;
    				}
    				
    			}
    		}catch(Exception ex){}
    	}
    	// ������� ���������� ���� 
    	public synchronized void messageTo(String msg)
    	{
    		try
    		{
    			out.write((msg+"\n").getBytes());
    		}catch(Exception ex)
    		{
    			for(int i=0;i<waitVc.size();i++)
    			{
    				Client client=waitVc.elementAt(i);
    				if(id.equals(client.id))
    				{
    					waitVc.removeElementAt(i);
    					break;
    				}
    			}
    		}
    	}
    	// ��ü������ ���� 
    	public synchronized void messageAll(String msg)
    	{
    		for(int i=0;i<waitVc.size();i++)
    		{
    			Client client=waitVc.elementAt(i);
    			try
    			{
    				client.messageTo(msg);
    			}catch(Exception ex)
    			{
    				waitVc.removeElementAt(i);
    			}
    		}
    	}
    }
}




