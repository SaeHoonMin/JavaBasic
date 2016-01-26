import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
// 한개이상의 기능에서 사용 ==> 멤버 
// 
//
public class MainClass extends JFrame
implements ActionListener
{
    JLabel la1,la2,la3,la4,la5,la6,la7;
    JTextField tf1,tf2,tf3,tf4,tf5;
    JComboBox box;
    JRadioButton rb1,rb2;
    JButton b1,b2,b3;
    Student std=new Student();
    // 화면 디자인
    public MainClass()
    {
    	la1=new JLabel("학번");
    	la2=new JLabel("이름");
    	la3=new JLabel("성별");
    	la4=new JLabel("전공");
    	la5=new JLabel("국어");
    	la6=new JLabel("영어");
    	la7=new JLabel("수학");
    	
    	tf1=new JTextField();
    	tf2=new JTextField();
    	tf3=new JTextField();
    	tf4=new JTextField();
    	tf5=new JTextField();
    	
    	box=new JComboBox();
    	// 데이터 첨부 
    	box.addItem("컴공");
    	box.addItem("영문학");
    	box.addItem("국문학");
    	
    	rb1=new JRadioButton("남자");
    	rb2=new JRadioButton("여자");
    	
    	// RadionButton => 반드시 그룹으로 묶어서 사용 
    	// ButtonGroup
    	ButtonGroup bg=new ButtonGroup();
    	bg.add(rb1);
    	bg.add(rb2);
    	
    	b1=new JButton("입력");
    	b2=new JButton("출력");
    	b3=new JButton("취소");
    	
    	b2.setEnabled(false);
    	
    	// 속성 처리 
    	rb1.setSelected(true);//남자 라디오 버튼을 선택한다 
    	// isSelected()
    	
    	// 배치
    	setLayout(null);//지원하는 Layout을 사용하지 않는다 
    	/*
    	 *   JFrame,JWindow,JDialog : default(BorderLayout)
    	 *   JPanel : FlowLayout 
    	 */
    	la1.setBounds(10, 15, 30, 30);
    	tf1.setBounds(45, 15, 150, 30);
    	
    	la2.setBounds(10, 50, 30, 30);
    	tf2.setBounds(45, 50, 150, 30);
    	
    	la3.setBounds(10, 85, 30, 30);
    	rb1.setBounds(45, 85, 70, 30);
    	rb2.setBounds(120, 85, 70, 30);
    	
    	la4.setBounds(10, 120, 30, 30);
    	box.setBounds(45, 120, 150, 30);
    	
    	la5.setBounds(10, 155, 30, 30);
    	tf3.setBounds(45, 155, 150, 30);
    	
    	la6.setBounds(10, 190, 30, 30);
    	tf4.setBounds(45, 190, 150, 30);
    	
    	la7.setBounds(10, 225, 30, 30);
    	tf5.setBounds(45, 225, 150, 30);
    	
    	JPanel p=new JPanel();
    	p.add(b1);
    	p.add(b2);
    	p.add(b3);
    	p.setBounds(10, 260, 250, 35);
    	
    	// 윈도우에 추가
    	add(la1);add(tf1);
    	add(la2);add(tf2);
    	add(la3);add(rb1);add(rb2);
    	add(la4);add(box);
    	add(la5);add(tf3);
    	add(la6);add(tf4);
    	add(la7);add(tf5);
    	add(p);
    	
    	// 윈도우 크기
    	setSize(285,335);
    	setVisible(true);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	
    	// 버튼을 클릭하면 MainClass가 가지고 있는 actionPerformed를 호출하라
    	// 시스템에 의해서 자동 호출 ==> CallBack
    	b1.addActionListener(this);
    	b2.addActionListener(this);
    	b3.addActionListener(this);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 윈도우 출력 =>생성자 호출 
		new MainClass();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1)
		{
			// 학번을 읽어 온다  : 
			// " 1" => error , "1" => 정수로 변경
			// Integer.parseInt("1") => static
			String hak=tf1.getText().trim();
			std.setHakbun(Integer.parseInt(hak));
			/*
			 *   데이터형을 제어할 수 있게 클래스화 (Wrapper)
			 *   ***** int : Integer
			 *   ***** double : Double
			 *   boolean : Boolean
			 *   byte : Byte 
			 *   
			 *   var a=10
			 *       a="10"
			 *       a=[]
			 *       a={}
			 */
			// TextField에 입력된 값을 읽는다 
			// 이름
			String name=tf2.getText().trim();
			std.setName(name);
			// 성별
			if(rb1.isSelected())
				std.setSex("남자");
			else
				std.setSex("여자");
			
			// 전공 :
			String sub=(String)box.getSelectedItem();
			std.setSubject(sub);
			// 국어 :
			String kor=tf3.getText().trim();
			std.setKor(Integer.parseInt(kor));
			// 영어 :
			String eng=tf4.getText().trim();
			std.setEng(Integer.parseInt(eng));
			// 수학 :
			String math=tf5.getText().trim();
			std.setMath(Integer.parseInt(math));
			
			// 완료
			JOptionPane.showMessageDialog(this,
					"저장 완료");
			
			b2.setEnabled(true);
		}
		else if(e.getSource()==b2)
		{
			String result="학번:"+std.getHakbun()+"\n"
					+"이름:"+std.getName()+"\n"
					+"성별:"+std.getSex()+"\n"
					+"전공:"+std.getSubject()+"\n"
					+"국어:"+std.getKor()+"\n"
					+"영어:"+std.getEng()+"\n"
					+"수학:"+std.getMath();
			JOptionPane.showMessageDialog(this,
					result);
			
		}
		else if(e.getSource()==b3)
		{
			dispose(); // 메모리 해제
			System.exit(0);
			// 정상 종료 (0),비정상 종료(1)
		}
	}

}
