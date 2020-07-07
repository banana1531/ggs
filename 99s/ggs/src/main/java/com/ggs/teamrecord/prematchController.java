package com.ggs.teamrecord;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ggs.DTO.TeampredictDTO;
import com.ggs.DTO.MembersDTO;

@Controller
@RequestMapping("matchpredict")
public class prematchController {

	
	//승부예측 메인페이지 가기
	@RequestMapping("/prematchMain.gg")
	public String matchpredict() {
		System.out.println("경기예측 메인페이지 matchpredict() 진입");
	
		
		//파라미터
		//회원정보(=id)
		//보유포인트 현황(=point)
		//오늘 날짜
	
		//비즈니스
		//회원정보테이블에서 아이디와 보유포인트 가져오기
		//오늘날짜와 대조하여 경기리스트 보여주기
	
	return "prematch/prematchMain";
}
	
	//---------------------------------------------------
	
	//경기일정 조회
	
	@RequestMapping("/schmatch.gg")
	public void schmatch() {
		
		System.out.println("경기일정 조회 schmatch() 진입성공");
		
	}
	
	
	//경기결과 조회
	
	@RequestMapping("/rltmatch.gg")
	public void rltmatch() {
	
		System.out.println("경기결과 조회 rltmatch() 진입성공");
		
	}
	
	
	//---------------------------------------------------
	
	//승부예측 상세페이지 가기
	@RequestMapping("/prematchdetail.gg")
	public String prematchdetail() {
		System.out.println("경기예측 상세페이지 matchpredictdetail() 진입");
		
		//파라미터

		//오늘 날짜=todayDate
		//경기일자=eventDate
		//팀이름=teamName

	
		//비즈니스
		//당일 경기일정 가져오기
		
		return "prematch/prematchdetail";
	}
	
	//---------------------------------------------------
	
	
	//투표하기
	@RequestMapping("/electedmatch.gg")
	public void electedmatch() {
		
		//파라미터
		//
		
		//비즈니스
		//투표결과 반영하여 prematchdetail에 반영된 결과 보여주기
	}
}
