package com.ggs.teamrecord;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
		model.addAttribute("RankingList", service.getRankingList(id));

		model.addAttribute("ppoint", service.getpointList(ppoint));

		//오늘날짜와 대조하여 경기리스트 보여주기
		model.addAttribute("TodayMatch",service.getTodayMatchGno(gno));
		
		model.addAttribute("TodayMatch",service.getTodayMatch(ateamname,bteamname));

	return "teampredict/prematchMain";
}
	
	//---------------------------------------------------
	
	//경기일정 조회
	
	@RequestMapping("/schmatchList.gg")
	public String schmatchList(Model model,Date gdate,String gtime,String ateamname,String ascore,
			String bscore,String bteamname,String stadium) {
		System.out.println("경기일정 페이지 schmatchList() 진입");

		model.addAttribute("SchMatchList",service.getschmatchList());
		
		return "teampredict/schmatchList";	
		
	}
	
	//---------------------------------------------------
	
	//경기결과 조회
	
	@RequestMapping("/rltmatchList.gg")
	public String rltmatchList() {
		System.out.println("경기결과 메인페이지 rltmatchList() 진입");

		
	
		
		return "teampredict/rltmatchList";
		
	}
	
	
	//---------------------------------------------------
	
	//승부예측 상세페이지 출력
	@RequestMapping("/prematchDetail.gg")
	public String prematchdetail(HttpServletRequest request,ModelAndView mv) {
		System.out.println("경기예측 상세보기 요청함수 matchpredictdetail() 진입");
		
		//1.파라미터
		//해당날짜의 해당경기를 gno로 읽어오자
		int gno = Integer.parseInt(request.getParameter("gno")); //경기기록번호
		//2.비즈니스로직수행
		
		
		return "teampredict/prematchDetail";
	}
	
	//---------------------------------------------------
	
	
	//투표하기
/*	@RequestMapping("/electedMatch.gg")
	public void electmatch() {
		System.out.println("경기예측 메인페이지 matchpredict() 진입");*/

		//파라미터
		//
		
		//비즈니스
		//투표결과 반영하여 prematchdetail에 반영된 결과 보여주기
		

}
