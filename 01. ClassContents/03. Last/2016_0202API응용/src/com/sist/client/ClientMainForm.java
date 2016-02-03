package com.sist.client;
import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import java.util.StringTokenizer;
import java.net.*;
import java.io.*;
public class ClientMainForm extends JFrame 
implements ActionListener,Runnable
{
    Login login=new Login();
    WaitRoom wr=new WaitRoom();
    CardLayout card=new CardLayout();
    Socket s;
    BufferedReader in;
    OutputStream out;
    ClientMainForm() 
    {
		setLayout(card);// BorderLayout
		
		add("LOG",login);
		add("WR",wr);
		setSize(800, 600);
		setVisible(true);
		login.b1.addActionListener(this);
		login.b2.addActionListener(this);
		//setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	    setResizable(false);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			 UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
		}catch(Exception ex){}
        new ClientMainForm();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==login.b1)
		{
			String id=login.tf.getText();
			String name=login.pf.getText();
			String sex="";
			if(login.man.isSelected())
				 sex="남자";
			else
				 sex="여자";
			String sendData=id+"|"+name+"|"+sex+"\n";
			
			//System.out.println(sendData);
			/*card.show(getContentPane(), "WR");
			
			StringTokenizer st=
					new StringTokenizer(sendData, "|");
			String[] data={st.nextToken(),
					       st.nextToken(),
					       st.nextToken(),
					       "대기실"};
			wr.model2.addRow(data);*/
			try
			{
				s=new Socket("211.238.142.46", 5260);
				in=new BufferedReader(
	    				new InputStreamReader(s.getInputStream()));
	    			out=s.getOutputStream();
	    	    out.write((sendData).getBytes());
			}catch(Exception ex){}
			new Thread(this).start();
			card.show(getContentPane(), "WR");
		}
		else if(e.getSource()==login.b2)
		{
			System.exit(0);
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try
		{
			System.out.println(" thread start ");
			while(true)
			{
				String msg=in.readLine();
				
				System.out.println(msg);
				
				StringTokenizer st=
					new StringTokenizer(msg, "|");
				String[] data={st.nextToken(),
					       st.nextToken(),
					       st.nextToken(),
					       st.nextToken()};
			    wr.model2.addRow(data);
			}
		}catch(Exception ex){}
	}

}
