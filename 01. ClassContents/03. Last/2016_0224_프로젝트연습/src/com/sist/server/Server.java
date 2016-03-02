package com.sist.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.Vector;

import com.sist.common.Function;
import com.sist.server.Server.Client;


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
    	String id,pos;
    	boolean bCheck;
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
	    					id=st.nextToken();
	    					pos="대기실";
	    					// 접속자 전원에게 메세지 전송 
	    					messageAll(Function.LOGIN+"|"+id+"|"+pos);
	    					// 접속자 추가
	    					waitVc.addElement(this);
	    					messageTo(Function.MYLOG+"|"+id);
	    					// 상대방의 정보 전송 
	    					for(Client client:waitVc)
	    					{
	    						messageTo(Function.LOGIN+"|"
	    								+client.id+"|"
	    								+client.pos);
	    					}
	    					// 방정보 
	    					for(Room room:roomVc)
	    					{
	    						messageTo(Function.MAKEROOM+"|"
		    							+room.roomName+"|"
		    							+room.current+"/"+room.inwon);
	    					}
	    				}
	    				break;
	    				
	    				case Function.CHATEND:
	    				{
	    					
	    				}
	    				break;
	    				case Function.MAKEROOM:
	    				{
	    					Room room=new Room(st.nextToken(),
	    							Integer.parseInt(st.nextToken()));
	    					messageAll(Function.MAKEROOM+"|"
	    							+room.roomName+"|"
	    							+room.current+"/"+room.inwon);
	    					pos=room.roomName;
	    					room.roomJJang=id;
	    					
	    					room.userVc.addElement(this);
	    					roomVc.addElement(room);
	    					
	    					messageTo(Function.MYROOMIN+"|"+id+"|"+room.roomName+"|"+room.roomJJang);
	    					messageAll(Function.ROOMUPDATE+"|"
	    					      +id+"|"+pos);
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
	    										+"|[알림 ☞"+id+"님이 입장하셨습니다]");
	    								client.messageTo(Function.ROOMIN+"|"
	    		   							     +id+"|"
	    		   							     +room.roomJJang);
	    								client.messageTo(Function.GAMEINIT+"|");	
	    							}
	    							// 들어가는 사람 처리
	    							messageTo(Function.MYROOMIN+"|"
	   	   							     +id+"|"
	   	   							     +room.roomName+"|"
	   	   							     +room.roomJJang);
	    							room.userVc.addElement(this);
	    							for(Client client:room.userVc)
	    							{
	    								if(!id.equals(client.id))
	    								{
	    									messageTo(Function.ROOMIN+"|"
		    		   							     +client.id+"|"
		    		   							     +room.roomJJang);
	    									messageTo(Function.GAMEINIT+"|");	
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
	    					
	    				}
	    				break;
	    				case Function.GAMEREADY:
	    				{
	    					String rn=st.nextToken();
	    					for(int i=0;i<roomVc.size();i++)
	    					{
	    						Room room=roomVc.elementAt(i);
	    						if(rn.equals(room.roomName))
	    						{
	    							for(int j=0;j<room.userVc.size();j++)
	    							{
	    								Client client=room.userVc.elementAt(j);
	    								if(client.id.equals(id))
	    								{
	    									bCheck=true;
	    								}
	    							}
	    							if(room.userVc.elementAt(0).bCheck==true 
	    								&& room.userVc.elementAt(1).bCheck==true)
	    							{
	    								for(int j=0;j<room.userVc.size();j++)
		    							{
		    								Client client=room.userVc.elementAt(j);
		    								client.messageTo(Function.GAMEREADY+"|"+room.roomJJang);
		    							}
	    							}
	    						}
	    					}
	    				}
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
