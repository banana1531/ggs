package com.ggs.mypage;

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
public class MyInfoController {

	@Autowired
	private MyInfoService myInfoService;
	
	@Autowired
	private MyPageService myPageService;
	
	//-------------------------------------------
	// 내정보 수정 보여주기
	@RequestMapping("/myInfoModifyForm.gg")
	public String myInfoModifyForm(Model model) {

		// 파라미터
		// 회원정보(id)
		String id = "test";
		// 비즈니스
		// 내 정보 가져오기
		model.addAttribute("myinfo", myPageService.getMyInfo(id));

		return "myPage/myInfoModify";
	}

	// 내정보 수정하기
	@PostMapping("/myInfoModify.gg")
	public String myInfoModify(Model model, MembersDTO member) {
		if (myInfoService.updateMyInfo(member) > 0) {
			model.addAttribute("result", "정보가 수정되었습니다.");}
		else {
			model.addAttribute("result", "정보을 실패하였습니다.");}
		
		// 모델 지정
		model.addAttribute("myinfo", myPageService.getMyInfo(member.getId()));

		return "/myPage/myInfoModify";
	}

	// 비밀번호 확인 폼 보여주기
	@GetMapping("/checkPw.gg")
	public String checkPw() {
		return "myPage/checkPw";
	}

	// 비밀번호 확인
	@PostMapping("/checkPw.gg")
	public String checkPw(Model model, String newPw) {
		System.out.println("checkPw()-post.newPw:" + newPw);
		String id = "test";
		if (myInfoService.checkPw(id, newPw)) {
			return "redirect:/mypage/myInfoModifyForm.gg";
		} else {
			model.addAttribute("notmatch", "비밀번호가 일치하지 않습니다.");
			return "myPage/checkPw";
		}
	}

	// 비밀번호 변경폼 보여주기
	@RequestMapping("/updatePwForm.gg")
	public String updatePwForm() {
		return "myPage/updatePw";
	}

	// 비밀번호 변경하기
	@RequestMapping("/updatePw.gg")
	public String updatePw(String newPw) {
		// 파라미터
		String id = "test";
		myInfoService.updatePw(id, newPw);
		return "myPage/updatePwSuccess";
	}

	// -------------------------------------------
	// 회원탈퇴 폼 보여주기
	@RequestMapping("/leaveForm.gg")
	public String leaveForm() {

		// 파라미터
		// 회원정보(id)

		return "myPage/leave";
	}

	// 인증번호 보내기 --> ajax로 구현
	@RequestMapping("/sendNum.gg")
	public String sendNum(Model model) {
		ConfirmMail mail = new ConfirmMail();
		model.addAttribute("num", mail.sendMail("desertfish@naver.com"));
		return "myPage/leave";
	}

	// 회원탈퇴 하기
	@RequestMapping("/leave.gg")
	public String leave() {

		// 파라미터
		// 회원정보(id), 인증번호

		// 비즈니스
		// 인증번호 일치유무 확인

		return "myPage/leaveSuccess";
	}
}
