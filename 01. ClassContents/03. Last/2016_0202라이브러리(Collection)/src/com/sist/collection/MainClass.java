package com.sist.collection;
import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        SawonManager sm=new SawonManager();
        ArrayList<Sawon> list=sm.sawonAllData();
        for(Sawon s:list)
        {
        	System.out.println(s.getSabun()+" "
        			+s.getName()+" "
        			+s.getDept()+" "
        			+s.getPay());
        }
	}

}
