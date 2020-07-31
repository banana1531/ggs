package com.ggs.teamrecord;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ggs.DTO.BoardDTO;
import com.ggs.DTO.PreResultDTO;
import com.ggs.DTO.ReplyDTO;
import com.ggs.DTO.TeamInfoDTO;
import com.ggs.DTO.TeamRecordDTO;
import com.ggs.team.TeamInfoService;
import com.ggs.util.PageUtil;

@Controller
@RequestMapping("/teampredict")
public class TeampredictController {

	@Autowired
	private TeampredictService service;
	
	@Autowired
	private TeamInfoService teamInfoService;

	//---------------------------------------------------
	
	
	//승부예측 메인페이지 가기
	@RequestMapping("/prematchMain.gg")
	public String matchpredict(Model model,Integer gno,String id, Integer ppoint,String ateamname, String bteamname) {
		System.out.println("경기예측 메인페이지 matchpredict() 진입");
		
		//비즈니스
		//회원정보테이블에서 아이디와 보유포인트 가져오기
		model.addAttribute("RankingList", service.getRankingList(id));

		model.addAttribute("ppoint", service.getpointList(ppoint));

		model.addAttribute("TodayMatch",service.getTodayMatch());

	return "teampredict/prematchMain";
}
	
	//---------------------------------------------------
	
	//특정 팀 경기일정 조회  - 관리자/마이페이지용
	@RequestMapping("/schmatchList")
	public String schmatchList(String name, Model model,
			@RequestParam(value="pageNo", defaultValue="1") String pageNo,  
			@RequestParam(value="perPage", defaultValue="10") String perPage,
			@RequestParam(value="month", defaultValue="0") int month) {
		System.out.println("TeampredictController.schmatchList");
		System.out.println("name="+name+"pageNo="+pageNo);
		List list = teamInfoService.schmatchList(name, pageNo, perPage, month);
		PageUtil pageInfo = new PageUtil(Integer.parseInt(pageNo), ((TeamRecordDTO)list.get(0)).getTotalcnt());
		model.addAttribute("list", list);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("nowPage", pageNo);
		model.addAttribute("month", month);
		return "teampredict/teamScheduleList";
		
	}
	
	
	//경기 일정 조회 - 메인화면용
	@RequestMapping("/schmatchList.gg")
	public String schmatchList(@RequestParam(value="pageNo", defaultValue="1") String pageNo,
			@RequestParam(value="month",defaultValue="0") int month,
			Model model) {
		List list = service.getschmatchList(pageNo, month);
		System.out.println("list="+list);
		int totalcnt = 0;
		try{
			totalcnt = ((TeamRecordDTO)list.get(0)).getTotalcnt();
		}catch (Exception e) {
			totalcnt = 0;
			model.addAttribute("error", month+"월 경기 일정은 없습니다.");
		}
		PageUtil pageInfo = new PageUtil(Integer.parseInt(pageNo), totalcnt,10,5);
		model.addAttribute("SchMatchList", list);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("month", month);
		return "teampredict/teamschmatchList";
	}
	
	
	
	//---------------------------------------------------
	
	//경기결과 목록조회
	@RequestMapping("/rltmatchList.gg")
	public String rltmatchList( Model model,
			@RequestParam(value="pageNo", defaultValue="1") String pageNo,
			@RequestParam(value="perPage", defaultValue="10") String perPage,
			@RequestParam(value="month",defaultValue="0") int month) {
		System.out.println("경기결과 메인페이지 rltmatchList() 진입");
		List list = service.getrltmatchList(pageNo, perPage, month);
		int totalcnt = 0;
		try{
			totalcnt = ((TeamRecordDTO)list.get(0)).getTotalcnt();
		}catch (Exception e) {
			totalcnt = 0;
			model.addAttribute("error", month+"월 경기 결과는 없습니다.");
		}
		PageUtil pageInfo = new PageUtil(Integer.parseInt(pageNo),totalcnt ,10,5);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("SchMatchList", list);
		model.addAttribute("month", month);
		return "teampredict/teamrltmatchList";
	}
	
