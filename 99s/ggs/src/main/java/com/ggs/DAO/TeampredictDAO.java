package com.ggs.DAO;


import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggs.DTO.MembersDTO;
import com.ggs.DTO.PreResultDTO;
import com.ggs.DTO.ReplyDTO;
import com.ggs.DTO.TeamInfoDTO;
import com.ggs.DTO.TeamRecordDTO;

@Repository
public class TeampredictDAO {

	@Autowired
	private SqlSessionTemplate session;
	
	//회원 순으로 가져오기
	public List<MembersDTO> getRankingList() {
		return session.selectList("Members.MembersRanking");
		
	}
	
	//point 리스트 가져오기
	public List<MembersDTO> getppoint(Integer ppoint){
		return session.selectList("Members.MembersRanking",ppoint);
	}

	//해당날짜의 해당경기번호읽기
	public List<TeamRecordDTO> getTodayMatchGno(Integer gno) {
		return session.selectList("todaymatch.todaymatch",gno);
	}
	
	//홈팀 어웨이팀 가져오기
	public List<TeamRecordDTO> getTodayMatch(String ateamname, String bteamname) {
		return session.selectList("todaymatch.todaymatch");
	}
	
	public TeamRecordDTO getdetailView(int gno) {
		return session.selectOne("matchdetail.matchdetail",gno);
	}
	
	//팀실적 가져오기
	public List<TeamRecordDTO> ApreteamScore(int win) {
		TeamRecordDTO atrdto = new TeamRecordDTO();
		atrdto.getAteamname();
		return session.selectList("teamRecord.preteamScore",win);
	}
	
	public TeamInfoDTO ApreteamScore() {
		TeamInfoDTO atrdto = new TeamInfoDTO();
		atrdto.setTeamName("Ateamname");
		return session.selectOne("teamRecord.ApreteamScore",atrdto);
	}

	public TeamInfoDTO BpreteamScore() {
		TeamInfoDTO btrdto = new TeamInfoDTO();
		btrdto.setTeamName("Bteamname");
		return session.selectOne("teamRecord.BpreteamScore",btrdto);
	}


	 //투표결과 DB저장
	public int insertRe(PreResultDTO irdto) {
		return session.insert("preresult.preresult",irdto);
	}

	//투표결과 반영값 불러오기
	public List<PreResultDTO> getelectmatchCount(int gno) {
		return session.selectList("preresult.predictcount", gno);
	}
	
	//경기 정보 수정하기
	public int gameUpdate(TeamRecordDTO dto) {
		return session.update("teamRecord.gameUpdate", dto);
	}
	
	//댓글 리스트 형태로 보기
	public List<ReplyDTO> rltmatchReply(ReplyDTO gno) {
	    return session.selectList("rltreply.rltmatchReply", gno);
	}
	
    //댓글 등록하기
    public int  rltmatchReplyAdd(ReplyDTO rDTO) {
		System.out.println("댓글 등록하기 DAO rDTO="+rDTO);
	   return session.insert("rltreply.rltreplyAdd", rDTO);
    }
	
}