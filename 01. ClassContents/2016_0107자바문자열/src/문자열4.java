//substring ==> 문자를 분리
/*
 * 	substring(int startIndex)
 * 	substring(3)
 * 	substring(int startIndex,endIndex)
 * 	sugstring(3,7) => endIndex-1
 */

import java.io.*;

public class 문자열4 {
	public static void main(String[] args)
	{
//		String str = "0123456789";
//		String res1 = str.substring(3);
//		
//		System.out.println(res1);
//		res1 = str.substring(3, 7);
//		System.out.println(res1);
		File dir = new File("C:\\Sist\\JavaBasic\\01. ClassContents\\2016_0106자바메소드\\src");
		File [] files = dir.listFiles();
		for(int i=0;i<files.length;i++)
		{
			String name = files[i].getName();
			String ext = name.substring(name.lastIndexOf('.')+1);
			if(ext.equals("java"))
				System.out.println(name);
		}
		
	}
}
