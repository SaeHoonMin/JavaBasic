package com.sist;
/*
 *    컬렉션 (Collection) : 자료구조
 *      => 데이터를 관리하는 것 
 *           Collection
 *              |
 *      -----------------------
 *      |          |           |
 *     Set       List        Queue   Map
 *                 |
 *            --------------
 *            |       |      |
 *         ArrayList  Vector LinkedList
 *        ===========
 *        1) 순서를 유지한다
 *        2) 데이터를 중복으로 저장이 가능 
 *        3) 입출력(데이터) 쉽다 
 *        4) 기능 
 *           1. 추가   add(Object obj) , add(int , Object)
 *           2. 삭제   remove
 *           3. 수정  set
 *           4. 가지고 오기  get
 *           5. 저장 갯수 size
 *        5) 단점 : 속도가  느리다 
 *        6) 배열형식 
 *        7) 데이터가 자유롭게 첨부할 수 있다 (데이터 통일)
 *           ============================
 *           제네릭
 *           
 *        class Box<T>
 *        {
 *            T t;
 *            public void setT(T t)
 *            {
 *                this.t=t;
 *            }
 *            public T getT()
 *            {
 *                return t;
 *            }
 *            
 *        }
 */
import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ArrayList<String> list=
        		new ArrayList<String>();
        list.add("홍길동1"); // 0
        list.add("홍길동2"); // 2
        list.add("홍길동3"); // 3 // remove
        list.add("홍길동4"); // 4 // 3
        list.add("홍길동5"); // 5 // 4
        list.add(1,"홍길동6"); // 1
        System.out.println("현재 저장:"+list.size());
        for(int i=0;i<list.size();i++)
        {
        	String name=(String)list.get(i);
        	System.out.println(name);
        }
        list.remove(3);
        System.out.println("현재 저장:"+list.size());
        for(int i=0;i<list.size();i++)
        {
        	String name=(String)list.get(i);
        	System.out.println(name);
        }
        list.set(3, "심청이");
        for(int i=0;i<list.size();i++)
        {
        	String name=(String)list.get(i);
        	System.out.println(name);
        }
	}

}
