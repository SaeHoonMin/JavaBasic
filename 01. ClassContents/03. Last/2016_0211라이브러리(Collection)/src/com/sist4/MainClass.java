package com.sist4;

import java.lang.reflect.Method;

class A
{
	public void display1()
	{
		System.out.println("A:display1 Call...");
	}
	public void display2()
	{
		System.out.println("A:display2 Call...");
	}
}
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try
        {
        	Class clsName=Class.forName("com.sist4.A");
        	Object obj=clsName.newInstance();
        	//  A a=new A();
        	Method[] m=clsName.getDeclaredMethods();
        	m[0].invoke(obj, null);
        }catch(Exception ex){}
	}

}
