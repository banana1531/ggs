package com.ggs.NewBoard;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ggs.DTO.FreeboardDTO;
import com.ggs.util.NoticePageUtil;

@Controller
@RequestMapping("/newboard")
public class NewBoardController {

	@Autowired
	private NewBoardService nbService;
	
	//리스트
	@GetMapping("/list")
	private String list(
			@RequestParam(value = "nowPage", required = false, defaultValue = "1") int nowPage,
			Model model) {
		
		NoticePageUtil pInfo = nbService.nbPage(nowPage);
		ArrayList<FreeboardDTO> nbList = nbService.nbList(pInfo);
		
		model.addAttribute("PINFO",pInfo);
		model.addAttribute("NBLIST",nbList);
		
		return "newboard/list";
	}
	
	//조회수 증가
	@GetMapping("/hits")
	public String hits(
			int writeno,
			int nowPage,
			HttpSession session) {

		nbService.hits(writeno, session);
		
		return "redirect:/newboard/detail?writeno="+writeno+"&nowPage="+nowPage;
	}
	
	//상세정보
	@GetMapping("/detail")
	public String detail(
			@RequestParam(value="writeno") int writeno,
			@RequestParam(value="nowPage") int nowPage,
			Model model) {
		
		FreeboardDTO nbDetail = nbService.nbDetail(writeno);
		
		model.addAttribute("nowPage",nowPage);
		model.addAttribute("NBDETAIL",nbDetail);
		
		return "newboard/detail";
	}

	//글쓰기-폼
	@GetMapping("/write")
	public String writeFORM(HttpSession session,
			Model model) {
		String id = (String)session.getAttribute("UID");
		model.addAttribute("ID",id);
		return "newboard/write";
	}
	
	//글쓰기-처리
	@PostMapping("/write")
	public String write(
			String id,
			String title,
			String content) {
		
		nbService.write(id, title, content);
		
		return "redirect:/newboard/list";	
	}
	
	//수정하기-폼
	@GetMapping("/update")
	public String updateFORM(
			int writeno,
			int nowPage,
			Model model) {
		
		FreeboardDTO nbUpdate = nbService.nbUpdate(writeno);
		nbUpdate.setNowPage(nowPage);
		
		model.addAttribute("NBUPDATE",nbUpdate);
		
		return "newboard/update";
	}
	
	//수정하기-처리
	@PostMapping("/update")
	public String update(
			int writeno,
			String title,
			String content,
			int nowPage,
			Model model) {
		
		nbService.update(writeno, title, content);
		
		return "redirect:/newboard/detail?writeno="+writeno+"&nowPage="+nowPage;
	}
	
	//삭제하기
	@GetMapping("/delete")
	public String delete(
			int writeno,
			int nowPage,
			Model model) {
		
		nbService.delete(writeno);
		
		return "redirect:/newboard/list?nowPage="+nowPage;	
	}
	
	//검색
	@GetMapping("/search")
	public String search(
			String searchType,
			String keyword,
			@RequestParam(value = "nowPage", required = false, defaultValue = "1") int nowPage,
			Model model) {
		
		NoticePageUtil pInfo = nbService.SearchPage(searchType, keyword, nowPage);
		ArrayList<FreeboardDTO> Search = nbService.Search(searchType, keyword, pInfo);
		
		model.addAttribute("searchType",searchType);
		model.addAttribute("keyword",keyword);
		model.addAttribute("SEARCH",Search);
		model.addAttribute("PINFO",pInfo);
		
		return "newboard/search";
	}
	
}
