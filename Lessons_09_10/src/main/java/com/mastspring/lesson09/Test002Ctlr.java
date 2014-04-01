package com.mastspring.lesson09;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * A @RequestMapping on the class level is not required. Without it, all paths are simply absolute, 
 * and not relative.
 */
@Controller
@RequestMapping (value="/myapp")
public class Test002Ctlr {

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
