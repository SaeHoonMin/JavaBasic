package com.sist.client;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GameView extends JPanel{
    JButton[][] pan=new JButton[5][5];
    int[][] panCount=new int[5][5];
    public GameView()
    {
    	setLayout(new GridLayout(5,5,5,5));
    	int k=1;
    	for(int i=0;i<5;i++)
    	{
    		for(int j=0;j<5;j++)
    		{
    			pan[i][j]=new JButton(String.valueOf(k));
    			k++;
    			add(pan[i][j]);
    		}
    	}
    }
    public void btnInit()
    {
    	for(int i=0;i<5;i++)
    	{
    		for(int j=0;j<5;j++)
    		{
    			pan[i][j].setText("");
    			pan[i][j].setEnabled(false);
    			
    		}
    	}
    }
    public void getRand()
    {
    	int[] temp=new int[25];
    	int su=0;
    	boolean bDash=false;
    	for(int i=0;i<25;i++)
    	{
    		bDash=true;
    		while(bDash)
    		{
    			// 난수 발생 
    			su=(int)(Math.random()*25)+1;
    			bDash=false;
    			for(int j=0;j<i;j++)
    			{
    				if(temp[j]==su)
    				{
    					bDash=true;//while이동
    					break;
    				}
    			}
    		}
    		temp[i]=su;
    		panCount[i/5][i%5]=temp[i];
    	}
    }
    public void display(int no)
    {
    	for(int i=0;i<5;i++)
    	{
    		for(int j=0;j<5;j++)
    		{
    			if(no==1)
    			{
    			  pan[i][j].setText(String.valueOf(panCount[i][j]));
    			  pan[i][j].setEnabled(true);
    			}
    			else
    			{
    				pan[i][j].setText("");
    				pan[i][j].setEnabled(false);
    			}
    			
    		}
    	}
    }
    public void btnClick(int no)
    {
    	for(int i=0;i<5;i++)
    	{
    		for(int j=0;j<5;j++)
    		{
    			String str=pan[i][j].getText();
    			if(no==Integer.parseInt(str))
    			{
    				pan[i][j].setBackground(Color.pink);
    				pan[i][j].setEnabled(false);
    			}
    		}
    	}
    }
    public void btnClickYou(int no)
    {
    	for(int i=0;i<5;i++)
    	{
    		for(int j=0;j<5;j++)
    		{
    			
    			if(no==panCount[i][j])
    			{
    				pan[i][j].setBackground(Color.pink);
    				pan[i][j].setEnabled(false);
    			}
    		}
    	}
    }
    
}

