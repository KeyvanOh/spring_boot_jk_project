package edu.sejong.ex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.sejong.ex.service.BoardService;
import edu.sejong.ex.vo.BoardVO;
import edu.sejong.ex.vo.BuserVO;
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
	
	@RequestMapping("/ajax_list_with_buid")
	public List<BuserVO> ajaxListWithBuid(
			@RequestParam("buid") String buid
	) {
		log.info("ajaxListWithBuid()..");
		return boardService.getListWithBuid(buid);
	}
	
	@RequestMapping("/ajax_register")
	public void ajaxRegister(
			@RequestParam("buid") String buid,
			@RequestParam("bupw") String bupw
			) {
		log.info("ajax_register()..");
		BuserVO vo = new BuserVO(buid, bupw);
		boardService.registerBuser(vo);
	}
	
	
	
	
	
}