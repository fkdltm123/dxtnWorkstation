package com.dxtn.erp.service;

import java.util.List;

import com.dxtn.erp.entity.Board;

public interface BoardService {

	/**
	 * 글목록 조회
	 * 
	 * @param board
	 * @return
	 */
	List<Board> getBoardList(Board board);

	/**
	 * 글쓰기 처리
	 * 
	 * @param board
	 */
	void insertBoard(Board board);

	Board getBoard(Board board);

	void updateBoard(Board board);

	void deleteBoard(Board board);

}
