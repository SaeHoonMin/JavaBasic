package com.sist;

import java.util.Scanner;

/*
 * 
 * 	�Ѱ��� ���� �ȿ� Ŭ���� 2�� �̻�
 * 	1) public ~ class��  �ݵ�� 1���� ����
 * 	2) public Ŭ������ ���ϸ�
 * 
 */

// ~DTO , ~VO  : ��� x , �����͸� ������
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
			System.out.print("�̸��� �Է��ϼ��� : ");
			std[i].name = scn.next();
			System.out.print("���������� �Է��ϼ��� : ");
			std[i].kor = scn.nextInt();
			System.out.print("���������� �Է��ϼ��� : ");
			std[i].eng = scn.nextInt();
			System.out.print("���������� �Է��ϼ��� : ");
			std[i].math = scn.nextInt();
			std[i].total = std[i].kor + std[i].math + std[i].eng;
			std[i].avg = std[i].total/3.0;
		}
		for(Student stu : std)
		{
			System.out.println("�̸� : "+stu.name);
			System.out.println("���� : "+stu.kor);
			System.out.println("���� : "+stu.eng);
			System.out.println("���� : "+stu.math);
			System.out.println("���� : "+stu.total);
			System.out.println("��� : "+stu.avg);
			System.out.println("==============");
		}
	}

}
