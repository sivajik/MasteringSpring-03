package com.mastspring.lesson09;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test008Ctlr {
	@RequestMapping (value="/localecheck")
	public String getObj() {
		return "localetest";
	}
}