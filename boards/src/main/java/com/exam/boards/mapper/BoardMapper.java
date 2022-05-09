package com.exam.boards.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.exam.boards.model.BoardsVO;

@Repository
@Mapper
public interface BoardMapper {
	
	//insert       //파라미터로 BoardsVO
	public void list(BoardsVO boards);

	//select
	public List <BoardsVO> getBoardList();
	
	//게시글 등록
	public void boardUpload(BoardsVO boards);
	
	//게시글 조회 //값이 담겨 있는 객체인 BoardsVO 작성해주고 (값의 타입)을 작성해 준다.
	public BoardsVO boardDetail(int no);
	
	//수정
	public int modify(BoardsVO boards);

	public BoardsVO getPage(int no);
	
	//삭제
	public int delete (int no);
}
