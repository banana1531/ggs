package com.ggs.notice;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ggs.DAO.NoticeDAO;
import com.ggs.DTO.NoticeDTO;
import com.ggs.util.NoticePageUtil;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	@Autowired
	private NoticeService nService;
	
	@Autowired
	private NoticeDAO nDAO;
	
	
	//리스트보기
	@GetMapping("/list")
	public String noticeList(
			@RequestParam(value = "nowPage", required = false, defaultValue = "1") int nowPage,
			@RequestParam(value ="result", defaultValue="0") int result,
			Model model) {
		
		if(result!=0) {
			model.addAttribute("result", "조회권한이 없습니다.");
		}
		
		
		NoticePageUtil pInfo = nService.noticePage(nowPage);
		ArrayList<NoticeDTO> noticeList = nService.noticeList(pInfo);
		
		model.addAttribute("PINFO", pInfo);
		model.addAttribute("noticeList", noticeList);
		
		return "Notice/list";
	}
	
	
	//조회수 증가
		@GetMapping("/hits")
		public String hits(
				int writeno,
				int nowPage,
				HttpSession session) {
			
			nService.hits(writeno, session);
			
			return "redirect:/notice/detail?writeno="+writeno+"&nowPage="+nowPage;
		}
		
		//상세정보
		@GetMapping("/detail")
		public String noticeDetail(
				@RequestParam(value="writeno") int writeno,
				@RequestParam(value="nowPage") int nowPage,
				Model model) {
			
			NoticeDTO noticeDetail = nService.noticeDetail(writeno);
			
			model.addAttribute("nowPage",nowPage);
			model.addAttribute("noticeDetail",noticeDetail);
			
			return "Notice/detail";
		}
		
		//글쓰기-폼
		@GetMapping("/write")
		public String noticeWriteForm(
				HttpSession session,
				Model model) {
			
			String id = (String)session.getAttribute("UID");
			model.addAttribute("ID", id);
			
			return "Notice/write";
		}
		
		//글쓰기-처리
		@PostMapping("/write")
		public String noticeWrite(
				String id,
				String title,
				String content) {
			
			nService.noticeWrite(id, title, content);
			
			return "redirect:/notice/list";
		}
		
		//수정하기-폼
		@GetMapping("/update")
		public String noticeUpdateForm(
				int writeno,
				int nowPage,
				Model model) {

			NoticeDTO noticeUpdateForm = nService.noticeUpdateForm(writeno);
			noticeUpdateForm.setNowPage(nowPage);
			
			model.addAttribute("noticeUpdateForm",noticeUpdateForm);
			
			return "Notice/update";
			
		}
		
		//수정하기-처리
		@PostMapping("/update")
		public String noticeUpdate(
				int writeno,
				String title,
				String content,
				int nowPage,
				Model model) {
			
			nService.noticeUpdate(writeno, title, content);
			
			return "redirect:/notice/detail?writeno="+writeno+"&nowPage="+nowPage;
		}
		
		//삭제하기
		@GetMapping("/delete")
		public String noticeDelete(
				int writeno,
				int nowPage,
				Model model) {
			
			nService.noticeDelete(writeno);
			
			return "redirect:/notice/list?nowPage="+nowPage;
		}

		//검색하기
		@GetMapping("/search")
		public String noticeSearch(
				String searchType,
				String keyword,
				@RequestParam(value = "nowPage", required = false, defaultValue = "1") int nowPage,
				Model model) {
			
			NoticePageUtil pInfo = nService.SearchPage(searchType, keyword, nowPage);
			ArrayList<NoticeDTO> noticeSearch = nService.noticeSearch(searchType, keyword, pInfo);
			
			model.addAttribute("searchType",searchType);
			model.addAttribute("keyword",keyword);
			model.addAttribute("noticeSearch", noticeSearch);
			model.addAttribute("PINFO", pInfo);

			return "Notice/search";
		}
	
}
