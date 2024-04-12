package edu.sejong.ex.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
PNUMBER  NOT NULL NUMBER(4)      
PID               VARCHAR2(12)   
PTITLE            VARCHAR2(30)   
PDATE             DATE           
PCONTENT          VARCHAR2(3000) 
PIMAGE            VARCHAR2(1000) 
PHIT              NUMBER(5)      
PLIKE             NUMBER(5)      
*/

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BoardVO {
	private int pnumber;
	private String pid;
	private String ptitle;
	private Date pdate;
	private String pcontent;
	private String pimage;
	private int phit;
	private int plike;
}