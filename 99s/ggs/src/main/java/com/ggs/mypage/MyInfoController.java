package com.ggs.mypage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.metal.MetalMenuBarUI;

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
	public String myInfoModifyForm(Model model, HttpServletRequest request) {

		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("UID");
		// 비즈니스
		// 내 정보 가져오기
		model.addAttribute("myinfo", myPageService.getMyInfo(id));

		return "myPage/myInfoModify";
	}

	// 내정보 수정하기
	@PostMapping("/myInfoModify.gg")
	public String myInfoModify(Model model, MembersDTO member, HttpServletRequest request) {
		if (myInfoService.updateMyInfo(member) > 0) {
			model.addAttribute("result", "정보가 수정되었습니다.");}
		else {
			model.addAttribute("result", "정보을 실패하였습니다.");}
		
		MembersDTO dto = myPageService.getMyInfo(member.getId());
		HttpSession session = request.getSession();
		session.setAttribute("UTEAM", dto.getTeam());		

		model.addAttribute("myinfo", dto);

		return "/myPage/myInfoModify";
	}

	// 비밀번호 확인 폼 보여주기
	@GetMapping("/checkPw.gg")
	public String checkPw() {
		return "myPage/checkPw";
	}

	// 비밀번호 확인
	@PostMapping("/checkPw.gg")
	public String checkPw(Model model, String newPw, HttpServletRequest request) {
		System.out.println("checkPw()-post.newPw:" + newPw);
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("UID");
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
	public String updatePw(Model model, String newPw, HttpServletRequest request) {
		// 파라미터
		HttpSession session = request.getSession();
		
		String id = (String)session.getAttribute("UID");
		System.out.println("id="+id);
		if(myInfoService.updatePw(id, newPw)>0) {
			model.addAttribute("result", "비밀번호가 정상적으로 변경되었습니다. 다시 로그인 해주시기 바랍니다.");
			return "member/loginFrm";
		}else {
			model.addAttribute("result", "비밀번호 변경에 실패하였습니다. 다시 시도 해주시기 바랍니다.");
			return "myPage/updatePw";
		}
	}

	// -------------------------------------------
	// 회원탈퇴 폼 보여주기
	@RequestMapping("/leaveForm.gg")
	public String leaveForm() {

		// 파라미터
		// 회원정보(id)

		return "myPage/leave";
	}

	// 인증번호 보내기
	@RequestMapping("/sendNum.gg")
	public String sendNum(Model model) {
		ConfirmMail mail = new ConfirmMail();
		model.addAttribute("num", mail.sendMail("desertfish@naver.com"));
		return "myPage/leave";
	}

	// 회원탈퇴 하기
	@RequestMapping("/leave.gg")
	public String leave(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String id=(String)session.getAttribute("UID");
		
		if(myPageService.leave(id)>0){
			model.addAttribute("result", "정상적으로 탈퇴되었습니다.");
			return "member/loginFrm";
		}else{
			model.addAttribute("result", "회원 탈퇴를 실패하였습니다. 다시 시도 해주시기 바랍니다.");
			return "myPage/leave";
		}
	}
}
