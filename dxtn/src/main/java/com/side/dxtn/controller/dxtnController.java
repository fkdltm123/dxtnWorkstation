package com.side.dxtn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class dxtnController {
	
	@GetMapping("/")
	public String getMainPage() {
	
		return "dxtn";
	}
	
	
}
