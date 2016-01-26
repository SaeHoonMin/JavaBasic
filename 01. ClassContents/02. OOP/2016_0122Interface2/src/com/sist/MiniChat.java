package com.sist;
/*
 *    interface 
 *       => 서로다른 클래스를 묶어서 사용 
 *       => 표준화가 가능하다
 *       형식)
 *           interface interfaceName
 *           {
 *               변수
 *               int a=10; => public static final
 *               메소드 (선언)
 *               void display(); => public abstract
 *               구현된 메소드(JDK 1.8)
 *                 static void a(){}
 *                 default void b(){}
 *           }
 *        => 단점 
 *            메모리 할당을 할 수 없다(미완성된 클래스)
 *            항상 상속받은 클래스 미완성된 메소드를 구현해서 사용
 *            => class가 상속받을 경우에는 implements를 사용한다 
 *        => 장점 
 *            다중 상속이 가능하다 
 *            interface A
 *            interface B
 *            class C implements A,B
 */
import java.awt.*;
import java.awt.event.*;//interface
import javax.swing.*;
/*
 *   윈도우 처리 => 윈도우 기능 
 *             =======
 *              1) 상속
 *              class A extends JFrame
 *              2) 포함 
 *              class A
 *              {
 *                 JFrame f=new JFrame();
 *              }
 */
public class MiniChat extends JFrame
implements ActionListener
{
    JTextArea ta;
    JTextField tf;
    public MiniChat()
    {
    	ta=new JTextArea();
    	ta.setEditable(false);
    	JScrollPane js=new JScrollPane(ta);
    	// 편집 방지 
    	tf=new JTextField(20);
    	// 배치
    	add("Center",js);
    	add("South",tf);
    	setSize(350,450);
    	setVisible(true);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	
    	tf.addActionListener(this);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new MiniChat();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==tf)
		{
			String data=tf.getText();
			if(data.length()<1)
				return;
			ta.append(data+"\n");
			tf.setText("");
		}
	}

}




