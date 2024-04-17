package edu.sejong.ex.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
DEPTNO NOT NULL NUMBER(2)    
DNAME           VARCHAR2(14) 
LOC             VARCHAR2(13) 
*/

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmpDept2VO {
	//emp.empno, emp.ename, emp.sal, emp.deptno, dept.dname	
	private int empno;
	private String ename;
	private int sal;
	private int deptno;
	private String dname;
}