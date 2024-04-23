package edu.sejong.ex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
//@RequestMapping("/login")
public class LoginController {

	@GetMapping("/login")
	public String login(Model model) {
		log.info("login()..");
		return "login/login";
	}
}
