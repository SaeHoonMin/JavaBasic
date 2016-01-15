package com.sist;

import java.util.Scanner;

/*
 * 
 * 	한개의 파일 안에 클래스 2개 이상
 * 	1) public ~ class는  반드시 1개만 존재
 * 	2) public 클래스가 파일명
 * 
 */

// ~DTO , ~VO  : 기능 x , 데이터만 모은거
class Student
{
	int hakbun;
	String name;
	int kor ;
	int eng;
	int math;
	int rank;
	int total;
	double avg;
	char hakjum;
}

public class Method {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student [] std = new Student [3];
		// int [] a = new int [3]
		Scanner scn = new Scanner(System.in);
		for(int i=0; i<3; i++)
		{
			std[i] = new Student();
			std[i].hakbun=i+1;
			System.out.print("이름을 입력하세요 : ");
			std[i].name = scn.next();
			System.out.print("국어점수를 입력하세요 : ");
			std[i].kor = scn.nextInt();
			System.out.print("영어점수를 입력하세요 : ");
			std[i].eng = scn.nextInt();
			System.out.print("수학점수를 입력하세요 : ");
			std[i].math = scn.nextInt();
			std[i].total = std[i].kor + std[i].math + std[i].eng;
			std[i].avg = std[i].total/3.0;
		}
		for(Student stu : std)
		{
			System.out.println("이름 : "+stu.name);
			System.out.println("국어 : "+stu.kor);
			System.out.println("영어 : "+stu.eng);
			System.out.println("수학 : "+stu.math);
			System.out.println("총점 : "+stu.total);
			System.out.println("평균 : "+stu.avg);
			System.out.println("==============");
		}
	}

}
