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
import com.ggs.util.NoticePageUtil;
import com.ggs.util.PageUtil;

@Controller
@RequestMapping("/admin")
public class DataManageController {
	
	
	@Autowired
	private TeamInfoService teamInfoService;

	@Autowired
	private PlayerInfoService playerInfoService;
	
	@Autowired
	private TeampredictService teampredicService;
	
	
	@Autowired
	private DataManageService dataManageService;
	
	/*** ==========================================
	 * data update
	 * ***/	
	
	//data update하기 메인화면보기
	@RequestMapping("/dataUpdate.gg")
	public String dataMain(String uri, Model model) {
		//업데이트 유무 확인하기
		if(dataManageService.checkUpdateDate()) {
		//경기 결과 업데이트 하기
		int r = dataManageService.updateDBTeamRecord();
		System.out.println("경기 데이터를 총 "+r+"건 업데이트 하였습니다.");
		//승부예측 포인트 계산하기
		int r2=dataManageService.calPoint();
		System.out.println("preResult 테이블에 총 "+r2+"건의 데이터를 업데이트 하였습니다.");
		}
		
		if(uri.equals("gamelist"))return "redirect:/admin/gameList.gg";
		else if(uri.equals("playerlist"))return "redirect:/admin/playerList.gg";
		else return "redirect:/admin/teamList.gg";
		
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
		return "/admin/teamDetail";
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
		System.out.println("option="+option);
		System.out.println("search="+search);
		List list = playerInfoService.playerList(pageNo, option, search);
		System.out.println("list.size="+list.size());
		int totalcnt = 0;
		try {
			totalcnt = ((PlayerInfoDTO)list.get(0)).getTotalcnt();
		}catch (Exception e) {
			totalcnt = 0;
			model.addAttribute("result", "검색 결과가 없습니다.");
		}
		if(search.equals("0")) search=null;
		model.addAttribute("option", option);
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
		NoticePageUtil pageInfo = playerInfoService.PlayerPage(Integer.parseInt(pageNo), playerInfoDTO.getPno());
		pageInfo.setLineCount(10);
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
	
	//선수 검색하기
	
	
	
	
	
	/*** ==========================================
	 * 경기일정 data관리
	 * ***/
	
	//경기 결과 목록 불러오기
	@RequestMapping("/gameList.gg")
	public String gameList(Model model,
			@RequestParam(value="pageNo", defaultValue="1" ) String pageNo,
			@RequestParam(value="month",defaultValue="0") int month) {
		List list = teampredicService.getrltmatchList(pageNo,"10", month);
		int totalcnt = 0;
		if(list.size()>0) totalcnt= ((TeamRecordDTO)list.get(0)).getTotalcnt();
		else model.addAttribute("result", "해당되는 경기가 없습니다.");
		PageUtil pageInfo = new PageUtil(Integer.parseInt(pageNo), totalcnt, 10,10);
		model.addAttribute("list", list);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("nowPage", pageNo);
		model.addAttribute("month", month);
		return "/admin/gameList";
	}
	
	
	//경기 정보 수정하기
	@RequestMapping("/gameUpdate.gg")
	public String gameUpdate(TeamRecordDTO dto, Model model,
			@RequestParam(value="pageNo", defaultValue="1" ) String pageNo,
			@RequestParam(value="month",defaultValue="0") int month) {
		
		if(teampredicService.gameUpdate(dto)>0) model.addAttribute("result", "정보가 정상적으로 수정되었습니다.");
		else model.addAttribute("result", "정보 수정에 실패하였습니다. 다시 시도해주시기 바랍니다.");
		
		List list = teampredicService.getrltmatchList(pageNo,"10", month);
		PageUtil pageInfo = new PageUtil(Integer.parseInt(pageNo), ((TeamRecordDTO)list.get(0)).getTotalcnt(),10,10);
		model.addAttribute("list", list);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("nowPage", pageNo);
		model.addAttribute("month", month);
		
		return "admin/gameList";
	}
}
