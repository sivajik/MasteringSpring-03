package com.mastspring.lesson09;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping (value="/modelatts")
public class Test004Ctlr {
	// Model attribute with model name as "firstemp"
	@ModelAttribute (value="firstemp")
	public Employee getEmployee() {
		return new Employee("James Gosling");
	}
	
	// These methods accept all @RequestMapping acceptable arguments. So we can use Model.
	@ModelAttribute
	public void addEmployess(Model model) {
		model.addAttribute("secondemp", new Employee("Doug Lee"));
		model.addAttribute("thirdemp", new Employee("Joshuah Bloch"));
		model.addAttribute("fourthemp", new Employee("Martin Odersky"));
	}
	
	// No model name given so it will take it as "employee"
	@ModelAttribute 
	public Employee lastEmployee() {
		return new Employee("Sivaji Kondapalli");
	}

	// No model name given but as "employee" was already added above, that will be overwritten.
	@ModelAttribute 
	public Employee lastEmployeeAgain() {
		return new Employee("Rod Johnson");
	}
	
	@RequestMapping (value="/showemps", method=RequestMethod.GET)
	public String showEmployees(Model model) {
		return "modelatts";
	}		
	
	/*
	 * e1 -> will be pulled form model named with "fourthemp"
	 * e2 -> will be created newly and added to model as "fifthemp"
	 */
	@RequestMapping (value="/validate", method=RequestMethod.GET)
	public String validateEmployees(@ModelAttribute ("fourthemp") Employee e1, 
								    @ModelAttribute ("fifthemp") Employee e2,
								    @ModelAttribute Employee e3) {
		System.out.println(e1);
		System.out.println(e2);
		System.out.println(e3);
		return "modelatts";
	}
}

class Employee {
	String name = "NO NAME GIVEN TO ME";

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	// This is must since spring might create a new instance on @ModelAttribute if
	// it cant find one in the model already.
	public Employee() {}
	public Employee(String name) {
		super();
		this.name = name;
	}
	
	public String toString() {
		return "Employee: " + name;
	}
}