package com.sist.client;
import java.awt.*;
import javax.swing.*;
public class Login extends JPanel{
     JLabel la1,la2,la3;
     JTextField tf;
     JTextField pf;
     JButton b1,b2;
     JRadioButton man,woman;
     Image img;
     Login()
     {
    	 img=Toolkit.getDefaultToolkit().getImage("c:\\image\\back.jpg");
         setLayout(null);// FlowLayout
         la1=new JLabel("ID");
         la2=new JLabel("PW");
         la3=new JLabel("성별");
         tf=new JTextField();
         pf=new JTextField();
         man=new JRadioButton("남자");
         woman=new JRadioButton("여자");
         ButtonGroup bg=new ButtonGroup();
         bg.add(man);
         bg.add(woman);
         man.setSelected(true);
         b1=new JButton("login");
         b2=new JButton("cancel");
         // 배치
         la1.setBounds(10, 15, 40, 30);
         la1.setForeground(Color.white);
         tf.setBounds(55, 15, 150, 30);
         
         la2.setBounds(10, 50, 40, 30);
         la2.setForeground(Color.white);
         pf.setBounds(55, 50, 150, 30);
         
         la3.setBounds(10, 85, 40, 30);
         la3.setForeground(Color.white);
         man.setBounds(55, 85, 70, 30);
         woman.setBounds(130, 85, 70, 30);
         
         man.setOpaque(false);
         woman.setOpaque(false);
         
         JPanel p=new JPanel();
         p.add(b1);
         p.add(b2);
         p.setBounds(10, 120, 195, 35);
         p.setOpaque(false);
         add(la1);
         add(tf);
         add(la2);
         add(pf);
         add(la3);add(man);add(woman);
         add(p);
         
     }
	 @Override
	 protected void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, getWidth(),getHeight(),this);
	 }
     
}
