package edu.sejong.ex.repository;

import java.util.List;

import edu.sejong.ex.vo.DeptVO;

public interface DeptRepository {
	List<DeptVO> selectList();
	//void insert(DeptVO deptVO);
	//void delete(DeptVO deptVO);
}