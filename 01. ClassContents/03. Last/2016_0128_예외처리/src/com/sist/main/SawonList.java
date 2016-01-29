package com.sist.main;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
public class SawonList extends JPanel{
    JLabel la;
    JTable table;
    DefaultTableModel model;
    public SawonList()
    {
    	la=new JLabel("사원 목록");
    	la.setFont(new Font("맑은 고딕",Font.BOLD,30));
    	String[] col={"사번","이름","직위","입사일"};
    	String[][] row=new String[0][4];
    	model=new DefaultTableModel(row, col)
        {
    		public boolean isCellEditable(int r,int c)
    		{
    			return false;
    		}
        };
        table=new JTable(model);
        JScrollPane js=new JScrollPane(table);
        setLayout(new BorderLayout());
        JPanel p=new JPanel();
        p.add(la);
        add("North",p);
        add("Center",js);
    }
}







