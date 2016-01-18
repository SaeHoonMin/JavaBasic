package com.seny;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainClass {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame jf = new JFrame ("btntest");
		JPanel jp = new JPanel();
		jp.setLayout(new FlowLayout());
		
		jf.setSize(400, 500);
		jf.setLayout(new BorderLayout());
		
		TransBtn btn1 = new TransBtn();
		TransBtn btn2 = new TransBtn();

		jp.add(btn1);
		jp.add(btn2);
		jf.add(jp,BorderLayout.CENTER);
		jf.setVisible(true);

	}

}
