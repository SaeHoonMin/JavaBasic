package com.sist;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class GameRoom extends JFrame implements ActionListener{
    BongoPanel myPanel=new BongoPanel();
    BongoPanel youPanel=new BongoPanel();
    JPanel my=new JPanel();
    JPanel you=new JPanel();
    JTextField myid=new JTextField();
    JTextField youid=new JTextField();
    JTextArea ta;
    JTextField tf;
    JButton b1,b2,b3;
    public GameRoom()
    {
    	ta=new JTextArea();
    	JScrollPane js=new JScrollPane(ta);
    	tf=new JTextField();
    	b1=new JButton("시작");
    	b2=new JButton("준비");
    	b3=new JButton("나가기");
    	my.setBackground(Color.black);
    	you.setBackground(Color.black);
    	
    	setLayout(null);
    	my.setBounds(10, 15,180, 150);
    	you.setBounds(350, 15, 180,150);
    	myid.setBounds(10, 170, 180, 30);
    	youid.setBounds(350, 170, 180, 30);
    	myPanel.setBounds(10, 210, 520, 320);
    	js.setBounds(540, 15, 230, 200);
    	tf.setBounds(540, 220, 230, 30);
    	youPanel.setBounds(540, 260, 230, 180);
    	myPanel.btnInit();
    	
    	youPanel.btnInit();
    	JPanel p=new JPanel();
    	p.setLayout(new GridLayout(3, 1,5,5));
    	p.add(b1);
    	p.add(b2);
    	p.add(b3);
    	p.setBounds(540, 450, 230, 80);
    	add(my);
    	add(you);
    	add(myid);
    	add(youid);
    	add(myPanel);
    	add(js);
    	add(tf);
    	add(youPanel);
    	add(p);
    	setSize(800, 600);
    	setVisible(true);
    	b2.addActionListener(this);
    	for(int i=0;i<5;i++)
    	{
    		for(int j=0;j<5;j++)
    		{
	    		myPanel.pan[i][j].addActionListener(this);
    		}
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new GameRoom();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b2)
		{
			myPanel.getRand();
	    	myPanel.display();
	    	
	    	youPanel.getRand();
		}
		for(int i=0;i<5;i++)
    	{
    		for(int j=0;j<5;j++)
    		{
	    		if(e.getSource()==myPanel.pan[i][j])
	    		{
	    			myPanel.btnClick(Integer.parseInt(myPanel.pan[i][j].getText()));
	    			youPanel.btnClick(Integer.parseInt(myPanel.pan[i][j].getText()));
	    		}
    		}
    	}
	}

}
