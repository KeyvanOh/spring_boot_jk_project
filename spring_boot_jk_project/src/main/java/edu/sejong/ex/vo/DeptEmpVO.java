package edu.sejong.ex.vo;

import java.util.List;

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
public class DeptEmpVO {
	private int deptno;
	private String dname;
	private String loc;

	private List<EmpVO2> empList;
	//private EmpVO2 empVO; association

}