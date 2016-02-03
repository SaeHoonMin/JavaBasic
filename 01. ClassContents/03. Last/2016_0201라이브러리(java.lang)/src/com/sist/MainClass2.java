package com.sist;

import java.text.SimpleDateFormat;
import java.util.Date;


/*
 * 
 * 		java.util
 * 		=========
 * 	 	= Date : 시스템의 시간을 읽어 온다. (데이터베이스)
 * 			=> SYSDATE
 * 		= Calendar
 * 		= StringTokenizer
 * 
 */
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date = new Date();
		System.out.println(date.toString());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 (hh시mm분ss초)");
		/*
		 * 
		 * yyyy = 년도 (yy,yyyy)
		 * MM : 월 (M)
		 * dd : 일 (d)
		 *
		 * hh
		 * mm
		 * ss
		 */
		System.out.println(sdf.format(date));
		
	}

}
