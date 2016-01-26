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
		String [] col = {"사번","이름","부서"};
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
		
		String [] data1 = {"1","홍길동","영업부"};
		String [] data2 = {"2","김길동","기획부"};
		String [] data3 = {"3","김기동","총무부"};
		String [] data4 = {"4","배일동","영업부"};
		String [] data5 = {"5","배규철","개발부"};
		
		
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
				
				String res = "사번 : " +sabun+"\n"
							+"이름 : "+name+"\n"
							+"부서 : "+dept+"\n";
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
