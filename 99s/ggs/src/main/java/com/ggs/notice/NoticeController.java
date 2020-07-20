package com.ggs.notice;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.ggs.DAO.NoticeDAO;
import com.ggs.DTO.NoticeDTO;
import com.ggs.util.NoticePageUtil;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	@Autowired
	NoticeService nService;
	
	@Autowired
	NoticeDAO nDAO;
	
	@RequestMapping("/list")
	public ModelAndView noticeList(
			@RequestParam(value = "nowPage", required = false, defaultValue = "1") int nowPage,
			ModelAndView mv) {
		
		NoticePageUtil pInfo = nService.noticePage(nowPage);
		ArrayList<NoticeDTO> noticeList = nService.noticeList(pInfo);
		
		mv.addObject("noticeList", noticeList);
		mv.addObject("PINFO", pInfo);
		
		mv.setViewName("Notice/list");
		
		return mv;
	}
	
	@RequestMapping("/detail")
	public ModelAndView noticeDetail(
			@RequestParam(value="writeno") int writeno,
			@RequestParam(value="nowPage") int nowPage,
			@RequestParam(value="views") int views,
			ModelAndView mv) {
		
		nService.hit(views, writeno);
		
		ArrayList<NoticeDTO> noticeDetail = nService.noticeDetail(writeno, nowPage);
		
		mv.addObject("noticeDetail",noticeDetail);
		
		mv.setViewName("Notice/detail");
		
		return mv;
		
	}
	
	@GetMapping("/write")
	public String noticeWriteForm() {
		return "Notice/write";
	}
	
	@PostMapping("/write")
	public ModelAndView noticeWrite(
			String id,
			String title,
			String content,
			ModelAndView mv) {
		
		nService.noticeWrite(id, title, content);
		
		RedirectView rv = new RedirectView("./list");
		mv.setView(rv);
		
		return mv;
	}
	
	@GetMapping("/update")
	public ModelAndView noticeUpdateForm(
			int writeno,
			ModelAndView mv) {

		ArrayList<NoticeDTO> noticeUpdateForm = nService.noticeUpdateForm(writeno);
		
		mv.addObject("noticeUpdateForm",noticeUpdateForm);
		
		mv.setViewName("Notice/update");
		
		return mv;
		
	}
	
	@PostMapping("/update")
	public ModelAndView noticeUpdate(
			int writeno,
			String title,
			String content,
			int nowPage,
			int views,
			ModelAndView mv) {
		
		nService.noticeUpdate(writeno, title, content);
		
		RedirectView rv = new RedirectView("./detail?writeno="+writeno+"&nowPage="+nowPage+"&views="+views);
		mv.setView(rv);
		
		return mv;
	}
	
	@RequestMapping("/delete")
	public ModelAndView noticeDelete(
			int writeno,
			int nowPage,
			ModelAndView mv) {
		
		nService.noticeDelete(writeno);
		
		RedirectView rv = new RedirectView("./list?nowPage="+nowPage);
		mv.setView(rv);
		
		return mv;
	}

	@RequestMapping("/search")
	public ModelAndView noticeSearch(
			@RequestParam(value="searchType") String searchType,
			@RequestParam(value="keyword") String keyword,
			@RequestParam(value = "nowPage", required = false, defaultValue = "1") int nowPage,
			ModelAndView mv) {
		
		NoticePageUtil pInfo = nService.SearchPage(searchType, keyword, nowPage);
		pInfo.setSearchType(searchType);
		pInfo.setKeyword(keyword);
		ArrayList<NoticeDTO> noticeSearch = nService.noticeSearch(searchType, keyword, pInfo);
		
		mv.addObject("noticeSearch", noticeSearch);
		mv.addObject("PINFO", pInfo);
		
		mv.setViewName("Notice/search");
		
		return mv;
	}
	
}
