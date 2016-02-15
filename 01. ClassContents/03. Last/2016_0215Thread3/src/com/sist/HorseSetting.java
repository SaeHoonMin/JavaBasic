package com.sist;

import java.awt.*;
import javax.swing.*;

public class HorseSetting extends JFrame{
	
	JLabel [] la = new JLabel[5];
	JTextField [] tf = new JTextField[5];
	JButton b1,b2;
	
	public HorseSetting()
	{
		setLayout(null);
		for(int i=0;i<5;i++)
		{
			la[i] = new JLabel((i+1)+"번말");
			tf[i] = new JTextField();
			la[i].setBounds(10, 15 + (i*35), 40, 30);
			tf[i].setBounds(55,15 + (i*35),150,30);
			add(la[i]);
			add(tf[i]);
		}
		b1 = new JButton("설정");
		b2 = new JButton("취소");
		JPanel p = new JPanel();
		p.add(b1);
		p.add(b2);
		
		p.setBounds(10,185,195,35);
		add(p);
		setSize(230,270);
//		setVisible(true);
		
	}

}
