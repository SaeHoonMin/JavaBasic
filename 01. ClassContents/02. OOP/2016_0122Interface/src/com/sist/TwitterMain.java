package com.sist;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

import twitter4j.FilterQuery;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

public class TwitterMain extends JFrame implements ActionListener{
	/*
	 * 
	 * DefaultTableModel : model
	 * JTable			 : View
	 * Swing?			 : controller
	 * 
	 */
	JTable table;		// ���. �����ִ� �κ�
	
	static DefaultTableModel model;// �����Ͱ���
	JLabel la;
	JTextField tf;
	JButton bu;
	
	TableColumn column;
	
	//Twitter
	TwitterStream ts;
	FilterQuery	fq;
	
	
	public TwitterMain()
	{
		la = new JLabel("�˻�� �Է��ض�.");
		tf = new JTextField(20);
		bu = new JButton("�˻�");
		
		
		String [] col = {"���̵�","������"};
		String [][] row = new String[0][2];
		model = new DefaultTableModel(row,col);
		
		table = new JTable(model);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.getTableHeader().setBackground(Color.pink);
		table.setRowHeight(35);
		table.setShowVerticalLines(false);
		JScrollPane js = new JScrollPane(table);
		js.getViewport().setBackground(new Color(0xff,0x8c,0x00,100));
		
		JPanel p = new JPanel();
		p.add(la);
		p.add(tf);
		p.add(bu);
		
		
		add("North",p);
		add("Center",js);
		
		setSize(800,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		for(int i=0; i<col.length; i++)
		{
			column = table.getColumnModel().getColumn(i);
			DefaultTableCellRenderer rnd = new DefaultTableCellRenderer();
		
			if(i==0)
			{
				column.setPreferredWidth(100);
				rnd.setHorizontalAlignment(JLabel.CENTER);
			}
			else if(i==1)
			{
				column.setPreferredWidth(700);
				rnd.setHorizontalAlignment(JLabel.LEFT);
			}
			column.setCellRenderer(rnd);
		}
		
		ts = new TwitterStreamFactory().getInstance();
		fq = new FilterQuery();
		TwitterListener list = new TwitterListener();
		ts.addListener(list);
		bu.addActionListener(this);
		tf.addActionListener(this);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new TwitterMain();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(bu) || e.getSource()==tf)
		{
			String data = tf.getText();
			if(data.length() <1)
			{
				JOptionPane.showMessageDialog(this, "�˻�� �Է��ض�.");
				tf.requestFocus();
				return;
			}
			fq.track(data);
			ts.filter(fq);
			
		}
	}

}