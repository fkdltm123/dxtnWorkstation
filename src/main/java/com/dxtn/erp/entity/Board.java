package com.dxtn.erp.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "board")
@Getter
@Setter
@NoArgsConstructor
public class Board {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int boardId;
	//제목
	@Column(length = 35, nullable = false)
	private String boardTitle;
	//내용
	@Column(length = 5000, nullable = false)
	private String boardContent;
	//조회수
	@Column
	private int boardViewCount;
	//등록일자
	@Column(length = 20, nullable = false)
	private Date boardRegdate;
	//수정일자
	@Column(length = 20, nullable = true)
	private LocalDateTime boardUpdatedate;
	//작성자(외래키)
	@Column(length = 20, nullable = false, unique = true)
	private String memberId;
	
	@Builder
	public Board(String boardTitle, String boardContent, String memberId, int boardViewCount) {
	    this.boardTitle = boardTitle;
	    this.boardContent = boardContent;
	    this.memberId = memberId;
	    this.boardViewCount = boardViewCount;
	}
	
	public void update(String boardTitle, String boardContent, String memberId) {
		this.boardTitle = boardTitle;
	    this.boardContent = boardContent;
	    this.memberId = memberId;
        this.boardUpdatedate = LocalDateTime.now();
    }
}

