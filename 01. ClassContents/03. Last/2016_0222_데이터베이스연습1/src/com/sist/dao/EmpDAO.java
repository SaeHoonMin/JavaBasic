package com.sist.dao;
import java.sql.*;
import java.util.*;
/*
 *    JDBC : 자바언어를 이용해서 오라클의 데이터 제어 
 *    ==== 라이브러리 (java.sql.*)
 *    ==== 데이터베이스 연결 할 수 있는 드라이버 
 *         (ojdbc6.jar)
 *    작업 순서 
 *      1) 드라이버 설치 
 *         Class.forName("드라이버 이름")
 *         * oracle.jdbc.driver.OracleDriver
 *      2) 오라클 연결
 *         Connection : getConnection(URL,username,pwd)
 *      3) SQL문장을 오라클로 전송 
 *         Statement => 문장과 데이터를 동시에 전송
 *         PreparedStatement(일반화):미리 SQL문장을 제작후에 
 *                                 나중에 값 대입 
 *         CallableStatement(프로시저)
 *         예)
 *            String id="aaa";
 *            String pwd="1234";
 *            String name="홍길동";
 *            int age=30;
 *            String addr="서울";
 *            
 *            String sql="INSERT INTO member VALUES("
 *                      +"'"+id+"','"+pwd
 *                      +"','"+name+"',"+age+",'"+addr
 *                      +"')";
 *            String sql="INSERT INTO member VALUES("
 *                      +"?,?,?,?,?)";
 *            String sql="{CALL memberInsert(?,?,?,?,?)}";
 *            
 *            = ResultSet executeQuery() : SELECT
 *            = int executeUpdate() : UPDATE,DELETE,INSERT
 *            
 *        4) 결과값 받기 
 *           ResultSet 
 *           =====================
 *             id    pwd   name
 *           =====================
 *                   BOF
 *           =====================
 *            aaa   1234   hong  : next()
 *            bbb   1234   shim
 *            ccc   1234   park  : previous()
 *           =====================
 *                   EOF
 *           =====================
 *        5) 종료 
 *           
 *           시작 : Connection=Statement=ResultSet
 *           종료 : ResultSet=Statement=Connection
 *                       
 */
public class EmpDAO {
	//연결객체
	private Connection conn;
	//statement 전송객체
	private PreparedStatement ps;
	// URL
	// jdbc:업체명:드라이버이름:@IP:PORT:데이터베이스
	private final String URL = "jdbc:oracle:thin:@211.238.142.46:1521:ORCL";
	
	public EmpDAO()
	{
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception ex)
		{
			System.out.println(" EmpDAO() : " +ex.getMessage());
		}
	}
	// 연결
	public void getConnection()
	{
		try
		{
			conn = DriverManager.getConnection(URL,"scott","tiger");
		}catch (Exception ex)
		{
			System.out.println("getConnection () : "+ex.getMessage());
		}
	}
	// 연결 해제
	public void disconnection()
	{
		try{
			if(ps!=null)
				ps.close();		//input, output
			if(conn!=null)
				conn.close();	//socket information
			
		}catch(Exception e)
		{
			System.out.println("disconnection() : "+e.getMessage());
		}
	}
	// 기능
	// 1. emp 에 있는 사원 정보(전체)
	
	public ArrayList<EmpDTO> empAllData()
	{
		ArrayList<EmpDTO> list = new ArrayList<EmpDTO>();
		try{
			getConnection();
			String sql = "SELECT empno, ename, job,hiredate,deptno FROM emp";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				EmpDTO d = new EmpDTO();
				d.setEmpno(rs.getInt(1));
				d.setEname(rs.getString(2));
				d.setJob(rs.getString(3));
				d.setHiredate(rs.getDate(4));
				d.setDeptno(rs.getInt(5));
				list.add(d);
			}
			
		}catch(Exception ex)
		{
			System.out.println("empAllData() : " +ex.getMessage());
			ex.printStackTrace();
		}finally
		{
			//종료
			disconnection();
		}
		
		return list;
	}
	// 2. emp 에 있는 사원 상세정보 WHERE
	public EmpDTO empDetailData(int emp){
		EmpDTO d  = new EmpDTO();
		try
		{
			//연결
			getConnection();
			String sql = "SELECT * FROM emp WHERE empno=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, emp);
			ResultSet rs = ps.executeQuery();
			rs.next();
			d.setEmpno(rs.getInt(1));
			d.setEname(rs.getString(2));
			d.setJob(rs.getString(3));
			d.setMgr(rs.getInt(4));
			d.setHiredate(rs.getDate(5));
			d.setSal(rs.getInt(6));
			d.setComm(rs.getInt(7));
			d.setDeptno(rs.getInt(8));
			rs.close();
		}
		catch(Exception ex)
		{
			System.out.println("empDetailData: : " +ex.getMessage());
		}
		finally
		{
			disconnection();
		}
		return d;
	}
	
	// 3. emp 에 있는 사원 찾기 LIKE
	public	ArrayList<EmpDTO> empFindData(String column,String data)
	{
		ArrayList<EmpDTO>  list = new ArrayList<EmpDTO>();
		try{
			getConnection();
			//아래 LIKE 문 주의!!
			String sql = "SELECT empno, ename, job, hiredate, deptno "
					+ "FROM emp "
					+ "WHERE "+column+" LIKE '%'||?||'%'";
			ps = conn.prepareStatement(sql);
			ps.setString(1, data.toUpperCase());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				EmpDTO d = new EmpDTO();
				d.setEmpno(rs.getInt(1));
				d.setEname(rs.getString(2));
				d.setJob(rs.getString(3));
				d.setHiredate(rs.getDate(4));
				d.setDeptno(rs.getInt(5));
				list.add(d);
			}
		}catch (Exception ex){
			System.out.println("empFindData() : "+ex.getMessage());
		}
		finally {
			disconnection();
		}
		return list;
	}
	
	
	public ArrayList<ZipcodeDTO> postFind(String dong)
	
	{
		ArrayList<ZipcodeDTO> list = new ArrayList<ZipcodeDTO>();
		
		try{
			getConnection();
			String sql = "SELECT zipcode,sido,gugun,dong,NVL(bunji,' ') "
						+"FROM zipcode "
						+"WHERE dong LIKE '%'||?||'%'";
			ps = conn.prepareStatement(sql);
			ps.setString(1, dong);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				ZipcodeDTO d = new ZipcodeDTO();
				d.setZipcode(rs.getString(1));
				d.setSido(rs.getString(2));
				d.setGugun(rs.getString(3));
				d.setDong(rs.getString(4));
				d.setBunji(rs.getString(5));
				list.add(d);
			}
			rs.close();
			
		}catch(Exception ex)
		{
			System.out.println("postFind() : "+ex.getMessage());
		}finally
		{
			disconnection();
		}
		
		return list;
	}

}





