package edu.sejong.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.sejong.ex.vo.BoardVO;

@Mapper
public interface BoardMapper {
	List<BoardVO> selectList();
//	int insert(EmpVO empVO);
//	int delete(EmpVO empVO);
//	List<String> selectJobList();
//	List<MgrVO> selectMgrList();
//	List<Integer> selectDeptnosList();

}