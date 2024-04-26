package edu.sejong.ex.service;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.sejong.ex.mapper.BoardMapper;
import edu.sejong.ex.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TransactionTestService  {

	@Autowired
	private BoardMapper mapper;

	@Transactional
	public void transactionTest1() {
		log.info("transactionTest1()..");

		BoardVO boardVO = new BoardVO();
		boardVO.setPcontent("tx1");
		boardVO.setPtitle("tx1");
		boardVO.setPid("tx1");
		boardVO.setPimage("");

		mapper.insertIntoBoard(boardVO);
	}

	@Transactional
	public void transactionTest2() {
		log.info("transactionTest2()..");

		BoardVO boardVO = new BoardVO();
		boardVO.setPcontent("tx2");
		boardVO.setPtitle("tx2");
		boardVO.setPid("tx2");
		boardVO.setPimage("");

		mapper.insertIntoBoard(boardVO);
	}

	@Transactional
	public void transactionTest3() {
		log.info("transactionTest3()..");

		BoardVO boardVO = new BoardVO();
		boardVO.setPcontent("tx3");
		boardVO.setPtitle("tx3");
		boardVO.setPid("tx3");
		boardVO.setPimage("");

		mapper.insertIntoBoard(boardVO);
	}
	@Transactional
	public void transactionTest4() {
		log.info("transactionTest4()..");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setPcontent("tx4");
		boardVO.setPtitle("tx4");
		boardVO.setPid("tx4");
		boardVO.setPimage("");
		
		mapper.insertIntoBoard(boardVO);
		
		throw new RuntimeException("RuntimeException for rollback");
	}
	
	@Transactional
	public void transactionTest5() throws SQLException  {
		log.info("transactionTest5()..");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setPcontent("tx5");
		boardVO.setPtitle("tx5");
		boardVO.setPid("tx5");
		boardVO.setPimage("");
		
		mapper.insertIntoBoard(boardVO);
		
		//throw new RuntimeException("RuntimeException for rollback");
		throw new SQLException("RuntimeException for rollback");
	}
	
	//@Transactional
	@Transactional(rollbackFor = Exception.class)
	public void transactionTest6() throws SQLException {
		log.info("transactionTest6()..");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setPcontent("tx6");
		boardVO.setPtitle("tx6");
		boardVO.setPid("tx6");
		boardVO.setPimage("");
		
		mapper.insertIntoBoard(boardVO);
		
		//throw new RuntimeException("RuntimeException for rollback");
		throw new SQLException("RuntimeException for rollback");
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void transactionTest7() throws IOException  {
		log.info("transactionTest7()..");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setPcontent("tx7");
		boardVO.setPtitle("tx7");
		boardVO.setPid("tx7");
		boardVO.setPimage("");
		
		mapper.insertIntoBoard(boardVO);
		
		//throw new RuntimeException("RuntimeException for rollback");
		//throw new SQLException("RuntimeException for rollback");
		throw new IOException("RuntimeException for rollback");
	}

}
