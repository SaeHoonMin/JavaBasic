package com.sist;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MyWindow4 extends JFrame implements ActionListener{
	
	boolean isGameStarted;
	
	JButton [][] bu = new JButton[3][3];
	int [][] panCount = new int [3][3];
	int brow, bcol;
	JButton b1,b2;
	
	public MyWindow4()
	{
		isGameStarted = false;
		JPanel p  = new JPanel();
		p.setLayout(new GridLayout(3,3,5,5));
		int k=1;
		for(int i=0;i<3; i++)
		{
			for (int j=0;j<3;j++)
			{
				bu[i][j] = new JButton(String.valueOf(k++));
				bu[i][j].setFont(new Font("¸¼Àº °íµñ",Font.BOLD,20));
				bu[i][j].addActionListener(this);
				p.add(bu[i][j]);
				
			}
		}
		
		b1 = new JButton("½ÃÀÛ");
		b1.addActionListener(this);
		b2 = new JButton("Á¤Áö");
		b2.addActionListener(this);
		JPanel p1 = new JPanel();
		p1.add(b1);
		p1.add(b2);
		
		add("South",p1);
		add("Center",p);
		setSize(600,400);
		setVisible(true);
		
	}
	
	public void getRand()
	{
		int [] temp = new int[9];
		int su;
		for(int i=0;i<9;i++)
		{
			su = (int) (Math.random()*9)+1;
			temp[i] = su;
			panCount[i/3][i%3] = su;
			for(int j=0;j<i;j++)
			{
				if(temp[j]==su)
				{
					i--;
					break;
				}
			}
		}
	}
	public void display()
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(panCount[i][j]==9)
				{
					bu[i][j].setText("");
					bu[i][j].setEnabled(false);
					brow=i;
					bcol=j;
				}
				else
				{
					bu[i][j].setText(String.valueOf(panCount[i][j]));
					bu[i][j].setEnabled(true);
				}
			}
		}
		isGameStarted=true;
	}
	
	public boolean check()
	{
		boolean clear = true;
		int k=1;
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(panCount[i][j]==k)
					k++;
				else
				{
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyWindow4();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Object obj = e.getSource();
		
		if(obj==b1)
		{
			getRand();
			display();
		}
		else if(obj ==b2)
		{
			System.exit(0);
		}
		
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(e.getSource().equals(bu[i][j]) && isGameStarted==true)
				{
					if(!((brow==i && Math.abs(bcol-j)==1) 
							|| (bcol==j && Math.abs(brow-i)==1)))
						return;
					
					panCount[brow][bcol] = panCount[i][j];
					panCount[i][j] = 9;
					brow = i;
					bcol = j;
					display();
					if(check())
					{
						JOptionPane.showMessageDialog(this, "Game Over");
						System.exit(0);
					}
				}
			}
		}
	}

}
