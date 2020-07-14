package com.ggs.team;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ggs.DTO.TeamInfoDTO;
import com.ggs.DTO.TeamRecordDTO;

import com.ggs.util.PageUtil;

@Controller
@RequestMapping("/team")
public class TeamInfoController {

	@Autowired
	TeamInfoService tService;

	@RequestMapping("/list")
	public ModelAndView Teamlist(ModelAndView mv) {

		// 1.파라미터받기

		// 2.비즈니스로직(->Service->DAO->db)
		// KIA의 승,무,패,득점,실점

		ArrayList<TeamRecordDTO> KIAWin = tService.getKIAWin();
		ArrayList<TeamRecordDTO> KIADraw = tService.getKIADraw();
		ArrayList<TeamRecordDTO> KIALose = tService.getKIALose();
		ArrayList<TeamRecordDTO> KIAScore = tService.getKIAScore();
		ArrayList<TeamRecordDTO> KIALoss = tService.getKIALoss();

		// KT의 승,무,패,득점,실점
		ArrayList<TeamRecordDTO> KTWin = tService.getKTWin();
		ArrayList<TeamRecordDTO> KTDraw = tService.getKTDraw();
		ArrayList<TeamRecordDTO> KTLose = tService.getKTLose();
		ArrayList<TeamRecordDTO> KTScore = tService.getKTScore();
		ArrayList<TeamRecordDTO> KTLoss = tService.getKTLoss();

		// LG의 승,무,패,득점,실점
		ArrayList<TeamRecordDTO> LGWin = tService.getLGWin();
		ArrayList<TeamRecordDTO> LGDraw = tService.getLGDraw();
		ArrayList<TeamRecordDTO> LGLose = tService.getLGLose();
		ArrayList<TeamRecordDTO> LGScore = tService.getLGScore();
		ArrayList<TeamRecordDTO> LGLoss = tService.getLGLoss();

		// NC의 승,무,패,득점,실점
		ArrayList<TeamRecordDTO> NCWin = tService.getNCWin();
		ArrayList<TeamRecordDTO> NCDraw = tService.getNCDraw();
		ArrayList<TeamRecordDTO> NCLose = tService.getNCLose();
		ArrayList<TeamRecordDTO> NCScore = tService.getNCScore();
		ArrayList<TeamRecordDTO> NCLoss = tService.getNCLoss();

		// SK의 승,무,패,득점,실점
		ArrayList<TeamRecordDTO> SKWin = tService.getSKWin();
		ArrayList<TeamRecordDTO> SKDraw = tService.getSKDraw();
		ArrayList<TeamRecordDTO> SKLose = tService.getSKLose();
		ArrayList<TeamRecordDTO> SKScore = tService.getSKScore();
		ArrayList<TeamRecordDTO> SKLoss = tService.getSKLoss();

		// 두산의 승,무,패,득점,실점
		ArrayList<TeamRecordDTO> DSWin = tService.getDSWin();
		ArrayList<TeamRecordDTO> DSDraw = tService.getDSDraw();
		ArrayList<TeamRecordDTO> DSLose = tService.getDSLose();
		ArrayList<TeamRecordDTO> DSScore = tService.getDSScore();
		ArrayList<TeamRecordDTO> DSLoss = tService.getDSLoss();

		// 롯데의 승,무,패,득점,실점
		ArrayList<TeamRecordDTO> LTWin = tService.getLTWin();
		ArrayList<TeamRecordDTO> LTDraw = tService.getLTDraw();
		ArrayList<TeamRecordDTO> LTLose = tService.getLTLose();
		ArrayList<TeamRecordDTO> LTScore = tService.getLTScore();
		ArrayList<TeamRecordDTO> LTLoss = tService.getLTLoss();

		// 삼성의 승,무,패,득점,실점
		ArrayList<TeamRecordDTO> SSWin = tService.getSSWin();
		ArrayList<TeamRecordDTO> SSDraw = tService.getSSDraw();
		ArrayList<TeamRecordDTO> SSLose = tService.getSSLose();
		ArrayList<TeamRecordDTO> SSScore = tService.getSSScore();
		ArrayList<TeamRecordDTO> SSLoss = tService.getSSLoss();

		// 키움의 승,무,패,득점,실점
		ArrayList<TeamRecordDTO> KUWin = tService.getKUWin();
		ArrayList<TeamRecordDTO> KUDraw = tService.getKUDraw();
		ArrayList<TeamRecordDTO> KULose = tService.getKULose();
		ArrayList<TeamRecordDTO> KUScore = tService.getKUScore();
		ArrayList<TeamRecordDTO> KULoss = tService.getKULoss();

		// 한화의 승,무,패,득점,실점
		ArrayList<TeamRecordDTO> HHWin = tService.getHHWin();
		ArrayList<TeamRecordDTO> HHDraw = tService.getHHDraw();
		ArrayList<TeamRecordDTO> HHLose = tService.getHHLose();
		ArrayList<TeamRecordDTO> HHScore = tService.getHHScore();
		ArrayList<TeamRecordDTO> HHLoss = tService.getHHLoss();

		// 3.Model(실제조회목록)
		// KIA의 승,무,패,득점,실점
		mv.addObject("KIAWin", KIAWin);
		mv.addObject("KIADraw", KIADraw);
		mv.addObject("KIALose", KIALose);
		mv.addObject("KIAScore", KIAScore);
		mv.addObject("KIALoss", KIALoss);

		// KT의 승,무,패,득점,실점
		mv.addObject("KTWin", KTWin);
		mv.addObject("KTDraw", KTDraw);
		mv.addObject("KTLose", KTLose);
		mv.addObject("KTScore", KTScore);
		mv.addObject("KTLoss", KTLoss);

		// LG의 승,무,패,득점,실점
		mv.addObject("LGWin", LGWin);
		mv.addObject("LGDraw", LGDraw);
		mv.addObject("LGLose", LGLose);
		mv.addObject("LGScore", LGScore);
		mv.addObject("LGLoss", LGLoss);

		// NC의 승,무,패,득점,실점
		mv.addObject("NCWin", NCWin);
		mv.addObject("NCDraw", NCDraw);
		mv.addObject("NCLose", NCLose);
		mv.addObject("NCScore", NCScore);
		mv.addObject("NCLoss", NCLoss);

		// SK의 승,무,패,득점,실점
		mv.addObject("SKWin", SKWin);
		mv.addObject("SKDraw", SKDraw);
		mv.addObject("SKLose", SKLose);
		mv.addObject("SKScore", SKScore);
		mv.addObject("SKLoss", SKLoss);

		// 두산의 승,무,패,득점,실점
		mv.addObject("DSWin", DSWin);
		mv.addObject("DSDraw", DSDraw);
		mv.addObject("DSLose", DSLose);
		mv.addObject("DSScore", DSScore);
		mv.addObject("DSLoss", DSLoss);

		// 롯데의 승,무,패,득점,실점
		mv.addObject("LTWin", LTWin);
		mv.addObject("LTDraw", LTDraw);
		mv.addObject("LTLose", LTLose);
		mv.addObject("LTScore", LTScore);
		mv.addObject("LTLoss", LTLoss);

		// 삼성의 승,무,패,득점,실점
		mv.addObject("SSWin", SSWin);
		mv.addObject("SSDraw", SSDraw);
		mv.addObject("SSLose", SSLose);
		mv.addObject("SSScore", SSScore);
		mv.addObject("SSLoss", SSLoss);

		// 키움의 승,무,패,득점,실점
		mv.addObject("KUWin", KUWin);
		mv.addObject("KUDraw", KUDraw);
		mv.addObject("KULose", KULose);
		mv.addObject("KUScore", KUScore);
		mv.addObject("KULoss", KULoss);

		// 한화의 승,무,패,득점,실점
		mv.addObject("HHWin", HHWin);
		mv.addObject("HHDraw", HHDraw);
		mv.addObject("HHLose", HHLose);
		mv.addObject("HHScore", HHScore);
		mv.addObject("HHLoss", HHLoss);

		// 4.View
		mv.setViewName("TeamInfo/list");

		return mv;
	}

