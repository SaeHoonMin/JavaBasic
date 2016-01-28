package com.sist;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BaseBallGame extends JFrame implements ActionListener{

	JTextArea ta;
	JTextField tf;
	JButton b1,b2;
	int [] com = new int[3];
	int [] user = new int[3];
	
	public BaseBallGame(){
		
		ta = new JTextArea();
		ta.setEditable(false);
		JScrollPane js = new JScrollPane(ta);
		tf = new JTextField(10);
		b1 = new JButton("Start");
		b2 = new JButton("Exit");
		tf.setEnabled(false);
		JPanel p = new JPanel();
		p.add(tf);
		p.add(b1);
		p.add(b2);
		
		add("Center",js);
		add("South",p);
		setSize(350,350);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		tf.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
	}
	
	//³­¼ö
	public void getRand()
	{
		int su = 0;
		for(int i=0;i<3;i++)
		{
			su = (int)(Math.random()*9)+1;
			com[i]=su;
			for(int j=0;j<i;j++)
			{
				if(com[i]==com[j])
				{
					i--;
					break;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new BaseBallGame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == b1)
		{
			getRand();
			JOptionPane.showMessageDialog(this, "Let The Game Begin");
			b1.setEnabled(false);
			tf.setEnabled(true);
			tf.requestFocus();
		}
		else if(e.getSource()==b2)
		{
			dispose();
			System.exit(0);
		}
		else if(e.getSource()==tf)
		{
			String strNum = tf.getText().trim();
			int num=0;
			try{
				num = Integer.parseInt(strNum);
			}
			catch (NumberFormatException ex)
			{
				errorDialog("Integer Input Only");
				return;
			}
			
			if(num<100 || num>999)
			{
				errorDialog("3 Digit Integer Only");
				return;
			}
			
			user[0] = num/100;
			user[1] = (num%100)/10;
			user[2] = (num%10);
			if(user[0]==user[1] || user[1]==user[2] || user[0]==user[2])
			{
				errorDialog("Each number of digit must different");
				return;
			}
			
			int s=0;
			int b=0;
			for(int i=0;i<3;i++)
			{
				for (int j=0;j<3;j++)
				{
					if(com[i]==user[j])
					{
						if(i==j)
							s++;
						else
							b++;
					}
				}
			}
			
			String result= "Input Number : " +num
					+ ",Result : "+s+"S-"+b+"B\n";
			ta.append(result);
			
			if(s==3)
			{
				JOptionPane.showMessageDialog(this, "Game Over");
				System.exit(0);
			}
		}
		
	}
	
	public void errorDialog(String msg)
	{
		JOptionPane.showMessageDialog(this, msg);
		tf.setText("");
		tf.requestFocus();
	}

}
