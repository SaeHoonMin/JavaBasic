package com.io;
/*
 *    IO => 입출력 
 *     = 메모리 
 *       InputStream 
 *       OutputStream ==> interface
 *       ===========
 *       System.out
 *       System.in
 *       =========== 자바 메모리 입출력 표준 
 *     = 파일
 *       FileInputStream
 *       FileOutputStream 
 *     = 데이터베이스
 *     = 네트워크
 *     ==>
 *     자바에서 입출력 (Stream : 데이터를 이동하는 통로)
 *     1byte (바이트 스트림)
 *       InputStream , OutputStream (interface)
 *         => FileInputStream ,FileOutputStream
 *            ObjectInputStream,ObjectOutputStream
 *            BufferedInputStream ,BufferedOutputStream
 *      
 *     2byte (문자 스트림)
 *       Reader , Writer
 *         => r,w,a
 *         => FileReader,FileWriter
 *         FileWriter fw=new FileWriter(file명,true);
 *         fw.write("aaa")
 *         fw.write("ccc");
 *            BufferedReader , BufferedWriter
 */
import java.util.*;
import java.io.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try
        {
        	String msg="안녕하세요 ~~ 자바입니다\n";
        	FileWriter fos=
        		new FileWriter("./image/io.txt");
        	fos.write(msg);
        	// %E%A
        	fos.close();
        	System.out.println("입력완료!!");
        	FileReader fis=
        		new FileReader("./image/io.txt");
        	int i=0;
        	while((i=fis.read())!=-1)
        	{
        		System.out.print((char)i);
        	}
        	fis.close();
        }catch(Exception ex){}
	}

}
