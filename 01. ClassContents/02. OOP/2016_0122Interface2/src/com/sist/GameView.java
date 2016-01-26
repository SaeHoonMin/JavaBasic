package com.sist;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class GameView extends JPanel{
	Image back, move;
	int x,y;
	public GameView()
	{
		back = Toolkit.getDefaultToolkit().getImage("c:\\image\\back.png");
		move = Toolkit.getDefaultToolkit().getImage("c:\\image\\enter.gif");
	}
	
	public void paint(Graphics g)
	{

		g.drawImage(back, 0, 0, getWidth(),getHeight(),this);
		g.drawImage(move, x, y, this);
	}
}
