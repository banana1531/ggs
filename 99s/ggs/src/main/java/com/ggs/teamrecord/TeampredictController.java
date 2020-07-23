package com.ggs.teamrecord;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.ggs.DTO.PreResultDTO;
import com.ggs.DTO.ReplyDTO;
import com.ggs.DTO.TeamInfoDTO;
import com.ggs.DTO.TeamRecordDTO;
import com.ggs.util.NoticePageUtil;

@Controller
@RequestMapping("/teampredict")
public class TeampredictController {

	@Autowired
	private TeampredictService service;
	

	//---------------------------------------------------
	
	
	//승부예측 메인페이지 가기
	@RequestMapping("/prematchMain.gg")
	public String matchpredict(Model model,Integer gno,String id, Integer ppoint,String ateamname, String bteamname) {
		System.out.println("경기예측 메인페이지 matchpredict() 진입");
		
		//비즈니스
		//회원정보테이블에서 아이디와 보유포인트 가져오기
		model.addAttribute("RankingList", service.getRankingList());

		//오늘날짜와 대조하여 경기리스트 보여주기
		model.addAttribute("TodayMatch",service.getTodayMatchGno(gno));
		
		model.addAttribute("TodayMatch",service.getTodayMatch(ateamname,bteamname));

		
	return "teampredict/prematchMain";
}
	
	//---------------------------------------------------
	
	//경기일정 조회
	
	@RequestMapping("/schmatchList.gg")
	public String schmatchList(Model mv,Date gdate,String gtime,String ateamname,String ascore,
			String bscore,String bteamname,String stadium) {
		System.out.println("경기일정 페이지 schmatchList() 진입");

		mv.addAttribute("SchMatchList",service.getschmatchList());
		
		return "teampredict/schmatchList";	
		
	}
	
	//경기일정 세부 조회
	@RequestMapping("/schmatchDetail.gg")
	public String schmatchDetail(HttpServletRequest request,Model mv) {
		System.out.println("경기일정 상세보기 페이지 진입");
	
		//해당날짜의 해당경기를 gno로 읽어오자
		int gno = Integer.parseInt(request.getParameter("gno")); //경기기록번호
		System.out.println("해당 날짜 해당 경기의 gno="+gno);

		//해당 경기의 팀 이름을 가져오기
		String ateamname =request.getParameter("ateamname");
		String bteamname =request.getParameter("bteamname");

		//2.비즈니스로직수행
		List<TeamRecordDTO> gsmdDTO = service.getschmatchDetail(gno, ateamname, bteamname);
		TeamRecordDTO trDTO = service.getdetailView(gno);
		TeamInfoDTO atrDTO = service.AgetpreTeamScore(ateamname);
		TeamInfoDTO btrDTO = service.BgetpreTeamScore(bteamname);

		//팀실적 가져오기

		//3.Model
		mv.addAttribute("SchMatchDetail",service.getschmatchDetail(gno, ateamname, bteamname));
		mv.addAttribute("TRDTO",trDTO);
		mv.addAttribute("atrDTO",service.AgetpreTeamScore(ateamname));
		mv.addAttribute("btrDTO",service.BgetpreTeamScore(bteamname));
	
	return "teampredict/schmatchDetail";
	}
	//---------------------------------------------------
	
	//경기결과 조회
	
	@RequestMapping("/rltmatchList.gg")
	public String rltmatchList(Model model) {
		System.out.println("경기결과 메인페이지 rltmatchList() 진입");

	model.addAttribute("RltMatchList",service.getrltmatchList());
	
	return "teampredict/rltmatchList";	
		
	}
	
	
	//경기결과 세부 조회
	@RequestMapping("/rltmatchDetail.gg")
	public String rltmatchDetail(PreResultDTO dto,HttpServletRequest request,Model mv) {
		System.out.println("경기결과 상세보기 페이지 진입");
		HttpSession session = request.getSession();
		//해당날짜의 해당경기를 gno로 읽어오자
		int gno = Integer.parseInt(request.getParameter("gno")); //경기기록번호
		System.out.println("해당 날짜 해당 경기의 gno="+gno);
	    String Id = (String)session.getAttribute("UID"); //아이디
	    System.out.println("id="+Id);

		//해당 경기의 팀 이름을 가져오기
		String ateamname =request.getParameter("ateamname");
		String bteamname =request.getParameter("bteamname");

		//2.비즈니스로직수행
		List<TeamRecordDTO> gsmdDTO = service.getschmatchDetail(gno, ateamname, bteamname);
		TeamRecordDTO trDTO = service.getdetailView(gno);
		String prDTO = service.getpreteamCount(dto); //,ino,id,ppoint 넣을것
		TeamInfoDTO atrDTO = service.AgetpreTeamScore(ateamname);
		TeamInfoDTO btrDTO = service.BgetpreTeamScore(bteamname);

		//팀실적 가져오기

		//3.Model
		mv.addAttribute("SchMatchDetail",service.getschmatchDetail(gno, ateamname, bteamname));
		
		mv.addAttribute("TRDTO",trDTO);
		mv.addAttribute("preCount",prDTO);
		mv.addAttribute("atrDTO",service.AgetpreTeamScore(ateamname));
		mv.addAttribute("btrDTO",service.BgetpreTeamScore(bteamname));
		
		return "teampredict/rltmatchDetail";
	}
	
