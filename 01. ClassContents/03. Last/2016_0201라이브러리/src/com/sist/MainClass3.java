package com.sist;
// clone : 복제 
class Sawon
{
	String name;
	String dept;
	
	public void print()
	{
		System.out.println("Name:"+name);
		System.out.println("Dept:"+dept);
	}
}
/*
 *    class A impements B
 *    
 *    B b=new A();
 */
class Student implements Cloneable
{
	String id;
	public Student display()
	{
		Student s=null;
		try
		{
			s=(Student)super.clone();
		}catch(Exception ex){}
		return s;
	}
}
public class MainClass3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// prototype
		Student s1=new Student();
		s1.id="hong";
		System.out.println("s1.id:"+s1.id);
		Student s2=s1.display();
		//s2.id="shim";
		System.out.println("s2.id:"+s2.id);
		System.out.println("s1.id:"+s1.id);
        /*Sawon s1=new Sawon();
        s1.name="홍길동";
        s1.dept="영업부";
        s1.print();
        Sawon s2=s1;
        // 주소만 참조 ==> 메모리 같다
        s2.name="심청이";
        s2.dept="개발부";
        s2.print();
        s1.print();*/
	}

}