	@RequestMapping("/KIA")
	public ModelAndView KIADetailView(
			@RequestParam(value = "nowPage", required = false, defaultValue = "1") int nowPage,
			ModelAndView mv) {

		// 1.파라미터받기

		// 2.비즈니스로직(->Service->DAO->db)
		ArrayList<TeamInfoDTO> InfoKIA = tService.getInfoKIA();

		ArrayList<TeamRecordDTO> KIAWin = tService.getKIAWin();
		ArrayList<TeamRecordDTO> KIADraw = tService.getKIADraw();
		ArrayList<TeamRecordDTO> KIALose = tService.getKIALose();
		ArrayList<TeamRecordDTO> KIAScore = tService.getKIAScore();
		ArrayList<TeamRecordDTO> KIALoss = tService.getKIALoss();
		
		PageUtil pInfo = tService.getKIACnt(nowPage);
		ArrayList<TeamRecordDTO> ScheduleKIA = tService.getScheduleKIA(pInfo);

		// 3.Model(실제조회목록)
		mv.addObject("InfoKIA", InfoKIA);

		mv.addObject("KIAWin", KIAWin);
		mv.addObject("KIADraw", KIADraw);
		mv.addObject("KIALose", KIALose);
		mv.addObject("KIAScore", KIAScore);
		mv.addObject("KIALoss", KIALoss);

		mv.addObject("ScheduleKIA", ScheduleKIA);//실제조회목록
		mv.addObject("PINFO",pInfo);//페이징관련 정보
		
		// 4.View
		mv.setViewName("TeamInfo/InfoKIA");

		return mv;
	}
	
