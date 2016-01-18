package com.sist;
import java.sql.*;
public class MainClass2 {
    Connection conn;
    PreparedStatement ps;
    MainClass2()
    {
    	//오라클 연결시에 드라이버 설정
    	try{
    		Class.forName("oracle.jdbc.driver.OracleDriver");
    	}catch (Exception e)
    	{
    		System.out.println(e.getMessage());
    	}
    }
    
    void getData()
    {
    	try {
    		//Oracle Default 번호 : 1521
			String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
			conn = DriverManager.getConnection(url,"scott","tiger");
			String sql = "SELECT * FROM emp";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "
								+ rs.getString(2) + " "
								+ rs.getString(3));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainClass2 ms2 = new MainClass2();
		ms2.getData();
	}

}
