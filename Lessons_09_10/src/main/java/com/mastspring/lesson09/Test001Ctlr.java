package com.mastspring.lesson09;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 * A @RequestMapping on the class level is not required. Without it, all paths are simply absolute, 
 * and not relative.
 */
@Controller
@RequestMapping (value="/hrapplication") // top part of the URL
public class Test001Ctlr {

	/*
	 * Directly invoked on /hrapplication/
	 */
	@RequestMapping (value="/welcome")
	public String welcome(Model model) {
		model.addAttribute("welcome", "Welcome to <h4>HR Application</h4> To Manage Employees..");
		return "welcome";
	}
	
	/*
	 * URI Templates, with 2 parameters. firstname, lastname.
	 */
	@RequestMapping (value="/add/{firstname}/{lastname}")
	public String addEmployee(@PathVariable (value="firstname") String fname, @PathVariable(value="lastname") String lname, Model model) {
		model.addAttribute("emp_added", "Employee <h4>" + fname + " , " + lname + "</h4> Added to application");
		return "addemp";
	}
	
	/*
	 * @PathVariable used but no parameter name given since parameter name and variable name as same (uid).
	 * This method will be invoked only on GET request. If you call as POST it wont be invoked.
	 */
	@RequestMapping (value="/get/{uid}", method=RequestMethod.GET) 
	public String getEmployee(@PathVariable String uid, Model model) {
		model.addAttribute("get_emp", "Employee with <h4>" + uid + "</h4> Exists... : ");
		return "getemp";
	}
	
	/*
	 * Let this method consumes a piece of XML. We give some XML as input to this method
	 * and expects to consume it. If input is not XML then it wont accept it.
	 */
	@RequestMapping (value="/readxml" ,consumes="application/xml")
	public ResponseEntity<String> readXml(@RequestBody String rBody) {
		return new ResponseEntity<String>(rBody, HttpStatus.OK);
	}
	
	/*
	 * Let this method consumes a piece of JSON. We give some JSON as input to this method
	 * and expects to consume it. If input is not JSON then it wont accept it.
	 */
	@RequestMapping (value="/readjson" ,consumes="application/json")
	public ResponseEntity<String> readJson(@RequestBody String rBody) {
		return new ResponseEntity<String>(rBody, HttpStatus.OK);
	}
}
