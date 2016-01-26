package com.sist;
import java.awt.*;
import javax.swing.*;
public class GameView extends JPanel{
   Image back,move;
   int x=680,y=480;
   // 생성자 ==> update(){clearRect()} => paint()
   // repaint() ==> 로딩 ,윈도우 크기 변경 
    
   public GameView()
   {
	   back=Toolkit.getDefaultToolkit().getImage("c:\\image\\back.jpg");
	   move=Toolkit.getDefaultToolkit().getImage("c:\\image\\left.gif");
       new MoveTest().start();
   }
	@Override
	public void paint(Graphics g) {
		g.drawImage(back, 0, 0, getWidth(),
				getHeight(),this);
		g.drawImage(move, x, y, this);
	}
    class MoveTest extends Thread
    {
    	public void run()
    	{
    		try
    		{
    			while(true)
    			{
    				x-=5;
    				if(x<0)
    					x=800;
    				Thread.sleep(10);
    			}
    		}catch(Exception ex){}
    	}
    }
}



