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
	
	//수정
	public int modify(BoardsVO boards);

	public BoardsVO getPage(int no);
	
	//삭제
	public int delete (int no);
}
