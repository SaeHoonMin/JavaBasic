package com.sist;
interface 비행기
{
	void fly();
}
interface 배
{
	void ship();
}
class 자동차 implements 비행기,배
{

	@Override
	public void ship() {
		// TODO Auto-generated method stub
		System.out.println("배 기능 추가");
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("비행기 기능 추가");
	}
	public void drive()
	{
		System.out.println("자동차 기능");
	}
	
}
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		비행기 a = new 자동차();
		배 b = new 자동차();
		자동차 c = new 자동차();
		

	}
}
