package com.sist;
import java.util.Scanner;
// 2개 정수를 받아서 배열에 저장 => 나눈값을 출력 
// 1) 문자열 ==> 정수변환 
// 2) 배열의 범위 초과
// 3) 나누기 (0)
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
	        Scanner scan=new Scanner(System.in);
	        int[] num=new int[2];
	        System.out.print("첫번째 정수:");
	        num[0]=Integer.parseInt(scan.next());
	        System.out.print("두번째 정수:");
	        num[2]=Integer.parseInt(scan.next());
	        // error
	        
	        System.out.println(num[0]/num[1]);
		}catch(NumberFormatException e)
		{
			System.out.println("정수로 변환 할 수 없다:"+e.getMessage());
		}catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("배열 범위 초과:"+e.getMessage());
		}catch(ArithmeticException e)
		{
			System.out.println("0으로 나눌수 없다:"+e.getMessage());
		}
        
        
	}

}





