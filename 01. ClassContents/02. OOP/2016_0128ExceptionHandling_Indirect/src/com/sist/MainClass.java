package com.sist;

import java.sql.SQLException;

/*
 *    간접처리 
 *      = 예외에 대한 등록 (예약)
 *      = 시스템에 의해 처리 
 *      = 사용법 
 *        메소드() throws 예외의 종류....
 *        
 *        double div(int[] a) throws ArithmeticException,ArrayIndexOutOfBoundException
 *          ==> 예외클래스 순서는 없다
 *        
 *        int[] arr={1,2};
 *        double res=div(arr);
 *        
 */
public class MainClass {
    double div(int[] arr) throws RuntimeException,Exception,SQLException
    {
    	return arr[0]/arr[1];
    }
	public static void main(String[] args) 
	//throws Exception
	{
		// TODO Auto-generated method stub
        MainClass m=new MainClass();
        int[] arr={10,0};
        try
        {
        double d=m.div(arr);
        }catch(Exception ex){}
	}

}
