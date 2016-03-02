package com.sist.dao;
/*
 *   오라클에서 제공하는 데이터형 
 *   문자형
 *     CHAR(1~2000byte)
 *     VARCHAR2(1~4000byte)
 *     CLOB(4GB)
 *       ======> String
 *   숫자형
 *     NUMBER(4) : int , NUMBER(7,2) : double
 *   날짜형
 *     DATE,TIMESTAMP : java.util.Date
 *   기타형 
 *     BFILE
 *     BLOB 
 *     ===== InputStream
 */
import java.util.*;

public class EmpDTO {
     private int empno;
     private String ename;
     private String job;
     private int mgr;
     private Date hiredate;
     private int sal;
     private int comm;
     private int deptno;
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public int getComm() {
		return comm;
	}
	public void setComm(int comm) {
		this.comm = comm;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
     
}




