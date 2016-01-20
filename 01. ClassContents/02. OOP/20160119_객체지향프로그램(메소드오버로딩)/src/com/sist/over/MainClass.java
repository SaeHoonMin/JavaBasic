package com.sist.over;
/*
 *   메소드 오버로딩 (+ +)
 *     => 같은 클래스내에서 
 *     => 같은 이름 메소드 
 *           => 매개변수의 개수가 틀리다,데이터형이 다르다 
 *           => 리턴형은 관계없다 
 *              print,println
 *     => plus(정수,정수)
 *        plus(실수,실수)
 *        plus(실수,정수)
 *        plus(정수,실수)
 *        plus(문자,문자)
 */
public class MainClass {
    public void plus(int a,int b,int c)
    {
    	System.out.println(a+b+c);
    }
    public void plus(char a,int b,float c)
    {
    	System.out.println(a+b+c);
    }
    public void plus(char a,float b,int c)
    {
    	System.out.println(a+b+c);
    }
    public void plus(double a,double b,double c)
    {
    	System.out.println(a+b+c);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         MainClass mc=new MainClass();
         mc.plus('A',10 , 20F);
	}

}