	//경기  상세
	@RequestMapping("/rltmatchDetail.gg")
	public String rltmatchDetail(PreResultDTO dto,Model mv) {
		System.out.println("경기결과 상세보기 페이지 진입");
		System.out.println("rltmatchDetail() dto="+dto);
		
		//경기 정보 가져오기
		TeamRecordDTO trDTO = service.getdetailView(dto.getGno());
		
		//승부 예측 결과 가져오기
		String prDTO = service.getpreteamCount(trDTO); 
		Date date = new Date();
		if(prDTO.length()>0) mv.addAttribute("preCount",prDTO);
		else if(date.compareTo(trDTO.getGdate())<0) mv.addAttribute("schedule", ",일정입니다."); 
		else mv.addAttribute("result", "승부 예측 기록이 없습니다.");
		
				
		//3.Model
		mv.addAttribute("detail",trDTO);
		mv.addAttribute("atrDTO",service.getTeamScore(trDTO.getAteamname()));
		mv.addAttribute("btrDTO",service.getTeamScore(trDTO.getBteamname()));
		
		return "teampredict/schmatchDetail";
	}
	
	
	
	//댓글 등록
	@RequestMapping("/reply")
	public String reply(Model model, ReplyDTO replyDTO) {
		System.out.println("reply()");
		replyDTO.setBoardname("teamRecord");
		System.out.println("replyDTO="+replyDTO);
		service.reply(replyDTO); 
		
		return "redirect:/teampredict/replyList?writeno="+replyDTO.getWno();
	}
	
	//댓글 리스트
	@RequestMapping("/replyList")
	public String replyList(Model model, BoardDTO boardDTO,
			@RequestParam(value = "pageNo", defaultValue = "1") int pageNo) {
		System.out.println("replyList()");
		boardDTO.setBoardname("teamRecord");
		model.addAttribute("list", service.getReplyList(boardDTO));
		return "teampredict/replyList";
	}
	
	
	
	//---------------------------------------------------
	
	//승부예측 상세페이지 출력
	@RequestMapping("/prematchDetail.gg")
	public String prematchdetail(PreResultDTO dto,Model mv,
			@RequestParam(value="result", defaultValue="3") int result) {
		System.out.println("경기예측 상세보기 요청함수 matchpredictdetail() 진입 dto="+dto);
		
		System.out.println("result="+result);
		if(result==0)mv.addAttribute("result", "투표하긴 결과가 적용되었습니다. 회원님의 포인트가 10p 차감되었습니다.");
		else if(result==1) mv.addAttribute("result", "이미 투표하신 경기 입니다.");
		//2.비즈니스로직수행
		TeamRecordDTO trDTO = service.getdetailView(dto.getGno());
		System.out.println("prematchdetail() trDTO="+trDTO);
		String prDTO = service.getpreteamCount(trDTO);
		if(prDTO.length()<1) prDTO = "[['predict','precount'],['"
		    	+trDTO.getAteamname()+"',"+0+"],['무승부',0],['"
		    	+trDTO.getBteamname()+"',"+0+"]]";
		
		TeamInfoDTO atrDTO = service.getTeamScore(trDTO.getAteamname());
		TeamInfoDTO btrDTO = service.getTeamScore(trDTO.getBteamname());
		
		//팀실적 가져오기
		System.out.println(prDTO);
		//3.Model
		mv.addAttribute("TRDTO",trDTO);
		mv.addAttribute("preCount",prDTO);
		mv.addAttribute("atrDTO",atrDTO);
		mv.addAttribute("btrDTO",btrDTO);
		return "/teampredict/prematchDetail";
	}
		
		//---------------------------------------------------
		//투표 처리
	@RequestMapping("/electmatch.gg")
	public String electmatch(PreResultDTO dto, Model mv, HttpServletRequest request) {
		System.out.println("electedMatch() dto="+dto);
		int result = service.insertRe(dto, request);
		return "redirect:/teampredict/prematchDetail.gg?gno="+dto.getGno()+"&result="+result;
			
	}
	
	//---------------------------------------------------


}
