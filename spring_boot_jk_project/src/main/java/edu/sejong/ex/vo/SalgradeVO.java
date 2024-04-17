package edu.sejong.ex.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
GRADE       NUMBER 
LOSAL       NUMBER 
HISAL       NUMBER   
*/

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SalgradeVO {
	private int grade;
	private int losal;
	private int hisal;
}