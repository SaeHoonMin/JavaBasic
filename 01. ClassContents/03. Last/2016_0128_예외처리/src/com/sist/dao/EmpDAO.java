package com.sist.dao;
import java.sql.*;
import java.util.*;
//
public class EmpDAO {
     private Connection conn;
     // 서버와 연결 
     private PreparedStatement ps;
     // 문장 전송 
     // 서버주소 
     private final String URL="jdbc:oracle:thin:@localhost:1521:ORCL";
     public EmpDAO()
     {
    	 // 오라클 연결 ==> 드라이버 설정 
    	 try
    	 {
    		 // 컴파일 예외 ==> 컴파일시에 예외처리를 확인 
    		 Class.forName("oracle.jdbc.driver.OracleDriver");
    	 }catch(ClassNotFoundException cf)
    	 {
    		 System.out.println(cf.getMessage());
    	 }
     }
     // 연결
     public void getConnection()
     {
    	 try
    	 {
    		 conn=DriverManager.getConnection(URL,"scott","tiger");
    		 // conn scott/tiger
    	 }catch(Exception ex){}
     }
     // 연결 해제
     public void disConnection()
     {
    	 try
    	 {
    		 if(ps!=null) ps.close();
    		 if(conn!=null) conn.close();
    	 }catch(Exception ex){}
     }
     // 로그인
     public String login(int empno,String ename)
     {
    	 String result="";
    	 try
    	 {
    		 // 연결
    		 getConnection();
    		 String sql="SELECT COUNT(*) FROM emp "
    				   +"WHERE empno=?";
    		 ps=conn.prepareStatement(sql);
    		 ps.setInt(1, empno);
    		 ResultSet rs=ps.executeQuery();
    		 rs.next(); // 커서위치 변경 
    		 int count=rs.getInt(1);
    		 rs.close();
    		 if(count==0)
    		 {
    			 result="noid";
    		 }
    		 else
    		 {
    			 sql="SELECT ename FROM emp "
    			    +"WHERE empno=?";
    			 ps=conn.prepareStatement(sql);
    			 ps.setInt(1, empno);
    			 rs=ps.executeQuery();
    			 rs.next();
    			 String db_name=rs.getString(1);
    			 rs.close();
    			 if(db_name.equals(ename.toUpperCase()))
    			 {
    				 result="ok";
    			 }
    			 else
    			 {
    				 result="noname";
    			 }
    		 }
    		 
    	 }catch(Exception ex)
    	 {
    		 System.out.println(ex.getMessage());
    	 }
    	 finally
    	 {
    		 disConnection();
    	 }
    	 return result;
     }
     
}






