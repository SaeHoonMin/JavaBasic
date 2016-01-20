package com.sist;
class A
{
	int a=10;
	public void display(){
		System.out.println("A:display() Call...");
	}
	
}
class B extends A
{
	int a=20;
	public void display(){
		System.out.println("B:display() Call...");
	}
	
}
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     /*   A a=new A();
        a.display();
        B b=new B();
        a=b;
        a.display();
        
        b=(B)a;
        b.display();*/
		//Object o=new A();
		// 변수:클래스타입 , 메소드:생성자
		//System.out.println(o.toString());
		//Object o1=new B();
      /*  B b=new B();
        b.display();
        A c=new B();
        c.display();*/
        A a=new A();
        a.display();
        System.out.println(a.a);
        B b=new B();
        b.display();
        System.out.println(b.a);
        A c=new B();
        c.display();
        System.out.println(c.a);
	}

}
