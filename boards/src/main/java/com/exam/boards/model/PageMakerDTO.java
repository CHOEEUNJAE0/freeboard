package com.exam.boards.model;

import java.util.List;

public class PageMakerDTO {
	
	//시작 페이지
	private int startPage;
	//마지막 페이지
	private int endPage;
	//이전 페이지, 다음 페이지 존재 유무
	private boolean prev, next;
	//전체 게시물 수 
	private int total;
	//현재 페이지, 페이지 당 게시물 표시수 정보
	private Criteria cri;

	//boardsVO list 타입으로 선언
	private List <BoardsVO> getBoardList;
	

	//현재페이지에 대한 정보인 critria, 게시물의 총개수인 total을 파라미터로 부여한	생성자
	public PageMakerDTO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		//마지막페이지
		this.endPage = (int)(Math.ceil(cri.getPageNum()/10.0))*10;
		//시작페이지
		this.startPage = this.endPage -9;
		//전체 마지막 페이지
		int realEnd = (int)(Math.ceil(total * 1.0/cri.getAmount()));
		//전체 마지막 페이지(realend)가 화면에 보이는 마지막 페이지보다 작은 경우 , 보여지는 페이지
		if(realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		//시작 페이지 값이 1보다 큰 경우 true
		this.prev = this.startPage > 1;
		//마지막 페이지 값이 1보다 큰 경우 true
		this.next = this.endPage < realEnd;
	}



	public int getStartPage() {
		return startPage;
	}



	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}



	public int getEndPage() {
		return endPage;
	}



	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}



	public boolean isPrev() {
		return prev;
	}



	public void setPrev(boolean prev) {
		this.prev = prev;
	}



	public boolean isNext() {
		return next;
	}



	public void setNext(boolean next) {
		this.next = next;
	}



	public int getTotal() {
		return total;
	}



	public void setTotal(int total) {
		this.total = total;
	}



	public Criteria getCri() {
		return cri;
	}



	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	
	public List<BoardsVO> getGetBoardList() {
		return getBoardList;
	}

	public void setGetBoardList(List<BoardsVO> getBoardList) {
		this.getBoardList = getBoardList;
	}
	
	//List <BoardVO> 은 toString에는 추가 하지 않아도 된다.
	@Override
	public String toString() {
		return "PageMakerDTO [startPage=" + startPage + ", endPage=" + endPage + ", prev=" + prev + ", next=" + next
				+ ", total=" + total + ", cri=" + cri + "]";
	}
	
	
}
