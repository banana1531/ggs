package com.ggs.column;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import com.ggs.column.ColumnService;
import com.ggs.DAO.ColumnDAO;
import com.ggs.DTO.BoardDTO;
import com.ggs.DTO.ReplyDTO;
import com.ggs.util.ColumnPageUtil;




@Controller
@RequestMapping("/column")
public class ColumnController {


	@Autowired
	ColumnService cService;
		
	@Autowired
	ColumnDAO cDAO;
	
	
	@RequestMapping("/search")
	public ModelAndView cBoardSearch(
			@RequestParam(value="searchType") String searchType,
			@RequestParam(value="keyword") String keyword,
			@RequestParam(value = "nowPage", required = false, defaultValue = "1") int nowPage,
			ModelAndView mv) {
		
		ColumnPageUtil cPinfo = cService.searchPage(searchType, keyword, nowPage);
		cPinfo.setSearchType(searchType);
		cPinfo.setKeyword(keyword);
		ArrayList<BoardDTO> cBoardSearch = cService.cBoardSearch(searchType, keyword, cPinfo);
		
		mv.addObject("cBoardSearch", cBoardSearch);
		mv.addObject("CPINFO", cPinfo);
		
		mv.setViewName("column/search");
		
		return mv;
	}
	
	@RequestMapping("/delete")
	public ModelAndView cBoardDelete(
			int writeno,
			int nowPage,
			ModelAndView mv) {
		
		cService.cBoardDelete(writeno);
		
		RedirectView rv = new RedirectView("./list?nowPage="+nowPage);
		mv.setView(rv);
		
		return mv;
	}
	
	
	@GetMapping("/update")
	public ModelAndView cBoardUpdateFrm(
			int writeno,
			ModelAndView mv) {

		ArrayList<BoardDTO> cBoardUpdateFrm = cService.cBoardUpdateFrm(writeno);
		
		mv.addObject("cBoardUpdateFrm",cBoardUpdateFrm);
		
		mv.setViewName("column/update");
		
		return mv;
		
	}
	
	@PostMapping("/update")
	public ModelAndView cBoardUpdate(
			int writeno,
			String title,
			String content,
			int nowPage,
			int views,
			ModelAndView mv) {
		
		cService.cBoardUpdate(writeno, title, content);
		
		RedirectView rv = new RedirectView("./detail?writeno="+writeno+"&nowPage="+nowPage+"&views="+views);
		mv.setView(rv);
		
		return mv;
	}
	
	@RequestMapping("/detail")
	public ModelAndView cBoardDetail(
			@RequestParam(value="writeno") int writeno,
			@RequestParam(value="nowPage") int nowPage,
			@RequestParam(value="views") int views,
			@RequestParam(value = "nowPage2", required = false, defaultValue = "1") int nowPage2,
			ModelAndView mv) {
		
		cService.hit(views, writeno);
		ArrayList<BoardDTO> cBoardDetail = cService.cBoardDetail(writeno, nowPage);
		
		ColumnPageUtil cPinfo = cService.replyPage(nowPage2, writeno);
		ArrayList<ReplyDTO> cBoardReply = cService.cBoardReply(writeno, cPinfo);
		
		mv.addObject("cBoardDetail",cBoardDetail);
		mv.addObject("cBoardReply",cBoardReply);
		mv.addObject("CPINFO", cPinfo);
		
		mv.setViewName("column/detail");
		
		return mv;
		
	}
	
	@PostMapping("/detail")
	public ModelAndView cBoardReply(
			String id,
			String content,
			int wno,
			int nowPage,
			int views,
			ModelAndView mv) {
		System.out.println("column컨트롤러 replyAdd 갔니");
		cService.replyAdd(id, content, wno);
		
		RedirectView rv = new RedirectView("./detail?writeno="+wno+"&nowPage="+nowPage+"&views="+views);
		mv.setView(rv);
		
		return mv;
	}
	
	@GetMapping("/write")
	public String cBoardWriteFrm() {
		System.out.println("글쓰기 폼 cBoardWriteFrm()진입");
		return "column/write";
	}
	
	@PostMapping("/write")
	public ModelAndView cBoardWrite(
			String title,
			String content,
			HttpSession session,
			ModelAndView mv) {
		System.out.println("글쓰기cBoardWrite() id title content "+title+content);
		cService.cBoardWrite(title, content,session);
		
		RedirectView rv = new RedirectView("./list");
		mv.setView(rv);
		
		return mv;
	}
	
	@RequestMapping("/list")
	public ModelAndView cBoardList(
			@RequestParam(value = "nowPage", required = false, defaultValue = "1") int nowPage,
			ModelAndView mv) {
		
		ColumnPageUtil cPinfo = cService.cBoardPage(nowPage);
		ArrayList<BoardDTO> cBoardList = cService.cBoardList(cPinfo);
		
		mv.addObject("cBoardList", cBoardList);
		mv.addObject("CPINFO", cPinfo);
		
		mv.setViewName("column/list");
		
		return mv;
	}
	
	
	
	

		
}