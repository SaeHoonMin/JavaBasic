package com.sist.collection;
import java.util.*;
import java.io.*;
public class SawonManager {
   private static ArrayList<Sawon> list=
		           new ArrayList<Sawon>();
   static
   {
	   try
	   {
		   File file=new File("C:\\javaDev\\javaStudy3\\20160202_라이브러리(컬렉션)\\src\\com\\sist\\collection\\sawon.csv");
		   FileReader fr=new FileReader(file);
		   char[] data=new char[1024];
		   int i=0;
		   String temp="";
		   while((i=fr.read(data,0,1024))!=-1)
		   {
			   //System.out.println(String.valueOf(data));
		       temp+=String.valueOf(data);
		   }
		   System.out.println(temp);
	   }catch(Exception ex)
	   {
		   System.out.println(ex.getMessage());
	   }
   }
   // 목록 
   public ArrayList<Sawon> sawonAllData()
   {
	   return list;
   }
   // 상세보기
   public Sawon sawonDetail(int sabun)
   {
	   Sawon sa=new Sawon();
	   for(Sawon s:list)
	   {
		   if(s.getSabun()==sabun)
		   {
			   sa=s;
			   break;
		   }
	   }
	   return sa;
   }
   
}
