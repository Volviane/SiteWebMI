package com.mi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
	
	
	@RequestMapping(value = "/testMethode", method = RequestMethod.GET)
	public String testMethodesGet(Model model) {
		System.out.println("/testMethode get");

		return "testMethode";
	}

}
