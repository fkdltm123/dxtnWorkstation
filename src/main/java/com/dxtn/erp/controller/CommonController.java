package com.dxtn.erp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CommonController {

	@GetMapping("/")
	public ModelAndView getIndexPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("commonViews/index");
		return mv;
	}
}
