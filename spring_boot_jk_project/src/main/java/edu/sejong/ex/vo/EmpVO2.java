package edu.sejong.ex.vo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
EMPNO    NOT NULL NUMBER(4)    
ENAME             VARCHAR2(10) 
JOB               VARCHAR2(9)  
MGR               NUMBER(4)    
HIREDATE          DATE         
SAL               NUMBER(7,2)  
COMM              NUMBER(7,2)  
DEPTNO            NUMBER(2)    
*/

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmpVO2 {
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	// private Date hiredate;
	private Timestamp hiredate;
	private int sal;
	private int comm;
	private int deptno;
}