package edu.sejong.ex.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.sejong.ex.service.RPSService;
import edu.sejong.ex.vo.RPSVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/rps")
public class RPSRestController {
	@Autowired
	private RPSService rpsService;
	@RequestMapping("/ajax")
	public RPSVO ajax(@RequestParam("rps") String rps) {
		log.info("ajax()..");
		return rpsService.getJson(rps);
	}
	@RequestMapping("/ajax_list")
	public String[] ajaxList() {
		log.info("ajaxList()..");
		return rpsService.getRPSList();
	}
}