package com.ggs.teamrecord;


import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggs.DAO.PreResultDAO;
import com.ggs.DAO.SchMatchDAO;
import com.ggs.DAO.TeampredictDAO;
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
	private SqlSessionTemplate session;
	
	
	
	//아이디와 포인트 가져오기
	public List<MembersDTO> getRankingList(String id) {
		return teampredictdao.getRankingList();
	}
	
	public List<MembersDTO> getpointList(Integer ppoint) {
		return teampredictdao.getppoint(ppoint);
	}
	public List<TeamRecordDTO> getTodayMatchGno(Integer gno) {
		return teampredictdao.getTodayMatchGno(gno);
	}
	
	//오늘날짜에 해당하는 경기리스트 가져오기
	public List<TeamRecordDTO> getTodayMatch(String ateamname, String bteamname) {
		return teampredictdao.getTodayMatch(ateamname,bteamname);
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
	
	//팀 실적 가져오기 select id = preteamScore
	public TeamInfoDTO AgetpreTeamScore(String ateamname) {
		TeamInfoDTO atrdto = new TeamInfoDTO();
		atrdto.setTeamName(ateamname);
		return session.selectOne("teamRecord.ApreteamScore",atrdto);
	}
	
	public TeamInfoDTO BgetpreTeamScore(String bteamname) {
		TeamInfoDTO btrdto = new TeamInfoDTO();
		btrdto.setTeamName(bteamname);
		return session.selectOne("teamRecord.BpreteamScore",btrdto);
	}
	
	//투표결과보여주기
	 public String getpreteamCount(PreResultDTO dto) {
		 
	List<PreResultDTO> list = preresultdao.predict(dto);
		 
    String result = "[['predict','precount'],";
    for(PreResultDTO dto1 : list) {
    	
       result += "['"+dto1.getPredict()+"',"+dto1.getPrecount()+"],";
    }
    result=result.substring(0, result.length()-1)+"]";
    
    System.out.println("result 길이는?="+result.length());
    return result;
    
	}

	 //투표결과 DB저장
	public int insertRe(String id, int gno, String predict) {
		PreResultDTO irdto = new PreResultDTO();
		irdto.setId(id);
		irdto.setGno(gno);
		irdto.setPredict(predict);
		System.out.println("irdto="+irdto);
		return teampredictdao.insertRe(irdto);
	}
	
	//투표 반영결과 보여주기
	 public String getelectmatchCount(int dto) {
		    String result = "[['predict','precount'],";
		    List<PreResultDTO> list = teampredictdao.getelectmatchCount(dto);
		    for(PreResultDTO dto1 : list) {
		       result += "['"+dto1.getPredict()+"',"+dto1.getPrecount()+"],";
		    }
		    result=result.substring(0, result.length()-1)+"]";
		    System.out.println("result="+result);
		    return result;
	}
	 
	 //댓글 추가
	 public int rltmatchReplyAdd(int gno,String id, String content) {
	      ReplyDTO rDTO = new ReplyDTO();
	      rDTO.setId(id);
	      rDTO.setContent(content);
	      rDTO.setWno(gno);
	      System.out.println("rDTO="+rDTO);
	      System.out.println(" 댓글등록 Service rdto="+rDTO);
	      return teampredictdao.rltmatchReplyAdd(rDTO);
	   }

		//댓글기능
	 	public List<ReplyDTO> rltmatchReply(int gno) {
		    ReplyDTO rDTO = new ReplyDTO();
		    rDTO.setWno(gno);
		return teampredictdao.rltmatchReply(rDTO);
	 	}
	 
	 
	 
	 //경기 정보 수정
	public int gameUpdate(TeamRecordDTO dto) {
		return teampredictdao.gameUpdate(dto);
	}
}

