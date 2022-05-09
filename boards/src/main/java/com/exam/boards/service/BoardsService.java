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
	
	//게시글 조회
	public BoardsVO BoardDetail(int no) {
		return boardmapper.boardDetail(no);
	}
	
	public void BoardUploard(BoardsVO boards) {
		boardmapper.boardUpload(boards);
		
	}
	
	//수정
	public int modify(BoardsVO boards) {
		
		//System.out.println(boards.getNo());
		//System.out.println(boards.getTitle());
		return boardmapper.modify(boards);
	
	}

	public BoardsVO getPage(int no) { 
		return boardmapper.getPage(no);
	}
	//삭제
	public int delete(int no) {
		return boardmapper.delete(no);
	}
	
	

}
