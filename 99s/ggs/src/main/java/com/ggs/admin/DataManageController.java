package com.ggs.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ggs.DTO.PlayerInfoDTO;
import com.ggs.DTO.PlayerRecordDTO;
import com.ggs.DTO.TeamInfoDTO;
import com.ggs.DTO.TeamRecordDTO;
import com.ggs.player.PlayerInfoService;
import com.ggs.team.TeamInfoService;
import com.ggs.teamrecord.TeampredictService;
import com.ggs.util.PageUtil;

@Controller
@RequestMapping("/admin")
public class DataManageController {
	
	@Autowired
	private AdminService service;	
	
	@Autowired
	private TeamInfoService teamInfoService;

	@Autowired
	private PlayerInfoService playerInfoService;
	
	@Autowired
	private TeampredictService teampredicService;
	
	
	/*** ==========================================
	 * data관리
	 * ***/	
	
	//data관리 메인화면보기
	@RequestMapping("/dataMain.gg")
	public String dataMain() {
		return "/admin/dataMain";
	}
	
	
	/*** ==========================================
	 * 팀 data관리
	 * ***/	
	
	//팀 기본정보 목록 가져오기
	@RequestMapping("/teamList.gg")
	public String teamList(Model model) {
		
		model.addAttribute("list", teamInfoService.teamList());
				
		return "/admin/teamList";
	}
	
	//팀 상세 정보 수정폼 가기
	@RequestMapping("/teamDetail.gg")
	public String teamDetail(Model model, String name) {
		//팀 상세 정보 가져오기
		model.addAttribute("team", teamInfoService.teamDetail(name));
		return "/admin/teamDetail";
	}
	
	//팀 경기 기록 페이징#1
	@RequestMapping("/teamRecordP")
	public String teamRecordP(String name, @RequestParam(value="pageNo", defaultValue="1") String pageNo, Model model) {
		System.out.println("DataManageController.teamRecordP");
		System.out.println("name="+name+"pageNo="+pageNo);
		List list = teamInfoService.teamRecord(name, pageNo);
		PageUtil pageInfo = new PageUtil(Integer.parseInt(pageNo), ((TeamRecordDTO)list.get(0)).getTotalcnt());
		model.addAttribute("list", list);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("nowPage", pageNo);
		return "/admin/teamRecordList";
	}
	

	//팀 상세 정보 수정
	@RequestMapping("/teamInfoUpdate.gg")
	public String teamGameUpdate(Model model, TeamInfoDTO teamInfoDTO) {
		System.out.println("DataManageController.teamGameUpdate");
		System.out.println("teamInfoDTO="+teamInfoDTO);
		if(teamInfoService.updateInfo(teamInfoDTO)>0)
			model.addAttribute("result", "정보가 정상적으로 수정되었습니다.");
		else 
			model.addAttribute("result", "정보가 수정되지 않았습니다.");
		model.addAttribute("team", teamInfoService.teamDetail(teamInfoDTO.getTeamName()));
		return "redirect:/admin/teamDetail.gg?name="+teamInfoDTO.getTeamName();
	}
	
	
	/*** ==========================================
	 * 선수 data관리
	 * ***/	
	
	//선수목록 가져오기 불러오기 페이징
	@RequestMapping("/playerList.gg")
	public String playList(Model model, @RequestParam(value="pageNo", defaultValue="1")String pageNo
			,@RequestParam(value="option", defaultValue="0") String option
			,@RequestParam(value="search", defaultValue="0") String search) {
		System.out.println("DataManageController.playList");
		List list = playerInfoService.playerList(pageNo, option, search);
		System.out.println("list.size="+list.size());
		int totalcnt = ((PlayerInfoDTO)list.get(0)).getTotalcnt();
		if(search.equals("0")) search=null;
		model.addAttribute("search", search);
		model.addAttribute("playerlist", list);
		model.addAttribute("pageInfo", new PageUtil(Integer.parseInt(pageNo), totalcnt, 10, 10));
		return "/admin/playerList";
	}
	
	//선수 상세 정보 불러오기
	@RequestMapping("/playerDetail.gg")
	public String playerDetail(Model model, PlayerInfoDTO playerInfoDTO, @RequestParam(value="pageNo", defaultValue="1") String pageNo) {
		System.out.println("DataManageController.playerDetail");
		model.addAttribute("player", playerInfoService.playerDetail(playerInfoDTO));
		return "/admin/playerDetail";
	}
	
	//선수 상세 정보 수정하기
	@RequestMapping("/playerUpdate.gg")
	public String playerUpdate(Model model, PlayerInfoDTO playerInfoDTO) {
		if(playerInfoService.playerUpdate(playerInfoDTO)>0)
			model.addAttribute("result", "정보가 정상적으로 수정되었습니다.");
		else 
			model.addAttribute("result", "정보가 수정되지 않았습니다.");
		model.addAttribute("player", playerInfoService.playerDetail(playerInfoDTO));
		return "/admin/playerDetail";
	}
	
	//선수 경기 기록 가져오기 페이징
	@RequestMapping("/playerRecord")
	public String playerRecord(Model model, PlayerInfoDTO playerInfoDTO, @RequestParam(value="pageNo", defaultValue="1") String pageNo) {
		System.out.println("pageNo="+pageNo);
		PageUtil pageInfo = playerInfoService.PlayerPage(Integer.parseInt(pageNo), playerInfoDTO.getPno());
		List list = playerInfoService.pitcher(playerInfoDTO.getPno(), pageInfo);
		model.addAttribute("list", list);
		model.addAttribute("pageInfo", pageInfo);
		return "/admin/playerRecord";
	}
	
	
	//선수 경기 기록 상세 보기
	@RequestMapping("/playerRecordDetail.gg")
	public String playerRecordDetail(Model model, PlayerRecordDTO playerRecordDTO){
		model.addAttribute("player", playerInfoService.playerRecordDetail(playerRecordDTO));
		return "/admin/playerRecordDetail";
	}
	
	
	//선수 경기 기록 수정하기
	@RequestMapping("/playerRecordUpdate.gg")
	public String playerRecordUpdate(Model model, PlayerRecordDTO playerRecordDTO) {
		if(playerInfoService.playerRecordUpdate(playerRecordDTO)>0)
			model.addAttribute("result", "정보가 정상적으로 수정되었습니다.");
		else 
			model.addAttribute("result", "정보가 수정되지 않았습니다.");
		model.addAttribute("player", playerInfoService.playerRecordDetail(playerRecordDTO));
		return "/admin/playerRecordDetail";
	}
	
	/*** ==========================================
	 * 경기일정 data관리
	 * ***/
	
	//경기일정 목록 불러오기
	@RequestMapping("/gameList.gg")
	public String gameList(Model model, @RequestParam(value="pageNo", defaultValue="1" ) String pageNo) {
		model.addAttribute("list", teampredicService.getschmatchList());
		return "/admin/gameList";
	}
	
}
