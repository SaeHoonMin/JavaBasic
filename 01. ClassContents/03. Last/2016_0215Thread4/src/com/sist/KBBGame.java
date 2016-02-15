package com.sist;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class KBBGame extends JFrame
implements ActionListener,Runnable,MouseListener{
    JLabel la;
    JLabel com,user;
    JButton b1,b2;
    String [] data = {"b.png","c.png","a.png"};
    int tIndex;

	boolean bThread;
	
	
	UserSelect us = new UserSelect();
	int kbb = 0;
	
    public KBBGame()
    {
    	la=new JLabel("가위바위보게임");
    	la.setFont(new Font("맑은 고딕",Font.BOLD,30));
    	com=new JLabel(new ImageIcon("./image/a.png"));
    	user=new JLabel(new ImageIcon("./image/a.png"));
    	b1=new JButton("Start");
    	b2=new JButton("Stop");
    	JPanel p1=new JPanel();
    	p1.add(la);
    	JPanel p2=new JPanel();
    	p2.add(com);
    	p2.add(user);
    	JPanel p3=new JPanel();
    	p3.add(b1);
    	p3.add(b2);
    	
    	add("North",p1);
    	add("Center",p2);
    	add("South",p3);
    	
    	setSize(350,300);
    	setVisible(true);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	
    	b1.addActionListener(this);
    	b2.addActionListener(this);
    	us.la1.addMouseListener(this);
    	us.la2.addMouseListener(this);
    	us.la3.addMouseListener(this);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new KBBGame();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			while(bThread)
			{
				com.setIcon(new ImageIcon("./image/"+data[tIndex]));
				tIndex++;
				if(tIndex>2)
					tIndex=0;
				Thread.sleep(100);
			}
		}catch(Exception ex)
		{
			
		}
	}
	
	public void result()
	{
		int res = kbb - tIndex;
		switch(res)
		{
		case -1:
		case 2:
			JOptionPane.showMessageDialog(this, "Player Win");
			break;
		case 1:
		case -2:
			JOptionPane.showMessageDialog(this, "Thread Win");
			break;
		case 0:
			JOptionPane.showMessageDialog(this, "Draw!");
			break;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1)
		{
			if(bThread==false)
			{
				bThread = true;
				new Thread(this).start();
				us.setVisible(true);
			}
		}
		else if(e.getSource()==b2)
		{
			bThread = false;
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==us.la1)
		{
			kbb=0;
		}
		else if(e.getSource()==us.la2)
		{
			kbb=1;
		}
		else if(e.getSource()==us.la3)
		{
			kbb=2;
		}
		user.setIcon(new ImageIcon("./image/"+data[kbb]));
		us.setVisible(false);
		bThread=false;
		result();
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
