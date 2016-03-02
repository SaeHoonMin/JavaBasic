package com.sist.client;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class WaitRoom extends JPanel{
    JTable table1,table2;
    DefaultTableModel model1,model2;
    JTextArea ta;
    JTextField tf;
    JComboBox box;
    JButton b1,b2,b3,b4;
    JScrollBar bar;
    public WaitRoom() 
    {
		String[] col1={"방이름","인원"};
		String[][] row1=new String[0][2];
		model1=new DefaultTableModel(row1,col1)
		{

			@Override
			public boolean isCellEditable(int r, int c) {
				// TODO Auto-generated method stub
				return false;
			}
			
		};
		table1=new JTable(model1);
		table1.getTableHeader().setReorderingAllowed(false);
		JScrollPane js1=new JScrollPane(table1);
		
		String[] col2={"ID","위치"};
		String[][] row2=new String[0][2];
		model2=new DefaultTableModel(row2,col2)
		{

			@Override
			public boolean isCellEditable(int r, int c) {
				// TODO Auto-generated method stub
				return false;
			}
			
		};
		table2=new JTable(model2);
		JScrollPane js2=new JScrollPane(table2);
		
		ta=new JTextArea();
		JScrollPane js3=new JScrollPane(ta);
		bar=js3.getVerticalScrollBar();
		tf=new JTextField();
		box=new JComboBox();
		box.addItem("black");
		box.addItem("blue");
		box.addItem("green");
		box.addItem("cyan");
		box.addItem("pink");
		
		b1=new JButton("방만들기");
		b2=new JButton("방들어가기");
		
		b3=new JButton("정보보기");
		b4=new JButton("나가기");
		
		JPanel p=new JPanel();
		p.setLayout(new GridLayout(2, 2,5,5));
		p.add(b1);p.add(b2);
		
		p.add(b3);p.add(b4);
		
		setLayout(null);
		js1.setBounds(10, 15, 500, 350);
		js2.setBounds(10, 370, 500, 180);
		js3.setBounds(515, 15, 265, 300);
		tf.setBounds(515, 320, 160, 30);
		box.setBounds(680, 320, 100, 30);
		p.setBounds(515, 470, 265, 80);
		add(js1);
		add(js2);
		add(js3);
		add(tf);
		add(box);
		add(p);
		
		
	 }
}
