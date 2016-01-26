package com.sist;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;
import javax.swing.table.*;
public class WaitRoom extends JFrame{
    JTable table;
    DefaultTableModel model;
    public WaitRoom()
    {
    	String[] col={"이름","성별","전화"};
    	Object[][] row=new Object[0][3];
    	model=new DefaultTableModel(row, col){
			@Override
			public Class getColumnClass(int arg0) {
				// TODO Auto-generated method stub
				return getValueAt(0, arg0).getClass();
			}

			@Override
			public boolean isCellEditable(int arg0, int arg1) {
				// TODO Auto-generated method stub
				return false;
			}
			
    	};		//익명클래스로 상속 없이 오버라이딩
    	
    	table=new JTable(model);
    	table.setRowHeight(35);
    	// M(model)V(view)
    	JScrollPane js=new JScrollPane(table);
    	
    	add("Center",js);
    	setSize(640, 480);
    	setVisible(true);
    	
    	Object [] data1 = {"홍길동",new ImageIcon("c:\\image\\man1.gif"),new Boolean(true),};
    	model.addRow(data1);
    	Object [] data2 = {"심청이",new ImageIcon("c:\\image\\woman1.gif"),new Boolean(false)};
    	model.addRow(data2);
    	
    	addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(1);
			}
    	});
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new WaitRoom();
	}
}
