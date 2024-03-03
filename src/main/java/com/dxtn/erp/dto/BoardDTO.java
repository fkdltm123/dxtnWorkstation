package com.dxtn.erp.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDTO {

	private int boardId;

	private String boardTitle;

	private String boardContent;

	private int boardViewCount;

	private Date boardRegdate;

	private Date boardUpdatedate;

	private String memberId;
}
