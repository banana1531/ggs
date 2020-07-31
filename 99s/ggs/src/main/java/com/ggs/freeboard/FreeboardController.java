package com.ggs.freeboard;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.ggs.DTO.FreeboardDTO;
import com.ggs.DTO.ReplyDTO;
import com.ggs.util.NoticePageUtil;

@Controller
@RequestMapping("/freeboard")
public class FreeboardController {

	@Autowired
	FreeboardService fbService;
	
	//리스트보기
	@GetMapping("/list")
	public ModelAndView freeboardList(
			@RequestParam(value = "nowPage", required = false, defaultValue = "1") int nowPage,
			@RequestParam(value ="result", defaultValue="0") int result,
			ModelAndView mv) {
		
		if(result!=0) {
			mv.addObject("result", "조회권한이 없습니다.");
		}
		
		NoticePageUtil pInfo = fbService.freeboardPage(nowPage);
		ArrayList<FreeboardDTO> freeboardList = fbService.freeboardList(pInfo);
		
		mv.addObject("freeboardList", freeboardList);
		mv.addObject("PINFO", pInfo);
		
		System.out.println("FreeboardController.freeboardList");
		mv.setViewName("Freeboard/list");
		
		return mv;
	}
	
	//게시물보기 & 댓글보기
	@GetMapping("/detail")
	public ModelAndView freeboardDetail(
			@RequestParam(value="writeno") int writeno,
			@RequestParam(value="nowPage", defaultValue="1") int nowPage,
			@RequestParam(value="views") int views,
			@RequestParam(value = "nowPage2", required = false, defaultValue = "1") int nowPage2,
			@RequestParam(value = "re", defaultValue="0") int re,
			String result,
			ModelAndView mv) {
		
		if(re!=0) mv.addObject("re", "조작 권한이 없습니다.");
		
		
		System.out.println("freeboardDetail. result="+result);
		fbService.hit(views,writeno);
		
		ArrayList<FreeboardDTO> freeboardDetail = fbService.freeboardDetail(writeno, nowPage);
		
		NoticePageUtil pInfo = fbService.ReplyPage(nowPage2, writeno);
		ArrayList<ReplyDTO> freeboardReply = fbService.freeboardReply(writeno, pInfo);
		
		mv.addObject("freeboardDetail",freeboardDetail);
		mv.addObject("freeboardReply",freeboardReply);
		mv.addObject("PINFO", pInfo);
		mv.addObject("result", result);
		
		mv.setViewName("Freeboard/detail");
		
		return mv;
	}
	
	//댓글등록
	@PostMapping("/detail")
	public ModelAndView freeboardReply(
			String id,
			String content,
			int wno,
			int nowPage,
			int views,
			ModelAndView mv) {
		
		fbService.replyAdd(id, content, wno);
		
		RedirectView rv = new RedirectView("./detail?writeno="+wno+"&nowPage="+nowPage+"&views="+views);
		mv.setView(rv);
		
		return mv;
	}
	
	//검색기능
	@GetMapping("/search")
	public ModelAndView freeboardSearch(
			@RequestParam(value="searchType") String searchType,
			@RequestParam(value="keyword") String keyword,
			@RequestParam(value = "nowPage", required = false, defaultValue = "1") int nowPage,
			ModelAndView mv) {
		
		NoticePageUtil pInfo = fbService.SearchPage(searchType, keyword, nowPage);
		pInfo.setSearchType(searchType);
		pInfo.setKeyword(keyword);
		ArrayList<FreeboardDTO> freeboardSearch = fbService.freeboardSearch(searchType, keyword, pInfo);
		
		mv.addObject("freeboardSearch", freeboardSearch);
		mv.addObject("PINFO", pInfo);
		
		mv.setViewName("Freeboard/search");
		
		return mv;
	}
	
	//글쓰기-폼
	@GetMapping("write")
	public String freeboardWriteForm() {
		return "Freeboard/write";
	}
	
	//글쓰기-처리
	@PostMapping("/write")
	public ModelAndView freeboardWrite(
			String id,
			String title,
			String content,
			ModelAndView mv) {
		
		fbService.freeboardWrite(id, title, content);
		
		RedirectView rv = new RedirectView("./list");
		mv.setView(rv);
		
		return mv;
	}
	
	//수정하기-폼
	@GetMapping("/update")
	public ModelAndView freeboardUpdateForm(
			int writeno,
			ModelAndView mv) {
		
		ArrayList<FreeboardDTO> freeboardUpdateForm = fbService.freeboardUpdateForm(writeno);
		
		mv.addObject("freeboardUpdateForm",freeboardUpdateForm);
		
		mv.setViewName("Freeboard/update");
		
		return mv;
	}
	
	//수정하기-처리
	@PostMapping("/update")
	public ModelAndView freeboardUpdate(
			int writeno,
			String title,
			String content,
			int nowPage,
			int views,
			ModelAndView mv) {
		
		fbService.freeboardUpdate(writeno, title, content);
		
		RedirectView rv = new RedirectView("./detail?writeno="+writeno+"&nowPage="+nowPage+"&views="+views);
		mv.setView(rv);
		
		return mv;
	}
	
	@GetMapping("/delete")
	public ModelAndView freeboardDelete(
			int writeno,
			int nowPage,
			ModelAndView mv) {
		
		fbService.freeboardDelete(writeno);
		
		RedirectView rv = new RedirectView("./list?nowPage="+nowPage);
		mv.setView(rv);
		
		return mv;
	}
}
