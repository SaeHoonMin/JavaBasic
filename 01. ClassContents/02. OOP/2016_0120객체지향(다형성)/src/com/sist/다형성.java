package com.sist;
/*
 *    1. 다형성 (오버로딩,오버라이딩)
 *       오버로딩 (중복메소드 정의)
 *       오버라이딩(메소드 재정의)
 *     ==============================
 *       오버로딩                            오버라이딩
 *     ==============================
 *      같은 클래스내에서                     상속
 *      메소드명 동일                      메소드명이 동일 
 *      매개변수가 다르다               매개변수가 동일
 *      리턴형과 관계없다               리턴형이 동일
 *                       접근지정어의 확대
 *     ===============================
 *       접근지정어의 크기 
 *       private < default < protected < public 
 *     
 *     1) 캡슐화 : 기능별 분리 , 데이터 은닉화 
 *              ==> 메소드와 변수가 하나로 묶어서 
 *     2) 상속 : 기존의 클래스를 확장해서 사용 
 *             추가(오버로딩),변경(오버라이딩) (다형성)
 *             
 *    2. 클래스의 종류 
 *       1) 추상클래스  : 공통적으로 적용되는 메소드가 존재할 때 
 *                   버튼 클릭,마우스 처리,키보드 
 *                   => 서로 다른 클래스 연결해서 사용 할 때 
 *                   => 설계용으로 주로 사용한다 
 *          원형)  
 *          public abstract class className
 *          {
 *               선언만된 메소드가 한개이상 (구현없는 메소드)
 *               public abstract 리턴형 메소드명();
 *               public void display(){}
 *          }
 *       2) 내부 클래스 : 윈도우,네트워크,쓰레드 
 *            => 공통으로 사용되는 데이터,메소드가 있는 경우에 주로 사용
 *            ***** 멤버 클래스
 *            class A
 *            {
 *              A와 B가 공통으로 사용된 데이터 
 *              class B
 *              {
 *              }
 *            }
 *            ***** 익명의 클래스 : 상속없이 재정의(오버라이딩)
 *            class A
 *            {
 *               B b=new B()
 *               {
 *                  void display(){}
 *               }
 *            }
 *            class B
 *            {
 *               void display(){}
 *            }
 *            ***** 지역클래스 (X)
 *            class A
 *            {
 *               public void display()
 *               {
 *                   class B
 *                   {
 *                   }
 *               }
 *            }
 *        3) 종단 클래스 : 상속을 할 수 없는 클래스 
 *                    => 변경이 불가능한 클래스
 *                       String , Math,System
 *           public final class className
 *           {
 *           }
 *           
 *        4) 인터페이스 : 추상클래스의 일종 
 *              => 다중상속이 가능 
 *              => 모든 메소드가 추상메소드 (선언)
 *              => 모든 변수는 상수형 
 *              => 관련된 클래스를 묶어서 관리 
 *              => 표준화가 가능하다 
 *              원형)
 *              public interface Name
 *              {
 *                 (public static final) int a=20; // 상수형 
 *                 (public abstract) void display();
 *              }
 *              
 *              => 클래스가 인터페이스로부터 상속 => 메소드를 구현해서 사용 
 *              public interface Name
 *              {
 *                  void disp();
 *                  default public void aaa()
 *                  {
 *                  }
 *                  public static void bbb()
 *                  {
 *                  } 
 *              }
 *              
 *              => 
 *              class A implements Name
 *              {
 *                  public void disp(){}
 *              }
 *       
 *       상속 
 *          interface ==> interface
 *                  extends 
 *          interface ==> class
 *                  implements
 *          class ==> class
 *                  extends 
 *          class ==> interface
 *                 error 
 *                 
 *          interface A
 *          interface B extends A
 *          interface C extends B
 *          class D implements C
 *          class D implements A,B,C
 *                           Mouse,Key,Runnable,Action
 *          ========================================
 *            추상 클래스                                인터페이스 
 *          ========================================
 *            단일 상속                                 다중 상속 
 *            구현(O),구현(X)       구현(X)
 *                               default,static(1.8)
 *            오버라이딩                            오버라이딩 
 *            클래스를 묶어서 사용  ===> factory패턴 
 *          ========================================
 */
// 추상클래스 
abstract class Ani
{
	public abstract void eat();
	public void run()
	{
		System.out.println("네발로 걷는다");
	}
}
class Human extends Ani
{

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("수저로 먹는다");
	}
	public void run()
	{
		System.out.println("두발로 걷는다");
	}
	
}
class Dog extends Ani
{

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("개같이 먹는다");
	}
	
}
class Pig extends Ani
{

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("돼지같이 먹는다");
	}
	
}
public class 다형성 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