	@RequestMapping("/KT")
	public ModelAndView KTDetailView(
			@RequestParam(value = "nowPage", required = false, defaultValue = "1") int nowPage,
			ModelAndView mv) {

		// 1.파라미터받기

		// 2.비즈니스로직(->Service->DAO->db)
		ArrayList<TeamInfoDTO> InfoKT = tService.getInfoKT();

		ArrayList<TeamRecordDTO> KTWin = tService.getKTWin();
		ArrayList<TeamRecordDTO> KTDraw = tService.getKTDraw();
		ArrayList<TeamRecordDTO> KTLose = tService.getKTLose();
		ArrayList<TeamRecordDTO> KTScore = tService.getKTScore();
		ArrayList<TeamRecordDTO> KTLoss = tService.getKTLoss();
		
		PageUtil pInfo = tService.getKTCnt(nowPage);
		ArrayList<TeamRecordDTO> ScheduleKT = tService.getScheduleKT(pInfo);

		// 3.Model(실제조회목록)
		mv.addObject("InfoKT", InfoKT);

		mv.addObject("KTWin", KTWin);
		mv.addObject("KTDraw", KTDraw);
		mv.addObject("KTLose", KTLose);
		mv.addObject("KTScore", KTScore);
		mv.addObject("KTLoss", KTLoss);

		mv.addObject("ScheduleKT", ScheduleKT);//실제조회목록
		mv.addObject("PINFO",pInfo);//페이징관련 정보
		
		// 4.View
		mv.setViewName("TeamInfo/InfoKT");

		return mv;
	}
	
