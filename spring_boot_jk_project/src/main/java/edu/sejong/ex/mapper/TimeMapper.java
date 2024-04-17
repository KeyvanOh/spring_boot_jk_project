package edu.sejong.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import edu.sejong.ex.vo.DeptVO;
import edu.sejong.ex.vo.EmpVO;

@Mapper
public interface TimeMapper {
	@Select("select sysdate from dual")
	public String getTime();

	@Select("select ename from emp where ename = 'KING'")
	public String getKing();

	// @Select("select * from emp where ename = 'KING'")
	// public String[] getKingArr();
	// public List<String> getKingArr();

	@Select("select * from emp where ename = 'KING'")
	public EmpVO getKingVO();

	@Select("select * from emp")
	public List<EmpVO> getEmps();

	@Select("select * from dept")
	public List<DeptVO> getDepts();

	@Select("select 1 + 1 from dual")
	public String getOnePlusOne();

	// @Update
	// @Delete

	public String getTime2();

	public String getOnePlusOne2();

}