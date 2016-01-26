package com.sist;
// DAO , Manager
import java.util.Scanner;
public class StudentConfig {
   public void jumsuInput(Student s)
   {
	   Scanner scan=new Scanner(System.in);
	   System.out.print("국어 입력:");
	   s.setKor(scan.nextInt());
	   System.out.print("영어 입력:");
	   s.setEng(scan.nextInt());
	   System.out.print("수학 입력:");
	   s.setMath(scan.nextInt());
   }
   public void jumsuTotal(Student s)
   {
	   s.setTotal(s.getKor()+s.getEng()+s.getMath());
   }
   public void jumsuAvg(Student s)
   {
	   s.setAvg(s.getTotal()/3.0);
   }
   public void jumsuHakjum(Student s)
   {
	   char c='A';
	   switch(s.getTotal()/30)
	   {
	   case 10:
	   case 9:
		   c='A';
		   break;
	   case 8:
		   c='B';
		   break;
	   case 7:
		   c='C';
		   break;
	   case 6:
		   c='D';
		   break;
	   default:
		   c='F';
	   }
	   s.setHakjum(c);
   }
}