	@RequestMapping("/LG")
	public ModelAndView LGDetailView(
			@RequestParam(value = "nowPage", required = false, defaultValue = "1") int nowPage,
			ModelAndView mv) {

		// 1.파라미터받기

		// 2.비즈니스로직(->Service->DAO->db)
		ArrayList<TeamInfoDTO> InfoLG = tService.getInfoLG();

		ArrayList<TeamRecordDTO> LGWin = tService.getLGWin();
		ArrayList<TeamRecordDTO> LGDraw = tService.getLGDraw();
		ArrayList<TeamRecordDTO> LGLose = tService.getLGLose();
		ArrayList<TeamRecordDTO> LGScore = tService.getLGScore();
		ArrayList<TeamRecordDTO> LGLoss = tService.getLGLoss();
		
		PageUtil pInfo = tService.getLGCnt(nowPage);
		ArrayList<TeamRecordDTO> ScheduleLG = tService.getScheduleLG(pInfo);

		// 3.Model(실제조회목록)
		mv.addObject("InfoLG", InfoLG);

		mv.addObject("LGWin", LGWin);
		mv.addObject("LGDraw", LGDraw);
		mv.addObject("LGLose", LGLose);
		mv.addObject("LGScore", LGScore);
		mv.addObject("LGLoss", LGLoss);

		mv.addObject("ScheduleLG", ScheduleLG);//실제조회목록
		mv.addObject("PINFO",pInfo);//페이징관련 정보
		
		// 4.View
		mv.setViewName("TeamInfo/InfoLG");

		return mv;
	}
	
	@RequestMapping("/NC")
	public ModelAndView NCDetailView(
			@RequestParam(value = "nowPage", required = false, defaultValue = "1") int nowPage,
			ModelAndView mv) {

		// 1.파라미터받기

		// 2.비즈니스로직(->Service->DAO->db)
		ArrayList<TeamInfoDTO> InfoNC = tService.getInfoNC();

		ArrayList<TeamRecordDTO> NCWin = tService.getNCWin();
		ArrayList<TeamRecordDTO> NCDraw = tService.getNCDraw();
		ArrayList<TeamRecordDTO> NCLose = tService.getNCLose();
		ArrayList<TeamRecordDTO> NCScore = tService.getNCScore();
		ArrayList<TeamRecordDTO> NCLoss = tService.getNCLoss();
		
		PageUtil pInfo = tService.getNCCnt(nowPage);
		ArrayList<TeamRecordDTO> ScheduleNC = tService.getScheduleNC(pInfo);

		// 3.Model(실제조회목록)
		mv.addObject("InfoNC", InfoNC);

		mv.addObject("NCWin", NCWin);
		mv.addObject("NCDraw", NCDraw);
		mv.addObject("NCLose", NCLose);
		mv.addObject("NCScore", NCScore);
		mv.addObject("NCLoss", NCLoss);

		mv.addObject("ScheduleNC", ScheduleNC);//실제조회목록
		mv.addObject("PINFO",pInfo);//페이징관련 정보
		
		// 4.View
		mv.setViewName("TeamInfo/InfoNC");

		return mv;
	}
	
	@RequestMapping("/SK")
	public ModelAndView SKDetailView(
			@RequestParam(value = "nowPage", required = false, defaultValue = "1") int nowPage,
			ModelAndView mv) {

		// 1.파라미터받기

		// 2.비즈니스로직(->Service->DAO->db)
		ArrayList<TeamInfoDTO> InfoSK = tService.getInfoSK();

		ArrayList<TeamRecordDTO> SKWin = tService.getSKWin();
		ArrayList<TeamRecordDTO> SKDraw = tService.getSKDraw();
		ArrayList<TeamRecordDTO> SKLose = tService.getSKLose();
		ArrayList<TeamRecordDTO> SKScore = tService.getSKScore();
		ArrayList<TeamRecordDTO> SKLoss = tService.getSKLoss();
		
		PageUtil pInfo = tService.getSKCnt(nowPage);
		ArrayList<TeamRecordDTO> ScheduleSK = tService.getScheduleSK(pInfo);

		// 3.Model(실제조회목록)
		mv.addObject("InfoSK", InfoSK);

		mv.addObject("SKWin", SKWin);
		mv.addObject("SKDraw", SKDraw);
		mv.addObject("SKLose", SKLose);
		mv.addObject("SKScore", SKScore);
		mv.addObject("SKLoss", SKLoss);

		mv.addObject("ScheduleSK", ScheduleSK);//실제조회목록
		mv.addObject("PINFO",pInfo);//페이징관련 정보
		
		// 4.View
		mv.setViewName("TeamInfo/InfoSK");

		return mv;
	}
	
