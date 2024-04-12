package edu.sejong.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.sejong.ex.vo.DeptVO;

@Mapper
public interface DeptMapper {
	public List<DeptVO> selectList();
	public void insert(DeptVO deptVO);
	public void delete(DeptVO deptVO);
}