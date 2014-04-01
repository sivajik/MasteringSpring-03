package com.mastspring.lesson09;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping (value="/modelattsextended")
public class Test005Ctlr {
	
	/*
	 * Try playing around giving diff names for URI template variable (prodidstr)
	 * and method argument names.
	 */
	@RequestMapping (value="/getproduct/{prodidstr}", method=RequestMethod.GET)
	public String showProduct(@PathVariable @ModelAttribute (value="new_name_for_model_obj") Product prodidstr) {
		System.out.println(prodidstr);
		return "products";
	}
}

final class StringToProductConveter implements Converter<String, Product> {
	static Map<String, Product> mapping = new HashMap<String, Product>();

	static {
		mapping.put("P1", new Product(1001, "Sony PlayStation 4"));
		mapping.put("P2", new Product(1002, "Kindle E Ink Display"));
		mapping.put("P3", new Product(1003, "Canon EOS 1100D Digital SLR Camera"));
		mapping.put("P4", new Product(1004, "Only Fools and Horses - The Complete DVD Set"));
	}
	
	public Product convert(String arg0) {
		System.out.println("In conversion code..." + arg0 + ", " + mapping.get(arg0));
		return mapping.get(arg0);
	}
}

class Product {
	long prodid;
	String name;
	public long getProdid() {
		return prodid;
	}
	public void setProdid(long prodid) {
		this.prodid = prodid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Product(long prodid, String name) {
		super();
		this.prodid = prodid;
		this.name = name;
	}
	
	public Product() {}
	@Override
	public String toString() {
		return "Product [prodid=" + prodid + ", name=" + name + "]";
	}
	
	
}