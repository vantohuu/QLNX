package QLNX.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WellcomeController {
	@RequestMapping("welcome")
	public String sayHello() {
		System.out.println("welcome");
		return "welcome";
	}
	
}