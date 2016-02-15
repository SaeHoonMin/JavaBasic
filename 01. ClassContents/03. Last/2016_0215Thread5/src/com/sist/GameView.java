package com.sist;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
public class GameView extends JPanel{
    Image back,move;
    Image chong;
    int x,y;
    Graphics gg;
    
    ArrayList<Point> bullets = new ArrayList<Point>();
    
    public int getBulletCount()
    {
    	return bullets.size();
    }
    
    public GameView()
    {
    	setOpaque(true);
    	x=340;
    	y=430;
    	back=Toolkit.getDefaultToolkit().getImage("./image/sky.png");
    	move=Toolkit.getDefaultToolkit().getImage("./image/spider1.png");
    	chong=Toolkit.getDefaultToolkit().getImage("./image/w0.png");   
    }
    public void paint(Graphics g)
    {
    	gg=g;
    	g.drawImage(back, 0,0,getWidth(),getHeight(),this);
    	g.drawImage(move, x,y,this);
    	for(int i=0;i<bullets.size();i++)
    	{
    		Point p = bullets.get(i);
    		g.drawImage(chong,p.x,p.y,GameView.this);
    	}
    }
    
    class ChongThread extends Thread{
    
    	Point p = new Point() ;
    	public ChongThread(int mx, int my)
    	{
    		p.x = mx;
    		p.y = my;
    	}
    	public void run()
    	{
    		bullets.add(p);
    		try{
    			while(true){
    				p.y-=5;
    				if(p.y<0)
    				{
    					p.y = -30;
    					break;
    				}
    				repaint();
    				Thread.sleep(10);
    			}
    			bullets.remove(p);
    		}catch(Exception ex)
    		{
    			
    		}
    	}
    }
}





