package com.client;
import com.server.*;
import com.common.*;
import java.util.Scanner;
public class Client {
	Server server=new Server();
    public void connection()
    {
    	server.accept();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Client client=new Client();
        client.server.start();
        client.connection();
        Scanner scan=new Scanner(System.in);
        while(true)
        {
        	System.out.print("요청번호 입력:");
        	int num=scan.nextInt();
        	client.server.readwrite(num);
        	if(num==999)
        		break;
        }
        client.server.end();
	}

}
