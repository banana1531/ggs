package com.ggs.column;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import com.ggs.column.ColumnService;
import com.ggs.DTO.BoardDTO;
import com.ggs.util.ColumnPageUtil;

@Controller
@RequestMapping("/column")
public class ColumnController {


	@Autowired
	ColumnService cService;
		
		//검색2
		@RequestMapping("/cBoardSearch")
		public ModelAndView cBoardSearch(@RequestParam(value="searchType") String searchType,
										 @RequestParam(value="keyword") String keyword,
										 @RequestParam(value="nowPage", required = false, defaultValue="1") int nowPage,
										 ModelAndView mv){
			
			ColumnPageUtil cPinfo = ColumnService.SearchPage(searchType,keyword,nowPage);
			cPinfo.setSearchType(searchType);
			cPinfo.setKeyword(keyword);
			ArrayList<BoardDTO> boardSearch = ColumnService.boardSearch(searchType, keyword, cPinfo);

			mv.addObject("boardSearch", boardSearch);
			mv.addObject("CPINFO", cPinfo);

			mv.setViewName("column/search");
											
			
			return mv;
			
		}
		
	
	
//		//검색
//		@RequestMapping("/boardSearch")
//		public ModelAndView	boardSearch(ModelAndView mv, 
//										HttpServletRequest req) {
//		//파라미터받기
//		String	target = req.getParameter("target");
//		String	word = req.getParameter("word");
//		
//		String	strPage = req.getParameter("nowPage");
//		int		nowPage = 1;
//		if(strPage == null || strPage.length() == 0) {
//			nowPage = 1;
//		}
//		else {
//			nowPage = Integer.parseInt(strPage);
//		}
//		
//		//비즈니스로직
//		BoardDTO bDTO = new BoardDTO();
//		bDTO.setTarget(target);
//		bDTO.setWord(word);
//		PageUtil pInfo =cService.getSearchBoard(bDTO,nowPage);
//		
//		ArrayList	list = cService.searchBoard(pInfo, target, word);
//		//Model
//		mv.addObject("target", target);
//		mv.addObject("word", word);
//		mv.addObject("PINFO", pInfo);
//		mv.addObject("LIST", list);
//		
//		//View
//		mv.setViewName("/Column/boardSearch");
//		return mv;
//	}
	
		
	
		//삭제하기
		@RequestMapping("/delBoard")
		public ModelAndView delBoard(@RequestParam(value="writeno") int writeno,
										ModelAndView mv,BoardDTO bDTO){
		System.out.println("삭제요청함수 delBoard()진입");
		
		//1.파라미터받기    no=글번호	  pw=(삭제용)비번		
		//2.비즈니스로직수행
		bDTO.setWriteno(writeno);
		cService.delBoard(bDTO);
		//3.Model
		//4.View    목록보기
		RedirectView rv =
				new RedirectView("../column/cBoard.gg");
		mv.setView(rv);
		System.out.println("삭제요청함수 delBoard() 리턴 전");
		System.out.println("delBoard() 리턴전에 확인 "+" no:"+writeno);

		return mv;
	}
	
		//수정처리
		@RequestMapping("/modifyProc.gg")
		public ModelAndView modifyProc(BoardDTO bDTO, ModelAndView mv, 
										RedirectView rv){
		System.out.println("글수정요청함수 modifyProc()진입");
		//1.파라미터받기  
		/* bno=글번호	  nowPage=보고싶은페이지(릴레이용)
		 * title=제목      content=내용    pw=(삭제용)비번
		        첨부파일   */
		System.out.println("cBoard 글번호= "+bDTO.getWriteno());
		System.out.println("cBoard nowPage= "+bDTO.getNowPage());
		System.out.println("cBoard 제목= "+bDTO.getTitle());
		
		//3.내용수정하고
		cService.modifyBoard(bDTO);
	
		//3.Model & View
		rv.setUrl("../column/detailView.gg");
		rv.addStaticAttribute("nowPage", bDTO.getNowPage());
		rv.addStaticAttribute("writeno", bDTO.getWriteno());
		mv.setView(rv);
		return mv;
		}
	
