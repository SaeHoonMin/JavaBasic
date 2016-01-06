import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class 자리배정 extends JFrame
implements ActionListener,Runnable
{
    JProgressBar[] bar=new JProgressBar[22];
    JLabel[] la=new JLabel[22];
    JButton b=new JButton("시작");
    static int score=0;
    int[] ii=new int[22];
    public 자리배정()
    {
    	setLayout(null);
    	for(int i=0;i<22;i++)
    	{
    		la[i]=new JLabel(String.valueOf(i+1));
    		la[i].setBounds(10,10+i*25,50,25);
    		add(la[i]);
    	}
    	for(int i=0;i<22;i++)
    	{
    		bar[i]=new JProgressBar();
    		bar[i].setBackground(Color.white);
    		bar[i].setForeground(Color.blue);
    		bar[i].setStringPainted(true);
    		bar[i].setBounds(65,10+i*25,300,20);
    		add(bar[i]);
    	}
    	JPanel p=new JPanel();
    	p.add(b);
    	p.setBounds(10,560,390,35);
    	add(p);
    	setSize(400,680);
    	setVisible(true);
    	b.addActionListener(this);
    }
    public void run()
    {
    	int[] num=new int[22];
    	for(int i=0;i<22;i++)
    	{
    		num[i]=(int)(Math.random()*101);
    	}
    	
    	for(int i=0;i<22;i++)
    	{
    		for(int j=0;j<=num[i];j++)
    		{
    			try
    			{
    				bar[i].setValue(j);
    				Thread.sleep(30);
    			}catch(Exception ex){}
    		}
    		
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new 자리배정();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b)
		{
			try
			{
			  new Thread(this).start();
			}catch(Exception ex){};
		}
	}

}
