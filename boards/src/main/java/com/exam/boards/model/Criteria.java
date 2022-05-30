package com.exam.boards.model;

import lombok.Data;

@Data
public class Criteria {
	//페이징 쿼리를 동적 제어하기 위해 필요한 데이터 pageNum이랑 amount를 같이 파라미터로 전달하기 위한 용도
	//연관성 있는 데이터를 같이 관리함으로써 관리와 재사용성이 용이하여 따로 클래스 작성
	//criteria는 기준이라는 의미로 검색의 기준이라는 느낌으로 클래스명 사용

	//현재 페이지
	private int pageNum;
	
	//한 페이지 당 보여질 게시물 갯수
	private int amount;

	//스킵 할 게시물 수 (pageNum-1)*amount) 
	private int skip; //limit 사용을 위한 추가적인 변수 선언
	
	//기본 생성자 -> 기본 세팅 : pageNum = 1, amount = 10
	//파라미터 없이 criteria 호툴 했을 경우 기본적으로 pagNum은 1, amont는 10을 가지도록 생성자 작성
	public Criteria() {
		this(1,10);
		this.skip = 0; //limit을 사용 할거기 때문에 추가적인 설정
	}
	
	//생성자 -> 원하는 pageNum, 원하는 amount
	//파라미터와 함께 criteria 호출하게 되면 파아미터 값이 각각 pageNum이랑 amount에 값이 저장 되도록 생성자 작성
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
		this.skip = (pageNum-1)*amount; //생성자에도 skip 값이 연산되어 저장 되도록 코드를 추가
	}
	
	//쿼리문의 limit에서 사용 할 skip 개수를 미리 java단계에서 처리 후 넘겨주기 위함
	
	
	//setAmount(), setPageNum() 메소드를 호출하는 것은 amount, pageNum 값을 변경한다는 것을 의미
	//skip의 값 또한 변경 되어야 하기 때문에 해당 메소드 구현부에 skip값이 변경되도록 코드를 추가 
	
	public int getPageNum() {
		return pageNum;
	}

	//pageNum의 값을 변경, skip의 값 또한 변경 되어야 하기 때문에 ksip 값 변경 되는 코드 추가 
	public void setPageNum(int pageNum) {
		this.skip= (pageNum-1)*this.amount;
		this.pageNum = pageNum;
	}

	public int getAmount() {
		return amount;
	}

	//amount의 값을 변경
	public void setAmount(int amount) {
		this.skip = (this.pageNum-1)*amount;
		this.amount = amount;
	}

	public int getSkip() {
		return skip;
	}

	public void setSkip(int skip) {
		this.skip = skip;
	}

	@Override
	public String toString() {
		return "Criteria [pageNum=" + pageNum + ", amount=" + amount + ", skip=" + skip + "]";
	}
	
	
	

}
