package com.ggs.DAO;


import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggs.DTO.TeamInfoDTO;
import com.ggs.DTO.TeamRecordDTO;

@Repository
public class TeamInfoDAO {
	
	@Autowired
	private SqlSessionTemplate session;
	
	//session정보를 받아서 처리
	public TeamInfoDTO getTeamInfo() {
		System.out.println("TeamInfoDAO.getTeamInfo() 진입");
		
		String teamname = "SK";
				
		System.out.println(session.selectOne("TeamInfo.myteam").toString());
		
		return null;
	}
	
	//KIA�쓽 �늻�쟻 �듅由ъ닔
	public ArrayList getKIAWin (TeamRecordDTO trDto) {	
		return (ArrayList)session.selectList("team.getKIAWin", trDto);
	}

	//KIA�쓽 �늻�쟻 臾댁듅遺��닔
	public ArrayList getKIADraw(TeamRecordDTO trDto) {
		return (ArrayList)session.selectList("team.getKIADraw", trDto);
	}

	//KIA�쓽 �늻�쟻 �뙣諛곗닔
	public ArrayList getKIALose(TeamRecordDTO trDto) {
		return (ArrayList)session.selectList("team.getKIALose", trDto);
	}

	//KIA�쓽 �늻�쟻 �뱷�젏
	public ArrayList getKIAScore(TeamRecordDTO trDto) {
		return (ArrayList)session.selectList("team.getKIAScore", trDto);
	}

	//KIA�쓽 �늻�쟻 �떎�젏
	public ArrayList getKIALoss(TeamRecordDTO trDto) {
		return (ArrayList)session.selectList("team.getKIALoss", trDto);
	}

	public ArrayList getKTWin(TeamRecordDTO trDto) {
		return (ArrayList)session.selectList("team.getKTWin", trDto);
	}

	public ArrayList getKTDraw(TeamRecordDTO trDto) {
		return (ArrayList)session.selectList("team.getKTDraw", trDto);
	}

	public ArrayList getKTLose(TeamRecordDTO trDto) {
		return (ArrayList)session.selectList("team.getKTLose", trDto);
	}

	public ArrayList getKTScore(TeamRecordDTO trDto) {
		return (ArrayList)session.selectList("team.getKTScore", trDto);
	}

	public ArrayList getKTLoss(TeamRecordDTO trDto) {
		return (ArrayList)session.selectList("team.getKTLoss", trDto);
	}

	public ArrayList getLGWin(TeamRecordDTO trDto) {
		return (ArrayList)session.selectList("team.getLGWin", trDto);
	}

	public ArrayList getLGDraw(TeamRecordDTO trDto) {
		return (ArrayList)session.selectList("team.getLGDraw", trDto);
	}

	public ArrayList getLGLose(TeamRecordDTO trDto) {
		return (ArrayList)session.selectList("team.getLGLose", trDto);
	}

	public ArrayList getLGScore(TeamRecordDTO trDto) {
		return (ArrayList)session.selectList("team.getLGScore", trDto);
	}

	public ArrayList getLGLoss(TeamRecordDTO trDto) {
		return (ArrayList)session.selectList("team.getLGLoss", trDto);
	}

	public ArrayList getNCWin(TeamRecordDTO trDto) {
		return (ArrayList)session.selectList("team.getNCWin", trDto);
	}

	public ArrayList getNCDraw(TeamRecordDTO trDto) {
		return (ArrayList)session.selectList("team.getNCDraw", trDto);
	}

	public ArrayList getNCLose(TeamRecordDTO trDto) {
		return (ArrayList)session.selectList("team.getNCLose", trDto);
	}

	public ArrayList getNCScore(TeamRecordDTO trDto) {
		return (ArrayList)session.selectList("team.getNCScore", trDto);
	}

	public ArrayList getNCLoss(TeamRecordDTO trDto) {
		return (ArrayList)session.selectList("team.getNCLoss", trDto);
	}

	public ArrayList getSKWin(TeamRecordDTO trDto) {
		return (ArrayList)session.selectList("team.getSKWin", trDto);
	}

	public ArrayList getSKDraw(TeamRecordDTO trDto) {
		return (ArrayList)session.selectList("team.getSKDraw", trDto);
	}

