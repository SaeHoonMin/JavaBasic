package com.sist;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MouseMain extends JFrame implements MouseListener{
	JButton b1,b2;
	public MouseMain(){
		
		b1 = new JButton("로그인");
		b2 = new JButton("취소");
		
		b1.addMouseListener(this);
		b2.addMouseListener(this);
		
		JPanel p = new JPanel();
		
		p.add(b1);
		p.add(b2);
		add("Center",p);
		setSize(300,250);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public static void main(String [] args)
	{
		new MouseMain();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		JButton b = (JButton) e.getSource();
		
		if(b==b1)
			b1.setForeground(Color.green);
		else if(b==b2)
			b2.setForeground(Color.red);
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		JButton b = (JButton) e.getSource();
		if(b==b1)
			b1.setForeground(Color.black);
		else if(b==b2)
			b2.setForeground(Color.black);
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
