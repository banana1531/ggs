package com.ggs.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.ggs.DTO.MembersDTO;
import com.ggs.member.Memberservice;
import com.ggs.util.ConfirmMail;

@Controller
@RequestMapping("/member")
public class LoginController {

	@Autowired
	Memberservice mService;

	// 로그인 폼 보여주기
	@RequestMapping("/loginFrm.gg")
	public String loginFrm() {
		System.out.println("요청 함수 loginFrm()!");
		return "member/loginFrm";
	}

	// 로그인 처리
	@RequestMapping("loginProc.gg")
	public ModelAndView loginProc(MembersDTO mdto, HttpSession session, ModelAndView mv) {
		System.out.println("요청 함수 loginloginProc()!");
		// 1.파라미터 받기
		String id = mdto.getId();
		String pw = mdto.getPw();
		System.out.println("요청 함수 loginloginProc()id/pw= " + id + "/" + pw);

		// 2.비즈니스로직 -> Service ->DAO ->DB
		MembersDTO result = mService.loginProc(mdto, session);
		if (result == null) {
			// 로그인 실패
			mv.setViewName("member/loginFrm");
			mv.addObject("msg", "fail");
		} else if (result.getLogin() != 1) {
			// 로그인 권한이 없을 경우
			mv.setViewName("member/loginFrm");
			mv.addObject("msg", "log");
		} else {
			// 로그인 성공
			RedirectView rv = new RedirectView("../"); // main으로 이동하기로 변경예정
			mv.setView(rv);
		}
		return mv;
	}

