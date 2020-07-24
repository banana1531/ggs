package com.ggs.mypage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggs.DAO.FreeBoardDAO;
import com.ggs.DAO.MembersDAO;
import com.ggs.DAO.PreResultDAO;
import com.ggs.DAO.TeamInfoDAO;
import com.ggs.DAO.TeamRecordDAO;
import com.ggs.DTO.BoardDTO;
import com.ggs.DTO.MembersDTO;
import com.ggs.DTO.PreResultDTO;
import com.ggs.DTO.TeamInfoDTO;
import com.ggs.DTO.TeamRecordDTO;

@Service
public class MyPageService {
	
	@Autowired
	private PreResultDAO preResultDAO;
	
	@Autowired
	private MembersDAO membersDAO;
	
	@Autowired
	private TeamRecordDAO teamRecordDAO;
	
	@Autowired
	private FreeBoardDAO freeBoardDAO;
	
	
	//내가 쓴글 가져오기
	public List<BoardDTO> getMyArticle(String id) {
		return freeBoardDAO.getMyArticle(id);
	}

	//내가 참여한 승부예측 가져오기
	public List<PreResultDTO> getMyPreList(String id){
		return preResultDAO.getMyPreList(id);
	}
	
	//내팀 경기일정 가져오기
	public List<TeamRecordDTO> getMyteamSchedule(String team) {
		return teamRecordDAO.getMyTeamSchedule(team);
	}
	
	
	//내정보 가져오기
	public MembersDTO getMyInfo(String id) {
		return membersDAO.getMyInfo(id);
	}
	
	//탈퇴하기
	public int leave(String id) {
		MembersDTO membersDTO = new MembersDTO();
		membersDTO.setId(id);
		return membersDAO.leave(membersDTO);
	}
	
	//비교팀 정보 가져오기
	
	
}
