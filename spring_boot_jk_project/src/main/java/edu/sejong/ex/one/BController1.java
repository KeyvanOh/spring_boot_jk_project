
package edu.sejong.ex.one;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/one")
public class BController1 {

	@Autowired
	private BService1 bService1;

	@RequestMapping("/list")
	public String list(Model model) throws Exception {

		System.out.println("list()");
		//model.addAttribute("boards", bService1.selectBoardList());

		return "/board/list";
	}

}
