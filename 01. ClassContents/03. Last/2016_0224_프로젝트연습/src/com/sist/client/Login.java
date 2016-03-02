package com.sist.client;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JPanel{
    JLabel la1;
    JTextField tf;
    
    JButton b1,b2;
    Image img;
    Login()
    {
   	 img=Toolkit.getDefaultToolkit().getImage("c:\\image\\back.jpg");
        setLayout(null);// FlowLayout
        la1=new JLabel("ID");
        
        tf=new JTextField();
        
        
        b1=new JButton("login");
        b2=new JButton("cancel");
        // ¹èÄ¡
        la1.setBounds(10, 15, 40, 30);
        la1.setForeground(Color.white);
        tf.setBounds(55, 15, 150, 30);
       
        
        JPanel p=new JPanel();
        p.add(b1);
        p.add(b2);
        p.setBounds(10, 85, 195, 35);
        p.setOpaque(false);
        add(la1);
        add(tf);
       
        add(p);
        
    }
	 @Override
	 protected void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, getWidth(),getHeight(),this);
	 }
    
}
