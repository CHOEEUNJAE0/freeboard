package com.exam.boards.model;

import lombok.Data;

@Data
public class BoardsVO {
	private int no;
	private String title;
	private String board_classification;
	private String use_yn;
	private String content;
	private String answer;
	private String important;
	private int file_no;
	private String user_id;
	private String user_name;
	private int hits;
	private String create;
	private String lastmodified;
	private String locale;

}
