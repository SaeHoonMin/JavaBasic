package com.sist;
import java.util.Scanner;
// 2�� ������ �޾Ƽ� �迭�� ���� => �������� ��� 
// 1) ���ڿ� ==> ������ȯ 
// 2) �迭�� ���� �ʰ�
// 3) ������ (0)
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
	        Scanner scan=new Scanner(System.in);
	        int[] num=new int[2];
	        System.out.print("ù��° ����:");
	        num[0]=Integer.parseInt(scan.next());
	        System.out.print("�ι�° ����:");
	        num[2]=Integer.parseInt(scan.next());
	        // error
	        
	        System.out.println(num[0]/num[1]);
		}catch(NumberFormatException e)
		{
			System.out.println("������ ��ȯ �� �� ����:"+e.getMessage());
		}catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("�迭 ���� �ʰ�:"+e.getMessage());
		}catch(ArithmeticException e)
		{
			System.out.println("0���� ������ ����:"+e.getMessage());
		}
        
        
	}

}





