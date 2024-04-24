package edu.sejong.ex.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

	@GetMapping("/loginInfo")
	public String loginInfo(Authentication authentication, Principal principal, Model model) {
		log.info("loginInfo()..");
		System.out.println(principal.getClass());
		System.out.println(principal.getName());

		System.out.println(authentication.getAuthorities());
		System.out.println(authentication.getDetails());
		System.out.println(authentication.getClass());
		System.out.println(authentication.getPrincipal());

		UserDetails user = (UserDetails) authentication.getPrincipal();
		System.out.println(user.getPassword());
		System.out.println(user.getUsername());
		System.out.println(user.getAuthorities());
		System.out.println(user.getClass());

		WebAuthenticationDetails web = (WebAuthenticationDetails) authentication.getDetails();
		System.out.println(web.getSessionId());
		System.out.println(web.getClass());
		System.out.println(web.getRemoteAddress());

		// SecurityContextHolder holder = web.
		UserDetails user2 = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println(user2.getPassword());
		System.out.println(user2.getUsername());
		System.out.println(user2.getAuthorities());
		System.out.println(user2.getClass());

		return "login/login";
	}
}