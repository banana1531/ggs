package com.ggs.player;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ggs.DAO.PlayerInfoDAO;
import com.ggs.DTO.PlayerInfoDTO;
import com.ggs.DTO.PlayerRecordDTO;
import com.ggs.util.PageUtil;

@Controller
@RequestMapping("/player")
public class PlayerInfoController {

	@Autowired
	PlayerInfoDAO pDao;
	
	@Autowired
	PlayerInfoService pService;

	@RequestMapping("/list")
	public String PlayerList() {
		return "PlayerInfo/list";
	}

	@RequestMapping("/KIA")
	public ModelAndView PlayerKIA(@RequestParam(value = "nowPage", required = false, defaultValue = "1") int nowPage,
			ModelAndView mv) {

		// 1.파라미터받기

		// 2.비즈니스로직(->Service->DAO->db)
		PageUtil pInfo = pService.getKIACnt(nowPage);
		ArrayList<PlayerInfoDTO> getListKIA = pService.getListKIA(pInfo);

		// 3.Model(실제조회목록)
		mv.addObject("getListKIA", getListKIA);// 실제조회목록
		mv.addObject("PINFO", pInfo);// 페이징관련 정보

		// 4.View
		mv.setViewName("PlayerInfo/PlayerKIA");

		return mv;
	}
	
	@RequestMapping("/KT")
	public ModelAndView PlayerKT(@RequestParam(value = "nowPage", required = false, defaultValue = "1") int nowPage,
			ModelAndView mv) {

		// 1.파라미터받기

		// 2.비즈니스로직(->Service->DAO->db)
		PageUtil pInfo = pService.getKTCnt(nowPage);
		ArrayList<PlayerInfoDTO> getListKT = pService.getListKT(pInfo);

		// 3.Model(실제조회목록)
		mv.addObject("getListKT", getListKT);// 실제조회목록
		mv.addObject("PINFO", pInfo);// 페이징관련 정보

		// 4.View
		mv.setViewName("PlayerInfo/PlayerKT");

		return mv;
	}
	
	@RequestMapping("/LG")
	public ModelAndView PlayerLG(@RequestParam(value = "nowPage", required = false, defaultValue = "1") int nowPage,
			ModelAndView mv) {

		// 1.파라미터받기

		// 2.비즈니스로직(->Service->DAO->db)
		PageUtil pInfo = pService.getLGCnt(nowPage);
		ArrayList<PlayerInfoDTO> getListLG = pService.getListLG(pInfo);

		// 3.Model(실제조회목록)
		mv.addObject("getListLG", getListLG);// 실제조회목록
		mv.addObject("PINFO", pInfo);// 페이징관련 정보

		// 4.View
		mv.setViewName("PlayerInfo/PlayerLG");

		return mv;
	}
	
	@RequestMapping("/NC")
	public ModelAndView PlayerNC(@RequestParam(value = "nowPage", required = false, defaultValue = "1") int nowPage,
			ModelAndView mv) {

		// 1.파라미터받기

		// 2.비즈니스로직(->Service->DAO->db)
		PageUtil pInfo = pService.getNCCnt(nowPage);
		ArrayList<PlayerInfoDTO> getListNC = pService.getListNC(pInfo);

		// 3.Model(실제조회목록)
		mv.addObject("getListNC", getListNC);// 실제조회목록
		mv.addObject("PINFO", pInfo);// 페이징관련 정보

		// 4.View
		mv.setViewName("PlayerInfo/PlayerNC");

		return mv;
	}
	
	@RequestMapping("/SK")
	public ModelAndView PlayerSK(@RequestParam(value = "nowPage", required = false, defaultValue = "1") int nowPage,
			ModelAndView mv) {

		// 1.파라미터받기

		// 2.비즈니스로직(->Service->DAO->db)
		PageUtil pInfo = pService.getSKCnt(nowPage);
		ArrayList<PlayerInfoDTO> getListSK = pService.getListSK(pInfo);

		// 3.Model(실제조회목록)
		mv.addObject("getListSK", getListSK);// 실제조회목록
		mv.addObject("PINFO", pInfo);// 페이징관련 정보

		// 4.View
		mv.setViewName("PlayerInfo/PlayerSK");

		return mv;
	}
	
