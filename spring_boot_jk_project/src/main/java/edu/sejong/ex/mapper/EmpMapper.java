package edu.sejong.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import edu.sejong.ex.vo.EmpSalgradeDeptVO;
import edu.sejong.ex.vo.EmpSalgradeVO;
import edu.sejong.ex.vo.EmpVO;
import edu.sejong.ex.vo.EmpVO2;
import edu.sejong.ex.vo.MgrVO;

@Mapper
public interface EmpMapper {
	List<EmpVO> selectList();

	int insert(EmpVO empVO);

	int delete(EmpVO empVO);

	List<String> selectJobList();

	List<MgrVO> selectMgrList();

	List<Integer> selectDeptnosList();

	List<EmpSalgradeVO> selectEmpSalgradeList();

	List<EmpSalgradeDeptVO> selectEmpSalgradeDeptList();

	@Select("select * from emp where ename = #{ename}")
	// List<EmpVO2> getEmp(String ename);
	EmpVO2 getEmp(String ename);

}