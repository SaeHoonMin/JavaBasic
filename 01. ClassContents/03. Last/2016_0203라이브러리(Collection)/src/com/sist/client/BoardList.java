package com.sist.client;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
public class BoardList extends JPanel{
     JLabel la;
     JButton b1;
     JTable table;
     DefaultTableModel model;
     JLabel la2;
     JComboBox box;
     JTextField tf;
     JButton b2,b3,b4,b5;
     JLabel pageLa;
     TableColumn column;
     /*
      *   생성자 => 메모리할당시에 한번만 호출 
      *   ====
      *    특징) 클래스명과 동일 
      *        멤버의 초기화 
      *        오버로딩지원 => 다형성의 일종 
      *        *** 상속에서 제외가 된다 
      *        
      *    ===> 초기화 블럭 
      *    인스턴스 초기화 블럭  {}
      *    static 의 초기화 블럭 static{}
      *    class영역에는 로직을 사용할 수 없다 
      *      ==> 선언만 가능 하다 
      *      
      *    ****** 라이브러리 사용 
      *      = 포함 : 있는 그대로 사용 
      *      = 상속 : 변경이 가능 
      */
     public BoardList()
     {
    	 la=new JLabel("게시판");
    	 la.setFont(new Font("맑은 고딕",Font.BOLD,30));
    	 b1=new JButton("새글");
    	 JPanel p=new JPanel();
    	 p.add(la);
    	 
    	 String[] col={"번호","제목","이름","작성일","조회수"};
    	 String[][] row=new String[0][5];
    	 model=new DefaultTableModel(row, col)
    	 {
    		 public boolean isCellEditable(int r,int c)
    		 {
    			 return false;
    		 }
    	 };
    	 table=new JTable(model);
    	 table.setRowHeight(27);
    	 table.setShowGrid(false);
    	 table.setSelectionBackground(Color.gray);
    	 table.setSelectionForeground(Color.pink);
    	 table.getTableHeader().
    	       setReorderingAllowed(false);
    	 table.getTableHeader().setResizingAllowed(false);
    	 table.getTableHeader().setBackground(Color.pink);
    	 JScrollPane js=new JScrollPane(table);
    	 js.getViewport().setBackground(Color.white);
    	 
    	 la2=new JLabel("Search");
    	 box=new JComboBox();
    	 box.addItem("이름");
    	 box.addItem("제목");
    	 box.addItem("내용");
    	 b2=new JButton("찾기");
    	 b3=new JButton("목록");
    	 b4=new JButton("이전");
    	 b5=new JButton("다음");
    	 pageLa=new JLabel("0 page / 0 pages");
    	 tf=new JTextField(10);
    	 JPanel p1=new JPanel();
    	 p1.add(la2);
    	 p1.add(box);
    	 p1.add(tf);
    	 p1.add(b2);
    	 p1.add(b3);
    	 JPanel p2=new JPanel();
    	 p2.add(b4);
    	 p2.add(b5);
    	 p2.add(pageLa);
    	 
    	 setLayout(null);
    	 p.setBounds(10, 15, 770, 45);
    	 b1.setBounds(10, 65, 100, 30);
    	 js.setBounds(10, 100, 770, 400);
    	 p1.setBounds(10, 505, 350, 35);
    	 p2.setBounds(550, 505, 230, 35);
    	 add(p);
    	 add(b1);
    	 add(js);
    	 add(p1);
    	 add(p2);
    	 for(int i=0;i<col.length;i++)
    	 {
    		 column=table.getColumnModel().getColumn(i);
    		 DefaultTableCellRenderer rnd=
    				new DefaultTableCellRenderer();
    		 if(i==0)
    		 {
    			 column.setPreferredWidth(60);
    			 rnd.setHorizontalAlignment(JLabel.CENTER);
    		 }
    		 else if(i==1)
    		 {
    			 column.setPreferredWidth(400);
    		 }
    		 else if(i==2)
    		 {
    			 column.setPreferredWidth(100);
    			 column.setPreferredWidth(60);
    			 rnd.setHorizontalAlignment(JLabel.CENTER);
    		 }
    		 else if(i==3)
    		 {
    			 column.setPreferredWidth(150);
    			 column.setPreferredWidth(60);
    			 rnd.setHorizontalAlignment(JLabel.CENTER);
    		 }
    		 else if(i==4)
    		 {
    			 column.setPreferredWidth(60);
    			 column.setPreferredWidth(60);
    			 rnd.setHorizontalAlignment(JLabel.RIGHT);
    		 }
    		 column.setCellRenderer(rnd); 
    	 }
     }
}




