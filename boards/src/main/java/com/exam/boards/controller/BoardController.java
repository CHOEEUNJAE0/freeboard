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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.exam.boards.model.BoardsVO;
import com.exam.boards.service.BoardsService;

@Controller

public class BoardController {
	@Autowired
	BoardsService boardsService;

	@GetMapping("/boards/{no}")
	@ResponseBody
	public List<BoardsVO> GetBoardList(int no) {
		return boardsService.getBoardList();
	}
	
	@PostMapping("/board")
	public String BoardUpload (@RequestBody BoardsVO boards) {
		boardsService.BoardUploard(boards);
		return "redirect:/list";
	}
	
	//상세페이지 진입
	@GetMapping("boards/detail/{no}")
	@ResponseBody
	public BoardsVO BoardDetail(@PathVariable int no, RedirectAttributes rttr) {
		return boardsService.BoardDetail(no);
	}
	
	//수정 페이지로 이동
	@GetMapping("/modify")
	@ResponseBody
	public void modify(int no, Model model) {
		model.addAttribute("pageInfo", boardsService.getPage(no));
	}
	
	//페이지 수정 //
	@PutMapping("/board/{no}")							//객체를 받아 올 때 객체로 인식해주는 어노테이션
	public String boardMOdifyPOST(@PathVariable int no, @RequestBody BoardsVO boards, RedirectAttributes rttr) {
		boardsService.modify(boards);
		System.out.println(no);
		rttr.addFlashAttribute("result", "modify success");
		return "redirect:/list";
		
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
