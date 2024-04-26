package edu.sejong.ex.controller;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.sejong.ex.service.TransactionTestService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
//@RequestMapping("/tx")
@RequestMapping("/tx/*")
public class TransactionTestController {

	// @Autowired
	// private BoardService boardService;
	@Autowired
	private TransactionTestService transactionTestService;

	// @GetMapping("/list")
	@GetMapping("/{num}")
	public String transaction(@PathVariable("num") int num) throws SQLException, IOException {
		// log.info("transaction()..");
		log.info("transaction()..====================" + num);

//		if (num == 1) {
//			transactionTestService.transactionTest1();
//		}
//		;
		
		switch(num) {
			case 1: {
				transactionTestService.transactionTest1();
				break;
			}
			case 2: {
				transactionTestService.transactionTest2();
				break;
			}
			case 3: {
				transactionTestService.transactionTest3();
				break;
			}
			case 4: {
				transactionTestService.transactionTest4();
				break;
			}
			case 5: {
				transactionTestService.transactionTest5();
				break;
			}
			case 6: {
				transactionTestService.transactionTest6();
				break;
			}
			case 7: {
				transactionTestService.transactionTest7();
				break;
			}
			default: {
				
			}
		};
		
		
		
		//return "redirect:/board/list2";
		return "redirect:/board/list";

	}

}
