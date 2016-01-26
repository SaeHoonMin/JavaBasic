package com.sist;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SelectedAvatar extends JFrame{
	
	JLabel la;
	
	public SelectedAvatar()
	{
		la = new JLabel(" ");
		add("Center",la);
		setSize(120,170);
		
		setVisible(true);
	}
	
	public void set(int index,int selNum)
	{
		la.setIcon(new ImageIcon("c:\\image\\"+(index==0?"m":"w")+""+selNum+".gif"));
	}

}
