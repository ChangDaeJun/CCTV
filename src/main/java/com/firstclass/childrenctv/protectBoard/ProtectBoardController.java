package com.firstclass.childrenctv.protectBoard;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.firstclass.childrenctv.ChildBoard.ChildBoardService;
import com.firstclass.childrenctv.ChildBoard.ChildBoardVO;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ProtectBoardController {

	private ProtectBoardService boardService;
	private ChildBoardService childService;
	
	@GetMapping("/protectBoard/list")
	public String protectBoardlist(Model model) {
		model.addAttribute("list", boardService.getAll());
		return "protectboard/list";
	}
	
	@GetMapping("/protectBoard/register")
	public String protectBoardregister() {
		
		return "protectboard/register";
	}
	
	@PostMapping("/protectBoard/register")
	public String protectboardregister(ProtectBoardVO board) {
		System.out.println("넣는 정보는 무엇일까????" +board.toString());
		boardService.insert(board);
		
		return "redirect:/protectBoard/list";
	}
	
	@GetMapping("/protectBoard/get")
	public String protectboardget(@RequestParam("protect_id") Long protect_id, Model model) {
		ProtectBoardVO board = boardService.get(protect_id);
		Long child_age = Long.valueOf(board.getChild_age());
		model.addAttribute("board", board);
		model.addAttribute("matchList", childService.matching(board.getChild_name(), board.getChild_gender(),child_age));
		System.out.println("GET 컨트롤러 왔다!!");
		if(boardService.get(protect_id) != null) {
			return "protectboard/get";
		}
		else {
			return "redirect:/";
		}
	}
	
	@PostMapping("/protectBoard/delete")
	public String deleteprotectboard(Long protect_id) {
		boardService.delete(protect_id);
		return "redirect:/protectBoard/list";
	}
	
	@GetMapping("/protectBoard/update")
	public String update(@RequestParam("protect_id") Long protect_id, Model model) {
		ProtectBoardVO board = boardService.get(protect_id);
		System.out.println("가져온 정보는???" + board);
		model.addAttribute("board", board);
		return "protectboard/update";
	}
	
	@PostMapping("/protectBoard/update")
	public String update(ProtectBoardVO board) {
		System.out.println("넣는 정보는?????" + board.toString());
		boardService.update(board);
		return "redirect:/protectBoard/list";
	}
	
	@PostMapping("/protectBoard/matching")
	public void matchingList(Long protect_id, Model model) {
		System.out.println("매칭 드가자~~~~~~~~");
		ProtectBoardVO board = boardService.get(protect_id);
		Long child_age = Long.valueOf(board.getChild_age());
		List<ChildBoardVO> childList =childService.matching(board.getChild_name(), board.getChild_gender(), child_age);
		if (childList != null && !childList.isEmpty()) {
	        System.out.println("가져온 아동 정보는?" + childList.get(0));
	        model.addAttribute("matchList", childList);
	    } else {
	        // childList가 비어있는 경우에 대한 처리
	        System.out.println("가져온 아동 정보가 없습니다.");
	    }
	}
	
	
	
}