package edu.sejong.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.sejong.ex.vo.BoardVO;
import edu.sejong.ex.vo.BuserVO;
import edu.sejong.ex.vo.CommentsVO;

@Mapper
public interface BoardMapper {
	//List<BoardVO> selectList();
	List<BoardVO> selectList(int page);

//	int insert(EmpVO empVO);
//	int delete(EmpVO empVO);
//	List<String> selectJobList();
//	List<MgrVO> selectMgrList();
//	List<Integer> selectDeptnosList();
	List<BuserVO> selectListWithBuid(String buid);

	void insertIntoBuser(BuserVO vo);

	void insertIntoBoard(BoardVO vo);
	
	int selectCountOfBoard();

	void insertIntoComments(CommentsVO vo);

	List<CommentsVO> selectCommentList(int pnumber);
}