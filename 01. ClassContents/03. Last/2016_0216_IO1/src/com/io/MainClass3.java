package com.io;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MainClass3 extends JFrame
implements ActionListener
{
    JLabel la;
    JButton b1,b2;
    JTextField tf;
    public MainClass3()
    {
    	la=new JLabel("파일");
    	tf=new JTextField(25);
    	b1=new JButton("찾기");
    	b2=new JButton("저장");
    	setLayout(new FlowLayout());
    	add(la);
    	add(tf);
    	add(b1);
    	add(b2);
    	setSize(600,200);
    	setVisible(true);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	b1.addActionListener(this);
    	b2.addActionListener(this);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new MainClass3();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1)
		{
			JFileChooser jc=
					new JFileChooser();
			if(jc.showOpenDialog(this)==jc.APPROVE_OPTION)
			{
				File file=jc.getSelectedFile();
				tf.setText(file.getPath());
			}
		}
		else if(e.getSource()==b2)
		{
			try
			{
				String path=tf.getText();
				File file=new File(path);
				saveFile(file);
			}catch(Exception ex){}
		}
	}
	public void saveFile(File file)
	{
		try
		{
			FileInputStream fis=
				new FileInputStream(file);
			FileOutputStream fos=
				new FileOutputStream("./download/"+file.getName());
			byte[] buffer=new byte[1024];
			int i=0;
			while((i=fis.read(buffer, 0, 1024))!=-1)
			{
				fos.write(buffer, 0, i);
			}
			fis.close();
			fos.close();
			JOptionPane.showMessageDialog(this,
					"파일 업로드 완료");
		}catch(Exception ex){}
	}

}



