package com.io;
import java.io.*;
import java.net.*;
public class MainClass5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try
        {
        	/*BufferedReader in=
        		new BufferedReader(
        				new InputStreamReader(System.in));
        	System.out.println("입력값:");
        	String msg=in.readLine();
        	System.out.println(msg);*/
        	/*
        	 *  키보드 입력값을 받는 경우
        	 *  BufferedReader in=
        		new BufferedReader(
        				new InputStreamReader(System.in));
        	          파일 입력값
        	    BufferedReader in=
        		new BufferedReader(
        				new InputStreamReader(new FileInputStream("파일명"));  
        	          네트워크
        	    BufferedReader in=
        		new BufferedReader(
        				new InputStreamReader(socket.getInputStream()));  
        	    웹서버 이용
        	    BufferedReader in=
        		new BufferedReader(
        				new InputStreamReader(url.openConnection().getInputStream()));  
        	 */
        	/*URL url=new URL("http://www.daum.net");
        	HttpURLConnection conn=
        		 (HttpURLConnection)url.openConnection();
        	if(conn!=null)
        	{
        		BufferedReader in=
        			new BufferedReader(new InputStreamReader(conn.getInputStream()));
        		while(true)
        		{
        			String msg=in.readLine();
        			System.out.println(msg);
        			if(msg==null)break;
        		}
        	}*/
        	/*BufferedReader in=
        		new BufferedReader(new InputStreamReader(new FileInputStream("c:\\image\\io.txt")));
        	while(true)
        	{
        		String msg=in.readLine();
        		if(msg==null)break;
        		System.out.println(msg);
        	}*/
        	System.out.print("입력:");
        	int data=System.in.read();
        	System.out.println((char)data);
        }catch(Exception ex){}
	}

}





