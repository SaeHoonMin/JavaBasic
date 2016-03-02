package com.sist.client;


import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class MakeRoom extends JFrame
{
    JLabel la1,la2;
    JTextField tf;
    JComboBox box;
    JButton b1,b2;
    // {}
    public MakeRoom()
    {
    	la1=new JLabel("방이름");
    	la2=new JLabel("인원");
    	tf=new JTextField();
    	
    	box=new JComboBox();
    	for(int i=2;i<=2;i++)
    	{
    		box.addItem(i+"명");
    	}
    	
    	b1=new JButton("확인");
    	b2=new JButton("취소");
    	
    	// 배치
    	setLayout(null);
    	la1.setBounds(10, 15,40, 30);
    	tf.setBounds(55, 15, 150, 30);
    	
    	la2.setBounds(10, 50, 40, 30);
    	box.setBounds(55, 50, 100, 30);
    	
    	JPanel p=new JPanel();
    	p.add(b1);
    	p.add(b2);
    	
    	p.setBounds(10, 85, 195, 35);
    	
    	// 추가 
    	add(la1);add(tf);
    	add(la2);add(box);
    	add(p);
    	
    	setSize(230, 165);
    	//setVisible(true);
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new MakeRoom();
	}
	
}