package com.ggs.team;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;




@Controller
@RequestMapping("/team")
public class TeamController {

	@Autowired
	TeamService tService;

	@RequestMapping("/ListView")
	public ModelAndView TeamlistView(ModelAndView mv) {
		
		//1.파라미터받기
		
		//2.비즈니스로직(->Service->DAO->db)
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
		
		//3.Model(실제조회목록)
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
		
		//4.View
		mv.setViewName("team/listView");

		return mv;
	}
	
	@RequestMapping("/DetailView")
	public ModelAndView TeamDetailView(ModelAndView mv) {
		
		//1.파라미터받기
		
		//2.비즈니스로직(->Service->DAO->db)
		
		//3.Model(실제조회목록)
		
		//4.View
		
		return mv;
	}
}
