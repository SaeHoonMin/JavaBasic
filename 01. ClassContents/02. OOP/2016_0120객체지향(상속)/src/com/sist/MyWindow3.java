package com.sist;

import javax.swing.*;
import java.awt.*;

public class MyWindow3 extends JFrame {

	JTabbedPane tp;
	public MyWindow3()
	{
		tp = new JTabbedPane();
		JPanel p1 = new JPanel();
		p1.setBackground(Color.red);
		
		JPanel p2 = new JPanel();
		p2.setBackground(Color.blue);
		
		JPanel p3 = new JPanel();
		p3.setBackground(Color.MAGENTA);
		
		tp.setTabPlacement(tp.BOTTOM);
		tp.addTab("red", p1);
		tp.addTab("blue",p2);
		tp.addTab("Magenta", p3);
		
		add("Center",tp);
		setSize(640,480);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyWindow3();
	}

}
