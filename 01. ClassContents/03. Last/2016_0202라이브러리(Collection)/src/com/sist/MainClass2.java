package com.sist;
import java.util.*;
class Sawon
{
	private int sabun;
	private String name;
	private String dept;
	
	public int getSabun() {
		return sabun;
	}
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public Sawon(int sabun, String name, String dept) {
		this.sabun = sabun;
		this.name = name;
		this.dept = dept;
	}
	
	
}
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        List<Sawon> list=
        	new LinkedList<Sawon>();
        list.add(new Sawon(1,"홍길동","개발부"));
        list.add(new Sawon(2,"심청이","자재부"));
        list.add(new Sawon(3,"춘향이","총무부"));
        list.add(new Sawon(4,"박문수","영업부"));
        list.add(new Sawon(5,"김두한","기획부"));
        System.out.println("현재 직원수:"+list.size());
        System.out.println("======직원목록======");
        for(Sawon s:list)
        {
        	System.out.println(s.getSabun()+" "
        			+s.getName()+" "
        			+s.getDept());
        }
        System.out.println("======신규사원 추가======");
        list.add(new Sawon(list.size()+1,"이순신","영업부"));
        System.out.println("======직원목록======");
        for(Sawon s:list)
        {
        	System.out.println(s.getSabun()+" "
        			+s.getName()+" "
        			+s.getDept());
        }
        System.out.println("======중간에 추가=====");
        list.add(3,new Sawon(list.size()+1,"강감찬","개발부"));
        System.out.println("======직원목록======");
        for(Sawon s:list)
        {
        	System.out.println(s.getSabun()+" "
        			+s.getName()+" "
        			+s.getDept());
        }
        System.out.println("=====권고 사직====");
        Random r=new Random();
        list.remove(r.nextInt(list.size()-1));
        System.out.println("======직원목록======");
        for(Sawon s:list)
        {
        	System.out.println(s.getSabun()+" "
        			+s.getName()+" "
        			+s.getDept());
        }
        System.out.println("==== 개명을 했을 경우 =====");
        list.set(r.nextInt(list.size()-1),new Sawon(r.nextInt(list.size()-1),"춘향이(개명)","총무부") );
        System.out.println("======직원목록======");
        for(Sawon s:list)
        {
        	System.out.println(s.getSabun()+" "
        			+s.getName()+" "
        			+s.getDept());
        }
	}

}




