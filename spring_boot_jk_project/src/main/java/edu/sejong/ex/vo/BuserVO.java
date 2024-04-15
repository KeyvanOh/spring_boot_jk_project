package edu.sejong.ex.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
BUID NOT NULL VARCHAR2(20) 
BUPW          VARCHAR2(20) 
*/

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
//@ToString
public class BuserVO {
	private String buid;
	private String bupw;
}