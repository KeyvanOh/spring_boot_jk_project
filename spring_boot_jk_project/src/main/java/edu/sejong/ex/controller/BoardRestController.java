package edu.sejong.ex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.sejong.ex.service.BoardService;
import edu.sejong.ex.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/board")
public class BoardRestController {
	@Autowired
	private BoardService boardService;

	@RequestMapping("/ajax_list")
	public List<BoardVO> ajaxList() {
		log.info("ajaxList()..");
		return boardService.getList();
	}
}