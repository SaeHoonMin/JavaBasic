package com.sist;
/*
 *    패키지 => java.lang , java.util
 *    1) java.lang => import를 생략할 수 있다 
 *       Object : 최상위 클래스
 *         = finalize() : 객체 소멸시에 호출 (소멸자)
 *         = toString() : Object를 문자열로 변환 
 *         = equals() : 객체가 가지고 있는 멤버변수값이 동일여부
 *         = clone() : 메모리 복제 
 *           => Cloneable를 구현해야 한다 
 *       String : 문자열 관리 클래스
 *         => char[]
 *         = 문자열 비교 : equals
 *         = 문자열 분해 : substring
 *                    split
 *         = 문자한개 가지고 온다 : charAt
 *           String str="Hello"
 *            str.charAt(2)
 *           String str1="Java"
 *         = 모든 데이터형을 문자열 변경 : valueOf
 *               ===> static 
 *         = 앞에 같은 문자열이 있는지 확인 : startsWith
 *         = 뒤에 같은 문자열이 있는지 확인 : endsWith
 *         ====================== 서제스트 
 *         = 원하는 문자의 위치확인 : indexOf,lastIndexOf
 *         = toUpperCase,toLowerCase
 *       Math : 숫자 (수학 클래스)
 *         = random() ==> Random
 *         = abs() : 절대값
 *         = ceil() : 올림  (*******)
 *         => count=38;// 게시물 
 *           total=count/10; ==> 3
 *           if(count%10>0)
 *              total++;   ==> 4
 *              
 *           total=(int)(Math.ceil(count/10.0))
 *                           3.8 
 *       System 
 *         = gc()
 *         = exit() : 시스템 종료 
 *       Wrapper 
 *         ***** = Integer (int)
 *            parseInt() : 문자열 => 정수형
 *            valueOf() : 정수를 추출 
 *            
 *            Integer i=new Integer(10);
 *            int ii=i; unboxing
 *            Integer i=100; boxing
 *            
 *         ***** = Double (double)
 *         = Float  (float)
 *         = Boolean (boolean)
 *         = Byte (byte)
 *       StringBuffer
 *          = append()
 *       
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
