package com.sist;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
public class MainClass2 extends JFrame
implements ActionListener
{
    JTextField tf;
    JButton bu;
    JTextArea ta;
    public MainClass2()
    {
    	tf=new JTextField(30);
    	bu=new JButton("GO");
    	ta=new JTextArea();
    	JScrollPane js=new JScrollPane(ta);
    	JPanel p=new JPanel();
    	p.add(tf);
    	p.add(bu);
    	
    	add("North",p);
    	add("Center",js);
    	setSize(800, 600);
    	setVisible(true);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	tf.addActionListener(this);
    	bu.addActionListener(this);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new MainClass2();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==tf || e.getSource()==bu)
		{
			try
			{
				ta.setText("");
			   String str=tf.getText().trim();
			   if(str.length()<1)
			   {
				   JOptionPane.showMessageDialog(this,
						   "URL를 압력하세요");
				   return;
			   }
			   URL url=new URL(str);
			   HttpURLConnection conn=
					   (HttpURLConnection)url.openConnection();
			   StringBuffer sb=new StringBuffer();
			   if(conn!=null)
			   {
				   BufferedReader in=
					new BufferedReader(
							new InputStreamReader(
									conn.getInputStream(), "UTF-8"));
				   
				   while(true)
				   {
					   String s=in.readLine();
					   if(s==null)
						   break;
					   sb.append(s+"\n");
				   }
				   ta.append(sb.toString());
			   }
			   
			}catch(Exception ex){}
		}
	}

}



