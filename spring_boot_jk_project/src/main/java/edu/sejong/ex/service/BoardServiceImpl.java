package edu.sejong.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sejong.ex.mapper.BoardMapper;
import edu.sejong.ex.vo.BoardVO;
import edu.sejong.ex.vo.BuserVO;
import edu.sejong.ex.vo.CommentsVO;
import edu.sejong.ex.vo.PostviewVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;

	@Override
	// public List<BoardVO> getList() {
	public List<BoardVO> getList(int page) {
		// System.out.println("getList()..");
		log.info("getList()..log..");

		// return boardMapper.selectList();
		return boardMapper.selectList(page);
	}

	@Override
	public List<BuserVO> getListWithBuid(String buid) {
		log.info("getListWithBuid()..log..");

		return boardMapper.selectListWithBuid(buid);
	}

	@Override
	public void registerBuser(BuserVO vo) {
		log.info("registerBuser()..log..");

		boardMapper.insertIntoBuser(vo);
	}

	@Override
	public void writePost(BoardVO vo) {
		log.info("writePost()..log..");

		boardMapper.insertIntoBoard(vo);
	}

	@Override
	public int getCountOfPosts() {
		log.info("getCountOfPosts()..log..");

		return boardMapper.selectCountOfBoard();
	}

	@Override
	public void addComment(CommentsVO vo) {
		log.info("addComment()..log..");

		boardMapper.insertIntoComments(vo);

	}

	@Override
	public List<CommentsVO> getCommentList(int pnumber) {
		log.info("getCommentList()..log..");

		return boardMapper.selectCommentList(pnumber);
	}

	@Override
	public void deletePost(int pnumber) {
		log.info("deletePost()..log..");

		boardMapper.deletePostFromPnumber(pnumber);
	}

	@Override
	public void viewUp(int pnumber, String buid) {
		log.info("viewUp()..log..");

		boardMapper.insertPostview(pnumber, buid);
	}

	@Override
	public List<PostviewVO> getViewtListFromBuid(int pnumber, String buid) {
		log.info("getViewtListFromBuid()..log..");

		return boardMapper.selectPostviewListFromBuid(pnumber, buid);
		// return boardMapper.getPostviewList(pnumber, buid);
	}

	@Override
	public List<PostviewVO> getViewtListFromPnumber(int pnumber) {
		log.info("getViewtListFromPnumber()..log..");

		return boardMapper.selectPostviewListFromPnumber(pnumber);
	}

	@Override
	public void phitUp(int pnumber, int phit) {
		log.info("phitUp()..log..");
		
		boardMapper.updateBoardPhit(pnumber, phit);
	}

	@Override
	public void plikeUp(int pnumber, int plike) {
		log.info("plikeUp()..log..");
		
		boardMapper.updateBoardPlike(pnumber, plike);
	}

}