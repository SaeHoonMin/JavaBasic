package com.sist;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import jdk.jfr.events.FileWriteEvent;

public class MainClass {
	
	
	
	public static void main(String[] args) throws Exception{
		EmpDAO dao = new EmpDAO();
		ArrayList<EmpDTO> list = dao.empAllData();
		File file = new File("./data/emp.csv");
		if(!file.exists())
		{
			file.createNewFile();
		}
		FileWriter fw = new FileWriter(file);
		String data = "enmpno,ename,sal\n";
		for(EmpDTO d : list)
		{
			data += (d.getEmpno()+","+d.getEname()+","+ d.getSal() +"\n" );
			
		}
		fw.write(data);
		fw.close();
		System.out.println("¿Ï·á");
	}
	
}

