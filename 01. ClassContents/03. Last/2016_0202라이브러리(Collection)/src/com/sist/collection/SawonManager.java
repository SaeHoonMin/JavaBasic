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
		   while((i=fr.read())!=-1)
		   {
			   //System.out.println(String.valueOf(data));
		       temp+=String.valueOf((char)i);
		   }
		   //System.out.println(temp);
		   /*StringTokenizer st=
				   new StringTokenizer(temp, "\n");
		   int j=0;
		   while(st.hasMoreTokens())
		   {
			   System.out.println(st.nextToken());
			   j++;
		   }
		   String[] sawonData=new String[j];
		   j=0;
		   st=new StringTokenizer(temp, "\n");
		   while(st.hasMoreTokens())
		   {
			   sawonData[j]=st.nextToken();
			   j++;
		   }*/
		   String[] sawonData=temp.split("\n");
		   for(i=0;i<sawonData.length;i++)
		   {
			   StringTokenizer ss=
					 new StringTokenizer(sawonData[i], ",");
			   //System.out.println(sawonData[i]);
			   Sawon sawon=new Sawon();
			   sawon.setSabun(Integer.parseInt(ss.nextToken().trim()));
			   sawon.setName(ss.nextToken());
			   sawon.setDept(ss.nextToken());
			   sawon.setJob(ss.nextToken());
			   sawon.setHiredate(ss.nextToken());
			   sawon.setPay(Integer.parseInt(ss.nextToken().trim()));
			   list.add(sawon);
			   
		   }
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
