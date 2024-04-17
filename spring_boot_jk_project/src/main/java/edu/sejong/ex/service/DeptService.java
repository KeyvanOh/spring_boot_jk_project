package edu.sejong.ex.service;

import java.util.List;

import edu.sejong.ex.vo.DeptVO;

public interface DeptService{
	List<DeptVO> getList();
	void register(DeptVO deptVO);
	void remove(DeptVO deptVO);
	List<DeptVO> deptList();
}