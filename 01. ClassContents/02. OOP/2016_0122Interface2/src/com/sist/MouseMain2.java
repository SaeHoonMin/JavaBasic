package com.sist;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;

public class MouseMain2 extends JFrame implements MouseListener{
	
	JTable table;
	DefaultTableModel model;
	
	public MouseMain2()
	{
		String [] col = {"���","�̸�","�μ�"};
		String [][] row = new String[0][3];
		model = new DefaultTableModel(row,col){
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		
		table = new JTable(model);
		JScrollPane js = new JScrollPane(table);
		add("Center",js);
		setSize(350,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		String [] data1 = {"1","ȫ�浿","������"};
		String [] data2 = {"2","��浿","��ȹ��"};
		String [] data3 = {"3","��⵿","�ѹ���"};
		String [] data4 = {"4","���ϵ�","������"};
		String [] data5 = {"5","���ö","���ߺ�"};
		
		
		model.addRow(data1);
		model.addRow(data2);
		model.addRow(data3);
		model.addRow(data4);
		model.addRow(data5);
		
		table.addMouseListener(this);
	}
	
	public static void main(String[] args) {
		new MouseMain2();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==table)
		{
			if(e.getClickCount()==2)
			{
				int row = table.getSelectedRow();
				String sabun = model.getValueAt(row, 0).toString();
				String name = model.getValueAt(row, 1).toString();
				String dept = model.getValueAt(row, 2).toString();
				
				String res = "��� : " +sabun+"\n"
							+"�̸� : "+name+"\n"
							+"�μ� : "+dept+"\n";
				JOptionPane.showMessageDialog(this, res);
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
