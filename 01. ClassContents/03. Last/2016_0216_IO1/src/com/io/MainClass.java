package com.io;
/*
 *    IO => ����� 
 *     = �޸� 
 *       InputStream 
 *       OutputStream ==> interface
 *       ===========
 *       System.out
 *       System.in
 *       =========== �ڹ� �޸� ����� ǥ�� 
 *     = ����
 *       FileInputStream
 *       FileOutputStream 
 *     = �����ͺ��̽�
 *     = ��Ʈ��ũ
 *     ==>
 *     �ڹٿ��� ����� (Stream : �����͸� �̵��ϴ� ���)
 *     1byte (����Ʈ ��Ʈ��)
 *       InputStream , OutputStream (interface)
 *         => FileInputStream ,FileOutputStream
 *            ObjectInputStream,ObjectOutputStream
 *            BufferedInputStream ,BufferedOutputStream
 *      
 *     2byte (���� ��Ʈ��)
 *       Reader , Writer
 *         => r,w,a
 *         => FileReader,FileWriter
 *         FileWriter fw=new FileWriter(file��,true);
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
        	String msg="�ȳ��ϼ��� ~~ �ڹ��Դϴ�\n";
        	FileWriter fos=
        		new FileWriter("./image/io.txt");
        	fos.write(msg);
        	// %E%A
        	fos.close();
        	System.out.println("�Է¿Ϸ�!!");
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
