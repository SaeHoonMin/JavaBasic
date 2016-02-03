package com.sist;
import java.awt.*;
import javax.swing.*;
public class BookPanel extends JPanel{
     Image poster;
     String path="c:\\image\\";
     public BookPanel()
     {
    	 poster=Toolkit.getDefaultToolkit().getImage(path+"1.jpg");
     }
     public void setPoster(int no)
     {
    	 poster=Toolkit.getDefaultToolkit().getImage(path+no+".jpg");
     }
     public void paint(Graphics g)
     {
    	 g.drawImage(poster,0,0,getWidth(),getHeight(),this);
     }
}
