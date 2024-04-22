package edu.sejong.ex.service;

import java.util.List;

import edu.sejong.ex.vo.BoardVO;
import edu.sejong.ex.vo.BuserVO;
import edu.sejong.ex.vo.CommentsVO;
import edu.sejong.ex.vo.PostlikeVO;
import edu.sejong.ex.vo.PostviewVO;

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

	void viewUp(int pnumber, String buid);

	List<PostviewVO> getViewListFromBuid(int pnumber, String buid);

	List<PostviewVO> getViewListFromPnumber(int pnumber);

	void phitUp(int pnumber, int phit);

	void plikeUp(int pnumber, int plike);

	List<PostlikeVO> getLikeListFromBuid(int pnumber, String buid);

	void likeUp(int pnumber, String buid);

	List<PostlikeVO> getLikeListFromPnumber(int pnumber);


}