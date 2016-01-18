package com.sist.client;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ClientMainForm extends JFrame implements ActionListener{
	
    Login login=new Login();
    WaitRoom wr=new WaitRoom();
    CardLayout card=new CardLayout();
    ClientMainForm() 
    {
		setLayout(card);// BorderLayout

		add("LOG",login);
		add("WR",wr);
		
		setSize(800, 600);
		setVisible(true);
		
		login.b1.addActionListener(this);
		login.b2.addActionListener(this);
		wr.b6.addActionListener(this);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
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
		if(e.getSource().equals(login.b1))
		{
			card.show(getContentPane(), "WR");
		}
		else if(e.getSource().equals(login.b2))
		{
			System.exit(0);
		}
		else if(e.getSource().equals(wr.b6))
		{
			card.show(getContentPane(), "LOG");
		}
	}

}
