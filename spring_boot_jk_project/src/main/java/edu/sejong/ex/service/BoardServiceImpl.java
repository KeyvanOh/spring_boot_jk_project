package edu.sejong.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sejong.ex.mapper.BoardMapper;
import edu.sejong.ex.vo.BoardVO;
import edu.sejong.ex.vo.BuserVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;

	@Override
	public List<BoardVO> getList() {
		// System.out.println("getList()..");
		log.info("getList()..log..");

		return boardMapper.selectList();
	}

	@Override
	public List<BuserVO> getListWithBuid(String buid) {
		log.info("getListWithBuid()..log..");

		return boardMapper.selectListWithBuid(buid);
	}

}