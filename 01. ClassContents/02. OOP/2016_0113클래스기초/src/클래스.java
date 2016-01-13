import java.util.Scanner;

import javax.swing.JOptionPane;

/*
 *    클래스 발전 과정 
 *      변수  ==> 배열  ==> 구조체  ==> 클래스 
 *      : 데이터를 모아서 관리 
 *      변수 : 단일 데이터를 저장해서 사용
 *      배열 : 같은 크기의 데이터를 저장해서 사용
 *      구조체 : 다른 크기의 데이터를 모아서 사용 (모든 데이터=>공개)
 *      클래스 : 구조체 + 메소드 (비공개)
 *    클래스의 구성 요소 
 *      데이터(속성)
 *        => 멤버변수 
 *            공통변수(클래스변수) ==> static 
 *            객체변수 (인스턴스 변수) ==> (X)
 *            사용법 
 *              class A
 *              {
 *                 int a;
 *                 static int b;
 *              }
 *              b변수는 클래스를 가상머신 읽어을 경우에 저장 
 *              a변수는 저장 공간 만든후에 사용이 가능 (new)
 *              A aa=new A();
 *              stack
 *              == aa
 *              100          heap
 *              ==           === 100
 *                            a
 *                           ===
 *      메소드(기능) : 저장된 변수에 대해서 동작 수행 
 *      
 *      클래스 제작 
 *      1) 추상화 작업 : 설계(모델링)
 *          => 현실세계의 모든 사물을 단순화 
 *          사람 
 *          =========
 *           이름
 *           성별
 *           주민번호
 *           입
 *           눈 
 *           코
 *           귀
 *           ===========
 *             입 => 말하다
 *             귀 => 듣는다
 *             눈 => 본다
 *           ===========
 *      2) 구체화 작업 : 모델링 내용을 사뮬레이션 
 *      
 *      1) 변수 ==> 배열 , 클래스
 *      2) 명령문 ==> 메소드
 *      3) 클래스 ==> 패키지
 *      
 *      ======================
 *      클래스 형식( java )
 *      1) package
 *      2) import ==> 여러개 
 *      3) class className
 *         {
 *             변수 선언
 *            ============
 *             메소드 선언
 *            ============
 *             생성자 선언 => 생략
 *            ============
 *         }
 *         
 *      숫자야구게임 
 *      난수 발생    ==> com[]
 *      입력           ==> user[]
 *      비교           ==> com[],user[] ==> s,b
 *      힌트          ==> s,b
 *      종료         ==> s
 */

/*
 * 
 * 	생략 : extends Object
 * 		 import java.lang*
 * 				==========
 * 				String, Math, System..
 * 		 
 * 
 * 
 */
public class 클래스 {
	
	int [] com = new int [3] ; 
	int [] user = new int [3];
    int s, b;
    
    void getRand()
    {
    	for(int i=0;i<3;i++)
    	{
    		com[i] = (int)(Math.random()*9);
    		for(int j=0;j<i;j++)
    		{
    			if(com[i]==com[j])
    				i--;
    		}
    	}
    }
    void userInput()
    {
    	int num;
    	while(true)
    	{
    		String input = JOptionPane.showInputDialog("세 자리 정수 입력");
    		num = Integer.parseInt(input);
    		if(num>999 || num<0)
    		{
    			JOptionPane.showMessageDialog(null, "세 자리 정수를 입력해야 합니다.");
    			continue;
    		}
    		user[0] = input.charAt(0)-'0';
    		user[1] = input.charAt(1)-'0';
    		user[2] = input.charAt(2)-'0';
    		if(user[0] == user[1] || user[0]==user[2] || user[1]==user[2])
    		{
    			JOptionPane.showMessageDialog(null, "중복된 수는 사용불가");
    			continue;
    		}
    		else
    			break;
    	}
    }
    void hint()
    {
    	System.out.printf("Input Number : %d-%d-%d\nResult:%dS-%dB\n",
    						user[0],user[1],user[2],s,b);
    }
    void compare()
    {
    	s=0;
    	b=0;
    	for(int i=0; i<3;i++)
    	{
    		for(int j=0;j<3;j++)
    		{
    			if(i==j && com[i]==user[j])
    				s++;
    			else if(com[i]==user[j])
    				b++;
    		}
    	}
    }
    boolean isEnd()
    {
    	if(s==3)
    		return true;
    	return false;
    }
    void process()
    {
    	getRand();
    	while(true)
    	{
    	 	userInput();
        	compare();
        	hint();
        	if(isEnd())
        	{
        		int a = JOptionPane.showConfirmDialog(null, 
        				"종료할까요? ","선택",JOptionPane.YES_NO_OPTION);
        		if(a==JOptionPane.YES_OPTION)
        		{
        			JOptionPane.showMessageDialog(null, "게임을 종료한다.");
        			System.exit(0);
        		}
        		else
        		{
        			JOptionPane.showMessageDialog(null, "새 게임이 시작되었따");
        			process();
        		}        			
        	}
    	}
   
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		클래스 myClass = new 클래스();
		myClass.process();
	}

}
