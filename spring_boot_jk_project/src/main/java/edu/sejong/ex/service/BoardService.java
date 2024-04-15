package edu.sejong.ex.service;

import java.util.List;

import edu.sejong.ex.vo.BoardVO;
import edu.sejong.ex.vo.BuserVO;

public interface BoardService {

	List<BoardVO> getList();

	List<BuserVO> getListWithBuid(String buid);

}