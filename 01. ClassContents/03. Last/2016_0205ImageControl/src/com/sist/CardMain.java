package com.sist;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CardMain extends JFrame implements  ActionListener{
	
	JPanel my, you;
	
	JButton b1,b2;

	String path = "./image/";
	public CardMain()
	{
		my = new JPanel();
		my.setBackground(Color.black);
		you = new JPanel();
		you.setBackground(Color.black);
		b1 = new JButton("카드보기");
		b2 = new JButton("종료");
		setLayout(null);
		my.setBounds(10, 15, 120,150);
		you.setBounds(180, 15, 120, 150);
		
		my.setLayout(new BorderLayout());
		my.add("Center",new JLabel(new ImageIcon(setImage(path+"back.png",my.getWidth(),my.getHeight()))));
		you.setLayout(new BorderLayout());
		you.add("Center",new JLabel(new ImageIcon(setImage(path+"back.png",my.getWidth(),my.getHeight()))));
		
		JPanel p = new JPanel();
		p.add(b1);
		p.add(b2);
		p.setBounds(10,180,290,35);
		
		b1.setBounds(10,180,290,35);
		b1.setIcon(new ImageIcon(setImage("./image/5.gif",20,20)));	 
		b1.setRolloverIcon(new ImageIcon(setImage("./image/6.gif",20,20)));
		add(my);
		add(you);
		add(p);
		
		setSize(325,255);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		b1.addActionListener(this);
	}
	
	public Image setImage(String filename, int w, int h)
	{
		ImageIcon ic = new ImageIcon(filename);
		Image i = ic.getImage().getScaledInstance(w,h,Image.SCALE_SMOOTH);
		return i;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CardMain();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1)
		{
			Random rand = new Random();
			int a= rand.nextInt(13)+1;
			int b= rand.nextInt(13)+1;
			my.removeAll();
			you.removeAll();
			my.setLayout(new BorderLayout());
			my.add("Center",new JLabel(new ImageIcon(setImage(path+"1_"+a+".png",my.getWidth(),my.getHeight()))));
			you.setLayout(new BorderLayout());
			you.add("Center",new JLabel(new ImageIcon(setImage(path+"1_"+b+".png",my.getWidth(),my.getHeight()))));
			my.validate();
			you.validate();
		}
	}

}
