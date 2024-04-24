package edu.sejong.ex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/test")
public class TestController {

	// @Autowired
	// private BoardService boardService;

	@GetMapping("/")
	public String home(Model model) {
		log.info("home()..");

		//return "home2";
		return "home";
	}
}