		//수정폼보기
		@RequestMapping("/modifyFrm")
		public void modifyFrm(HttpServletRequest request){
		System.out.println("수정폼요청함수 modifyFrm()진입");
		
		//1.파라미터받기  bno=글번호	  nowPage=보고싶은페이지(릴레이용)
		int writeno  =  Integer.parseInt(request.getParameter("writeno"));//글번호
		int nowPage = Integer.parseInt(request.getParameter("nowPage"));//보고싶은페이지(릴레이용)
		System.out.println("수정폼요청함수의 글번호 writeno= "+writeno);
		//2.비즈니스로직수행
		BoardDTO bDTO = cService.detailView(writeno);
		 
		//3.Model
		request.setAttribute("BDTO", bDTO);//상세내용
		request.setAttribute("nowPage", nowPage);//보고싶은페이지(릴레이용)
		//4.View
		}
	
		//	2) 상세보기
		//	요청		: http://localhost:9000/myapp/fileBoard/   .mj
		@RequestMapping("/detailView")
		public ModelAndView detailView(HttpServletRequest request,ModelAndView mv) {
			System.out.println("column 컨트롤러에서 상세보기요청함수 detailView()진입");
	//	1.파라미터받기
	//	파라미터	: bno=글번호 nowPage=보고싶은페이지(릴레이용)
		int writeno=Integer.parseInt(request.getParameter("writeno"));
		int nowPage=Integer.parseInt(request.getParameter("nowPage")); //보고싶은페이지
		System.out.printf("컨트롤러에서 detailView 받은파라미터 writeno= "+writeno);
		System.out.printf("컨트롤러에서 detailView 받은파라미터 nowPage= "+nowPage);
	//	2.비즈니스로직
		BoardDTO bDTO = cService.detailView(writeno);
		
		
	//	3.모델
		mv.addObject("nowPage",nowPage);
		mv.addObject("BDTO",bDTO);
		
	//	4.뷰
		mv.setViewName("/column/detailView");
		return mv;
		}
	
		//조회수증가
		@RequestMapping("/viewsUpdate")
		public ModelAndView viewsUpdate(HttpServletRequest request, 
										HttpSession session,ModelAndView mv) {
		System.out.println("column컨트롤러에서 조회수증가요청함수 viewsUpdate()진입");
		
		//1.파라미터받기
		int writeno=Integer.parseInt(request.getParameter("writeno"));
		int nowPage=Integer.parseInt(request.getParameter("nowPage")); //보고싶은페이지
		
		cService.viewsUpdate(writeno,session);

		mv.addObject("nowPage",nowPage); 	//보고싶은페이지(릴레이용)
		mv.addObject("writeno",writeno); 	//보고싶은페이지(릴레이용)
//			4.View 리다이렉트용뷰	:	상세보기
		RedirectView rv = new RedirectView("../column/detailView.gg");
		mv.setView(rv);
		return mv;
//			파라미터	: bno=글번호 nowPage=보고싶은페이지(릴레이용)
		}
		
		//글목록보기 요청.
		@RequestMapping("/cBoard")
		public ModelAndView cBoard(@RequestParam(value="nowPage",required=false,
									defaultValue="1") int nowPage,ModelAndView mv){
		System.out.println("야구지식목록보기요청-cBoard()진입");
			
		ColumnPageUtil pInfo = cService.getPageInfo(nowPage);
		ArrayList<BoardDTO> list = cService.getCBoard(pInfo);
		
		mv.addObject("LIST", list); 		//실제조회목록
		mv.addObject("PINFO",pInfo);		//페이징관련정보
		
		mv.setViewName("column/cBoard");
		
		return mv;
		}
		
		//글쓰기 처리
		@RequestMapping("/writeProc")
		public ModelAndView writeProc(BoardDTO bDTO,HttpSession session) {
		
		System.out.println("글쓰기 bDTO= 받았니 "+bDTO);
		
//		2.비즈니스로직 - Service - Dao - sql - db
		cService.insertBoard(bDTO,session);	//list로 묶어져있기 때문에 list로 넘김
	
//		3.Model
	
	//		4.View : 목록보기
		ModelAndView mv = new ModelAndView();
		RedirectView rv = new RedirectView("../column/cBoard.gg");
		mv.setView(rv);
		return mv;
		}
		
		//글쓰기 - 폼보기 
		@RequestMapping("/writeFrm")
		public void writeFrm() {
			System.out.println("글쓰기폼보기-writeFrm()진입");

		}
		
}