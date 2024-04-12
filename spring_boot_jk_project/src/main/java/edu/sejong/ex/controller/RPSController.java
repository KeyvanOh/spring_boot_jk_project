package edu.sejong.ex.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import edu.sejong.ex.service.RPSService;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
@RequestMapping("/rps")
public class RPSController {
	@Autowired
	private RPSService rpsService;
	@GetMapping("/main")
	public String list(Model model) {
		log.info("list()..");
		model.addAttribute("rpsList", rpsService.getRPSList());
		return "/rps/main";
	}
}