	@RequestMapping("/DS")
	public ModelAndView DSDetailView(
			@RequestParam(value = "nowPage", required = false, defaultValue = "1") int nowPage,
			ModelAndView mv) {

		// 1.파라미터받기

		// 2.비즈니스로직(->Service->DAO->db)
		ArrayList<TeamInfoDTO> InfoDS = tService.getInfoDS();

		ArrayList<TeamRecordDTO> DSWin = tService.getDSWin();
		ArrayList<TeamRecordDTO> DSDraw = tService.getDSDraw();
		ArrayList<TeamRecordDTO> DSLose = tService.getDSLose();
		ArrayList<TeamRecordDTO> DSScore = tService.getDSScore();
		ArrayList<TeamRecordDTO> DSLoss = tService.getDSLoss();
		
		PageUtil pInfo = tService.getDSCnt(nowPage);
		ArrayList<TeamRecordDTO> ScheduleDS = tService.getScheduleDS(pInfo);

		// 3.Model(실제조회목록)
		mv.addObject("InfoDS", InfoDS);

		mv.addObject("DSWin", DSWin);
		mv.addObject("DSDraw", DSDraw);
		mv.addObject("DSLose", DSLose);
		mv.addObject("DSScore", DSScore);
		mv.addObject("DSLoss", DSLoss);

		mv.addObject("ScheduleDS", ScheduleDS);//실제조회목록
		mv.addObject("PINFO",pInfo);//페이징관련 정보
		
		// 4.View
		mv.setViewName("TeamInfo/InfoDS");

		return mv;
	}
	
	@RequestMapping("/LT")
	public ModelAndView LTDetailView(
			@RequestParam(value = "nowPage", required = false, defaultValue = "1") int nowPage,
			ModelAndView mv) {

		// 1.파라미터받기

		// 2.비즈니스로직(->Service->DAO->db)
		ArrayList<TeamInfoDTO> InfoLT = tService.getInfoLT();

		ArrayList<TeamRecordDTO> LTWin = tService.getLTWin();
		ArrayList<TeamRecordDTO> LTDraw = tService.getLTDraw();
		ArrayList<TeamRecordDTO> LTLose = tService.getLTLose();
		ArrayList<TeamRecordDTO> LTScore = tService.getLTScore();
		ArrayList<TeamRecordDTO> LTLoss = tService.getLTLoss();
		
		PageUtil pInfo = tService.getLTCnt(nowPage);
		ArrayList<TeamRecordDTO> ScheduleLT = tService.getScheduleLT(pInfo);

		// 3.Model(실제조회목록)
		mv.addObject("InfoLT", InfoLT);

		mv.addObject("LTWin", LTWin);
		mv.addObject("LTDraw", LTDraw);
		mv.addObject("LTLose", LTLose);
		mv.addObject("LTScore", LTScore);
		mv.addObject("LTLoss", LTLoss);

		mv.addObject("ScheduleLT", ScheduleLT);//실제조회목록
		mv.addObject("PINFO",pInfo);//페이징관련 정보
		
		// 4.View
		mv.setViewName("TeamInfo/InfoLT");

		return mv;
	}
	
