package com.dxtn.erp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxtn.erp.entity.Board;
import com.dxtn.erp.repository.BoardRepository;
import com.dxtn.erp.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardRepository boardRepository;

	/**
	 * 글목록 조회
	 * 
	 * @param board
	 * @return
	 */
	@Override
	public List<Board> getBoardList(Board board) {
		return (List<Board>) boardRepository.findAll();
	}

	/**
	 * 글쓰기 처리
	 * 
	 * @param board
	 */
	@Override
	public void insertBoard(Board board) {

	}

	@Override
	public Board getBoard(Board board) {
		return null;
	}

	@Override
	public void updateBoard(Board board) {

	}

	@Override
	public void deleteBoard(Board board) {

	}

}
