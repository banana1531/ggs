package com.ggs.teamrecord;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggs.DAO.MembersDAO;
import com.ggs.DAO.PreResultDAO;
import com.ggs.DAO.ReplyDAO;
import com.ggs.DAO.SchMatchDAO;
import com.ggs.DAO.TeamInfoDAO;
import com.ggs.DAO.TeamRecordDAO;
import com.ggs.DAO.TeampredictDAO;
import com.ggs.DTO.BoardDTO;
import com.ggs.DTO.MembersDTO;
import com.ggs.DTO.PreResultDTO;
import com.ggs.DTO.ReplyDTO;
import com.ggs.DTO.TeamInfoDTO;
import com.ggs.DTO.TeamRecordDTO;

@Service
public class TeampredictService {

	@Autowired
	private TeampredictDAO teampredictdao;
		
	@Autowired
	private SchMatchDAO schmatchdao;
	
	@Autowired
	private PreResultDAO preresultdao;
		
	@Autowired
	private ReplyDAO replyDAO;
	
	@Autowired
	private TeamRecordDAO teamRecordDAO;
	
	@Autowired
	private MembersDAO membersDAO;
	
	//아이디와 포인트 가져오기
	public List<MembersDTO> getRankingList(String id) {
		return teampredictdao.getRankingList();
	}
	
	public List<MembersDTO> getpointList(Integer ppoint) {
		return teampredictdao.getppoint(ppoint);
	}
	
	
	//오늘날짜에 해당하는 경기리스트 가져오기
	public List<TeamRecordDTO> getTodayMatch() {
		return teampredictdao.getTodayMatch();
	}
	//해당하는 경기리스트 출력해주기
	
	//경기리스트 오름차순으로 출력하기
	public List<TeamRecordDTO> getschmatchList(String pageNo, int month){
		System.out.println("TeampredictService.schmatchList");
		int temp = Integer.parseInt(pageNo);
		int start = (temp-1)*10;
		TeamRecordDTO teamRecordDTO = new TeamRecordDTO();
		if(month>0) teamRecordDTO.setMonth(month);
		teamRecordDTO.setStart(start);		
		return schmatchdao.getschmatchList(teamRecordDTO);
	}
	
	//경기결과 오름차순으로 출력하기
	public List<TeamRecordDTO> getrltmatchList(String pageNo, String perPage, int month) {
		System.out.println("TeampredictService.getrltmatchList");
		int temp = Integer.parseInt(pageNo);
		int start = (temp-1)*Integer.parseInt(perPage);
		TeamRecordDTO teamRecordDTO = new TeamRecordDTO();
		if(month>0) teamRecordDTO.setMonth(month);
		teamRecordDTO.setStart(start);
		return schmatchdao.getrltmatchList(teamRecordDTO);
	}
	
	//경기번호 조회 출력
	public TeamRecordDTO getdetailView(int gno){
		return teampredictdao.getdetailView(gno);
	}
	
	//경기일자 게시판에서 해당경기 해당번호에 해당하는 경기 출력하기
	public TeamRecordDTO getschmatchDetail(int gno,String ateamname,String bteamname){
		return schmatchdao.getschmatchDetail(gno, ateamname, bteamname);	
	}
	
	//경기일자 세부 게시판에서 해당경기 해당번호에 해당하는 팀실적 출력하기
	public List<TeamRecordDTO> getschmatchTeam(String ateamname, String bteamname){
		return schmatchdao.getschmatchTeam(ateamname,bteamname);
	}
	
	//팀 실적 가져오기
	public TeamInfoDTO getTeamScore(String teamname) {
		System.out.println("getTeamScore()");
		return teamRecordDAO.teamScore(teamname);
	}

	
	// 투표결과보여주기
	public String getpreteamCount(TeamRecordDTO dto) {
		System.out.println("getpreteamCount() dto=" + dto);
		PreResultDTO preResultDTO = preresultdao.predict(dto);
		String result = "";
		
		if(preResultDTO.getTotalpp()==0&&preResultDTO.getTotalcnt()==0&&preResultDTO.getPrecount()==0) {	
		}else{
			result = "[['predict','precount'],['" + dto.getAteamname() + "'," + preResultDTO.getTotalcnt()
					+ "],['무승부'," + preResultDTO.getTotalpp() + "],['" + dto.getBteamname() + "',"
					+ preResultDTO.getPrecount() + "]]";
		}
		System.out.println("result="+result);
		return result;
	}

	 //투표결과 DB저장
	public int insertRe(PreResultDTO dto, HttpServletRequest request) {
		int result = teampredictdao.checkList(dto).size();
		System.out.println("insertRe() result="+result);
		if(result<1) {
			teampredictdao.insertRe(dto);
			membersDAO.payPoint(dto);
			HttpSession session = request.getSession();
			session.setAttribute("UPOINT", (membersDAO.getMyInfo(dto.getId())).getPpoint());
		}
		return result;
	}
	
	 	 
	 //경기 정보 수정
	public int gameUpdate(TeamRecordDTO dto) {
		return teampredictdao.gameUpdate(dto);
	}

	
	//댓글 등록하기
	public int reply(ReplyDTO dto) {
		return replyDAO.reply(dto); 
	}
	
	//댓글 가져오기
	public List<ReplyDTO> getReplyList(BoardDTO boardDTO) {
		return replyDAO.getReplyList(boardDTO);
	}
}

