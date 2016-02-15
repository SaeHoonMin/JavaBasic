package com.sist;
/*
 *   Thread : java.lang
 *   
 *   생성 방법 : implements Runnable
 *           extends Thread
 *   Thread 생명주기 
 *     = new Thread() : name,priority(우선순위)
 *                      name : Thread-0
 *                      priority : 1~10
 *                        MAX(10),MIN(1),NORM(5)
 *                        사용자 정의는 NORM
 *                       
 *     = 대기상태 (Runnable) => start()
 *     = 실행상태 (Running) => run()
 *       start() => run()호출 
 *         run(): Thread의 동작을 설정 
 *       = Blocked (일시 정지) : sleep,wait
 *       = Dead (종료) : join,interrupt()
 */
class MyThread extends Thread
{
	public void run()
	{
		try
		{
			for(int i=1;i<=10;i++)
			{
				System.out.println(getName()+":"+i);
				Thread.sleep(100);
			}
		}catch(Exception ex){}
	}
}
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        MyThread m1=new MyThread();
//        m1.setName("10번");
//        System.out.println(m1.getName());
//        System.out.println(m1.getPriority());
        
        MyThread m2 = new MyThread();
        MyThread m3 = new MyThread();
        
        
        m1.start();
        m2.start();
        m3.start();
        
	}

}
