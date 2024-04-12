package edu.sejong.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.sejong.ex.service.DeptService;
import edu.sejong.ex.vo.DeptVO;

//@WebServlet("/jk/*")
@Controller
@RequestMapping("/dept")
public class DeptController {

	@Autowired
	private DeptService deptService;

	@GetMapping(value = "/list")
	public String list(Model model) {
		System.out.println("list()..");
		// model.addAttribute("depts", deptService.getList());
		model.addAttribute("depts", deptService.deptList());

		return "/dept/list";
	}

	@GetMapping("/insert_view")
	public String insert_view(Model model) {
		System.out.println("insert_view()..");
		model.addAttribute("depts", deptService.getList());

		return "/dept/insert";
	}

	@PostMapping("/register")
	public String register(DeptVO deptVO) {
		System.out.println("register()..");
		deptService.register(deptVO);
		return "redirect:/dept/list";
	}
	@GetMapping("/remove")
	public String remove(DeptVO deptVO) {
		System.out.println("remove()..");
		deptService.remove(deptVO);
		return "redirect:/dept/list";
	}

}