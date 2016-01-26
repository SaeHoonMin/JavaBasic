package com.sist.game;
import java.awt.*;
import javax.swing.*;
public class MainClass extends JFrame{
    GameView gv=new GameView();
    public MainClass()
    {
    	add("Center",gv);
    	setSize(335, 470);
    	setVisible(true);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new MainClass();
	}

}
