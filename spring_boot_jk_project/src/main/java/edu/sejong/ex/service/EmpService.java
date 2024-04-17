package edu.sejong.ex.service;

import java.util.List;

import edu.sejong.ex.vo.EmpSalgradeVO;
import edu.sejong.ex.vo.EmpVO;
import edu.sejong.ex.vo.MgrVO;

public interface EmpService {
	List<EmpVO> getList();

	void register(EmpVO empVO);

	void remove(EmpVO empVO);

	List<String> getJobList();

	// List<Integer> getMgrList();
	List<MgrVO> getMgrList();

	List<Integer> getDeptnosList();

	List<EmpSalgradeVO> getEmpSalgradeVOList();
}
