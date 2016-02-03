package com.sist;
import java.util.*;
public class MainClass4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String[] data={
           "aaa","bbb","ccc","ddd","eee","fff",
           "ggg","hhh","iii","jjj","kkk","lll",
           "mmm","nnn"
        };
        int totalpage=(int)(Math.ceil(data.length/5.0));
        System.out.println("총페이지:"+totalpage);
        Scanner scan=new Scanner(System.in);
        System.out.print("페이지 입력:");
        int page=scan.nextInt();
        
        int j=0;
        int pagecnt=(page*5)-5;
        /*
         * 	0	5	10	
         * 	4	9	14
         * (1) (2)  (3)
         * 
         */
        for(int i=0;i<data.length;i++)
        {
        	if(j<5 && i>=pagecnt)
        	{
        		System.out.println(data[i]);
        		j++;
        	}
        }
	}

}






