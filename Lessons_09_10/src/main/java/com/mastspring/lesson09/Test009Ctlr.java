package com.mastspring.lesson09;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test009Ctlr {
	@RequestMapping (value="/themecheck")
	public String getObj() {
		return "themetest";
	}
}