package com.sist;

import java.text.SimpleDateFormat;
import java.util.Date;


/*
 * 
 * 		java.util
 * 		=========
 * 	 	= Date : �ý����� �ð��� �о� �´�. (�����ͺ��̽�)
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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd�� (hh��mm��ss��)");
		/*
		 * 
		 * yyyy = �⵵ (yy,yyyy)
		 * MM : �� (M)
		 * dd : �� (d)
		 *
		 * hh
		 * mm
		 * ss
		 */
		System.out.println(sdf.format(date));
		
	}

}
