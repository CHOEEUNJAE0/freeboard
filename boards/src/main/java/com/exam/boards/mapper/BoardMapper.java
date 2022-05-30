package com.exam.boards.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.exam.boards.model.BoardsVO;
import com.exam.boards.model.Criteria;

@Repository
@Mapper
public interface BoardMapper {
	
	//insert       //파라미터로 BoardsVO
	//public void list(BoardsVO boards);

	//select 게시글 목록 조회
	public List <BoardsVO> getBoardList();
	
	
	//게시판 목록 (페이징 처리)
	//pageNum,amount 정보 넘기기 위해 criteria 클래스를 파라미터로 지정
	public List<BoardsVO> getListPaging(Criteria cri);
	
	
	
	//게시글 등록             //리턴 파라미터 타입
	public void upload(BoardsVO boards);
	
	//하나의 게시글 조회 //값이 담겨 있는 객체인 BoardsVO 작성해주고 (값의 타입)을 작성해 준다. 
	public BoardsVO detail(int no);
	
	//수정             
	//no,title,content,user_id에 대한 데이터가 필요하기때문에 해당 변수가 정의 도니 BoardVO를 파라미터로 지정
	//수정 메서드는 반환 타입이 필요 없긴 하지만 int 형으로 설정 하면 성고 시 1을 반환, 실패 시 0을 반환 해준다.
	public int modify(BoardsVO boards);
	
	//public BoardsVO getPage(int no);
	
	//삭제
	//int형으로 작성. 삭제 성공시 1을 반환, 실패 시 0을 반환
	public int delete (int no);
	
	//게시판 총 갯수
	public int getTotal();
}
