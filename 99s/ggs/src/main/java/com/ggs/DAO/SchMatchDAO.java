package com.ggs.DAO;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggs.DTO.TeamRecordDTO;

@Repository
public class SchMatchDAO {

	@Autowired
	private SqlSessionTemplate session;
	
	//경기일정 리스트 가져오기
	public List<TeamRecordDTO> getschmatchList(TeamRecordDTO teamRecordDTO){
		System.out.println("month="+teamRecordDTO.getMonth());
		return session.selectList("schmatch.schmatch",teamRecordDTO);
	}
	
	//경기결과 리스트 가져오기	
	public List<TeamRecordDTO> getrltmatchList(TeamRecordDTO teamRecordDTO) {
		return session.selectList("schmatch.getrltmatchList", teamRecordDTO);
	}
	
	
	public List<TeamRecordDTO> getrltmatchList() {
		return session.selectList("schmatch.schmatch");
	}
	
	/*경기내용 가져오기*/ 
	public TeamRecordDTO getschmatchDetail(int gno, String ateamname, String bteamname){
		TeamRecordDTO tDTO = new TeamRecordDTO();
		tDTO.setGno(gno);
		tDTO.setAteamname(ateamname);
		tDTO.setBteamname(bteamname);
		return session.selectOne("schmatch.schmatchDetail",tDTO);
	}
	
	/*해당 팀의 경기 실적 가져오기*/
	 public List <TeamRecordDTO> getschmatchTeam(String ateamname,String bteamname){
		 return session.selectList("schmatch.schpreteamScore");
		 }


}
