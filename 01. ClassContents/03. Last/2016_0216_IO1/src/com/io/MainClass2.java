package com.io;
// File �Ӽ� 
import java.util.*;
import java.io.*;
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try
        {
        	/*
        	 *   File 2���� ���� 
        	 *     �������� => isFile()
        	 *     ���丮 => isDirectory()
        	 */
        	File dir=new File("./download");
        	if(!dir.exists())
        	{
        		dir.mkdir();
        	}
        	File[] fileList=dir.listFiles();
        	for(File f:fileList)
        	{
        		if(f.isFile())
        		{
        		  System.out.println(f.getPath());
        		  // getName() , getPath()
        		}
        	}
        }catch(Exception ex){}
	}

}




