package com.sist;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class SlotMain extends JFrame
implements Runnable, ActionListener
{
    SlotView sv=new SlotView();
    JButton b1,b2;
    static boolean bThread = false;
    
    Thread thread=null;
    
    public SlotMain()
    {
    	b1=new JButton("Start");
    	b2=new JButton("Stop");
    	JPanel p=new JPanel();
    	p.add(b1);
    	p.add(b2);
    	add("Center",sv);
    	add("South",p);
    	setSize(300, 350);
    	setVisible(true);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	
    	b1.addActionListener(this);
    	b2.addActionListener(this);
    //	new Thread(this).start();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new SlotMain();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try
		{
			while(bThread)
			{
				sv.drawImage();
				Thread.sleep(100);
			}
			thread = null;
		}catch(Exception ex){}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1)
		{
			bThread = true;
			
			if(thread ==null)
			{
				thread = new Thread(this);
				thread.start();
			}
		}
		else if(e.getSource()==b2)
		{
			bThread=false;
		}
	}
    
}
