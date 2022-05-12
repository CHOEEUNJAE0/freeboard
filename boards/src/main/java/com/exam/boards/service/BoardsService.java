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
	
	//게시글 목록 조회
	public List <BoardsVO> getBoardList() {
		return boardmapper.getBoardList();
	}
	
	//하나의 게시글 조회
		
	public BoardsVO BoardDetail(int no, BoardsVO boards) {
		return boardmapper.boardDetail(no);
	}
	
	//게시글 등록
	public void BoardUploard(BoardsVO boards) {
		boardmapper.BoardUpload(boards);
		
	}
	
	//게시글 수정
	public int modify(BoardsVO boards) {
		
		//System.out.println(boards.getNo());
		//System.out.println(boards.getTitle());
		return boardmapper.modify(boards);
	
	}

	/*public BoardsVO getPage(int no) { 
		return boardmapper.getPage(no);
	}*/
	//게시글 삭제
	public int delete(int no) {
		return boardmapper.delete(no);
	}
	
	

}
