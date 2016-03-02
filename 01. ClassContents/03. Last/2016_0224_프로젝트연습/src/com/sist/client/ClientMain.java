package com.sist.client;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import com.sist.common.*;
import java.net.*;
public class ClientMain extends JFrame
implements Runnable,ActionListener,MouseListener
{
    Login login=new Login();
    WaitRoom wr=new WaitRoom();
    GameRoom gr=new GameRoom();
    MakeRoom mr=new MakeRoom();
    CardLayout card=new CardLayout();
    
    // 네트워크 
    Socket s;
    BufferedReader in;
    OutputStream out;
    boolean bTurn;
    String myRoom;
    public ClientMain()
    {
    	setLayout(card);
    	
    	add("LOG",login);
    	add("WR",wr);
    	add("GR",gr);
    	
    	
    	setSize(800, 600);
    	setVisible(true);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	// 로그인 등록 
    	login.b1.addActionListener(this);
    	login.b2.addActionListener(this);
    	wr.b1.addActionListener(this);
    	
    	mr.b1.addActionListener(this);
    	mr.b2.addActionListener(this);
    	
    	wr.table1.addMouseListener(this);
    	gr.b1.addActionListener(this);
    	gr.b2.addActionListener(this);
    	gr.b3.addActionListener(this);
    }
    public void connection(String id)
    {
    	try
    	{
    		s=new Socket("localhost", 3355);
    		// Connection
    		in=new BufferedReader(
    				new InputStreamReader(
    						s.getInputStream()));
    		// PreparedStatement
    		out=s.getOutputStream();
    		out.write((Function.LOGIN+"|"+id+"\n").getBytes());
    	}catch(Exception ex){}
    	// 서버에서 들어오는 값을 받아서 출력 
    	new Thread(this).start();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new ClientMain();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==wr.table1)
		{
			if(e.getClickCount()==2)
			{
				int row=wr.table1.getSelectedRow();
				String rn=wr.model1.getValueAt(row, 0).toString();
				String inwon=wr.model1.getValueAt(row, 1).toString();
				StringTokenizer st=
						new StringTokenizer(inwon, "/");
				if(Integer.parseInt(st.nextToken())==
						Integer.parseInt(st.nextToken()))
				{
					JOptionPane.showMessageDialog(this,
							"이미 방이 찼습니다\n다른 방을 선택하세요");
					return;
				}
				try
				{
					out.write((Function.MYROOMIN+"|"
							+rn+"\n").getBytes());
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
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==login.b1)
		{
			String id=login.tf.getText().trim();
			if(id.length()<1)
			{
				login.tf.requestFocus();
				return;
			}
			connection(id);
		}
		else if(e.getSource()==login.b2)
		{
			dispose();
			System.exit(0);
		}
		else if(e.getSource()==wr.b1)
		{
			mr.tf.setText("");
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
							"이미 존재하는 방입니다");
					mr.tf.setText("");
					mr.tf.requestFocus();
					return;
				}
			}
			int inwon=mr.box.getSelectedIndex()+2;
				// 서버로 전송 
			try
			{
				out.write((Function.MAKEROOM+"|"
				               +rn+"|"
				               +inwon+"\n").getBytes());
			}catch(Exception ex){}
			mr.setVisible(false);
			
		}
		else if(e.getSource()==mr.b2)
		{
			mr.setVisible(false);
		}
		else if(e.getSource()==gr.b1)
		{
			
		}
		else if(e.getSource()==gr.b2)
		{
			gr.myPanel.getRand();
			gr.myPanel.display(1);
			gr.youPanel.display(2);
			try
			{
				out.write((Function.GAMEREADY+"|"
						+myRoom+"\n").getBytes());
			}catch(Exception ex){}
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			try
			{
				String msg=in.readLine();
				StringTokenizer st=
						new StringTokenizer(msg, "|");
				int protocol=Integer.parseInt(st.nextToken());
				switch(protocol)
				{
					case Function.LOGIN:
					{
						String[] data={
							st.nextToken(),
							st.nextToken()
						};
						wr.model2.addRow(data);
					}
					break;
					case Function.MYLOG:
					{
						String id=st.nextToken();
						setTitle(id);
						card.show(getContentPane(), "WR");
					}
					break;
					case Function.MAKEROOM:
					{
						String[] data={
							st.nextToken(),
							st.nextToken()
						};
						wr.model1.addRow(data);
					}
					break;
					case Function.ROOMUPDATE:
					{
						String id=st.nextToken();
						String pos=st.nextToken();
						String temp="";
						for(int i=0;i<wr.model2.getRowCount();i++)
						{
							temp=wr.model2.getValueAt(i, 0).toString();
							if(temp.equals(id))
							{
								wr.model2.setValueAt(pos,i,1);
								break;
							}
						}
					}
					break;
					case Function.MYROOMIN:
					{
						String id=st.nextToken();
						myRoom=st.nextToken();
						gr.myid.setText(id);
						card.show(getContentPane(), "GR");
					}
					break;
					case Function.ROOMIN:
					{
						String id=st.nextToken();
						gr.youid.setText(id);
					}
					break;
					case Function.ROOMCHAT:
					{
						gr.ta.append(st.nextToken()+"\n");
					}
					break;
					case Function.GAMEINIT:
					{
						gr.b2.setEnabled(true);
					}
					break;
					case Function.GAMEREADY:
					{
						String rj=st.nextToken();
						if(rj.equals(getTitle()))
						{
							gr.b1.setEnabled(true);
							
						}
						else
						{
							gr.b1.setEnabled(false);
						}
						gr.b2.setEnabled(false);
					}
					break;
					
				}
			}catch(Exception ex){}
		}
	}

}
