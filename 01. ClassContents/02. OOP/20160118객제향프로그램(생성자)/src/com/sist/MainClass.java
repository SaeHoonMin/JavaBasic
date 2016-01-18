package com.sist;
/*
 *    자바 => 파일의 구성 
 *    1) 파일명과 클래스명이 동일 
 *    2) 순서 
 *       package : 한번만 사용이 가능  
 *       import : 여러개 사용 할 수 있다 
 *       class clasName
 *       {
 *           ===========
 *             멤버변수 (instance)
 *             공통변수 (static)
 *           ===========
 *             메소드 선언 : 메소드안 다른 메소드를 선언할 수 없다
 *           ===========
 *             생성자 (생략이 가능하다)
 *           ===========
 *       }
 *       
 *       class A  ==> 쓰레드,네트워크
 *       {
 *          class B
 *          {
 *          }
 *       } ==> 내부 클래스
 *       class A
 *       {
 *          void disp()
 *          {
 *             class B
 *             {
 *             }
 *          }
 *       } ==> 지역 클래스 
 *       class A
 *       {
 *          void disp()
 *          {
 *             void aaa()
 *             {
 *             }
 *          }
 *       } ==> error
 *    
 *    1) 객체는 모듈화 
 *       데이터와 오퍼레이션(메소드)를 포함하는 모듈이다 
 *       ==> 연결후 그룹화 (캡슐화)
 *       ==> 재사용
 *       ==> 변경,추가 
 *    2) 생성자 
 *       ==> 클래스를 메모리에 저장할 경우에 호출되는 메소드 
 *           new 생성자()
 *       ==> 특징 
 *           1. 클래스명과 동일 
 *           2. 리턴형이 없다 
 *           3. 오버로딩을 지원한다(여러개의 생성자가 존재 할 수 있다)
 *              =====
 *               = 같은 클래스에 존재
 *               = 메소드명이 동일 
 *               = 매개변수 갯수나 데이터형이 다르다
 *               = 리턴형은 관계가 없다 
 *               = 중복 함수 정의 
 *               
 *           4. 멤버변수의 초기화 (초기화블럭) 
 *           5. 사용처 : 윈도우,네트워크,쓰레드,데이터베이스
 *           6. 생성자함수는 생략이 될 경우에는 
 *              JVM 자동으로 생성자함수를 지원한다
 *              (디폴트 생성자) => 매개변수 없는 생성자 
 *              new A();
 *           7. 생성자 => 객체를 생성 
 *              = 객체를 소멸 => 소멸자(Object)
 *                객체가 null이거나 더이상 사용하지 않는 경우에
 *                자동으로 메모리 회수 (GC)
 */
public class MainClass {
    int age; // 0
    String name; // null
    /*MainClass()
    {
    	name="홍길동";
    	age=30;
    }*/
    MainClass(String n,int a)
    {
    	name=n;
    	age=a;
    }
    MainClass()
    {
    	name="홍길동";
    	age=30;
    }
    MainClass(int a)
    {
    	age=a;
    }
    MainClass(String n)
    {
    	name=n;
    }
    // 일반 메소드
    void MainClass()
    {
    	name="춘향이";
    	age=28;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        /*MainClass m=new MainClass();
        System.out.println(m.name);
        System.out.println(m.age);*/
		MainClass m=new MainClass("심청이",25);
		System.out.println(m.name);
        System.out.println(m.age);
        m=new MainClass(20);
        System.out.println(m.name);
        System.out.println(m.age);
        
        m=new MainClass("김두한");
        System.out.println(m.name);
        System.out.println(m.age);
		
	}

}




