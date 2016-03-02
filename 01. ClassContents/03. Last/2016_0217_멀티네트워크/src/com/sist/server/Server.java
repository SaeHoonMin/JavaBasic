package com.sist.server;
import java.util.*;
import java.io.*;
import java.net.*;
import com.sist.common.*;
import com.sist.dao.*;
public class Server implements Runnable{
    // 서버 가동 
	ServerSocket ss;
	// port
	final int PORT=3355;
	// 접속자 정보를 저장 
	Vector<Client> waitVc=new Vector<Client>();
	// 방정보를 저장 
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
	// 접속시 ==> 쓰레드 생성 (통신연결)
	public void run()
	{
		try
		{
			while(true)
			{
				Socket s=ss.accept();
				// s=> client의 정보(ip,port)
				// Thread로 전송 => 통신 
				Client client=new Client(s);
				client.start();
				// 통신시작 
			}
		}catch(Exception ex){}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Server server=new Server();
        new Thread(server).start();
	}
	// 통신 => Server의 모든내용을 공유 : 내부클래스 
    class Client extends Thread
    {
    	String id,name,sex,pos;
    	int avata;
    	// 통신 
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
    	// 통신 
    	public void run()
    	{
    		try
    		{
    			while(true)
    			{
    				// 클라이언트 => 요청값을 받는다
    				String msg=in.readLine();
    				StringTokenizer st=
    					new StringTokenizer(msg, "|");
    				// 100|id|sex|name|avata
    				int protocol=Integer.parseInt(st.nextToken());
    				switch(protocol)
    				{
	    				case Function.LOGIN:
	    				{
	    					// 정보를 저장한다
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
	    					  pos="대기실";
	    					  int type=d.getType();
	    					  if(type==0)
	    					  {
	    					    // 대기실에 있는 사람에게 정보 전송
	    					    messageAll(Function.LOGIN+"|"+id+"|"
	    							+name+"|"+sex+"|"+pos);
	    					    // 저장
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
	    				
	    					// 개설된 방 정보
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
	    					
	    					room.roomBang=id;
	    					pos=room.roomName;
	    					room.userVc.addElement(this);
	    					roomVc.addElement(room);
	    					messageTo(Function.MYROOMIN+"|"
	   							     +id+"|"+name+"|"
	   							     +sex+"|"+avata+"|"
	   							     +room.roomName+"|"
	   							     +room.roomBang);
	    					messageAll(Function.POSCHANGE+"|"+id+"|"+pos);
	    				}
	    				break;
	    				case Function.MYROOMIN:
	    				{
	    					/*
	    					 *   1. 방을 찾기
	    					 *   2. 위치변경
	    					 *   3. 현재인원 증가 
	    					 *   4. 들어가 있는 사람
	    					 *      = 들어가는 사람의 정보
	    					 *      = 입장메세지 
	    					 *   5. 들어가는 사람
	    					 *      = 대기실=>채팅방으로 변경
	    					 *      = 들어가 있는 사람들의 정보 
	    					 *   6. 대기실
	    					 */
	    					String rn=st.nextToken();
	    					for(Room room:roomVc)
	    					{
	    						if(rn.equals(room.roomName))
	    						{
	    							room.current++;
	    							pos=room.roomName;
	    							for(Client client:room.userVc)
	    							{
	    								client.messageTo(Function.ROOMCHAT
	    										+"|[알림 ☞"+name+"님이 입장하셨습니다]");
	    								client.messageTo(Function.ROOMIN+"|"
	    		   							     +id+"|"+name+"|"
	    		   							     +sex+"|"+avata+"|"
	    		   							     +room.roomBang);
	    										
	    							}
	    							// 들어가는 사람 처리
	    							messageTo(Function.MYROOMIN+"|"
	   	   							     +id+"|"+name+"|"
	   	   							     +sex+"|"+avata+"|"
	   	   							     +room.roomName+"|"
	   	   							     +room.roomBang);
	    							room.userVc.addElement(this);
	    							for(Client client:room.userVc)
	    							{
	    								if(!id.equals(client.id))
	    								{
	    									messageTo(Function.ROOMIN+"|"
		    		   							     +client.id+"|"
	    											 +client.name+"|"
		    		   							     +client.sex+"|"
	    											 +client.avata+"|"
		    		   							     +room.roomBang);
	    								}
	    							}
	    							messageAll(Function.WAITUPDATE+"|"
	    									+room.roomName+"|"
	    									+room.current+"|"
	    									+room.inwon+"|"
	    									+id+"|"
	    									+pos);
	    						}
	    					}
	    				}
	    				break;
	    				case Function.ROOMOUT:
	    				{
	    					/*
	    					 *   1. 방을 찾기
	    					 *   2. 위치변경
	    					 *   3. 현재인원 증가 
	    					 *   4. 들어가 있는 사람
	    					 *      = 들어가는 사람의 정보
	    					 *      = 입장메세지 
	    					 *   5. 들어가는 사람
	    					 *      = 대기실=>채팅방으로 변경
	    					 *      = 들어가 있는 사람들의 정보 
	    					 *   6. 대기실
	    					 */
	    					String rn=st.nextToken();
	    					int i=0;
	    					for(Room room:roomVc)
	    					{
	    						if(rn.equals(room.roomName))
	    						{
	    							
	    							room.current--;
	    							pos="대기실";
	    							if(id.equals(room.roomBang))
	    							{
	    								if(room.current!=0)
	    								{
	    									room.roomBang=room.userVc.elementAt(1).id;
	    									String str=room.userVc.elementAt(1).name;
	    									for(Client client:room.userVc)
	    									{
	    										if(!id.equals(client.id))
	    										{
	    											client.messageTo(Function.BANGCHANGE+"|"+room.roomBang+"|"+str);
	    										}
	    									}
	    								}
	    							}
	    							for(Client client:room.userVc)
	    							{
	    								client.messageTo(Function.ROOMCHAT
	    										+"|[알림 ☞"+name+"님이 퇴장하셨습니다]");
	    								client.messageTo(Function.ROOMOUT+"|"+id+"|"+name);
	    										
	    							}
	    							// 들어가는 사람 처리
	    							int k=0;
	    							for(Client client:room.userVc)
	    							{
	    								if(id.equals(client.id))
	    								{
	    									messageTo(Function.MYROOMOUT+"|");
	    									room.userVc.removeElementAt(k);
	    									
	    								}
	    								k++;
	    							}
	    							messageAll(Function.WAITUPDATE+"|"
	    									+room.roomName+"|"
	    									+room.current+"|"
	    									+room.inwon+"|"
	    									+id+"|"
	    									+pos);
	    							if(room.current<1)
	    							{
	    								roomVc.removeElementAt(i);
	    								break;
	    							}
	    						}
	    						i++;
	    					}
	    				}
	    				break;
    				}
    				
    			}
    		}catch(Exception ex){}
    	}
    	// 결과값을 개인적으로 전송 
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
    	// 전체적으로 전송 
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




