package com.ggs.column;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

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
import com.ggs.DTO.MembersDTO;
import com.ggs.util.PageUtil;

@Controller
@RequestMapping("/column")
public class ColumnController {


	@Autowired
	ColumnService cService;
	
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
	
	/*	//파일다운로드 fno추가할것
		@RequestMapping("/fileDown")
		public ModelAndView fileDown(
				@RequestParam(value="fno") int fno
				) {
		//파라미터받기 글번호fno
		
		//비즈니스로직
		//해당 파일의 정보를 DB에서 가져와야 한다
		BoardDTO bDTO= cService.getFileDown(fno);
		
		//Model
		//View : 사용자정의 다운로드뷰
		컨트롤러에서 jsp가 아닌 컨트롤러를 호출해서 파일다운로드를 진행하고자 한다면
		 * 1. bean설정
		 * 2. AbstractView를 상속받는 클래스 제작
		 * 3. 컨트롤러 함수에서의 처리
		 * 
		 * new ModelAndView("사용자정의뷰명","모델키값",전달한데이터)
		 
		return mv;
	}*/
	
		/*//삭제하기
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
	}*/
	/*
		//수정처리
		@RequestMapping("/modifyProc.gg")
		public ModelAndView modifyProc(BoardDTO bDTO, ModelAndView mv, 
										RedirectView rv){
		System.out.println("글수정요청함수 modifyProc()진입");
		//1.파라미터받기  
		 bno=글번호	  nowPage=보고싶은페이지(릴레이용)
		 * title=제목      content=내용    pw=(삭제용)비번
		        첨부파일   
		System.out.println("cBoard 글번호= "+bDTO.getWriteno());
		System.out.println("cBoard nowPage= "+bDTO.getNowPage());
		System.out.println("cBoard 제목= "+bDTO.getTitle());
		
//			비즈니스로직수행
//			1. 첨부파일이 있는지 확인 -> 업로드 할지 말지
		boolean isUpload = false;  //첨부파일유무를 판단하기 위한 변수
//			-->첨부파일의 개수가 0이 아니면=> 있구나..

		//			dto에서 file배열 가져옴
//			파일추가를 눌러만 놓은 경우(이름이 없음) -> 첨부파일  처음부터 끝까지 반복해서 살펴봄
		for(int i=0;i<bDTO.getFiles().length;i++) {
//				파일이름이 있다면? 스트링을 준다
			String tempName = bDTO.getFiles()[i].getOriginalFilename();
			if(tempName!=null && tempName.length()!=0) {
				isUpload=true;
				break;
			}
		}
		//2.첨부파일에대한 정보 알아두기 + 파일복사
		//경로수정필요
		String path = "D:\\upload";
		
		//최대 다섯개까지의 첨부파일이 있으니 목록으로 묶는다
		ArrayList fileList = new ArrayList();
		if(isUpload==true) {

			for(int i = 0;i<bDTO.getFiles().length;i++) {	//파일이 여러 개이니 각각의 파일마다 반복
				//한개 씩 파일의 실제이름을 알아낸다
				String oriName = bDTO.getFiles()[i].getOriginalFilename();
				//파일이 업로드 되지 않으면 다음 작업을 시도한다
				if( oriName==null||oriName.length()==0 ) {
					continue;
				}
				String saveName = FileUtil.renameTo(path,oriName);	//path에 
				File file = new File(path, saveName);
				
				//파일복사: transferTo()
				try {
					bDTO.getFiles()[i].transferTo(file);
				}catch(Exception e) {
					System.out.println("파일복사관련에러="+e);
				}
				//--------------하나의 파일이 업로드된 상태-----------
				//업로드된 파일의 정보를 Map으로 묶는다
				HashMap map = new HashMap();
				map.put("path", path); 
				map.put("oriName", oriName);
				map.put("saveName",saveName );
				map.put("len",file.length() );
				fileList.add(map);
			}//for문 끝
		}//if문 끝
		
//			3.내용수정하고
		cService.modifyBoard(bDTO);

//			4.첨부파일이 있으면 등록
		if(isUpload==true) {
			BoardDTO bDTO1 = new BoardDTO();
//			 	4-1)과거에 업로드한 파일을 삭제
//				 		4-1-1)과거에 업로드한 파일의 정보를 DB에서 가져오기
			ArrayList<BoardDTO> list = 
					cService.getFileInfo(bDTO.getWriteno());
			if( list!=null && list.size()!=0) {
				for(int i=0;i<list.size();i++) {
					BoardDTO tempDTO = (BoardDTO)list.get(i);
//						4-1-2)해당 파일을 File객체로 만들어
					File tempFile = new File(path, tempDTO.getSaveName());
//				  		4-1-3)삭제
					tempFile.delete();
				}//for 끝
			}//if 끝
//				  4-2)DB에서 첨부파일정보 삭제
			cService.deleteFileInfo(bDTO.getWriteno());
//				  4-3)DB에    첨부파일정보 등록
			for(int i=0; i<fileList.size() ;i++) {
				HashMap tempMap=(HashMap)fileList.get(i);
				bDTO1.setWriteno(bDTO.getWriteno());
				bDTO1.setPath((String)tempMap.get("path"));
				bDTO1.setOriName((String)tempMap.get("oriName"));
				bDTO1.setSaveName((String)tempMap.get("saveName"));
				bDTO1.setLen((Long)tempMap.get("len"));
				
				cService.insertFileInfo(bDTO1);
			}//for문 끝

		}//if끝
		
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
		ArrayList<BoardDTO> list = cService.getFileInfo(writeno);
		
	//	3.모델
		mv.addObject("nowPage",nowPage);
		mv.addObject("BDTO",bDTO);
		mv.addObject("LIST",list); 
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
		public ModelAndView bcBoard(@RequestParam(value="nowPage",required=false,
									defaultValue="1") int nowPage,ModelAndView mv){
		System.out.println("야구지식목록보기요청-cBoard()진입");
			
		PageUtil pInfo = cService.getPageInfo(nowPage);
		ArrayList<BoardDTO> list = cService.getCBoard(pInfo);
		
		mv.addObject("LIST", list); 		//실제조회목록
		mv.addObject("PINFO",pInfo);		//페이징관련정보
		
		mv.setViewName("column/cBoard");
		
		return mv;
		}*/
		
