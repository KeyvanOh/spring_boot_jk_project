package edu.sejong.ex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/home")
public class HomeController {

	// @Autowired
	// private BoardService boardService;

	@GetMapping("/home2")
	public String home(Model model) {
		log.info("home()..");

		//return "home2";
		return "admin/home2";
	}
}
