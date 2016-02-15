package com.sist;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class GameMain extends JFrame
implements KeyListener{
    GameView gv=new GameView();
    public GameMain()
    {
    	add("Center",gv);
    	setSize(800, 600);
    	setVisible(true);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	addKeyListener(this);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new GameMain();
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode())
		{
		case KeyEvent.VK_LEFT:
			gv.x-=5;
			if(gv.x<0)
				gv.x=0;
			break;
		case KeyEvent.VK_RIGHT:
			gv.x+=5;
			if(gv.x>660)
				gv.x=660;
			break;
		case KeyEvent.VK_SPACE:
			if(gv.getBulletCount()<40)
			{
				try {
					Thread.sleep(5);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				gv.new ChongThread(gv.x+60, gv.y).start();
			}
			break;
		case KeyEvent.VK_ESCAPE:
			System.exit(0);
			break;
		}
		gv.repaint();
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
