package com.sist;
/*
 *    1) 재사용(확장)
 *    2) 반복코딩을 제거
 *    3) 상속 : 기존의 기능을 그대로 사용
 *            변경해서 사용이 가능 ---> 오버라이딩 
 *            
 *    4) 자바의 상속은 단일 상속 
 *       A   B
 *       C extends A,B (X)
 *       
 *       B extends A
 *       C extends B
 *    5) 상속의 예외 
 *        생성자 , static , private
 */
class 동물
{
	static int age=10;
	public void eat(){System.out.println("먹는다");}
	void run(){System.out.println("걷는다");}
	public 동물()
	{
		System.out.println("동물() Call...");
	}
}
class 사람  extends 동물
{
	/*
	 *   int age=10;
	     void eat(){System.out.println("먹는다");}
	     void run(){System.out.println("걷는다");}
	 */
	public void eat()
	{
		System.out.println("수저로 먹는다");
	}
	/*
	 *   오버라이딩 
	 *     => 상속이 존재 (익명의 클래스)
	 *     => 메소드명이 동일
	 *     => 매개변수가 동일 
	 *     => 리턴형이 동일 
	 *     => 확장,축소는 불가능 (접근지정어)
	 *        public > protected > default > private
	 */
}
class 개 extends 동물
{
	/*
	 *   int age=10;
	     void eat(){System.out.println("먹는다");}
	     void run(){System.out.println("걷는다");}
	 */
	public void eat()
	{
		System.out.println("개같이 먹는다");
	}
}
class 소 extends 사람
{
	/*
	 *   int age=10;
	     void eat(){System.out.println("먹는다");}
	     void run(){System.out.println("걷는다");}
	 */
	public 소()
	{
		System.out.println("소() Call...");
	}
	/*public void eat()
	{
		System.out.println("되새김을 한다");
	}*/
}
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
                  소 a=new 소();
        System.out.println("나이:"+a.age);
        a.eat();
        a.run();
        사람 b=new 사람();
        b.eat();
        b.age=10;
        
	}

}
