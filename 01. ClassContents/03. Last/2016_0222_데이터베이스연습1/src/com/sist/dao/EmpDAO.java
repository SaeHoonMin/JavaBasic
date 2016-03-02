package com.sist.dao;
import java.sql.*;
import java.util.*;
/*
 *    JDBC : �ڹپ� �̿��ؼ� ����Ŭ�� ������ ���� 
 *    ==== ���̺귯�� (java.sql.*)
 *    ==== �����ͺ��̽� ���� �� �� �ִ� ����̹� 
 *         (ojdbc6.jar)
 *    �۾� ���� 
 *      1) ����̹� ��ġ 
 *         Class.forName("����̹� �̸�")
 *         * oracle.jdbc.driver.OracleDriver
 *      2) ����Ŭ ����
 *         Connection : getConnection(URL,username,pwd)
 *      3) SQL������ ����Ŭ�� ���� 
 *         Statement => ����� �����͸� ���ÿ� ����
 *         PreparedStatement(�Ϲ�ȭ):�̸� SQL������ �����Ŀ� 
 *                                 ���߿� �� ���� 
 *         CallableStatement(���ν���)
 *         ��)
 *            String id="aaa";
 *            String pwd="1234";
 *            String name="ȫ�浿";
 *            int age=30;
 *            String addr="����";
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
 *        4) ����� �ޱ� 
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
 *        5) ���� 
 *           
 *           ���� : Connection=Statement=ResultSet
 *           ���� : ResultSet=Statement=Connection
 *                       
 */
public class EmpDAO {
	//���ᰴü
	private Connection conn;
	//statement ���۰�ü
	private PreparedStatement ps;
	// URL
	// jdbc:��ü��:����̹��̸�:@IP:PORT:�����ͺ��̽�
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
	// ����
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
	// ���� ����
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
	// ���
	// 1. emp �� �ִ� ��� ����(��ü)
	
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
			//����
			disconnection();
		}
		
		return list;
	}
	// 2. emp �� �ִ� ��� ������ WHERE
	public EmpDTO empDetailData(int emp){
		EmpDTO d  = new EmpDTO();
		try
		{
			//����
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
	
	// 3. emp �� �ִ� ��� ã�� LIKE
	public	ArrayList<EmpDTO> empFindData(String column,String data)
	{
		ArrayList<EmpDTO>  list = new ArrayList<EmpDTO>();
		try{
			getConnection();
			//�Ʒ� LIKE �� ����!!
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





