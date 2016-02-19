package com.sist.client;
import java.awt.*;
import javax.swing.*;

import com.sist.common.Function;


import java.awt.event.*;
import java.util.StringTokenizer;
import java.net.*;
import java.io.*;
public class ClientMainForm extends JFrame 
implements ActionListener,Runnable,MouseListener
{
    Login login=new Login();
    WaitRoom wr=new WaitRoom();
    MakeRoom mr=new MakeRoom();
    ChatRoom cr=new ChatRoom();
    GameRoom gr=new GameRoom();
    CardLayout card=new CardLayout();
    // ��Ʈ��ũ
    Socket s;
    BufferedReader in;
    OutputStream out;
    // ���� ����
    String myId,myRoom;
    ClientMainForm() 
    {
		setLayout(card);// BorderLayout
		
		add("LOG",login);
		add("WR",wr);
		add("CR",cr);
		add("GR",gr);
		setSize(800, 600);
		setVisible(true);
		login.b1.addActionListener(this);
		login.b2.addActionListener(this);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	    setResizable(false);
	    wr.tf.addActionListener(this);
	    wr.table2.addMouseListener(this);
	    wr.b6.addActionListener(this);
	    wr.b1.addActionListener(this);
	    mr.b1.addActionListener(this);
	    mr.b2.addActionListener(this);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			 UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
		}catch(Exception ex){}
        new ClientMainForm();
	}
	public void connection(String id,String pwd)
	{
		try
		{
			s=new Socket("localhost", 3355);
			// s => server
			in=new BufferedReader(
					new InputStreamReader(
							s.getInputStream()));
			out=s.getOutputStream();
			out.write((Function.LOGIN+"|"+id+"|"+
			           pwd+"\n").getBytes());
		}catch(Exception ex){}
		new Thread(this).start();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==login.b1)
		{
			String id=login.tf.getText().trim();
			if(id.length()<1)
			{
				JOptionPane.showMessageDialog(this,
						"ID�� �Է��ϼ���");
				login.tf.requestFocus();
				return;
			}
				
			String pwd=String.valueOf(login.pf.getPassword()).trim();
			if(pwd.length()<1)
			{
				JOptionPane.showMessageDialog(this,
						"��й�ȣ�� �Է��ϼ���");
				login.pf.requestFocus();
				return;
			}
			
			
			connection(id, pwd);
		}
		else if(e.getSource()==wr.tf)
		{
			String msg=wr.tf.getText().trim();
			if(msg.length()<1)
				return;
			try
			{
				out.write((Function.WAITCHAT+"|"+msg+"\n").getBytes());
			}catch(Exception ex){}
			wr.tf.setText("");
		}
		else if(e.getSource()==wr.b6)
		{
			try
			{
				out.write((Function.CHATEND+"|\n").getBytes());
			}catch(Exception ex){}
		}
		else if(e.getSource()==wr.b1)
		{
			mr.tf.setText("");
			mr.rb1.setSelected(true);
			mr.box.setSelectedIndex(0);
			mr.la3.setVisible(false);
			mr.pf.setVisible(false);
			mr.setVisible(true);
		}
		else if(e.getSource()==mr.b1)
		{
			String rn=mr.tf.getText().trim();
			if(rn.length()<1)
			{
				JOptionPane.showMessageDialog(this,
						"���̸��� �Է��ϼ���");
				mr.tf.requestFocus();
				return;
			}
			String temp="";
			for(int i=0;i<wr.model1.getRowCount();i++)
			{
				temp=wr.model1.getValueAt(i, 0).toString();
				if(rn.equals(temp))
				{
					JOptionPane.showMessageDialog(this,
							"�̹� �����ϴ� ���Դϴ�\n�ٸ� �̸��� �Է��ϼ���");
					mr.tf.setText("");
					mr.tf.requestFocus();
					return;
				}
			}
			String state="",pwd="";
			if(mr.rb1.isSelected())
			{
				state="����";
				pwd=" ";
			}
			else
			{
				state="�����";
				pwd=String.valueOf(mr.pf.getPassword());
			}
			int inwon=mr.box.getSelectedIndex()+2;
			// ������ ���� 
			try
			{
				out.write((Function.MAKEROOM+"|"
			               +rn+"|"+state+"|"
			               +pwd+"|"+inwon
			               +"\n").getBytes());
			}catch(Exception ex){}
			
			mr.setVisible(false);
		}
		else if(e.getSource()==mr.b2)
		{
			mr.setVisible(false);
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try
		{
			while(true)
			{
				// Ŭ���̾�Ʈ => ��û���� �޴´�
				String msg=in.readLine();
				StringTokenizer st=
					new StringTokenizer(msg, "|");
				// 100|id|sex|name|avata
				int protocol=Integer.parseInt(st.nextToken());
				switch(protocol)
				{
    				case Function.LOGIN:
    				{
    					String[] data={
    						st.nextToken(),	
    						st.nextToken(),	
    						st.nextToken(),	
    						st.nextToken()
    					};
    					wr.model2.addRow(data);
    				}
    				break;
    				case Function.MYLOG:
    				{
    					String id=st.nextToken();
    					myId=id;
    					setTitle(id);
    					card.show(getContentPane(), "WR");
    				}
    				break;
    				case Function.WAITCHAT:
    				{
    					wr.ta.append(st.nextToken()+"\n");
    					wr.bar.setValue(wr.bar.getMaximum());
    				}
    				break;
    				case Function.CHATEND:
    				{
    					String id=st.nextToken();
    					for(int i=0;i<wr.model2.getRowCount();i++)
    					{
    						String temp=wr.model2.getValueAt(i, 0).toString();
    						if(id.equals(temp))
    						{
    							wr.model2.removeRow(i);
    							break;
    						}
    					}
    				}
    				break;
    				case Function.MYCHATEND:
    				{
    					dispose();
    					System.exit(0);
    				}
    				break;
    				case Function.NOID:
    				{
    					JOptionPane.showMessageDialog(this,
    							"ID�� �������� �ʽ��ϴ�");
    					login.tf.setText("");
    					login.pf.setText("");
    					login.tf.requestFocus();
    				}
    				break;
    				case Function.NOPWD:
    				{
    					JOptionPane.showMessageDialog(this,
    							"��й�ȣ�� Ʋ���ϴ�");
    					
    					login.pf.setText("");
    					login.pf.requestFocus();
    				}
    				break;
    				case Function.MULTIID:
    				{
    					JOptionPane.showMessageDialog(this,
    							"�̹� ������� ���̵��Դϴ�");
    					login.tf.setText("");
    					login.pf.setText("");
    					login.tf.requestFocus();
    				}
    				break;
    				case Function.MAKEROOM:
    				{
    					String[] data={
    						st.nextToken(),	
    						st.nextToken(),	
    						st.nextToken()
    					};
    					wr.model1.addRow(data);
    				}
    				break;
    				case Function.MYROOMIN:
    				{
    					card.show(getContentPane(), "CR");
    				}
    				break;
				}
				
			}
		}catch(Exception ex){}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==wr.table2)
		{
			int row=wr.table2.getSelectedRow();
			String id=wr.model2.getValueAt(row, 0).toString();
			if(myId.equals(id))
			{
				wr.b3.setEnabled(false);
				wr.b4.setEnabled(false);
			}
			else
			{
				wr.b3.setEnabled(true);
				wr.b4.setEnabled(true);
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
