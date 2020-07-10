package com.ggs.notice;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ggs.utill.PageUtil;

@Controller
@RequestMapping("/NoticeBoard")
public class NoticeBoardController {

	@Autowired
	private NoticeBoardDAO nbDAO;

	@Autowired
	private NoticeBoardService nservice;

	@RequestMapping("/listView")
	public ModelAndView listView(@RequestParam(value = "nowPage", required = false, defaultValue = "1") int nowPage,
			ModelAndView mv) {
		System.out.println("목록보기요청-listView()진입");

		// 1.파라미터받기 nowPage=
		// 2.비즈니스로직 <->Service<->DAO<->SQL.xml->DB
		// 2-1) 페이징관련 정보준비
		System.out.println("nowPage=" + nowPage);
		PageUtil pInfo = nservice.getPageInfo(nowPage);

		// 2-2) 해당 페이지에 출력할 목록조회
		
		ArrayList<NoticeBoardDTO> list = nservice.getListView(pInfo);

		// 3.Model
		mv.addObject("LIST", list);// 실제조회목록
		mv.addObject("PINFO", pInfo);// 페이징관련 정보

		// 4.View
		mv.setViewName("NoticeBoard/listView");

		return mv;
	}

	// 해당 페이지에 출력할 목록조회
	public ArrayList<NoticeBoardDTO> getListView(PageUtil pInfo) {
		// where rno between #{start} and #{end}에 해당하는 부분이
		// FileBoardDTO에 세팅이 되어야 한다

		// lineCount; // 한페이지당 보여주고 싶은 게시물의 개수로 우리는 3설정
		// 보고싶은페이지 start end
		// 1 1 3
		// 2 4 6

		int start = (pInfo.getNowPage() - 1) * pInfo.getLineCount() + 1;
		int end = start + pInfo.getLineCount() - 1;

		NoticeBoardDTO nbDTO = new NoticeBoardDTO();
		//--------------------------------------------------------------------------------------------------------------
		PageUtil pg = new PageUtil(start, end);
		pg.setStartPage(start);
		pg.setEndPage(end);

		ArrayList<NoticeBoardDTO> list = nbDAO.getListView(nbDTO);
		return list;
	}

}
