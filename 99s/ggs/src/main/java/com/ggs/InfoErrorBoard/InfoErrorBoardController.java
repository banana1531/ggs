package com.ggs.InfoErrorBoard;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.ggs.DTO.BoardDTO;
import com.ggs.DTO.InfoErrorBoardDTO;
import com.ggs.DTO.ReplyDTO;
import com.ggs.util.NoticePageUtil;

@Controller
@RequestMapping("/inforerrorboard")
public class InfoErrorBoardController {

	@Autowired
	private InfoErrorBoardService ieService;
	
	//리스트보기
	@GetMapping("/list")
	public String InfoErrorBoardList(
			@RequestParam(value = "nowPage", required = false, defaultValue = "1") int nowPage,
			@RequestParam(value ="result", defaultValue="0") int result,
			Model model) {

		if(result!=0) {
			model.addAttribute("result", "조회권한이 없습니다.");
		}
		
		NoticePageUtil pInfo = ieService.InfoErrorBoardPage(nowPage);
		ArrayList<InfoErrorBoardDTO> InfoErrorBoardList = ieService.InfoErrorBoardList(pInfo);
		
		model.addAttribute("PINFO", pInfo);
		model.addAttribute("InfoErrorBoardList", InfoErrorBoardList);
		
		return "InfoErrorBoard/list";
	}
	
	//조회수 증가
	@GetMapping("/hits")
	public String hits(int writeno,	int nowPage, HttpSession session) {
		ieService.hits(writeno, session);
		return "redirect:/inforerrorboard/detail?writeno="+writeno+"&nowPage="+nowPage;
	}
	
	//상세정보
	@GetMapping("/detail")
	public String InfoErrorBoardReply(
			@RequestParam(value="writeno") int writeno,
			@RequestParam(value="nowPage") int nowPage,
			Model model) {
		
		InfoErrorBoardDTO InfoErrorBoardDetail = ieService.InfoErrorBoardDetail(writeno);
		
		model.addAttribute("nowPage",nowPage);
		model.addAttribute("InfoErrorBoardDetail",InfoErrorBoardDetail);
		
		return "InfoErrorBoard/detail";
	}
	
	
	//글쓰기-폼
	@GetMapping("/write")
	public String InfoErrorBoardWriteForm(
			HttpSession session,
			Model model) {
		
		String id = (String)session.getAttribute("UID");
		model.addAttribute("ID", id);
		
		return "InfoErrorBoard/write";
	}
	
	//글쓰기-처리
	@PostMapping("/write")
	public String InfoErrorBoardWrite(
			String id,
			String title,
			String content) {
		
		ieService.InfoErrorBoardWrite(id, title, content);
		
		return "redirect:/inforerrorboard/list";
	}
	
	//수정하기-폼
	@GetMapping("/update")
	public String InfoErrorBoardUpdateForm(
			int writeno,
			int nowPage,
			Model model) {
		
		InfoErrorBoardDTO InfoErrorBoardUpdateForm = ieService.InfoErrorBoardUpdateForm(writeno);
		InfoErrorBoardUpdateForm.setNowPage(nowPage);
		
		model.addAttribute("InfoErrorBoardUpdateForm",InfoErrorBoardUpdateForm);
		
		return "InfoErrorBoard/update";
	}
	
	//수정하기-처리
	@PostMapping("/update")
	public String InfoErrorBoardUpdate(
			int writeno,
			String title,
			String content,
			int nowPage,
			Model model) {
		
		ieService.InfoErrorBoardUpdate(writeno, title, content);
		
		return "redirect:/inforerrorboard/detail?writeno="+writeno+"&nowPage="+nowPage;
	}
	
	//삭제하기
	@GetMapping("/delete")
	public String InfoErrorBoardDelete(
			int writeno,
			int nowPage,
			Model model) {
		
		ieService.InfoErrorBoardDelete(writeno);
		
		return "redirect:/inforerrorboard/list?nowPage="+nowPage;
	}
	

	//검색기능
	@GetMapping("/search")
	public String InfoErrorBoardSearch(
			String searchType,
			String keyword,
			@RequestParam(value = "nowPage", required = false, defaultValue = "1") int nowPage,
			Model model) {
		
		NoticePageUtil pInfo = ieService.SearchPage(searchType, keyword, nowPage);
		ArrayList<InfoErrorBoardDTO> InfoErrorBoardSearch = ieService.InfoErrorBoardSearch(searchType, keyword, pInfo);
		
		model.addAttribute("searchType",searchType);
		model.addAttribute("keyword",keyword);
		model.addAttribute("InfoErrorBoardSearch", InfoErrorBoardSearch);
		model.addAttribute("PINFO", pInfo);
		
		return "InfoErrorBoard/search";
	}
		
}
