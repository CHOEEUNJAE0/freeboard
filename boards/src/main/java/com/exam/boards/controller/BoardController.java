package com.exam.boards.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.exam.boards.model.BoardsVO;
import com.exam.boards.service.BoardsService;

@Controller

public class BoardController {
	@Autowired
	BoardsService boardsService;
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";

	}
	
	//게시판 목록
	@GetMapping("/list")
	public String GetBoardList(Model model) {
		model.addAttribute("list", boardsService.getBoardList());
		return "boardList";
	}
	
	//등록페이지로 진입
	@GetMapping("/upload")
	public String BoardUploadGet() {
		return "boardUpload";
	}
	
	
	//게시글 등록
	@PostMapping("/upload")
	public String BoardUploadPost (BoardsVO boards) {
		//boardUpload view단에는 안 넣어줬지만 null값이 들어가면 안되기때문에 여기에 선언해준다.
		boards.setBoard_classification("test11");
		boards.setClassification("test111");
		boards.setUse_yn("y");
		boards.setLastmodified("test11");
		boards.setHits(11);
		boards.setCreated("2022-05-22");
		
		boardsService.BoardUploard(boards);
		return "redirect:/list";
	}
	 
	//상세페이지 진입 //됨
	@GetMapping("/detail/{no}")
	@ResponseBody
	public BoardsVO BoardDetail(@PathVariable int no, RedirectAttributes rttr) {
		return boardsService.BoardDetail(no);
	}
	
	//수정 페이지로 이동 //안됨
	@GetMapping("detail/modify/{no}")
	public String BoardModifyGet() {
		return "boardModify";
	}
	
	//페이지 수정 //   //안됨
	@PutMapping("/board/{no}")							//객체를 받아 올 때 객체로 인식해주는 어노테이션
	public String BoardModifyPOST(@PathVariable int no, @RequestBody BoardsVO boards, RedirectAttributes rttr) {
		boards.setNo(no);
		boardsService.modify(boards);
		System.out.println(no);
		rttr.addFlashAttribute("result", "modify success");
		return "redirect:/detail";
		
	}
	
	//페이지 삭제
	@DeleteMapping("/board/{no}")
	public String boardDeletePOST(@PathVariable int no, RedirectAttributes rttr) {
		boardsService.delete(no);
		System.out.println(no);
		rttr.addFlashAttribute("result", "delete success");
		return "redirect:/list";
	}
	 

}
