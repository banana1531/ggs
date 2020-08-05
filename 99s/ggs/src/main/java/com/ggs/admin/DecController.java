package com.ggs.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ggs.DTO.BoardDTO;
import com.ggs.DTO.DeclarationDTO;
import com.ggs.DTO.DeclarationDetailDTO;
import com.ggs.DTO.DeclarationListDTO;
import com.ggs.util.PageUtil;

@Controller
@RequestMapping("/admin")
public class DecController {
	
	@Autowired
	private DecService service;
	
	/*** ==========================================
	 * 신고접수 현황
	 * ***/
	//접수 현황 보기
	@RequestMapping("/deSummary.gg")
	public String deSummary(Model model) {
		//금일 접수건수
		model.addAttribute("todayCnt", service.todayCnt());
		//미처리건수
		model.addAttribute("toDoCnt", service.toDoCnt());
		//주간 누적 접수건수
		model.addAttribute("weekCnt", service.weekCnt());
		//접수건 trendChart
		model.addAttribute("weekly", service.weeklyCnt());
		//주간별 평균 처리 시간 trendchart
		model.addAttribute("avgTime", service.avgTime());
		
		//신고 사유별 점유율
		model.addAttribute("reason", service.reason());
		
		return "/admin/deSummary";
	}
	
	
	
	//미처리건 목록 보기
	@RequestMapping("/declList.gg")
	public String declList(Model model, @RequestParam(value="pageNo", defaultValue="1") String pageNo) {
		
		List list = service.getDeclList(pageNo);
		int totalCount = 0;
		try {
			totalCount = ((DeclarationListDTO)list.get(0)).getTotalcnt();
		}catch (Exception e) {
			model.addAttribute("result", "현재 미처리된 신고글은 없습니다.");
		}
		PageUtil pageInfo = new PageUtil(Integer.parseInt(pageNo), totalCount, 10, 10);
		
		model.addAttribute("declist", list);
		model.addAttribute("pageInfo", pageInfo);
		return "/admin/declList";
	}
	
	//미처리건 - 신고처리 화면보기
	@RequestMapping("/declDetail.gg")
	public String declDetail(Model model, DeclarationDetailDTO dto) {
		model.addAttribute("detail", service.getDetail(dto));
		return "/admin/declDetail";
	}
	
	//미처리건 - 신고처리 하기
	@RequestMapping("/declUpdate.gg")
	public String declUpdate(Model model, BoardDTO dto) {
		if(service.updateBoard(dto)<1){
			model.addAttribute("error", "결과 처리에 실패하였습니다.");
			return "/admin/declDetail";
			}
		return "redirect:/admin/declList.gg";
	}
	
	//신고처리 완료 목록 보기
	@RequestMapping("/dondeclList.gg")
	public String dondeclList(Model model, @RequestParam(value="pageNo", defaultValue="1") String pageNo) {
		List list = service.getdonDecList(pageNo);
		int totalCount = ((DeclarationListDTO)list.get(0)).getTotalcnt();
		PageUtil pageInfo = new PageUtil(Integer.parseInt(pageNo), totalCount, 10, 10);
		
		model.addAttribute("declist", list);
		model.addAttribute("pageInfo", pageInfo);
		
		model.addAttribute("declist", list);
		return "/admin/dondeclList";
	}
	
	//신고처리 완료 목록 검색하기
	@RequestMapping("/declSearch.gg")
	public String decSearch(Model model, String option, String name) {
		model.addAttribute("declist", service.decSearch(option, name));
		return "/admin/dondeclList";
	}
	
	
}
