package com.dxtn.erp.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dxtn.erp.entity.Board;
import com.dxtn.erp.service.BoardService;



@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/board")
	public ModelAndView boardMain() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("boardViews/boardMain");
		return mv;
	}
	
	@GetMapping("")
	public ModelAndView getBoardList(Model model, Board board) {
		List<Board> boardList = boardService.getBoardList(board);
		model.addAttribute("boardList", boardList);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("boardViews/boardMain");
		return mv;
	}
	
}
