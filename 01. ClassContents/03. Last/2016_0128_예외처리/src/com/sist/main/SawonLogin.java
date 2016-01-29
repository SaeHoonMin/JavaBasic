package com.sist.main;
import java.awt.*;
import javax.swing.*;
public class SawonLogin extends JPanel{
     JLabel la1,la2;
     JTextField tf;
     JPasswordField pf;
     JButton b1,b2;
     public SawonLogin()
     {
    	 // 메모리 할당 (클래스초기화)
    	 la1=new JLabel("사번");
    	 la2=new JLabel("이름");
    	 tf=new JTextField();
    	 pf=new JPasswordField();
    	 b1=new JButton("Login");
    	 b2=new JButton("Cancel");
    	 
    	 // 배치
    	 setLayout(null);
    	 la1.setBounds(10, 15, 30, 30);
    	 tf.setBounds(45, 15, 150, 30);
    	 
    	 la2.setBounds(10, 50, 30, 30);
    	 pf.setBounds(45, 50, 150, 30);
    	 
    	 JPanel p=new JPanel();
    	 p.add(b1);
    	 p.add(b2);
    	 
    	 p.setBounds(10, 85, 185, 35);
    	 
    	 //윈도우에 배치
    	 add(la1);add(tf);
    	 add(la2);add(pf);
    	 add(p);
     }
}






