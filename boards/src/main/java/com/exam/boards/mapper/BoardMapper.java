package com.exam.boards.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.exam.boards.model.BoardsVO;

@Repository
@Mapper
public interface BoardMapper {
	
	//insert       //파라미터로 BoardsVO
	//public void list(BoardsVO boards);

	//select 게시글 목록 조회
	public List <BoardsVO> getBoardList();
	
	//게시글 등록             //리턴 파라미터 타입
	public void BoardUpload(BoardsVO boards);
	
	//하나의 게시글 조회 //값이 담겨 있는 객체인 BoardsVO 작성해주고 (값의 타입)을 작성해 준다.
	public BoardsVO boardDetail(int no);
	
	//수정             //boardVO클래스를 boards 이름으로 지정, boards에 게시글의 정보가 담김
	public int modify(BoardsVO boards);
	
	//public BoardsVO getPage(int no);
	
	//삭제
	public int delete (int no);
}
