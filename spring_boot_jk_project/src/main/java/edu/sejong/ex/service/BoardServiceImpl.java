package edu.sejong.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sejong.ex.mapper.BoardMapper;
import edu.sejong.ex.vo.BoardVO;
import edu.sejong.ex.vo.BuserVO;
import edu.sejong.ex.vo.CommentsVO;
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

}