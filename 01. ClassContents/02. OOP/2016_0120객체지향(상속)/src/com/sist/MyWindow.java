package com.sist;
/*
 *   기존의 만들어진 클래스를 사용(재사용)
 *   ==========
 *       B  
 *   ==========
 *   1. 상속  ==> is-a : 단일상속
 *   class A extends B  ==> 
 *   2. 포함  ==> has-a
 *   class A
 *   {
 *       B b;==>익명의 클래스
 *   }
 *   
 *   =======================
 *   사용자정의 class 
 *   라이브러리 상속 ===> 윈도우
 *   
 *   윈도우 제작 
 *   1) 라이브러리를 읽어온다 
 *      import javax.swing : 윈도우와 관련된 모든 클래스 
 *      import java.awt : Layout
 *      import java.awt.event : 이벤트 처리 
 *   2) 화면 구성 
 *      = 필요한 컴포넌트를 선언
 *        JButton b1,b2;
 *      = 생성자에서 컴포넌트를 메모리 할당 
 *        b1=new JButton()
 *        속성처리 
 *        b1.setEnabled(false)
 *        배치 
 *        윈도우 크기 setSize(w,h)
 *        윈도우 보여라 setVisiable(true)
 *    3) 호출 
 *       new 생성자()   
 *    4) 이벤트에 대한 처리 ==> interface  
 *    =============================
 *    윈도우 창 (Container)
 *      = JFrame : 일반 윈도우(타이틀바)
 *      = JWindow : 타일틀바가 없는 윈도우 (게임소개,로그인)
 *      = JDialog : Modal , Modaless
 *      = JPanel : 단독으로 수행이 불가능 
 *                 (Component묶러서 사용이 가능)
 *    기능 (Component)
 *      = Button (JButton,JRadioButton,JCheckbox,JMenu)
 *      = TextField (JTextField,JPasswordField)
 *      = TextArea (JTextArea,JTextPane)
 *      = List (JList,JTable,JTree,JComboBox)
 *      = etc : JProgressBar , JSilderBar ,
 *              JScrollPane 
 *        => 윈도우 분리 : JTabbPane,JSilptPane,JInternalFrame
 *    배치
 *      = BorderLayout (5군데 배치)
 *      = FlowLayout (1자 배열)
 *      = GridLayout
 *      = CardLayout
 *    이벤트 
 *      = ActionListener : Button,Menu,TextField
 *      = MouseListener : 모든 컴포넌트에 적용
 *      = KeyListener : 키워드와 관련 
 *      = ItemListener : 콤보,목록선택 
 *      
 */
// 레이아웃 
import java.awt.*;
import javax.swing.*;
public class MyWindow extends JFrame{
    JButton b1,b2,b3,b4,b5;
    public MyWindow()
    {
    	b1=new JButton("North",new ImageIcon("c:\\image\\enter.gif"));
    	// 생성자 => 오버로딩  
    	b2=new JButton("East");
    	b2.setToolTipText("로그인");
    	b3=new JButton("West");
    	b4=new JButton("Center");
    	b5=new JButton("South");
    	b1.setRolloverIcon(new ImageIcon("c:\\image\\enter2.gif"));
    	b4.setEnabled(false);
    	// 배치
//    	add("North",b1);
//    	add("East",b2);
//    	add("West",b3);
//    	add("Center",b4);
//    	add("South",b5);
    	
    	setLayout(new GridLayout(3,2,5,5));
    	add(b1);
    	add(b2);
    	add(b3);
    	add(b4);
    	add(b5);
    	
    
    	
    	setSize(640,480);
    	setVisible(true);
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        MyWindow m=new MyWindow();
	}

}



