package edu.sejong.ex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.sejong.ex.service.EmpService;
import edu.sejong.ex.service.EshopperService;
import edu.sejong.ex.vo.EmpSalgradeDeptVO;
import edu.sejong.ex.vo.EmpSalgradeVO;
import edu.sejong.ex.vo.EmpVO;
import edu.sejong.ex.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/eshopper")
public class EshopperRestController {
	@Autowired
	private EmpService empService;

	@Autowired
	private EshopperService eshopperService;

	@RequestMapping("/ajax_list")
	public List<EmpVO> ajax_list() {
		log.info("ajaxList()..");
		return empService.getList();
	}

	@RequestMapping("/ajaxEmpSalgradelist")
	public List<EmpSalgradeVO> ajaxEmpSalgradelist() {
		log.info("ajaxEmpSalgradelist()..");
		return empService.getEmpSalgradeVOList();
	}

	@RequestMapping("/ajaxEmpSalgradeDeptlist")
	public List<EmpSalgradeDeptVO> ajaxEmpSalgradeDeptlist() {
		log.info("ajaxEmpSalgradeDeptlist()..");
		return empService.getEmpSalgradeDeptVOList();
	}

	@RequestMapping("/ajaxSignup")
	public void ajaxSignup(@RequestParam("username") String username, @RequestParam("password") String password) {
		log.info("ajaxSignup()..");
		// return empService.getEmpSalgradeDeptVOList();

		UserVO userVO = new UserVO(username, password, 1

		);

		eshopperService.register(userVO);

	}

}