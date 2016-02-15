package com.sist;
// Map => HashMap ==> Web,Spring
import java.util.*;
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Map<String,String> map=new HashMap<String,String>();
        map.put("id", "admin");
        map.put("pwd", "1234");
        String id=map.get("id");
        System.out.println(id);
	}

}
