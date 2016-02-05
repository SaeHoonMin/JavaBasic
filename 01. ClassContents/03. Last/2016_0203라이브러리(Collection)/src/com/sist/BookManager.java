package com.sist;
import java.util.*;
public class BookManager {
   private static ArrayList<Book> list=
		           new ArrayList<Book>();
   static
   {
	   list.add(new Book(1,"시작하세요! 앱 인벤터 2","김경민","위키북스","1.jpg",28000));
	   list.add(new Book(2,"실무로 배우는 시스템 성능 최적화","권문수","한빛미디어","2.jpg",42000));
	   list.add(new Book(3,"시스템 성능 분석과 최적화","브렌든 그레그","영진출판사","3.jpg",42000));
	   list.add(new Book(4,"모던 웹사이트 디자인의 정석","윤인성","위키북스","4.jpg",27000));
	   list.add(new Book(5,"쉽게 따라 하는 모바일 웹 개발","한정현","대림출판사","5.jpg",22000));
	   list.add(new Book(6,"실용주의 사고와 학습 (재출간판)","박영록","위키북스","6.jpg",22000));
	   list.add(new Book(7,"엔터프라이즈 애플리케이션 아키텍처 패턴","마틴 파울러","위키북스","7.jpg",35000));
	   list.add(new Book(8,"자바스크립트+jQuery 완전정복 스터디3","김춘경","한빛미디어","8.jpg",32000));
	   list.add(new Book(9,"자바스크립트+jQuery 완전정복 스터디2","김춘경","위키북스","9.jpg",24000));
	   list.add(new Book(10,"자바스크립트+jQuery 완전정복 스터디1","김춘경","대림출판사","10.jpg",25000));
   }
   public ArrayList<Book> bookAllData()
   {
	   return list;
   }
   public Book bookDetail(int no)
   {
	  Book book=new Book();
	  for(Book b:list)
	  {
		  if(b.getNo()==no)
		  {
			  book=b;
			  break;
		  }
	  }
	  return book;
   }
   public ArrayList<Book> bookFindData(String pub)
   {
	    ArrayList<Book> list=
	    		new ArrayList<Book>();
	    for(Book book:BookManager.list)
	    {
	    	if(pub.equals(book.getPublisher()))
	    	{
	    		list.add(book);
	    	}
	    }
	    return list;
   }
}







