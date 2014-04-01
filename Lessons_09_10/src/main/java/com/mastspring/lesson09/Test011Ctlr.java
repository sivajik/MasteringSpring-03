package com.mastspring.lesson09;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Test011Ctlr {
	@RequestMapping (value="/exptest")
	public void textExceptions() {
		int number = (new java.util.Random()).nextInt(100);
		if (number % 2 == 0) {
			throw new MyCustomEvenNumberException("2468", "I Don't Like Even Numbers", number);
		} else {
			throw new MyCustomOddNumberException("1357", "I Don't Like Odd Numbers", number);
		}
	}
	
	@ExceptionHandler (value={MyCustomOddNumberException.class, MyCustomEvenNumberException.class})
	public ModelAndView handleExce(RuntimeException re) {
		ModelAndView mv = new ModelAndView("oops", "numbererrors", re);
		return mv;
	}
}

class MyCustomEvenNumberException extends RuntimeException {
	String errorCode;
	String errorString;
	int number;
	
	public MyCustomEvenNumberException(String errorCode, String errorString, int number) {
		super();
		this.errorCode = errorCode;
		this.errorString = errorString;
		this.number = number;
	}
	
	@Override
	public String toString() {
		return "MyCustomEvenNumberException [errorCode=" + errorCode
				+ ", errorString=" + errorString + ", number=" + number + "]";
	}
}

class MyCustomOddNumberException extends RuntimeException {
	String errorCode;
	String errorString;
	int number;
	
	public MyCustomOddNumberException(String errorCode, String errorString, int number) {
		super();
		this.errorCode = errorCode;
		this.errorString = errorString;
		this.number = number;
	}
	
	@Override
	public String toString() {
		return "MyCustomOddNumberException [errorCode=" + errorCode
				+ ", errorString=" + errorString + ", number=" + number + "]";
	}
}