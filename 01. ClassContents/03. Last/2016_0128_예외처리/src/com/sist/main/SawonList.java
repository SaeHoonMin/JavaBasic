package com.sist.main;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class SawonList extends JPanel{

	JLabel la;
	JTable table;
	DefaultTableModel model;
	public SawonList()
	{
		la = new JLabel("��� ���");
		la.setFont(new Font("���� ���",Font.BOLD,30));
	
		String [] col = {"���","�̸�","����","�Ի���"};
		
		String [][] row = new String[0][4];
		
		model = new DefaultTableModel(row, col){
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		table = new JTable(model);
		JScrollPane js = new JScrollPane(table);
		setLayout(new BorderLayout());
		JPanel  p = new JPanel();
		p.add(la);
		add("North",p);
		add("Center",js);
		
		
		
	}
	
}
