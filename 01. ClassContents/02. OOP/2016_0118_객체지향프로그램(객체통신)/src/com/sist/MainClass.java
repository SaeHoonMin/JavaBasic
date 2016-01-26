package com.sist;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Student s=new Student();
        s.setHakbun(1);
        s.setName("홍길동");
        // 캡슐화 : getXxx(읽기),setXxx(쓰기)
        StudentConfig sc=new StudentConfig();
        sc.jumsuInput(s);
        sc.jumsuTotal(s);
        sc.jumsuAvg(s);
        sc.jumsuHakjum(s);
        // 출력
        System.out.println("학번:"+s.getHakbun());
        System.out.println("이름:"+s.getName());
        System.out.println("국어점수:"+s.getKor());
        System.out.println("영어점수:"+s.getEng());
        System.out.println("수학점수:"+s.getMath());
        System.out.println("총점:"+s.getTotal());
        System.out.println("평균:"+s.getAvg());
        System.out.println("학점:"+s.getHakjum());
        
        
	}

}
