package com.exam.boards.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.boards.mapper.BoardMapper;
import com.exam.boards.model.BoardsVO;
import com.exam.boards.model.Criteria;

@Service
public class BoardsService {
	//board interface  주입해주는 코드
	
	@Autowired
	BoardMapper boardmapper;
	
	//게시글 목록 조회
	public List <BoardsVO> getBoardList() {
		return boardmapper.getBoardList();
	}
	
	//게시글 목록 조회(페이징)
	public List <BoardsVO> getListPaging(Criteria cri) {
		return boardmapper.getListPaging(cri);
	}
	
	//하나의 게시글 조회	
	public BoardsVO BoardDetail(int no) {
		return boardmapper.detail(no);
	}
	
	//게시글 등록
	public void BoardUploard(BoardsVO boards) {
		boardmapper.upload(boards);
		
	}
	
	//게시글 수정
	public int modify(BoardsVO boards) {
		
		//System.out.println(boards.getNo());
		//System.out.println(boards.getTitle());
		return boardmapper.modify(boards);
	
	}

	//게시글 삭제
	public int delete(int no) {
		//인터페이스의 boardmapper 의 삭제 메서드 호출. int 반환해야하기 때문에 return값에 mapper 메서드 호출 
		return boardmapper.delete(no);
	}
	
	//게시판 총 갯수
	public int getTotal(){
		return boardmapper.getTotal();
	}
	

}
