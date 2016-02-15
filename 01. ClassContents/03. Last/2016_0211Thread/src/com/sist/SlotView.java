package com.sist;
import java.awt.*;
import javax.swing.*;
public class SlotView extends JPanel{
    Image[][] img=new Image[3][3];
    String path="./image/";
    JLabel[][] la=new JLabel[3][3];
    public SlotView()
    {
    	setLayout(new GridLayout(3, 3,5,5));
    	for(int i=0;i<3;i++)
    	{
    		for(int j=0;j<3;j++)
    		{
    			int rnd=(int)(Math.random()*9)+1;
    			img[i][j]=Toolkit.getDefaultToolkit().getImage(path+rnd+".jpg");
    			la[i][j]=new JLabel(new ImageIcon(img[i][j]));
    			add(la[i][j]);
    		}
    	}
    }
    public void drawImage()
    {
    	for(int i=0;i<3;i++)
    	{
    		for(int j=0;j<3;j++)
    		{
    			int rnd=(int)(Math.random()*9)+1;
    			img[i][j]=Toolkit.getDefaultToolkit().getImage(path+rnd+".jpg");
    			la[i][j].setIcon(new ImageIcon(img[i][j]));
    			
    		}
    	}
    }
    public Image setImage(String filename,int w,int h)
    {
    	ImageIcon ii=new ImageIcon(filename);
    	Image i=ii.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
    	return i;
    }
}
