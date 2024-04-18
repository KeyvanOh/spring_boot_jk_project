package edu.sejong.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.sejong.ex.vo.EmpSalgradeDeptVO;
import edu.sejong.ex.vo.EmpSalgradeVO;
import edu.sejong.ex.vo.EmpVO;
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

}