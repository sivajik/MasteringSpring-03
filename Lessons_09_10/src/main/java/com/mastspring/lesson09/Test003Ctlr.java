package com.mastspring.lesson09;

import java.io.UnsupportedEncodingException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping (value="/rmappingex")
public class Test003Ctlr {

	@RequestMapping (value="/check" , method=RequestMethod.GET)
	public String checkWhatWeGet(
			HttpServletRequest req,HttpServletResponse res, HttpSession session, 
			WebRequest wReq,Locale myLocale, @RequestParam("eid") String eid, 
			@RequestHeader (value="User-Agent") String browser, @RequestBody String reqBody,  Model model) {
		
		String str = "Servlet API Request Stuff, Employee Id: <b>" + req.getParameter("eid") + "</b><br>";
		str = str + "Servlet API Response Stuff: <b>" +res.getLocale() + "</b><br>";
		str = str + "Servlet API Session Stuff: <b>" + (session != null ? session.getId() : "No Session") + "</b><br>";
		str = str + "Web Request: <b>" + wReq.getParameter("eid") + "</b><br>" ;
		str = str + "Web Request, User Agent: <b>" + wReq.getHeader("User-Agent") + "</b><br>";
		str = str + "My Locale resolve by LocaleResolver: <b>" + myLocale.getDisplayName() + "</b><br>";
		str = str + "Using @RequestParam, Employee Id: <b>" + eid + "</b><br>";
		str = str + "Using @RequestHeader, User Agent: <b>" + browser + "</b><br>";
		str = str + "Using @RequestBody, request Body: <b>" + reqBody + "</b><br>";
		
		model.addAttribute("rmappingex_string", str);
		return "rmapexample";
	}
	
	// Look, its post
	@RequestMapping (value="/checkpost" , method=RequestMethod.POST)
	public String checkWhatWePost(
			HttpServletRequest req,HttpServletResponse res, HttpSession session, 
			WebRequest wReq,Locale myLocale, @RequestParam("eid") String eid, 
			@RequestHeader (value="User-Agent") String browser, @RequestBody String reqBody,  Model model) {
		
		String str = "Servlet API Request Stuff, Employee Id: <b>" + req.getParameter("eid") + "</b><br>";
		str = str + "Servlet API Response Stuff: <b>" +res.getLocale() + "</b><br>";
		str = str + "Servlet API Session Stuff: <b>" + (session != null ? session.getId() : "No Session") + "</b><br>";
		str = str + "Web Request: <b>" + wReq.getParameter("eid") + "</b><br>" ;
		str = str + "Web Request, User Agent: <b>" + wReq.getHeader("User-Agent") + "</b><br>";
		str = str + "My Locale resolve by LocaleResolver: <b>" + myLocale.getDisplayName() + "</b><br>";
		str = str + "Using @RequestParam, Employee Id: <b>" + eid + "</b><br>";
		str = str + "Using @RequestHeader, User Agent: <b>" + browser + "</b><br>";
		str = str + "Using @RequestBody, request Body: <b>" + reqBody + "</b><br>";
		
		model.addAttribute("rmappingex_string", str);
		return "rmapexample";
	}
	
	@RequestMapping (value="/directline", method=RequestMethod.GET)
	@ResponseBody
	public String writeDirectly() {
		return "Hello, I am coming directly from with out JSPs or something...";
	}	
	
	
	@RequestMapping("/httpentity")
	public ResponseEntity<String> handle(HttpEntity<String> requestEntity) throws UnsupportedEncodingException {
	  String requestHeader = requestEntity.getHeaders().getFirst("EMP_ADDRESS");
	  String requestBody = requestEntity.getBody();
	  // do something with request header and body

	  HttpHeaders responseHeaders = new HttpHeaders();
	  responseHeaders.set("EMP_ADDRESS", "10 Downing Street, SW1A 2AA, London");
	  return new ResponseEntity<String>("Hello World", responseHeaders, HttpStatus.CREATED);
	}
}