		//글쓰기 처리
		@RequestMapping("/writeProc")
		public ModelAndView writeProc(BoardDTO bDTO,HttpSession session) {
		
		ModelAndView mv = new ModelAndView();
			
		System.out.println("columnController의 id= "+bDTO.getId()+"writeno= "+bDTO.getWriteno()+"title= "+bDTO.getTitle()+"content= "+bDTO.getContent());
		System.out.println("bDTO= 받았니 "+bDTO);
		
		//파일업로드경로수정예정
		String path = "D:\\upload";
		
		//최대 다섯개까지의 첨부파일이 있으니 목록으로 묶는다
		ArrayList list = new ArrayList();
//		
//		for(int i = 0;i<bDTO.getFiles().length;i++) {	//파일이 여러 개이니 각각의 파일마다 반복
//		//한개 씩 파일의 실제이름을 알아낸다
//		String oriName = bDTO.getFiles()[i].getOriginalFilename();
//		//파일이 업로드 되지 않으면 다음 작업을 시도한다
//		if( oriName==null||oriName.length()==0 ) {
//			continue;
//		}
//		String saveName = FileUtil.renameTo(path,oriName);	//path에 
//		File file = new File(path, saveName);
//		
//		//파일복사: transferTo()
//		try {
//			bDTO.getFiles()[i].transferTo(file);
//		}catch(Exception e) {
//			System.out.println("파일복사관련에러="+e);
//		}
//		//--------------하나의 파일이 업로드된 상태-----------
//		//업로드된 파일의 정보를 Map으로 묶는다
//		HashMap map = new HashMap();
//		map.put("path", path); 
//		map.put("oriName", oriName);
//		map.put("saveName",saveName );
//		map.put("len",file.length() );
//		list.add(map);
//	}//for문 끝
		System.out.println("컨트롤러 writeProc() for문끝에도착");
//		2.비즈니스로직 - Service - Dao - sql - db
		/*cService.insertBoard(bDTO,session,list);	//list로 묶어져있기 때문에 list로 넘김
	
//		3.Model
	
	//		4.View : 목록보기
		ModelAndView mv = new ModelAndView();
		RedirectView rv = new RedirectView("../column/cBoard.gg");
		mv.setView(rv);
		return mv;
		*/
		return mv;
		}
	
		//글쓰기 - 폼보기 
		@RequestMapping("/writeFrm")
		public void writeFrm() {
			System.out.println("글쓰기폼보기-writeFrm()진입");
		}
		
}