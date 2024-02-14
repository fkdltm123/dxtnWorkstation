package com.dxtn.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SampleController {
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		System.out.println("index 호출");
		return "index";
	}
}
