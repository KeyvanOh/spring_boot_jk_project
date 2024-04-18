package edu.sejong.ex.vo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
PNUMBER             NUMBER(4)    
CNUMBER             NUMBER(3)    
PARENTCNUMBER       NUMBER(2)    
CID                 VARCHAR2(12) 
CCONTENT            VARCHAR2(30) 
CDATE               DATE            
*/

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CommentsVO {
	private int pnumber;
	private int cnumber;
	private int parentcnumber;
	private String cid;
	private String ccontent;
	// private Date cdate;
	private Timestamp cdate;
}