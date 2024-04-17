
package edu.sejong.ex.one;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.sejong.ex.twos.BService2;

@Controller
@RequestMapping("/two")
public class BController2 {

	@Autowired
	private BService2 bService2;

	@RequestMapping("/list")
	public String list(Model model) throws Exception {

		System.out.println("list()");
		// model.addAttribute("boards", bService2.selectBoardList());
		//model.addAttribute("boards", bService2.selectBoardPagingList(2));
		//model.addAttribute("page", bService2.selectBoardPagingList(2));
		//model.addAttribute("page", 2);

		return "/board/list";
	}

}
