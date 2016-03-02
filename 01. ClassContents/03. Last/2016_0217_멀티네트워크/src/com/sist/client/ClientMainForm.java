package com.sist.client;
import java.awt.*;
import javax.swing.*;

import com.sist.common.Function;


import java.awt.event.*;
import java.util.StringTokenizer;
import java.net.*;
import java.io.*;
/*
 * {
 *   case 1:
 *   {
 *     String id;
 *   }
 *     break;
 *   case 2:
 *   {
 *     String id
 *     }
 *     break;
 *  }
 */
public class ClientMainForm extends JFrame 
implements ActionListener,Runnable,MouseListener
{
    Login login=new Login();
    WaitRoom wr=new WaitRoom();
    MakeRoom mr=new MakeRoom();
    ChatRoom cr=new ChatRoom();
    GameRoom gr=new GameRoom();
    CardLayout card=new CardLayout();
    // 네트워크
    Socket s;
    BufferedReader in;
    OutputStream out;
    // 개인 정보
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
	    wr.table1.addMouseListener(this);
	    wr.table2.addMouseListener(this);
	    wr.b6.addActionListener(this);
	    wr.b1.addActionListener(this);
	    mr.b1.addActionListener(this);
	    mr.b2.addActionListener(this);
	    cr.b1.addActionListener(this);
	    cr.b2.addActionListener(this);
	    cr.b3.addActionListener(this);
	    cr.tf.addActionListener(this);
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
						"ID를 입력하세요");
				login.tf.requestFocus();
				return;
			}
				
			String pwd=String.valueOf(login.pf.getPassword()).trim();
			if(pwd.length()<1)
			{
				JOptionPane.showMessageDialog(this,
						"비밀번호를 입력하세요");
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
						"방이름을 입력하세요");
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
							"이미 존재하는 방입니다\n다른 이름을 입력하세요");
					mr.tf.setText("");
					mr.tf.requestFocus();
					return;
				}
			}
			String state="",pwd="";
			if(mr.rb1.isSelected())
			{
				state="공개";
				pwd=" ";
			}
			else
			{
				state="비공개";
				pwd=String.valueOf(mr.pf.getPassword());
			}
			int inwon=mr.box.getSelectedIndex()+2;
			// 서버로 전송 
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
		else if(e.getSource()==cr.b1)
		{
			
		}
		else if(e.getSource()==cr.b2)
		{
			
		}
		else if(e.getSource()==cr.b3)
		{
			try
			{
				out.write((Function.ROOMOUT+"|"
						+myRoom+"\n").getBytes());
			}catch(Exception ex){}
		}
		else if(e.getSource()==cr.tf)
		{
			
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try
		{
			while(true)
			{
				// 클라이언트 => 요청값을 받는다
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
    							"ID가 존재하지 않습니다");
    					login.tf.setText("");
    					login.pf.setText("");
    					login.tf.requestFocus();
    				}
    				break;
    				case Function.NOPWD:
    				{
    					JOptionPane.showMessageDialog(this,
    							"비밀번호가 틀립니다");
    					
    					login.pf.setText("");
    					login.pf.requestFocus();
    				}
    				break;
    				case Function.MULTIID:
    				{
    					JOptionPane.showMessageDialog(this,
    							"이미 사용중인 아이디입니다");
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
    					String id=st.nextToken();
    					String name=st.nextToken();
    					String sex=st.nextToken();
    					String avata=st.nextToken();
    					myRoom=st.nextToken();
    					String rb=st.nextToken();
    					card.show(getContentPane(), "CR");
    					String[] data={id,name,sex};
    					cr.model.addRow(data);
    					for(int i=0;i<6;i++)
    					{
    						if(!cr.sw[i])
    						{
    							cr.sw[i]=true;
    							cr.pan[i].setLayout(new BorderLayout());
    							cr.pan[i].removeAll();
    							cr.pan[i].add("Center",
    									new JLabel(new ImageIcon("c:\\image\\"
    							        +(sex.equals("남자")?"m":"w")+avata+".gif")));
    							cr.idtf[i].setText(name);
    							if(id.equals(rb))
    							{
    								cr.idtf[i].setForeground(Color.red);
    							}
    							cr.pan[i].validate();
    							break;
    						}
    					}
    					
    					if(id.equals(rb))
    					{
    						cr.b1.setEnabled(true);
    						cr.b2.setEnabled(true);
    					}
    					else
    					{
    						cr.b1.setEnabled(false);
    						cr.b2.setEnabled(false);
    					}
    					
    				}
    				break;
    				case Function.POSCHANGE:
    				{
    					String id=st.nextToken();
    					String pos=st.nextToken();
    					for(int i=0;i<wr.model2.getRowCount();i++)
    					{
    						String temp=wr.model2.getValueAt(i,0).toString();
    						if(id.equals(temp))
    						{
    							wr.model2.setValueAt(pos, i, 3);
    							break;
    						}
    					}
    				}
    				break;
    				case Function.ROOMIN:
    				{
    					String id=st.nextToken();
    					String name=st.nextToken();
    					String sex=st.nextToken();
    					String avata=st.nextToken();
    					String rb=st.nextToken();
    					card.show(getContentPane(), "CR");
    					String[] data={id,name,sex};
    					cr.model.addRow(data);
    					for(int i=0;i<6;i++)
    					{
    						if(!cr.sw[i])
    						{
    							cr.sw[i]=true;
    							cr.pan[i].setLayout(new BorderLayout());
    							cr.pan[i].removeAll();
    							cr.pan[i].add("Center",
    									new JLabel(new ImageIcon("c:\\image\\"
    							        +(sex.equals("남자")?"m":"w")+avata+".gif")));
    							cr.idtf[i].setText(name);
    							if(id.equals(rb))
    							{
    								cr.idtf[i].setForeground(Color.red);
    							}
    							cr.pan[i].validate();
    							break;
    						}
    					}
    				}
    				break;
    				case Function.ROOMCHAT:
    				{
    					cr.ta.append(st.nextToken()+"\n");
    				
    				}
    				break;
    				case Function.WAITUPDATE:
    				{
    					/*
    					 *  +room.roomName+"|"
	    									+room.current+"|"
	    									+room.inwon+"|"
	    									+id+"|"
	    									+pos
    					 */
    					String rn=st.nextToken();
    					String rc=st.nextToken();
    					String ri=st.nextToken();
    					String id=st.nextToken();
    					String pos=st.nextToken();
    					for(int i=0;i<wr.model1.getRowCount();i++)
    					{
    						String temp=wr.model1.getValueAt(i, 0).toString();
    						if(rn.equals(temp))
    						{
    							if(Integer.parseInt(rc)<1)
    							{
    								wr.model1.removeRow(i);
    							}
    							else
    							{
    								wr.model1.setValueAt(rc+"/"+ri, i, 2);
    							}
    							break;
    						}
    					}
    					for(int i=0;i<wr.model2.getRowCount();i++)
    					{
    						String temp=wr.model2.getValueAt(i,0).toString();
    						if(id.equals(temp))
    						{
    							wr.model2.setValueAt(pos, i, 3);
    							break;
    						}
    					}
    				}
    				break;
    				case Function.BANGCHANGE:
    				{
    					String bj=st.nextToken();
    					String name=st.nextToken();
    					JOptionPane.showMessageDialog(this,
    							"방장이 "+bj+"님으로 변경되었습니다");
    					for(int i=0;i<6;i++)
    					{
    						String n=cr.idtf[i].getText();
    						if(n.equals(name))
    						{
    							cr.idtf[i].setForeground(Color.red);
    						}
    						else
    						{
    							cr.idtf[i].setForeground(Color.black);
    						}
    					}
    					if(bj.equals(getTitle()))
    					{
    						cr.b1.setEnabled(true);
    						cr.b2.setEnabled(true);
    						
    					}
    					else
    					{
    						cr.b1.setEnabled(false);
    						cr.b2.setEnabled(false);
    					}
    				}
    				break;
    				case Function.ROOMOUT:
    				{
    					String id=st.nextToken();
    					String name=st.nextToken();
    					for(int i=0;i<6;i++)
    					{
    						String temp=cr.idtf[i].getText();
    						if(temp.equals(name))
    						{
	    						cr.sw[i]=false;
	    						cr.idtf[i].setText("");
	    						cr.pan[i].removeAll();
	    						cr.pan[i].setLayout(new BorderLayout());
	    						cr.pan[i].add("Center",new JLabel(
	    								new ImageIcon("c:\\image\\def.png")));
	    						cr.pan[i].validate();
	    						break;
    						}
    					}
    					
    					for(int i=cr.model.getRowCount()-1;i>=0;i--)
    					{
    						String ii=cr.model.getValueAt(i, 0).toString();
    						if(ii.equals(id))
    						{
    						  cr.model.removeRow(i);
    						  break;
    						}
    					}
    				}
    				break;
    				case Function.MYROOMOUT:
    				{
    					for(int i=0;i<6;i++)
    					{
    						cr.sw[i]=false;
    						cr.idtf[i].setText("");
    						cr.pan[i].removeAll();
    						cr.pan[i].setLayout(new BorderLayout());
    						cr.pan[i].add("Center",new JLabel(
    								new ImageIcon("c:\\image\\def.png")));
    						cr.pan[i].validate();
    					}
    					cr.ta.setText("");
    					cr.tf.setText("");
    					for(int i=cr.model.getRowCount()-1;i>=0;i--)
    					{
    						cr.model.removeRow(i);
    					}
    					card.show(getContentPane(), "WR");
    				}
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
		else if(e.getSource()==wr.table1)
		{
			if(e.getClickCount()==2)
			{
				int row=wr.table1.getSelectedRow();
				String rn=wr.model1.getValueAt(row, 0).toString();
				String rs=wr.model1.getValueAt(row, 1).toString();
				String ri=wr.model1.getValueAt(row, 2).toString();
				StringTokenizer st=
						new StringTokenizer(ri, "/");
				// 1/6  => 6/6
				if(Integer.parseInt(st.nextToken())==
						Integer.parseInt(st.nextToken()))
				{
					JOptionPane.showMessageDialog(this,
							"더이상 입장이 불가능 합니다");
					return;
				}
				try
				{
					out.write((Function.MYROOMIN+"|"+rn+"\n").getBytes());
				}catch(Exception ex){}
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
