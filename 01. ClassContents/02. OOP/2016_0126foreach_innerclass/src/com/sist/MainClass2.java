package com.sist;
/*
 *   1) 내부클래스 
 *        = 멤버클래스 : 윈도우,쓰레드,네트워크 
 *          class A
 *          {
 *             A와 B가 공유하는 내용 
 *             class B
 *             {
 *                A클래스가 가지고 있는 모든 메소드,변수를 이용할 수 있다
 *             }
 *          }
 *        = 익명의 클래스 : 상속없이 오버라이딩이 가능 
 *        형식)
 *             class A
 *             {
 *                B b=new B()
 *                {
 *                   // B가 가지고 있는 메소드를 재정의
 *                }
 *             }
 *             class B
 *             {
 *                public void display(){}
 *             }
 */
import java.awt.*;
import javax.swing.*;
public class MainClass2 extends JFrame{
    GameView gv=new GameView();
    public MainClass2()
    {
    	add("Center",gv);
    	
    	setSize(800, 600);
    	setVisible(true);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new MainClass2();
	}

}
