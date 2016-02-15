package com.sist;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class HorseGameMain extends JFrame
implements ActionListener
{
    HorseGameView[] hg=new HorseGameView[5];
    JProgressBar[] bar=new JProgressBar[5];
    JTextArea ta;
    JMenuItem readyItem,startItem,exitItem;
    HorseSetting hs=new HorseSetting();
    public HorseGameMain()
    {
    	JMenuBar jb=new JMenuBar();
    	JMenu menu=new JMenu("게임");
    	readyItem=new JMenuItem("준비");
    	startItem=new JMenuItem("시작");
    	exitItem=new JMenuItem("종료");
    	menu.add(readyItem);
    	menu.add(startItem);
    	menu.addSeparator();
    	menu.add(exitItem);
    	jb.add(menu);
    	// À©µµ¿ì¿¡ ¼³Á¤
    	setJMenuBar(jb);
    	Color[] color={Color.cyan,Color.green,
    			Color.magenta,Color.yellow,
    			Color.pink};
    	for(int i=0;i<hg.length;i++)
    	{
    		hg[i]=new HorseGameView(this);
    		bar[i]=new JProgressBar(0, 1000);
    		bar[i].setForeground(color[i]);
    		bar[i].setBackground(Color.WHITE);
    		bar[i].setStringPainted(true);
    	}
    	ta=new JTextArea();
    	ta.setEditable(false);
    	JScrollPane js=new JScrollPane(ta);
    	
    	setLayout(null);
    	js.setBounds(10, 15, 1010, 200);
    	for(int i=0;i<hg.length;i++)
    	{
    		hg[i].setBounds(10, 230+(i*100), 1010, 60);
    		bar[i].setBounds(10, 290+(i*100), 1010, 20);
    		
    		add(hg[i]);
    		add(bar[i]);
    	}
    	add(js);
    	setSize(1040, 800);
    	setVisible(true);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	
    	// ÀÌº¥Æ® µî·Ï 
    	readyItem.addActionListener(this);
    	startItem.addActionListener(this);
    	exitItem.addActionListener(this);
    	
    	hs.b1.addActionListener(this);
    	hs.b2.addActionListener(this);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new HorseGameMain();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==readyItem)
		{
			for(int i=0;i<hs.tf.length;i++)
			{
				hs.tf[i].setText("");
				bar[i].setValue(0);
			}
			hs.setVisible(true);
		}
		else if(e.getSource()==startItem)
		{
			for(int i=0;i<hg.length;i++)
			{
				hg[i].ht.start();
			}
		}
		else if(e.getSource()==exitItem)
		{
			dispose();
			System.exit(0);
		}
		else if(e.getSource() == hs.b1)
		{
			for(int i=0;i<hs.tf.length;i++)
			{
				hg[i].threadSetting(hs.tf[i].getText().trim());
				hg[i].x=0;
				hg[i].y=0;
			}
			hs.setVisible(false);
			JOptionPane.showMessageDialog(this, "초기화 완료");
			HorseGameView.grade=0;
			ta.setText("");
		}
		else if(e.getSource() == hs.b2)
		{
			hs.setVisible(false);
		}
	}

}
