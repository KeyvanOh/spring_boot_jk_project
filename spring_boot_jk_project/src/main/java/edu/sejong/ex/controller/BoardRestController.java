package edu.sejong.ex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.sejong.ex.service.BoardService;
import edu.sejong.ex.vo.BoardVO;
import edu.sejong.ex.vo.BuserVO;
import edu.sejong.ex.vo.CommentsVO;
import edu.sejong.ex.vo.PostlikeVO;
import edu.sejong.ex.vo.PostviewVO;
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

	@RequestMapping("/ajax_list2")
	// public List<BoardVO> ajaxList() {
	public List<BoardVO> ajaxList2() {
		log.info("ajaxList2()..");
		// return boardService.getList();
		return boardService.getList(1);
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

	// @RequestMapping("/ajax_delete")
	@DeleteMapping("/ajax_delete")
	// public void ajaxDelete(@RequestParam("pnumber") int pnumber) {
	public ResponseEntity<String> ajaxDelete(@RequestParam("pnumber") int pnumber) {
		log.info("ajaxDelete()..");
		ResponseEntity<String> entity = null;
		try {
			boardService.deletePost(pnumber);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
		// boardService.deletePost(pnumber);
	}

	/*
	 * @DeleteMapping("/{bid}") public ResponseEntity<String> rest_delete(BoardVO
	 * boardVO) { ResponseEntity<String> entity = null; log.info("rest_delete..");
	 * 
	 * try { boardService.remove(boardVO.getBid()); // 삭제가 성공하면 성공 상태메시지 저장 entity =
	 * new ResponseEntity<String>("SUCCESS", HttpStatus.OK); } catch (Exception e) {
	 * e.printStackTrace(); // 댓글 삭제가 실패하면 실패 상태메시지 저장 entity = new
	 * ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST); } // 삭제 처리
	 * HTTP 상태 메시지 리턴 return entity;
	 * 
	 * }
	 */

	@RequestMapping("/ajax_view")
	// public void ajaxDelete(@RequestParam("pnumber") int pnumber) {
	public ResponseEntity<String> ajaxView(@RequestParam("pnumber") int pnumber, @RequestParam("buid") String buid) {
		log.info("ajaxView()..");
		ResponseEntity<String> entity = null;
		try {
			boardService.viewUp(pnumber, buid);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
		// boardService.deletePost(pnumber);
	}

	@RequestMapping("/ajax_get_view_from_buid")
	public List<PostviewVO> ajaxViewListFromBuid(@RequestParam("pnumber") int pnumber,
			@RequestParam("buid") String buid) {
		log.info("ajaxViewListFromBuid()..");
		return boardService.getViewListFromBuid(pnumber, buid);
	}

	@RequestMapping("/ajax_get_view_from_pnumber")
	public List<PostviewVO> ajaxViewListFromPnumber(@RequestParam("pnumber") int pnumber) {
		log.info("ajaxViewListFromPnumber()..");
		return boardService.getViewListFromPnumber(pnumber);
	}

	@RequestMapping("/ajax_update_phit")
	public ResponseEntity<String> ajaxUpdatePhit(@RequestParam("pnumber") int pnumber, @RequestParam("phit") int phit) {
		log.info("ajaxUpdatePhit()..");
		ResponseEntity<String> entity = null;
		try {
			boardService.phitUp(pnumber, phit);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping("/ajax_like")
	public ResponseEntity<String> ajaxLike(@RequestParam("pnumber") int pnumber, @RequestParam("buid") String buid) {
		log.info("ajaxLike()..");
		ResponseEntity<String> entity = null;
		try {
			boardService.likeUp(pnumber, buid);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping("/ajax_get_like_from_buid")
	public List<PostlikeVO> ajaxLikeListFromBuid(@RequestParam("pnumber") int pnumber,
			@RequestParam("buid") String buid) {
		log.info("ajaxLikeListFromBuid()..");
		return boardService.getLikeListFromBuid(pnumber, buid);
	}

	@RequestMapping("/ajax_get_like_from_pnumber")
	public List<PostlikeVO> ajaxLikeListFromPnumber(@RequestParam("pnumber") int pnumber) {
		log.info("ajaxLikeListFromPnumber()..");
		return boardService.getLikeListFromPnumber(pnumber);
	}

	@RequestMapping("/ajax_update_plike")
	public ResponseEntity<String> ajaxUpdatePlike(@RequestParam("pnumber") int pnumber,
			@RequestParam("plike") int plike) {
		log.info("ajaxUpdatePlike()..");
		ResponseEntity<String> entity = null;
		try {
			// boardService.phitUp(pnumber, phit);
			boardService.plikeUp(pnumber, plike);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

}