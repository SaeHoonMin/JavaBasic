package com.sist;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
public class MiniChat2 extends JFrame
implements ActionListener
{
    JTextPane pane;			//색상별로 바뀔려면 textPane으로 해야한다...
    JTextField tf;
    JComboBox box;
    public MiniChat2()
    {
    	pane=new JTextPane();
    	pane.setEditable(false);
    	JScrollPane js=new JScrollPane(pane);
    	tf=new JTextField(20);
    	box=new JComboBox();
    	box.addItem("black");
    	box.addItem("green");
    	box.addItem("pink");
    	box.addItem("cyan");
    	box.addItem("magenta");
    	JPanel p=new JPanel();
    	p.add(tf);
    	p.add(box);
    	
    	add("Center",js);
    	add("South",p);
    	setSize(420,450);
    	setVisible(true);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	tf.addActionListener(this);
    }
    // 색상 변경 
    public void initStyle()
    {
    	// default 색상 
    	Style def=StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);
    	
    	Style green=pane.addStyle("green", def);
    	StyleConstants.setForeground(green, Color.green);
    	
    	Style pink=pane.addStyle("pink", def);
    	StyleConstants.setForeground(pink, Color.pink);
    	
    	Style cyan=pane.addStyle("cyan", def);
    	StyleConstants.setForeground(cyan, Color.cyan);
    	
    	Style magenta=pane.addStyle("magenta", def);
    	StyleConstants.setForeground(magenta, Color.magenta);
    	
    }
    // 문자열 결합 
    public void append(String msg,String color)
    throws Exception
    {
    	Document doc=pane.getDocument();
    	
		doc.insertString(doc.getLength(), msg+"\n", pane.getStyle(color));
		
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new MiniChat2();
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		if(e.getSource()==tf)
		{
			String data=tf.getText();
			if(data.length()<1)
				return;
			initStyle();
			String color=box.getSelectedItem().toString();
			try {
				append(data,color);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			tf.setText("");
		}
	}

}
