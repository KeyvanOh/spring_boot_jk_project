package edu.sejong.ex.repository;

import java.util.List;

import edu.sejong.ex.vo.EmpVO;
import edu.sejong.ex.vo.MgrVO;

public interface EmpRepository {
	List<EmpVO> selectList();
	void insert(EmpVO empVO);
	void delete(EmpVO empVO);
	List<String> selectJobList();
	List<MgrVO> selectMgrList();
	List<Integer> selectDeptnosList();
}
