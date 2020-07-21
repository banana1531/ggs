package com.ggs.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.ggs.DAO.NoticeDAO;
import com.ggs.DTO.BoardDTO;
import com.ggs.notice.NoticeService;
import com.ggs.util.PageUtil;

@Controller
@RequestMapping("/board")
public class boardController {

	@Autowired
	private BoardService boardService;
	
	//목록보기 + 검색하기
	@RequestMapping("/list")
	public String boardList(Model model,String boardname,
			@RequestParam(value = "pageNo", required = false, defaultValue = "1") int pageNo,
			@RequestParam(value="option", defaultValue="0") String option,
			@RequestParam(value="search", defaultValue="0") String search) {
		System.out.println("boardController.boardList");
		System.out.println("pageNo="+pageNo);
		System.out.println("boardname="+boardname);
		
		List list = boardService.boardList(pageNo, boardname);
		int totalcnt = ((BoardDTO)list.get(0)).getTotalcnt();
		PageUtil pageInfo = new PageUtil(pageNo, totalcnt, 10, 10);
		model.addAttribute("list", list);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("option", option);
		model.addAttribute("search", search);
		model.addAttribute("boardname", boardname);
		return "/board/boardList";
	}
	
	//상세내용보기
	@RequestMapping("/detail")
	public String boardDetail(BoardDTO boardDTO, int pageNo, Model model, 
			@RequestParam(value="hit", defaultValue="1") String hit) {
		//dto를 기준으로 글 상세 내용 가져오고 글 조회수 1증가시기자
		model.addAttribute("dto", boardService.boardDetail(boardDTO, hit));
		return "board/boardDetail";
	}
	
	
	//글쓰기 폼 보여주기
	@GetMapping("/write")
	public String boardWriteForm(Model model, String boardname) {
		//게시판 이름을 가지고 들어오자
		model.addAttribute("boardname", boardname);
		return "board/writeForm";
	}
	
	//글 등록하기
	@PostMapping("/write")
	public String boardWrite(BoardDTO boardDTO) {
		boardService.boardWrite(boardDTO);
		String boardname = boardDTO.getBoardname();
		return "redirect:/board/list?boardname="+boardname;
	}
	
	
	//글 수정 폼 보여주기
	@GetMapping("/update")
	public String boardUpdateForm(BoardDTO boardDTO, Model model,
			@RequestParam(value="hit", defaultValue="0") String hit) {
		model.addAttribute("dto", boardService.boardDetail(boardDTO, hit));
		return "board/boardUpdate";
		
	}
	
	//글 수정하기
	@PostMapping("/update")
	public String boardUpdate(BoardDTO boardDTO, Model model) {
		if(boardService.boardUpdate(boardDTO)>0) model.addAttribute("result", "글이 정상적으로 수정되었습니다.");
		else model.addAttribute("result", "글 수정에 실패하였습니다.");
		model.addAttribute("dto", boardService.boardDetail(boardDTO, "0"));
		return "board/boardDetail";
	}
	
	
	//글 삭제하기
	@RequestMapping("/delete")
	public String boardDelete(BoardDTO boardDTO) {		
		if(boardService.boardDelete(boardDTO)>0);
		String boardname = boardDTO.getBoardname();
		return "redirect:/board/list?boardname="+boardname;
	}
	
}
