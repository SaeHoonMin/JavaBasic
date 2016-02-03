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
		   File file=new File("./text/sawon.csv");
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
		   
		   
		//	ÈÎ¾À ÂªÀº°Å
		//  String [] sawonData = temp.split("\n");
		   
		   
		   StringTokenizer st=
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
		   }
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
   // ¸ñ·Ï 
   public ArrayList<Sawon> sawonAllData()
   {
	   return list;
   }
   // »ó¼¼º¸±â
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
