package edu.sejong.ex.vo;

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
public class CartVO {
	private String product = "사이다";
	private int count = 1;
}