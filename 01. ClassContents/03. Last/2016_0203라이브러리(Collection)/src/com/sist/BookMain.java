package com.sist;
/*
 *   클래스 용도 
 *     = 데이터를 모아서 사용하는 클래스  => DTO,VO
 *     = 데이터를 활용하는 클래스  => DAO
 *     = 모양을 제작 (윈도우,웹,안드로이드) => 디자인
 *           MyBatis,JPA,Hibernate,XML,Annotation
 *     오라클  => JSP => Spring => Hadoop => R
 *     ====================================
 *                               스파크    Node.js,Mean Stack
 *                               MongoDB 
 *                               IOT => 보안(해킹,시큐어 코딩) 
 *        (HTML,JavaScript,JQuery,AngularJS)
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
/*
 *    java : JDK 1.0 (Java)
 *    javax : JDK 1.2 (Java2) : swing,servlet,xml
 *    => JDK 1.8 (Java3) : 람다식,나즈혼(자바스크립트 제어),JavaFx
 *                        ======
 *                        함수인터페이스 
 *       =====> 오라클사에 처음으로 변경   <-
 */
import javax.swing.table.*;
// 인포트 자바엑스점스윙점
public class BookMain extends JFrame
implements MouseListener,ItemListener
{
    JTable table;
    DefaultTableModel model;
    BookPanel bp=new BookPanel();
    BookManager bm=new BookManager();
    JLabel la1,la2,la3,la4,la5;
    JComboBox box;
    JLabel la6;
    JTextField tf;
    JButton b;
    public BookMain()
    {
    	String[] col={"번호","제목","저자"};
    	String[][] row=new String[0][3];
    	model=new DefaultTableModel(row,col)
    	{
    		// 익명의 클래스 : 변경,추가
    		public boolean isCellEditable(int r,int c)
    		{
    			return false;
    		}
    	};
    	table=new JTable(model);
    	JScrollPane js=new JScrollPane(table);
    	la1=new JLabel("번호:");
    	la2=new JLabel("제목:");
    	la3=new JLabel("저자:");
    	la4=new JLabel("출판사:");
    	la5=new JLabel("가격:");
    	
    	la6=new JLabel("Search");
    	box=new JComboBox();
    	box.addItem("위키북스");
    	box.addItem("한빛미디어");
    	box.addItem("영진출판사");
    	box.addItem("대림출판사");
    	tf=new JTextField(20);
    	tf.setEditable(false);
    	b=new JButton("전체목록");
    	//<input type=text readonly>
    	JPanel p=new JPanel();
    	p.add(la6);
    	p.add(box);
    	p.add(tf);
    	p.add(b);
    	// 배치
    	setLayout(null);
    	p.setBounds(10, 15, 620, 35);
    	js.setBounds(10, 55, 620, 245);
    	bp.setBounds(10, 320, 300, 170);
    	la1.setBounds(320, 320, 300, 30);
    	la2.setBounds(320, 355, 300, 30);
    	la3.setBounds(320, 390, 300, 30);
    	la4.setBounds(320, 425, 300, 30);
    	la5.setBounds(320, 460, 300, 30);
    	add(p);
    	add(js);
    	add(bp);
    	add(la1);add(la2);
    	add(la3);add(la4);
    	add(la5);
    	
    	setSize(640,550);
    	setVisible(true);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	getData();
    	getData();
    	table.addMouseListener(this);
    	box.addItemListener(this);
    	b.addMouseListener(this);
    }
    public void getData()
    {
    	for(int i=model.getRowCount()-1;i>=0;i--)
    	{
    		model.removeRow(i);
    	}
    	ArrayList<Book> list=bm.bookAllData();
    	for(Book book:list)
    	{
    		String[] data={
    			String.valueOf(book.getNo()),
    			book.getTitle(),
    			book.getAuthor()
    		};
    		model.addRow(data);
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new BookMain();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==table)
		{
			if(e.getClickCount()==2)// 더블클릭
			{
				int row=table.getSelectedRow();
				String no=model.getValueAt(row, 0).toString();
				bp.setPoster(Integer.parseInt(no));
				bp.repaint();
				Book book=bm.bookDetail(Integer.parseInt(no));
				la1.setText("번호:"+no);
				la2.setText("제목:"+book.getTitle());
				la3.setText("저자:"+book.getAuthor());
				la4.setText("출판사:"+book.getPublisher());
				la5.setText("가격:"+book.getPrice());
			}
		}
		else if(e.getSource()==b)
		{
			getData();
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
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==box)
		{
			getFindData();
		}
	}
	public void getFindData()
    {
    	for(int i=model.getRowCount()-1;i>=0;i--)
    	{
    		model.removeRow(i);
    	}
    	String pub=box.getSelectedItem().toString();
    	ArrayList<Book> list=bm.bookFindData(pub);
    	tf.setText(pub);
    	for(Book book:list)
    	{
    		String[] data={
    			String.valueOf(book.getNo()),
    			book.getTitle(),
    			book.getAuthor()
    		};
    		model.addRow(data);
    	}
    }

}



