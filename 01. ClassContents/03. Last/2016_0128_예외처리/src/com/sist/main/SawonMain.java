package com.sist.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class SawonMain extends JFrame implements ActionListener{
	
	SawonLogin login = new SawonLogin ();
	SawonList sList = new SawonList();
	JTabbedPane tp;
	
	public SawonMain()
	{
		tp = new JTabbedPane();
		tp.addTab("로그인", login);
		tp.addTab("사원 목록", sList);
		
		tp.setEnabledAt(1, false);
		
		add("Center",tp);
		setSize(640,480);
		setVisible(true);
	
		login.b1.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new SawonMain();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() ==login.b1)
		{
			tp.setEnabledAt(0, false);		
			tp.setEnabledAt(1, true);
			tp.setSelectedIndex(1);
		}
	}

}
