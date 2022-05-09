package com.exam.boards.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.exam.boards.model.BoardsVO;
import com.exam.boards.service.BoardsService;

@Controller

public class BoardController {
	@Autowired
	BoardsService boardsService;
	
	@GetMapping
	public String hello() {
		return "hello";
		
	}
	@GetMapping("/list")
	@ResponseBody
	public List<BoardsVO> GetBoardList() {
		return boardsService.getBoardList();
	}
	
	//수정 페이지로 이동
	@PostMapping("/modify")
	@ResponseBody
	public void modify(int no, Model model) {
		model.addAttribute("pageInfo", boardsService.getPage(no));
	}
	
	//페이지 수정
	@PutMapping("/modify")	
	public String boardMOdifyPOST(BoardsVO boards, RedirectAttributes rttr) {
		boardsService.modify(boards);
		rttr.addFlashAttribute("result", "modify success");
		return "redirect:/list";
		
	}
	
	//페이지 삭제
	@PostMapping("/delete")
	public String boardDeletePOST(int no, RedirectAttributes rttr) {
		boardsService.delete(no);
		rttr.addFlashAttribute("result", "delete success");
		return "redirect:/list";
	}
	 

}
