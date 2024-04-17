package edu.sejong.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.sejong.ex.service.DeptEmpService;
import edu.sejong.ex.service.DeptService;
import edu.sejong.ex.service.EmpService;
import edu.sejong.ex.vo.EmpVO;
import lombok.extern.slf4j.Slf4j;

//@WebServlet("/jk/*")
@Slf4j
@Controller
@RequestMapping("/emp")
public class EmpController {

	@Autowired
	private EmpService empService;

	@Autowired
	private DeptService deptService;

	@Autowired
	private DeptEmpService deptEmpService;

	@GetMapping("/list")
	public String list(Model model) {
		System.out.println("list()..");
		model.addAttribute("emps", empService.getList());

		return "/emp/list";
	}

	@GetMapping("/insert_view")
	public String insert_view(Model model) {
		System.out.println("insert_view()..");
		model.addAttribute("emps", empService.getList());
		model.addAttribute("jobs", empService.getJobList());
		model.addAttribute("mgrs", empService.getMgrList());
		model.addAttribute("deptnos", empService.getDeptnosList());
		model.addAttribute("depts", deptService.getList());

		return "/emp/insert";
	}

	@PostMapping("/register")
	public String register(EmpVO empVO) {
		System.out.println("register()..");

		empService.register(empVO);

		return "redirect:/emp/list";
	}

	@GetMapping("/remove")
	public String remove(EmpVO empVO) {
		System.out.println("remove()..");

		empService.remove(empVO);

		return "redirect:/emp/list";
	}

	@GetMapping("/joinTest")
	public String joinTest(Model model) {
		System.out.println("joinTest()..");
		// model.addAttribute("emps", empService.getList());
		model.addAttribute("deptemps", deptEmpService.getList());

		return "/emp/joinTest";
	}

	@GetMapping("/salgrade")
	public String salgrade(Model model) {
		log.info("salgrade()..");
		model.addAttribute("empSalgrades", empService.getEmpSalgradeVOList());
		return "/emp/salgrade";
	}

}
