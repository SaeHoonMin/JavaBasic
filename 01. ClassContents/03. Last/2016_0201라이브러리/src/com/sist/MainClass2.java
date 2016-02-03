package com.sist;
// Object : finalize() : 객체메모리 회수시에 호출되는 메소드 
// ===> null => GC대상 (finalize())
class Member
{
	public Member()
	{
		System.out.println("(생성자호출:메모리 초기화)Member() Call..");
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("객체 소멸:finalize() Call...");
	}
	
}
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Member m=new Member();
        m=null;
        System.gc();// 가비지 켈렉션 호출 
	}

}
