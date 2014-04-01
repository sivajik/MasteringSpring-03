package com.mastspring.lesson09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class Test010Ctlr {
	@RequestMapping (value="/upload")
	@ResponseBody
	public String uploadFile(@RequestParam("txtfile") MultipartFile file) {
		String str = null;
		StringBuffer sf = new StringBuffer();
		try {
			sf.append( "File Details: " + file.getName() + ", " + file.getOriginalFilename() + "<br>");
			sf.append("And Content is: <hr><hr>");
			sf.append("<pre>");
			InputStream is = file.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			while ( (str = br.readLine()) != null) {
				sf.append(str + "<br>");
			}
			br.close();
			sf.append("</pre>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sf.toString();
	}
}