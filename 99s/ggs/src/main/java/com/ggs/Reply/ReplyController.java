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
	
	// 댓글 입력
	@RequestMapping("/insert")
	public void insert(@ModelAttribute ReplyDTO rDTO, HttpSession session) {
		String id = (String)session.getAttribute("UID");
		rDTO.setId(id);
		System.out.println(rDTO.getId());
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
	@RequestMapping("/listJson")
	@ResponseBody
	public List<ReplyDTO> listJson(@RequestParam int wno){
		List<ReplyDTO> list = replyService.list(wno);
		return list;
	}
	
}
