package com.exam.boards.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.boards.mapper.BoardMapper;
import com.exam.boards.model.BoardsVO;

@Service
public class BoardsService {
	//board interface  주입해주는 코드
	
	@Autowired
	BoardMapper boardmapper;
	

	public List <BoardsVO> getBoardList() {
		return boardmapper.getBoardList();
	}
	
	public int modify(BoardsVO boards) {
		return boardmapper.modify(boards);
	
	}

	public BoardsVO getPage(int no) { 
		return boardmapper.getPage(no);
	}
	
	public int delete(int no) {
		return boardmapper.delete(no);
	}

}
