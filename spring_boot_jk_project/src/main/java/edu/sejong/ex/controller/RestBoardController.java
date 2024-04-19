package edu.sejong.ex.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/board2")
public class RestBoardController {

	@GetMapping("/start")
	public ModelAndView start(ModelAndView mv) {
		log.info("start()..");
		mv.setViewName("board2/rest_list");
		return mv;

	}

}