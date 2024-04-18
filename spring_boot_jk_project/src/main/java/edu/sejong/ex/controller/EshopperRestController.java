package edu.sejong.ex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.sejong.ex.service.EmpService;
import edu.sejong.ex.vo.EmpSalgradeDeptVO;
import edu.sejong.ex.vo.EmpSalgradeVO;
import edu.sejong.ex.vo.EmpVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/eshopper")
public class EshopperRestController {
	@Autowired
	private EmpService empService;

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

}