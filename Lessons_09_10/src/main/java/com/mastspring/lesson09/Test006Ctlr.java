package com.mastspring.lesson09;

import java.beans.PropertyEditorSupport;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//read this for sure: http://stackoverflow.com/questions/9174048/difference-between-databinder-and-conversionservice-in-spring

@Controller
@RequestMapping (value="/mattsinitbinders")
public class Test006Ctlr {
	
	@InitBinder (value="somename")
	public void myInitBinder(WebDataBinder initBinder) {
		initBinder.registerCustomEditor(ShoppingObject.class, new MyPropertyEditor());
	}
	
	@RequestMapping (value="/{sObject}")
	@ResponseBody
	public String getObj(@PathVariable @ModelAttribute ShoppingObject sObject) {
		System.out.println(sObject);// Look now sObject will become ShoppingObject.
		return sObject.toString();
	}
}

class ShoppingObject {
	String name;
	String supplier;

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ShoppingObject(String name) {
		super();
		System.out.println("I am here");
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "ShoppingObject [name=" + name + ", supplier=" + supplier + "]";
	}
}

class MyPropertyEditor extends PropertyEditorSupport {

	public void setAsText(String name) {
    	ShoppingObject c = new ShoppingObject(name);
    	System.out.println("Name:  " + name);
    	String supplier = "";
    	if (name.startsWith("amz")) {
    		supplier = "Amazon";
    	} else if (name.startsWith("eba")) {
    		supplier = "Ebay";
    	} else if (name.startsWith("tsc")) {
    		supplier = "Tesco";
    	} 
    	c.setSupplier(supplier);
        this.setValue(c);
    }

    @Override
    public String getAsText() {
    	System.out.println("Name:  " );
    	ShoppingObject c = (ShoppingObject) this.getValue();
        return c.getName();
    }
}