	@RequestMapping("/SS")
	public ModelAndView SSDetailView(
			@RequestParam(value = "nowPage", required = false, defaultValue = "1") int nowPage,
			ModelAndView mv) {

		// 1.파라미터받기

		// 2.비즈니스로직(->Service->DAO->db)
		ArrayList<TeamInfoDTO> InfoSS = tService.getInfoSS();

		ArrayList<TeamRecordDTO> SSWin = tService.getSSWin();
		ArrayList<TeamRecordDTO> SSDraw = tService.getSSDraw();
		ArrayList<TeamRecordDTO> SSLose = tService.getSSLose();
		ArrayList<TeamRecordDTO> SSScore = tService.getSSScore();
		ArrayList<TeamRecordDTO> SSLoss = tService.getSSLoss();
		
		PageUtil pInfo = tService.getSSCnt(nowPage);
		ArrayList<TeamRecordDTO> ScheduleSS = tService.getScheduleSS(pInfo);

		// 3.Model(실제조회목록)
		mv.addObject("InfoSS", InfoSS);

		mv.addObject("SSWin", SSWin);
		mv.addObject("SSDraw", SSDraw);
		mv.addObject("SSLose", SSLose);
		mv.addObject("SSScore", SSScore);
		mv.addObject("SSLoss", SSLoss);

		mv.addObject("ScheduleSS", ScheduleSS);//실제조회목록
		mv.addObject("PINFO",pInfo);//페이징관련 정보
		
		// 4.View
		mv.setViewName("TeamInfo/InfoSS");

		return mv;
	}
	
	@RequestMapping("/KU")
	public ModelAndView KUDetailView(
			@RequestParam(value = "nowPage", required = false, defaultValue = "1") int nowPage,
			ModelAndView mv) {

		// 1.파라미터받기

		// 2.비즈니스로직(->Service->DAO->db)
		ArrayList<TeamInfoDTO> InfoKU = tService.getInfoKU();

		ArrayList<TeamRecordDTO> KUWin = tService.getKUWin();
		ArrayList<TeamRecordDTO> KUDraw = tService.getKUDraw();
		ArrayList<TeamRecordDTO> KULose = tService.getKULose();
		ArrayList<TeamRecordDTO> KUScore = tService.getKUScore();
		ArrayList<TeamRecordDTO> KULoss = tService.getKULoss();
		
		PageUtil pInfo = tService.getKUCnt(nowPage);
		ArrayList<TeamRecordDTO> ScheduleKU = tService.getScheduleKU(pInfo);

		// 3.Model(실제조회목록)
		mv.addObject("InfoKU", InfoKU);

		mv.addObject("KUWin", KUWin);
		mv.addObject("KUDraw", KUDraw);
		mv.addObject("KULose", KULose);
		mv.addObject("KUScore", KUScore);
		mv.addObject("KULoss", KULoss);

		mv.addObject("ScheduleKU", ScheduleKU);//실제조회목록
		mv.addObject("PINFO",pInfo);//페이징관련 정보
		
		// 4.View
		mv.setViewName("TeamInfo/InfoKU");

		return mv;
	}
	
	@RequestMapping("/HH")
	public ModelAndView HHDetailView(
			@RequestParam(value = "nowPage", required = false, defaultValue = "1") int nowPage,
			ModelAndView mv) {

		// 1.파라미터받기

		// 2.비즈니스로직(->Service->DAO->db)
		ArrayList<TeamInfoDTO> InfoHH = tService.getInfoHH();

		ArrayList<TeamRecordDTO> HHWin = tService.getHHWin();
		ArrayList<TeamRecordDTO> HHDraw = tService.getHHDraw();
		ArrayList<TeamRecordDTO> HHLose = tService.getHHLose();
		ArrayList<TeamRecordDTO> HHScore = tService.getHHScore();
		ArrayList<TeamRecordDTO> HHLoss = tService.getHHLoss();
		
		PageUtil pInfo = tService.getHHCnt(nowPage);
		ArrayList<TeamRecordDTO> ScheduleHH = tService.getScheduleHH(pInfo);

		// 3.Model(실제조회목록)
		mv.addObject("InfoHH", InfoHH);

		mv.addObject("HHWin", HHWin);
		mv.addObject("HHDraw", HHDraw);
		mv.addObject("HHLose", HHLose);
		mv.addObject("HHScore", HHScore);
		mv.addObject("HHLoss", HHLoss);

		mv.addObject("ScheduleHH", ScheduleHH);//실제조회목록
		mv.addObject("PINFO",pInfo);//페이징관련 정보
		
		// 4.View
		mv.setViewName("TeamInfo/InfoHH");

		return mv;
	}
	
}
