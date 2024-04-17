package edu.sejong.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.sejong.ex.vo.DeptEmpVO;
import edu.sejong.ex.vo.DeptVO2;
import edu.sejong.ex.vo.EmpDept2VO;
import edu.sejong.ex.vo.EmpVO2;

@Mapper
public interface EmpDept2Mapper {
	List<EmpDept2VO> selectList();

	List<EmpVO2> selectListEmp();

	List<DeptVO2> selectListDept();

	List<DeptEmpVO> getDeptEmpList();
}