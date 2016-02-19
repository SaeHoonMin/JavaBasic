package com.sist.server;
/*
 *     1) 서버 가동 
 *         = ServerSocket (교환 소켓)
 *         = Socket (통신 소켓)
 *         
 *         ServerSocket ss=
 *            new ServerSocket(PORT); ==> 50
 *            ==> bind() => Scoket에 ip,port를 심어준다
 *                          전화기 개통
 *                listen() => 대기상태 
 *     2) 대기상태 => 접속시 처리 
 *           ss.accept(); => 클라이언트가 접속을 했을 경우에만 
 *                           호출(신호)
 *           accept() => 리턴형 : 클라이언트의 정보 
 *                       ip,port
 *           ***** port (서버:고정,클라이언트:임시(자동 생성))
 *           port : 0~65535 (0~1023)
 *           메모리에 클라이언트 정보를 저장 
 *      ==================================
 *        쓰레드가 시작(통신)
 *        BufferedReader : 요청을 받는다 : readLine
 *           처리
 *        OutputStream : 결과값을 전송 : write
 *        
 *        close() : 종료
 *      
 *      ==================================
 *         
 */
import java.net.*;
import java.io.*;
import java.util.*;
public class Server implements Runnable{
    ServerSocket ss;
    Vector<Client> waitVc=
    		new Vector<Client>();
    // 서버 가동 
    public Server()
    {
    	try
    	{
    		ss=new ServerSocket(5260);
    		// bind(),listen(): 대기상태
    		System.out.println("Server Start...");
    	}catch(Exception ex){}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Server server=new Server();
        new Thread(server).start();
	}
    //접속 처리 
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try
		{
			while(true)
			{
				Socket s=ss.accept();
				// s: 클라이언트의 ip,port
				Client client=new Client(s);
				// 통신시작
				client.start();
				waitVc.addElement(client);
			}
		}catch(Exception ex){}
	}
    ///////////////////////// ServerSocket
	///// 통신 시작 
	class Client extends Thread
	{
		Socket s;
		BufferedReader in;
		OutputStream out;
		public Client(Socket s)
		{
			// 읽어오는 메모리 위치   in
			// 전송하는 메모리 위치  out
			try
			{
				this.s=s;
				in=new BufferedReader(new InputStreamReader(s.getInputStream()));
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
					String msg=in.readLine();
					for(Client client:waitVc)
					{
						client.out.write((msg+"\n").getBytes());
					}
				}
			}catch(Exception ex){}
		}
	}
}