	public ArrayList getSKLose(TeamRecordDTO trDto) {
		return (ArrayList)session.selectList("team.getSKLose", trDto);
	}

	public ArrayList getSKScore(TeamRecordDTO trDto) {
		return (ArrayList)session.selectList("team.getSKScore", trDto);
	}

	public ArrayList getSKLoss(TeamRecordDTO trDto) {
		return (ArrayList)session.selectList("team.getSKLoss", trDto);
	}

	public ArrayList getDSWin(TeamRecordDTO trDto) {
		return (ArrayList)session.selectList("team.getDSWin", trDto);
	}

	public ArrayList getDSDraw(TeamRecordDTO trDto) {
		return (ArrayList)session.selectList("team.getDSDraw", trDto);
	}

	public ArrayList getDSLose(TeamRecordDTO trDto) {
		return (ArrayList)session.selectList("team.getDSLose", trDto);
	}

	public ArrayList getDSScore(TeamRecordDTO trDto) {
		return (ArrayList)session.selectList("team.getDSScore", trDto);
	}

	public ArrayList getDSLoss(TeamRecordDTO trDto) {
		return (ArrayList)session.selectList("team.getDSLoss", trDto);
	}

	public ArrayList getLTWin(TeamRecordDTO trDto) {
		return (ArrayList)session.selectList("team.getLTWin", trDto);
	}

	public ArrayList getLTDraw(TeamRecordDTO trDto) {
		return (ArrayList)session.selectList("team.getLTDraw", trDto);
	}

	public ArrayList getLTLose(TeamRecordDTO trDto) {
		return (ArrayList)session.selectList("team.getLTLose", trDto);
	}

	public ArrayList getLTScore(TeamRecordDTO trDto) {
		return (ArrayList)session.selectList("team.getLTScore", trDto);
	}

	public ArrayList getLTLoss(TeamRecordDTO trDto) {
		return (ArrayList)session.selectList("team.getLTLoss", trDto);
	}

	public ArrayList getSSWin(TeamRecordDTO trDto) {
		return (ArrayList)session.selectList("team.getSSWin", trDto);
	}

	public ArrayList getSSDraw(TeamRecordDTO trDto) {
		return (ArrayList)session.selectList("team.getSSDraw", trDto);
	}

	public ArrayList getSSLose(TeamRecordDTO trDto) {
		return (ArrayList)session.selectList("team.getSSLose", trDto);
	}

	public ArrayList getSSScore(TeamRecordDTO trDto) {
		return (ArrayList)session.selectList("team.getSSScore", trDto);
	}

	public ArrayList getSSLoss(TeamRecordDTO trDto) {
		return (ArrayList)session.selectList("team.getSSLoss", trDto);
	}

	public ArrayList getKUWin(TeamRecordDTO trDto) {
		return (ArrayList)session.selectList("team.getKUWin", trDto);
	}

	public ArrayList getKUDraw(TeamRecordDTO trDto) {
		return (ArrayList)session.selectList("team.getKUDraw", trDto);
	}

	public ArrayList getKULose(TeamRecordDTO trDto) {
		return (ArrayList)session.selectList("team.getKULose", trDto);
	}

	public ArrayList getKUScore(TeamRecordDTO trDto) {
		return (ArrayList)session.selectList("team.getKUScore", trDto);
	}

	public ArrayList getKULoss(TeamRecordDTO trDto) {
		return (ArrayList)session.selectList("team.getKULoss", trDto);
	}

	public ArrayList getHHWin(TeamRecordDTO trDto) {
		return (ArrayList)session.selectList("team.getHHWin", trDto);
	}

	public ArrayList getHHDraw(TeamRecordDTO trDto) {
		return (ArrayList)session.selectList("team.getHHDraw", trDto);
	}

	public ArrayList getHHLose(TeamRecordDTO trDto) {
		return (ArrayList)session.selectList("team.getHHLose", trDto);
	}

	public ArrayList getHHScore(TeamRecordDTO trDto) {
		return (ArrayList)session.selectList("team.getHHScore", trDto);
	}

	public ArrayList getHHLoss(TeamRecordDTO trDto) {
		return (ArrayList)session.selectList("team.getHHLoss", trDto);
	}

	public ArrayList getInfoKIA(TeamInfoDTO trDto) {
		return (ArrayList)session.selectList("team.getInfoKIA", trDto);
	}

	
}