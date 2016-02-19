package com.io;
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
public class MainClass4 extends JFrame
implements MouseListener
{
    JTable table;
    DefaultTableModel model;
    JTextField tf;
    JButton bu;
    JLabel la;
    JTextArea ta;
    String path="c:\\";
    public MainClass4()
    {
    	la=new JLabel("Path");
    	tf=new JTextField();
    	tf.setText("c:\\");
    	bu=new JButton("GO");
    	ta=new JTextArea();
    	JScrollPane js=new JScrollPane(ta);
    	ta.setEditable(false);
    	
    	String[] col={"파일명","수정일","크기"};
    	String[][] row=new String[0][3];
    	model=new DefaultTableModel(row, col)
    	{
    		public boolean isCellEditable(int r,int c)
    		{
    			return false;
    		}
    	};
    	table=new JTable(model);
    	JScrollPane js1=new JScrollPane(table);
    	
    	setLayout(null);
    	la.setBounds(10, 15, 40, 30);
    	tf.setBounds(55, 15, 300, 30);
    	bu.setBounds(360, 15, 100, 30);
    	
    	js1.setBounds(10, 50, 450, 380);
    	js.setBounds(465, 15, 210, 415);
    	add(la);add(tf);add(bu);
    	add(js1);
    	add(js);
    	setSize(700,480);
    	setVisible(true);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	getData();
    	
    	table.addMouseListener(this);
    }
    public void getData()
    {
    	for(int i=model.getRowCount()-1;i>=0;i--)
    	{
    		model.removeRow(i);
    	}
    	path=tf.getText().trim();
    	try
    	{
    		File dir=new File(path);
    		File[] list=dir.listFiles();
    		for(File file:list)
    		{
    			if(file.isHidden())
    			{
    				continue;
    			}
    			if(file.isDirectory())
    			{
    				String[] data={
    						file.getName(),
    						new SimpleDateFormat("yyyy년 MM월 dd일").format(new Date(file.lastModified())),
    						"<DIR>"};
    				model.addRow(data);
    			}
    			else
    			{
    				String[] data={
    						file.getName(),
    						new SimpleDateFormat("yyyy년 MM월 dd일").format(new Date(file.lastModified())),
    						file.length()/1024>0?(file.length()/1024)+"KB":(file.length())+"Bytes"};
    				model.addRow(data);
    			}
    			
    		}
    		String temp=path.substring(
    				path.lastIndexOf("\\")+1);
			int len=temp.length();
			System.out.println(temp);
			if(len!=0)
			{
				String[] data={
						         "..","",""
						       };
				model.addRow(data);
			}
    	}catch(Exception ex){}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new MainClass4();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==table)
		{
			if(e.getClickCount()==2)
			{
				int row=table.getSelectedRow();
				String fname=model.getValueAt(row, 0).toString();
				String size=model.getValueAt(row, 2).toString();
				if(size.equals("<DIR>"))
				{
					// 디렉토리
					// c:\\ c:\\image
					String temp=path.substring(path.lastIndexOf("\\")+1);
					int len=temp.length();
					if(len==0)
					{
						path=path+fname;
					}
					else
					{
						path=path+"\\"+fname;
					}
					tf.setText(path);
					getData();
				}
				else
				{
					// 파일
					int len=path.lastIndexOf("\\");
					String ss=path.substring(len+1);
					String temp="";
					if(ss.equals(""))
					{
						
						temp=path+fname;
					}
					else
					{
						
						temp=path+"\\"+fname;
					}
					File file=new File(temp);
					//System.out.println(temp);
					String res = "파일명 : " + file.getName()+"\n"
								+"경로명 : " + file.getParent()+"\n"
								+"파일명+경로명 : " + file.getPath()+file.getName()+"\n"
								+"숨김파일 : " + file.isHidden()+"\n"
								+"읽기모드 : " + file.canRead()+"\n"
								+"쓰기모드 : " + file.canWrite()+"\n"
								+"수정일  : " + new Date(file.lastModified())+"\n"
								+"파일 크기 : " + file.length();
					ta.setText(res);
				}	
				
				if(fname.equals(".."))
				{
					
					int len=path.lastIndexOf("\\");
					if(len==2)
					{
						path=path.substring(0,
								path.lastIndexOf("\\")+1);
					}
					else
					{
						path=path.substring(0, 
								path.lastIndexOf("\\"));
					}
					tf.setText(path);
					getData();
				}
				
			}
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}





