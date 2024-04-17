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
public class DeptVO2 {
	private int deptno;
	private String dname;
	private String loc;
}