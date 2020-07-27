package com.ggs.InfoErrorBoard;

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
import com.ggs.DTO.InfoErrorBoardDTO;
import com.ggs.DTO.ReplyDTO;
import com.ggs.util.NoticePageUtil;

@Controller
@RequestMapping("/inforerrorboard")
public class InfoErrorBoardController {

	@Autowired
	InfoErrorBoardService ieService;
	
	//리스트보기
	@GetMapping("/list")
	public ModelAndView InfoErrorBoardList(
			@RequestParam(value = "nowPage", required = false, defaultValue = "1") int nowPage,
			ModelAndView mv) {
		
		NoticePageUtil pInfo = ieService.InfoErrorBoardPage(nowPage);
		ArrayList<InfoErrorBoardDTO> InfoErrorBoardList = ieService.InfoErrorBoardList(pInfo);
		
		mv.addObject("InfoErrorBoardList", InfoErrorBoardList);
		mv.addObject("PINFO", pInfo);
		
		mv.setViewName("InfoErrorBoard/list");
		
		return mv;
	}
	
	//게시물보기 & 댓글보기
	@GetMapping("/detail")
	public ModelAndView InfoErrorBoardDetail(
			@RequestParam(value="writeno") int writeno,
			@RequestParam(value="nowPage", defaultValue="1") int nowPage,
			@RequestParam(value="views") int views,
			@RequestParam(value = "nowPage2", required = false, defaultValue = "1") int nowPage2,
			ModelAndView mv) {
		
		ieService.hit(views,writeno);
		
		ArrayList<InfoErrorBoardDTO> InfoErrorBoardDetail = ieService.InfoErrorBoardDetail(writeno, nowPage);
		
		NoticePageUtil pInfo = ieService.ReplyPage(nowPage2, writeno);
		ArrayList<ReplyDTO> InfoErrorBoardReply = ieService.InfoErrorBoardReply(writeno, pInfo);
		
		mv.addObject("InfoErrorBoardDetail",InfoErrorBoardDetail);
		mv.addObject("InfoErrorBoardReply",InfoErrorBoardReply);
		mv.addObject("PINFO", pInfo);
		
		mv.setViewName("InfoErrorBoard/detail");
		
		return mv;
	}
	
	//댓글등록
	@PostMapping("/detail")
	public ModelAndView InfoErrorBoardReply(
			String id,
			String content,
			int wno,
			int nowPage,
			int views,
			ModelAndView mv) {
		
		ieService.replyAdd(id, content, wno);
		
		RedirectView rv = new RedirectView("./detail?writeno="+wno+"&nowPage="+nowPage+"&views="+views);
		mv.setView(rv);
		
		return mv;
	}
	
	//검색기능
	@GetMapping("/search")
	public ModelAndView InfoErrorBoardSearch(
			@RequestParam(value="searchType") String searchType,
			@RequestParam(value="keyword") String keyword,
			@RequestParam(value = "nowPage", required = false, defaultValue = "1") int nowPage,
			ModelAndView mv) {
		
		NoticePageUtil pInfo = ieService.SearchPage(searchType, keyword, nowPage);
		pInfo.setSearchType(searchType);
		pInfo.setKeyword(keyword);
		ArrayList<InfoErrorBoardDTO> InfoErrorBoardSearch = ieService.InfoErrorBoardSearch(searchType, keyword, pInfo);
		
		mv.addObject("InfoErrorBoardSearch", InfoErrorBoardSearch);
		mv.addObject("PINFO", pInfo);
		
		mv.setViewName("InfoErrorBoard/search");
		
		return mv;
	}
	
	//글쓰기-폼
	@GetMapping("write")
	public String InfoErrorBoardWriteForm() {
		return "InfoErrorBoard/write";
	}
	
	//글쓰기-처리
	@PostMapping("/write")
	public ModelAndView InfoErrorBoardWrite(
			String id,
			String title,
			String content,
			ModelAndView mv) {
		
		ieService.InfoErrorBoardWrite(id, title, content);
		
		RedirectView rv = new RedirectView("./list");
		mv.setView(rv);
		
		return mv;
	}
	
	//수정하기-폼
	@GetMapping("/update")
	public ModelAndView InfoErrorBoardUpdateForm(
			int writeno,
			ModelAndView mv) {
		
		ArrayList<InfoErrorBoardDTO> InfoErrorBoardUpdateForm = ieService.InfoErrorBoardUpdateForm(writeno);
		
		mv.addObject("InfoErrorBoardUpdateForm",InfoErrorBoardUpdateForm);
		
		mv.setViewName("InfoErrorBoard/update");
		
		return mv;
	}
	
	//수정하기-처리
	@PostMapping("/update")
	public ModelAndView InfoErrorBoardUpdate(
			int writeno,
			String title,
			String content,
			int nowPage,
			int views,
			ModelAndView mv) {
		
		ieService.InfoErrorBoardUpdate(writeno, title, content);
		
		RedirectView rv = new RedirectView("./detail?writeno="+writeno+"&nowPage="+nowPage+"&views="+views);
		mv.setView(rv);
		
		return mv;
	}
	
	//삭제하기
	@GetMapping("/delete")
	public ModelAndView InfoErrorBoardDelete(
			int writeno,
			int nowPage,
			ModelAndView mv) {
		
		ieService.InfoErrorBoardDelete(writeno);
		
		RedirectView rv = new RedirectView("./list?nowPage="+nowPage);
		mv.setView(rv);
		
		return mv;
	}
	
}
