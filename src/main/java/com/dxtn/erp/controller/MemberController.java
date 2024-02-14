package com.dxtn.erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.dxtn.erp.entity.Member;
import com.dxtn.erp.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@PostMapping("/createMember")
	public String createMember(@RequestBody Member member) {
		memberService.createMember(member);
		return "index";
	}
	
}
