package com.sist;
// 서로다른 클래스를 연결해서 사용이 가능 (interface가 주로 하는 역할)
/*
 *      interface A
 *      {
 *         int a=10;   // public static final
 *         void disp(); // public abstract
 *      }
 */
interface Connection
{
	public void getConnection();
	public static void disConnection()
	{
		System.out.println("데이터 베이스 종료");
	}
	default public void increment()
	{
		System.out.println("auto increment");
	}
}
class Oracle implements Connection
{

	@Override
	public void getConnection() {
		// TODO Auto-generated method stub
		System.out.println("오라클 연결...");
	}

	@Override
	public void increment() {
		System.out.println("create sequence..");
	}
	
}
class MSSQL implements Connection
{

	@Override
	public void getConnection() {
		// TODO Auto-generated method stub
		System.out.println("MSSQL연결...");
	}
	
}
class MySQL implements Connection
{

	@Override
	public void getConnection() {
		// TODO Auto-generated method stub
		System.out.println("MySQL연결...");
	}
	
}
class Container 
{
	public Connection getDataBase(String type)
	{
		Connection conn=null;
		if(type.equals("oracle"))
			conn=new Oracle();
		else if(type.equals("mysql"))
			conn=new MySQL();
		else if(type.equals("mssql"))
			conn=new MSSQL();
		return conn;
	}
}
public class 데이터베이스 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Container c=new Container();
        Connection conn=c.getDataBase("oracle");
        conn.getConnection();
        conn.increment();
        Connection.disConnection();
        
        conn=c.getDataBase("mysql");
        conn.getConnection();
        conn.increment();
        Connection.disConnection();
        
        conn=c.getDataBase("mssql");
        conn.getConnection();
        conn.increment();
        Connection.disConnection();
	}

}