	// 로그아웃 처리
	@RequestMapping("logout.gg")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("요청 함수 logout()!");
		// 1.파라미터 받기
		HttpSession session = request.getSession();
		if (session != null) {
			session.invalidate();
		}
		// 4. View
		ModelAndView mv = new ModelAndView();
		RedirectView rv = new RedirectView("../"); // main으로 이동하기로 변경예정
		mv.setView(rv);
		return mv;
	}

	// 아이디 찾기 폼 보여주기
	@RequestMapping("/idFindFrm.gg")
	public String idFindFrm() {
		System.out.println("요청 함수 idFindFrm()!");
		return "member/idFindFrm";
	}

	// 아이디 찾기 처리
	@RequestMapping("/idFindProc.gg")
	public ModelAndView idFindProc(MembersDTO mdto, ModelAndView mv) {
		System.out.println("요청 함수 idFindProc()!");
		// 1.파라미터 받기
		String name = mdto.getName();
		String email = mdto.getEmail();
		// 2.비즈니스 로직
		MembersDTO result = mService.mailAuth(mdto);
		// 3.Model & View
		mv.setViewName("member/idSuccess");
		mv.addObject("result", result);
		return mv;
	}

	// 비밀번호 찾기 폼 보여주기
	@RequestMapping("/pwFindFrm.gg")
	public String pwFindFrm() {
		System.out.println("요청 함수 pwFindFrm()!");
		return "member/pwFindFrm";
	}

	// 비밀번호 변경 폼 보여주기
	@RequestMapping("/pwChgFrm.gg")
	public String pwChgFrm(@RequestParam(value = "id") String id, HttpServletRequest request) {
		System.out.println("요청 함수 pwChgFrm()! id= " + id);
		request.setAttribute("id", id);
		return "member/pwChgFrm";
	}

	// 비밀번호 변경 처리
	@RequestMapping("/pwChgProc.gg")
	public String pwChgProc(MembersDTO memberDTO) {
		System.out.println("요청 함수 pwChgProc()!");
		// 1.파라미터 받기
		String id = memberDTO.getId();
		// 2.비즈니스 로직
		mService.updatePw(memberDTO);
		// 3.Model & View
		return "member/pwSuccess";

	}

	// 회원가입 폼 보여주기
	@RequestMapping("/joinFrm.gg")
	public String joinFrm() {
		System.out.println("요청 함수 joinFrm()!");
		return "member/joinFrm";
	}

	// 회원가입 처리
	@RequestMapping("/joinProc.gg")
	public String joinProc(MembersDTO mdto) {
		// 1.파라미터 받기
		System.out.println("joinProc mdto = " + mdto);
		// 2.비즈니스 로직
		mService.joinProc(mdto);
		// 3.Model & View
		return "member/joinSuccess";

	}

	// 회원가입시 - 아이디 중복체크
	@RequestMapping("/mailAuth1.gg")
	public ModelAndView mailAuth1(Model model, MembersDTO mdto, ModelAndView mv) {
		System.out.println("요청 함수 회원가입용 mailAuth1()!");

		// 1.파라미터 받기
		String id = mdto.getId();

		// 2.비즈니스 로직
		MembersDTO result = mService.mailAuth1(mdto);
		if (id.length() > 0 && result == null) {
			// 비회원
			System.out.println("비회원 입니다");
			mv.setViewName("member/joinFrm");
			mv.addObject("msg", "notmember");
			mv.addObject("id", id);
		} else {
			// 회원
			System.out.println("기존 회원 정보와 일치합니다");
			mv.setViewName("member/joinFrm");
			mv.addObject("msg", "fail");
		}

		return mv;
	}

	// 인증번호 보내기 이름-메일(아이디찾기) / id-메일 매칭(비밀번호찾기)
	@RequestMapping("/mailAuth.gg")
	public ModelAndView mailAuth(Model model, MembersDTO mdto, ModelAndView mv) {
		System.out.println("요청 함수 mailAuth()!");
		ConfirmMail mail = new ConfirmMail();
		// 1.파라미터 받기
		String id = mdto.getId();
		String name = mdto.getName();
		String email = mdto.getEmail();
		// 2.비즈니스 로직
		if (id == null) {
			MembersDTO result = mService.mailAuth(mdto);
			if (result != null) {
				// 일치 성공
				System.out.println("메일인증 매칭 성공 email= " + email);
				model.addAttribute("num", mail.sendMail(email));
				mv.setViewName("member/idFindFrm2");
				mv.addObject("result", result);
			} else {
				// 일치 실패
				System.out.println("메일인증 매칭실패");
				mv.setViewName("member/idFindFrm");
				mv.addObject("msg", "fail");
			}
		} else {
			MembersDTO result = mService.mailAuth(mdto);
			if (result != null) {
				// 일치 성공
				System.out.println("pwFind 메일인증 매칭 성공 email= " + email);
				model.addAttribute("num", mail.sendMail(email));
				mv.setViewName("member/pwFindFrm");
				mv.addObject("result", result);
			} else {
				// 일치 실패
				System.out.println("메일인증 매칭실패");
				mv.setViewName("member/pwFindFrm");
				mv.addObject("msg", "fail");
			}

		}
		return mv;
	}

	// 이메일 인증번호 보내기 - 회원가입
	@ResponseBody
	@RequestMapping("/mailAuth2")
	public JSONObject emailAuth(MembersDTO mdto, Model model) {
		System.out.println("회원가입 emailAuth() 진입");
		ConfirmMail mail = new ConfirmMail();

		// 1.파라미터 받기
		String id = mdto.getId();
		String email = mdto.getEmail();
		System.out.println(id + "/" + email);
		JSONObject obj = new JSONObject();

		// 2.비즈니스 로직
		MembersDTO result = mService.mailAuth1(mdto);
		// System.out.println("result=="+result);

		if (email != null && result == null) {
			System.out.println("비회원 입니다");
			System.out.println("회원가입 메일 전송 email= " + email);

			obj.put("confirmNum", mail.sendMail(email));
			obj.put("result", result);
			// obj.put("email",email);

		} else {
			// 회원
			System.out.println("기존 회원 정보와 일치합니다");
			obj.put("result", result);
		}
		return obj;
	}

}
