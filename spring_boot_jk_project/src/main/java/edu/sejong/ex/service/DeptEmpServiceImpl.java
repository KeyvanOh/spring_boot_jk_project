package edu.sejong.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sejong.ex.mapper.EmpDept2Mapper;
import edu.sejong.ex.vo.DeptEmpVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DeptEmpServiceImpl implements DeptEmpService {

	@Autowired
	private EmpDept2Mapper empDept2Mapper;

	@Override
	public List<DeptEmpVO> getList() {
		return empDept2Mapper.getDeptEmpList();
	}

}