	@RequestMapping("/DS")
	public ModelAndView PlayerDS(@RequestParam(value = "nowPage", required = false, defaultValue = "1") int nowPage,
			ModelAndView mv) {

		// 1.파라미터받기

		// 2.비즈니스로직(->Service->DAO->db)
		PageUtil pInfo = pService.getDSCnt(nowPage);
		ArrayList<PlayerInfoDTO> getListDS = pService.getListDS(pInfo);

		// 3.Model(실제조회목록)
		mv.addObject("getListDS", getListDS);// 실제조회목록
		mv.addObject("PINFO", pInfo);// 페이징관련 정보

		// 4.View
		mv.setViewName("PlayerInfo/PlayerDS");

		return mv;
	}
	
	@RequestMapping("/LT")
	public ModelAndView PlayerLT(@RequestParam(value = "nowPage", required = false, defaultValue = "1") int nowPage,
			ModelAndView mv) {

		// 1.파라미터받기

		// 2.비즈니스로직(->Service->DAO->db)
		PageUtil pInfo = pService.getLTCnt(nowPage);
		ArrayList<PlayerInfoDTO> getListLT = pService.getListLT(pInfo);

		// 3.Model(실제조회목록)
		mv.addObject("getListLT", getListLT);// 실제조회목록
		mv.addObject("PINFO", pInfo);// 페이징관련 정보

		// 4.View
		mv.setViewName("PlayerInfo/PlayerLT");

		return mv;
	}
	
	@RequestMapping("/SS")
	public ModelAndView PlayerSS(@RequestParam(value = "nowPage", required = false, defaultValue = "1") int nowPage,
			ModelAndView mv) {

		// 1.파라미터받기

		// 2.비즈니스로직(->Service->DAO->db)
		PageUtil pInfo = pService.getSSCnt(nowPage);
		ArrayList<PlayerInfoDTO> getListSS = pService.getListSS(pInfo);

		// 3.Model(실제조회목록)
		mv.addObject("getListSS", getListSS);// 실제조회목록
		mv.addObject("PINFO", pInfo);// 페이징관련 정보

		// 4.View
		mv.setViewName("PlayerInfo/PlayerSS");

		return mv;
	}
	
	@RequestMapping("/KU")
	public ModelAndView PlayerKU(@RequestParam(value = "nowPage", required = false, defaultValue = "1") int nowPage,
			ModelAndView mv) {

		// 1.파라미터받기

		// 2.비즈니스로직(->Service->DAO->db)
		PageUtil pInfo = pService.getKUCnt(nowPage);
		ArrayList<PlayerInfoDTO> getListKU = pService.getListKU(pInfo);

		// 3.Model(실제조회목록)
		mv.addObject("getListKU", getListKU);// 실제조회목록
		mv.addObject("PINFO", pInfo);// 페이징관련 정보

		// 4.View
		mv.setViewName("PlayerInfo/PlayerKU");

		return mv;
	}
	
	@RequestMapping("/HH")
	public ModelAndView PlayerHH(@RequestParam(value = "nowPage", required = false, defaultValue = "1") int nowPage,
			ModelAndView mv) {

		// 1.파라미터받기

		// 2.비즈니스로직(->Service->DAO->db)
		PageUtil pInfo = pService.getHHCnt(nowPage);
		ArrayList<PlayerInfoDTO> getListHH = pService.getListHH(pInfo);

		// 3.Model(실제조회목록)
		mv.addObject("getListHH", getListHH);// 실제조회목록
		mv.addObject("PINFO", pInfo);// 페이징관련 정보

		// 4.View
		mv.setViewName("PlayerInfo/PlayerHH");

		return mv;
	}
	
	@RequestMapping("/info")
	public ModelAndView PlayerInfo(
			@RequestParam(value="pno") int pno,
			@RequestParam(value="position") String position,
			@RequestParam(value = "nowPage", required = false, defaultValue = "1") int nowPage,
			ModelAndView mv) {
		
		if(position.contains("투수")) {
			PageUtil pInfo = pService.PlayerPage(nowPage, pno);
			ArrayList<PlayerRecordDTO> pitcher = pService.pitcher(pno, pInfo);
			mv.addObject("pitcher", pitcher);
			mv.addObject("PINFO", pInfo);
			mv.setViewName("PlayerInfo/pitcher");
		}
		else {
			PageUtil pInfo = pService.PlayerPage(nowPage, pno);
			ArrayList<PlayerRecordDTO> batter = pService.batter(pno, pInfo);
			mv.addObject("batter", batter);
			mv.addObject("PINFO", pInfo);
			mv.setViewName("PlayerInfo/batter");
		}
	
		return mv;
	}
	
}
