package com.sist.client;
import java.awt.*;
import javax.swing.*;
public class Login extends JPanel{
     JLabel la1,la2;
     JTextField tf;
     JPasswordField pf;
     JButton b1,b2;
     Image img;
     Login()
     {
    	 img=Toolkit.getDefaultToolkit().getImage("c:\\image\\back.png");
         setLayout(null);// FlowLayout
         la1=new JLabel("ID");
         la2=new JLabel("PW");
         tf=new JTextField();
         pf=new JPasswordField();
         b1=new JButton("login");
         b2=new JButton("cancel");
         // ��ġ
         la1.setBounds(10, 15, 40, 30);
         la1.setForeground(Color.white);
         tf.setBounds(55, 15, 150, 30);
         
         la2.setBounds(10, 50, 40, 30);
         la2.setForeground(Color.white);
         pf.setBounds(55, 50, 150, 30);
         
         JPanel p=new JPanel();
         p.add(b1);
         p.add(b2);
         p.setBounds(10, 85, 195, 35);
         p.setOpaque(false);
         add(la1);
         add(tf);
         add(la2);
         add(pf);
         add(p);
         
     }
	 @Override
	 protected void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, getWidth(),getHeight(),this);
	 }
     
}
