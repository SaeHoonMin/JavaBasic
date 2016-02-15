package com.sist;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;


public class MainClass extends JFrame implements ActionListener, Runnable{

	JProgressBar bar1, bar2, bar3;
	
	JLabel la1,la2,la3,la4;
	
	JTextField tf1,tf2,tf3;
	
	JButton b1,b2;
	
	public MainClass()
	{
		la1 = new JLabel("¿î¼¼",JLabel.CENTER);
		la1.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,30));
		la2 = new JLabel("±ÝÀü¿î",JLabel.CENTER);
		la2.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,15));
		la3 = new JLabel("¾ÖÁ¤¿î",JLabel.CENTER);
		la3.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,15));
		la4 = new JLabel("°Ç°­¿î",JLabel.CENTER);
		la4.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,15));
		
		tf1 = new JTextField();
		tf2 = new JTextField();
		tf3 = new JTextField();
		tf1.setHorizontalAlignment(JLabel.CENTER);
		tf2.setHorizontalAlignment(JLabel.CENTER);
		tf3.setHorizontalAlignment(JLabel.CENTER);
		
		b1 = new JButton("¿î¼¼º¸±â");
		b2 = new JButton("Á¾·á");
		
		bar1 = new JProgressBar();
		bar1.setMinimum(0);
		bar1.setMaximum(100);
		bar1.setBackground(Color.white);
		bar1.setForeground(Color.yellow);
		bar1.setStringPainted(true);
		bar2 = new JProgressBar();
		bar2.setMinimum(0);
		bar2.setMaximum(100);
		bar2.setBackground(Color.white);
		bar2.setForeground(Color.black);
		bar2.setStringPainted(true);
		bar3 = new JProgressBar();
		bar3.setMinimum(0);
		bar3.setMaximum(100);
		bar3.setBackground(Color.white);
		bar3.setForeground(Color.pink);
		bar3.setStringPainted(true);
		
		setLayout(null);
		la1.setBounds(10,15,600,35);
		
		la2.setBounds(10,75,50,30);
		bar1.setBounds(65,75,450,30);
		tf1.setBounds(520,75,90,30);
		
		la3.setBounds(10,110,50,30);
		bar2.setBounds(65,110,450,30);
		tf2.setBounds(520,110,90,30);
		
		la4.setBounds(10,145,50,30);
		bar3.setBounds(65,145,450,30);
		tf3.setBounds(520,145,90,30);
		
		JPanel p = new JPanel();
		p.add(b1);
		p.add(b2);
		p.setBounds(10, 180, 600, 35);
		
		add(p);
		add(la1);
		add(la2);add(bar1);add(tf1);
		add(la3);add(bar2);add(tf2);
		add(la4);add(bar3);add(tf3);
		setSize(640,380);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
	}
	
	public static void main(String[] args) {
		new MainClass();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == b2) {
			
			dispose();
			System.exit(0);

		} else if (e.getSource() == b1) {
			new Thread(this).start();
		}
	}
	
	public void go ()
	{
		try
		{
			Random rand = new Random();
			int a = rand.nextInt(101);
			int b = rand.nextInt(101);
			int c = rand.nextInt(101);
			for(int i=0;i<=a;i++)
			{
				bar1.setValue(i);
				Thread.sleep(50);
			}for(int i=0;i<=b;i++)
			{
				bar2.setValue(i);
				Thread.sleep(50);
			}for(int i=0;i<=c;i++)
			{
				bar3.setValue(i);
				Thread.sleep(50);
			}
			
			tf1.setText(a+"%");
			tf2.setText(b+"%");
			tf3.setText(c+"%");
		}catch(Exception e)
		{
			
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		go();
	}

}
