package com.ggs.mypage;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ggs.DTO.MembersDTO;
import com.ggs.util.ConfirmMail;

@Controller
@RequestMapping("mypage")
public class MDController {
	
	@Autowired
	private MyPageService service;
	
	//마이페이지 메인가기
	@RequestMapping("/mypageMain.gg")
	public String mypagemain(HttpServletRequest request, Model model) {
		System.out.println("MDController.mypagemain() 진입");
		//파라미터
		//회원정보(id)
		HttpSession session = request.getSession();
		String id = "test";//(String)session.getAttribute("id");
		
		//비즈니스
		//내가쓴글가져오기
		model.addAttribute("mylist", service.getMyArticle(id));
		
		//내가 참여한 승부예측 가져오기
		model.addAttribute("myprelist", service.getMyPreList(id));
		
		//내팀 최근 경기 일정 가져오기
		model.addAttribute("teamSchedule",service.getMyteamSchedule(id));
		
		
		return "myPage/mainMypage";
	}
	
	
	
	//-------------------------------------------
	//마이팀 상세정보 보기
	@RequestMapping("/myTeamDetail.gg")
	public String myTeamDetail(Model model) {
		System.out.println("MDController.myTeamDetail() 진입");
		
		
		//파라미터
		//회원정보(id)
		
		//비즈니스
		//내팀 정보 가져오기  
		//비교팀 정보 가져오기 -> 현시간 기준 다음 경기 상대팀
		/*** 팀정보게시판 service 활용검토 ***/
		service.getMyTeamInfo();
		
		return "myPage/myTeamDetail";
	}
	
	//상대팀 자료 가져오기 --> ajax로 구현
	@RequestMapping("/vsTeamDetail.gg")
	public void vsTeamDetail() {
		
		//파라미터
		//팀정보(이름)
		
		//비즈니스
		//비교 자료 가져오기
		
	}
	
	
	//-------------------------------------------
	//마이팀 경기일정 보기
	@RequestMapping("/myTeamSchedule.gg")
	public String myTeamSchedule() {
		
		//파라미터
		//팀정보(이름)
		String team = "sk";
		//날짜계산을 위한 Calander 생성
		Calendar cal = Calendar.getInstance();
		
		//비즈니스
		//당월 경기일정 가져오기
		//팀 이름과 월정보를 주면 해당 자료를 기준으로 경기일정을 가져온다.
		service.getMonthlySchedule(team, cal.get(Calendar.MONTH));
		
		return "myPage/myTeamSchedule";
	}
	
	//마이팀 월단위 경기일정 가져오기 --> ajax로 구현
	@RequestMapping("/myTeamMonthlySchedule.gg")
	public void myTeamMonthlySchedule() {
		
		//파라미터
		//팀정보(이름)/ 선택된 기간(월)정보
		
		
		//비즈니스
		//당월 경기일정 가져오기
	}
	
	//-------------------------------------------
	//내정보 수정 보여주기
	@RequestMapping("/myInfoModifyForm.gg")
	public String myInfoModifyForm(Model model) {
		
		//파라미터
		//회원정보(id)
		String id ="test";
		//비즈니스
		//내 정보 가져오기
		model.addAttribute("myinfo", service.getMyInfo(id));
		
		return "myPage/myInfoModify";
	}
	
	//내정보 수정하기 
	@PostMapping("/myInfoModify.gg")
	public String myInfoModify(Model model, MembersDTO member) {
		if(service.updateMyInfo(member)>0)
			model.addAttribute("result", "정보가 수정되었습니다.");
		else model.addAttribute("result", "정보을 실패하였습니다.");
		
		//모델 지정
		model.addAttribute("myinfo", service.getMyInfo(member.getId()));
		
		return "/myPage/myInfoModify";
	}
	
	//비밀번호 확인 폼 보여주기
	@GetMapping("/checkPw.gg")
	public String checkPw() {
		return "myPage/checkPw";
	}
	
	//비밀번호 확인
	@PostMapping("/checkPw.gg")
	public String checkPw(Model model, String newPw) {
		System.out.println("checkPw()-post.newPw:"+newPw);
		String id = "test";
		if(service.checkPw(id, newPw)) {
			return "redirect:/mypage/myInfoModifyForm.gg";
		}
		else {
			model.addAttribute("notmatch", "비밀번호가 일치하지 않습니다.");
			return "myPage/checkPw";
			}
	}
	
	
	
	//비밀번호 변경폼 보여주기
	@RequestMapping("/updatePwForm.gg")
	public String updatePwForm() {
		return "myPage/updatePw";
	}
	
	//비밀번호 변경하기 
	@RequestMapping("/updatePw.gg")
	public String updatePw(String newPw) {
		//파라미터
		String id="test";
		service.updatePw(id, newPw);
		return "myPage/updatePwSuccess";
	}


	//-------------------------------------------
	//회원탈퇴 폼 보여주기
	@RequestMapping("/leaveForm.gg")
	public String leaveForm() {
		
		//파라미터
		//회원정보(id)
		
		return "myPage/leave";
	}
	
		
	//인증번호 보내기  --> ajax로 구현
	@RequestMapping("/sendNum.gg")
	public void sendNum(Model model) {
		ConfirmMail mail = new ConfirmMail();
		model.addAttribute("num", mail.sendMail("desertfish@naver.com"));
	}
	
	
	//회원탈퇴 하기
	@RequestMapping("/leave.gg")
	public String leave() {
		
		//파라미터
		//회원정보(id), 인증번호
		
		//비즈니스
		//인증번호 일치유무 확인
		
		return "myPage/leaveSuccess";
	}
	
}
