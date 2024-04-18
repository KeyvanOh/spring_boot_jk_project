package edu.sejong.ex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/eshopper")
public class EshopperController {

	// @Autowired
	// private BoardService boardService;

	@GetMapping("/main")
	public String list(Model model) {
		System.out.println("list()..");
		// model.addAttribute("boards", boardService.getList());

		return "/eshopper/main";
	}

}
