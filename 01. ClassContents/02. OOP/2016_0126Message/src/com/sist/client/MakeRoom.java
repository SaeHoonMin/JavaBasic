package com.sist.client;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MakeRoom extends JFrame
implements ActionListener
{
    JLabel la1,la2,la3,la4;
    JTextField tf;
    JPasswordField pf;
    JComboBox box;
    JRadioButton open,noopen;
    JButton b1,b2;
    public MakeRoom()
    {
    	la1=new JLabel("방이름");
    	la2=new JLabel("상태");
    	la3=new JLabel("비밀번호");
    	la4=new JLabel("인원");
    	
    	tf=new JTextField();
    	pf=new JPasswordField();
    	box=new JComboBox();
    	for(int i=2;i<7;i++)
    	{
    		box.addItem(i+"명");
    	}
    	open=new JRadioButton("공개");
    	noopen=new JRadioButton("비공개");
    	ButtonGroup bg=new ButtonGroup();
    	bg.add(open);
    	bg.add(noopen);
    	open.setSelected(true);
    	la3.setVisible(false);
    	pf.setVisible(false);
    	
    	b1=new JButton("방만들기");
    	b2=new JButton("취소");
        JPanel p=new JPanel();
        p.add(b1);
        p.add(b2);
        
    	setLayout(null);
    	la1.setBounds(10, 15, 40, 30);
    	tf.setBounds(55, 15, 150, 30);
    	
    	la2.setBounds(10, 50, 40, 30);
    	open.setBounds(55, 50, 70, 30);
    	noopen.setBounds(130, 50, 70, 30);
    	
    	la3.setBounds(40, 85, 60, 30);
    	pf.setBounds(105, 85, 100, 30);
    	
    	la4.setBounds(10, 120, 40, 30);
    	box.setBounds(55, 120, 150, 30);
    	p.setBounds(10, 155, 195, 35);
    	add(la1);add(tf);
    	add(la2);add(open);add(noopen);
    	add(la3);add(pf);
    	add(la4);add(box);
    	add(p);
    	setSize(230, 235);
    	//setVisible(true);
    	//setDefaultCloseOperation(EXIT_ON_CLOSE);
    	open.addActionListener(this);
    	noopen.addActionListener(this);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new MakeRoom();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==open)
		{
			pf.setText("");
			pf.setVisible(false);
			la3.setVisible(false);
		}
		else if(e.getSource()==noopen)
		{
			pf.setText("");
			pf.setVisible(true);
			la3.setVisible(true);
			pf.requestFocus();
		}
	}

}


