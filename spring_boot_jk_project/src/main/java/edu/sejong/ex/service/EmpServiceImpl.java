package edu.sejong.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sejong.ex.mapper.EmpMapper;
import edu.sejong.ex.vo.EmpVO;
import edu.sejong.ex.vo.MgrVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmpServiceImpl implements EmpService {

	// @Autowired
	// private EmpRepository empRepository;
	@Autowired
	private EmpMapper empMapper;

	@Override
	public List<EmpVO> getList() {
		System.out.println("getList()..");
		log.info("getList()..log..");

		// return null;
		// return empRepository.selectList();
		return empMapper.selectList();
	}

	@Override
	public void register(EmpVO empVO) {
		System.out.println("register()..");

		// empRepository.insert(empVO);
		empMapper.insert(empVO);
	}

	@Override
	public void remove(EmpVO empVO) {
		System.out.println("remove()..");

		// empRepository.delete(empVO);
		empMapper.delete(empVO);
	}

	@Override
	public List<String> getJobList() {
		System.out.println("getJobList()..");

		// return empRepository.selectJobList();
		return empMapper.selectJobList();
	}

	@Override
	public List<MgrVO> getMgrList() {
		System.out.println("getMgrList()..");

		// return empRepository.selectMgrList();
		return empMapper.selectMgrList();
	}

	@Override
	public List<Integer> getDeptnosList() {
		System.out.println("getDeptnosList()..");

		// return empRepository.selectDeptnosList();
		return empMapper.selectDeptnosList();
	};
}