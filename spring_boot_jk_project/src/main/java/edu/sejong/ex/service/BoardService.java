package edu.sejong.ex.service;

import java.util.List;

import edu.sejong.ex.vo.BoardVO;
import edu.sejong.ex.vo.BuserVO;
import edu.sejong.ex.vo.CommentsVO;

public interface BoardService {

	//List<BoardVO> getList();
	List<BoardVO> getList(int page);

	List<BuserVO> getListWithBuid(String buid);

	void registerBuser(BuserVO vo);

	void writePost(BoardVO vo);
	
	int getCountOfPosts();

	void addComment(CommentsVO vo);

	List<CommentsVO> getCommentList(int pnumber);

	void deletePost(int pnumber);


}