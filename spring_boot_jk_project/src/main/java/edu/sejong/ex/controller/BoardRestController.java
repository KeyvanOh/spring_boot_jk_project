package edu.sejong.ex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.sejong.ex.service.BoardService;
import edu.sejong.ex.vo.BoardVO;
import edu.sejong.ex.vo.BuserVO;
import edu.sejong.ex.vo.CommentsVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/board")
public class BoardRestController {
	@Autowired
	private BoardService boardService;

	@RequestMapping("/ajax_list")
	// public List<BoardVO> ajaxList() {
	public List<BoardVO> ajaxList(@RequestParam("page") int page) {
		log.info("ajaxList()..");
		// return boardService.getList();
		return boardService.getList(page);
	}

	@RequestMapping("/ajax_list_with_buid")
	public List<BuserVO> ajaxListWithBuid(@RequestParam("buid") String buid) {
		log.info("ajaxListWithBuid()..");
		return boardService.getListWithBuid(buid);
	}

	@RequestMapping("/ajax_register")
	public void ajaxRegister(@RequestParam("buid") String buid, @RequestParam("bupw") String bupw) {
		log.info("ajaxRegister()..");
		BuserVO vo = new BuserVO(buid, bupw);
		boardService.registerBuser(vo);
	}

	/*
	 * PNUMBER NOT NULL NUMBER(4) PID VARCHAR2(12) PTITLE VARCHAR2(30) PDATE DATE
	 * PCONTENT VARCHAR2(3000) PIMAGE VARCHAR2(1000) PHIT NUMBER(5) PLIKE NUMBER(5)
	 */

	@RequestMapping("/ajax_posting")
	public void ajaxPosting(@RequestParam("pid") String pid, @RequestParam("ptitle") String ptitle,
			@RequestParam("pcontent") String pcontent, @RequestParam("pimage") String pimage) {
		log.info("ajaxPosting()..");
		// BuserVO vo = new BuserVO(buid, bupw);
		BoardVO vo = new BoardVO(0, pid, ptitle, null, pcontent, pimage, 0, 0);
		// boardService.registerBuser(vo);
		boardService.writePost(vo);
	}

	@RequestMapping("/ajax_posts_size")
	public int ajaxPostsSize() {
		log.info("ajaxPostsSize()..");
		return boardService.getCountOfPosts();
	}

	@RequestMapping("/ajax_comment")
	public void ajaxAddComment(@RequestParam("pnumber") int pnumber, @RequestParam("cid") String cid,
			@RequestParam("ccontent") String ccontent) {
		log.info("ajaxAddComment()..");

		CommentsVO vo = new CommentsVO();
		vo.setPnumber(pnumber);
		vo.setCid(cid);
		vo.setCcontent(ccontent);

		boardService.addComment(vo);

		// return boardService.getCountOfPosts();
	}

	@RequestMapping("/ajax_commentList")
	// public List<BoardVO> ajaxList() {
	public List<CommentsVO> ajaxCommentList(@RequestParam("pnumber") int pnumber) {
		log.info("ajaxCommentList()..");
		return boardService.getCommentList(pnumber);
	}

}