	//댓글보기
	
//-------------------------------------------------


//	   public ModelAndView InfoErrorBoardDetail(
//		         @RequestParam(value="writeno") int writeno,
//		         @RequestParam(value="nowPage") int nowPage,
//		         @RequestParam(value="views") int views,
//		         @RequestParam(value = "nowPage2", required = false, defaultValue = "1") int nowPage2,
//		         ModelAndView mv) {
//		      
////		      service.hit(views,writeno);
//
//		      NoticePageUtil pInfo = service.ReplyPage(nowPage2, writeno);
//		      ArrayList<ReplyDTO> InfoErrorBoardReply = service.InfoErrorBoardReply(writeno, pInfo);
//		      
////		      mv.addObject("InfoErrorBoardDetail",InfoErrorBoardDetail);
//		      mv.addObject("InfoErrorBoardReply",InfoErrorBoardReply);
//		      mv.addObject("PINFO", pInfo);
//		      
//		      mv.setViewName("teampredict/rltmatchDetail");
//		      
//		      return mv;
//		   }
//
//	
//	   //댓글등록
//	   @PostMapping("/detail")
//	   public ModelAndView InfoErrorBoardReply(
//	         String id,
//	         String content,
//	         int wno,
//	         int nowPage,
//	         int views,
//	         ModelAndView mv) {
//	      
//		   service.replyAdd(id, content, wno);
//	      
//	      RedirectView rv = new RedirectView("./detail?writeno="+wno+"&nowPage="+nowPage+"&views="+views);
//	      mv.setView(rv);
//	      
//	      return mv;
//	   }

	
	//---------------------------------------------------
	
	//승부예측 상세페이지 출력
	@RequestMapping("/prematchDetail.gg")
	public String prematchdetail(PreResultDTO dto,HttpServletRequest request,Model mv) {
		System.out.println("경기예측 상세보기 요청함수 matchpredictdetail() 진입");
		
		
		//해당날짜의 해당경기를 gno로 읽어오자
		int gno = Integer.parseInt(request.getParameter("gno")); //경기기록번호
		String predict = request.getParameter("predict");	//투표결과 (홈팀 승리:1 무승부:2 어웨이팀 승리:3)
		System.out.println("해당 날짜 해당 경기의 gno="+gno);
		
		//해당 경기의 팀 이름을 가져오기
		String ateamname =request.getParameter("ateamname");
		String bteamname =request.getParameter("bteamname");

		//2.비즈니스로직수행
		TeamRecordDTO trDTO = service.getdetailView(gno);
		String prDTO = service.getpreteamCount(dto); //,ino,id,ppoint 넣을것
		TeamInfoDTO atrDTO = service.AgetpreTeamScore(ateamname);
		TeamInfoDTO btrDTO = service.BgetpreTeamScore(bteamname);

		//팀실적 가져오기
		System.out.println(prDTO);
		//3.Model
		mv.addAttribute("TRDTO",trDTO);
		mv.addAttribute("preCount",prDTO);
		mv.addAttribute("atrDTO",service.AgetpreTeamScore(ateamname));
		mv.addAttribute("btrDTO",service.BgetpreTeamScore(bteamname));

		return "/teampredict/prematchDetail";
	}
	
	//---------------------------------------------------
	//투표 처리
	@RequestMapping("/electmatch.gg")
	public String electmatch(HttpServletRequest request, Model mv) {
		System.out.println("electedMatch() 진입");
			HttpSession session = request.getSession();
		//1.파라미터
		int gno = Integer.parseInt(request.getParameter("gno")); 	//경기기록번호
//		int INo = Integer.parseInt(request.getParameter("INo")); //회원기록번호
		   String Id = (String)session.getAttribute("UID"); //아이디
		   System.out.println("id="+Id);
//		int gno = Integer.parseInt(request.getParameter("gno")); //경기기록번호
		String predict = request.getParameter("predict");	//투표결과 
		String ateamname =request.getParameter("ateamname");
		String bteamname =request.getParameter("bteamname");

		int r = service.insertRe(Id,gno,predict);
		System.out.println("r="+r);
		
		System.out.println("gno="+gno);
		System.out.println("predict="+predict);

//		System.out.println("해당 날짜 해당 경기의 gno="+gno);
		
//		TeamRecordDTO trDTO = service.getdetailView(gno);
		
//		mv.addAttribute("eTRDTO",trDTO);
		TeamRecordDTO trDTO = service.getdetailView(gno);
		String emDTO = service.getelectmatchCount(gno); //,ino,id,ppoint 넣을것
		TeamInfoDTO atrDTO = service.AgetpreTeamScore(ateamname);
		TeamInfoDTO btrDTO = service.BgetpreTeamScore(bteamname);

		
		mv.addAttribute("TRDTO",trDTO);
		mv.addAttribute("preCount",emDTO);
		mv.addAttribute("atrDTO",service.AgetpreTeamScore(ateamname));
		mv.addAttribute("btrDTO",service.BgetpreTeamScore(bteamname));
		
		return "/teampredict/electmatch";
			
	}
}