package com.sist;
import java.util.*;
public class MainClass {
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Vector<String> vec=
        		new Vector<String>(5);
        // Vector : List (순서가 존재,중복을 허용)
        // 추가 ==> 0
        //System.out.println(vec.capacity());
        vec.addElement("홍길동");// 0
        vec.addElement("심청이");//2
        vec.addElement("심청이");
        vec.addElement("심청이");
        vec.addElement("심청이");
        vec.addElement("심청이");
        vec.addElement("심청이");
        vec.addElement("심청이");
        vec.addElement("심청이");
        vec.addElement("심청이");
        vec.addElement("심청이");
        
        vec.addElement("심청이");
        System.out.println(vec.capacity());
        vec.add(1, "춘향이");// 1 ==> gc
        for(int i=0;i<vec.size();i++)
        {
        	String name=vec.elementAt(i);
        	//  vec.get(i)
        	System.out.println(name);
        }
        // for-each : 배열,컬렉션
        vec.set(1, "이순신");
        vec.removeElementAt(0);// 홍길동 삭제
        // 이순신 => 심청이 
        System.out.println("저장 갯수:"+vec.size());
       // vec.removeAllElements();
        vec.clear();
        System.out.println("저장 갯수:"+vec.size());
        // 전체 삭제 
        for(String name:vec)
        {
        	System.out.println(name);
        }
	}

}
