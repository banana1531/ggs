package com.ggs.Reply;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ggs.DTO.ReplyDTO;

@RestController
@RequestMapping("/reply")
public class ReplyController {

	@Inject
	ReplyService replyService;
	
	//자유게시판 //댓글입력
	@RequestMapping("/insert")
	public void insert(@ModelAttribute ReplyDTO rDTO, HttpSession session) {
		String id = (String)session.getAttribute("UID");
		rDTO.setId(id);
		replyService.create(rDTO);
	}
	
	// 댓글 목록
	@RequestMapping("/list")
	public ModelAndView list(@RequestParam int wno, ModelAndView mv) {
		System.out.println(wno);
		List<ReplyDTO> list = replyService.list(wno);
		mv.setViewName("newboard/replyList");
		mv.addObject("list",list);
		return mv;
	}
	
	// 댓글 목록(@RestController Json방식으로 처리 : 데이터를 리턴)
	//자유게시판 //댓글조회
	@RequestMapping("/listJson")
	@ResponseBody
	public List<ReplyDTO> listJson(@RequestParam int wno){
		List<ReplyDTO> list = replyService.list(wno);
		return list;
	}
	
	//정보오류신고 //댓글조회
	@RequestMapping("/listJson2")
	@ResponseBody
	public List<ReplyDTO> listJson2(@RequestParam int wno){
		List<ReplyDTO> list = replyService.list2(wno);
		return list;
	}
	
	//정보오류신고 //댓글입력
	@RequestMapping("/insert2")
	public void insert2(@ModelAttribute ReplyDTO rDTO, HttpSession session) {
		String id = (String)session.getAttribute("UID");
		rDTO.setId(id);
		replyService.create2(rDTO);
	}
	
	//공지사항 //댓글조회
	@RequestMapping("/listJson3")
	@ResponseBody
	public List<ReplyDTO> listJson3(@RequestParam int wno){
		List<ReplyDTO> list = replyService.list3(wno);
		return list;
	}
	
	//공지사항 //댓글입력
	@RequestMapping("/insert3")
	public void insert3(@ModelAttribute ReplyDTO rDTO, HttpSession session) {
		String id = (String)session.getAttribute("UID");
		rDTO.setId(id);
		replyService.create3(rDTO);
	}
	
}
