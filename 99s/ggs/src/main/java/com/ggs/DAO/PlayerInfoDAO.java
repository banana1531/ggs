package com.ggs.DAO;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggs.DTO.PlayerInfoDTO;
import com.ggs.DTO.PlayerRecordDTO;

@Repository
public class PlayerInfoDAO {

	@Autowired
	SqlSessionTemplate session;
	
	public int PlayerPage(int pno) {
		return (Integer)session.selectOne("player.PlayerPage", pno);
	}

	public ArrayList<PlayerRecordDTO> pitcher(PlayerRecordDTO prDto) {
		return (ArrayList)session.selectList("player.pitcher", prDto);
	}

	public ArrayList<PlayerRecordDTO> batter(PlayerRecordDTO prDto) {
		return (ArrayList)session.selectList("player.batter", prDto);
	}

	public ArrayList<PlayerRecordDTO> Ranking() {
		return (ArrayList)session.selectList("player.ranking");
	}

	public ArrayList<PlayerRecordDTO> Ranking2() {
		return (ArrayList)session.selectList("player.ranking2");
	}

	public ArrayList<PlayerRecordDTO> Ranking3() {
		return (ArrayList)session.selectList("player.ranking3");
	}

	public ArrayList<PlayerRecordDTO> Ranking4() {
		return (ArrayList)session.selectList("player.ranking4");
	}

	public ArrayList<PlayerRecordDTO> Ranking5() {
		return (ArrayList)session.selectList("player.ranking5");
	}

	public ArrayList<PlayerRecordDTO> Ranking6() {
		return (ArrayList)session.selectList("player.ranking6");
	}

	public ArrayList<PlayerInfoDTO> common(int pno) {
		return (ArrayList)session.selectList("player.common", pno);
	}

	public ArrayList<PlayerRecordDTO> pitcher2(int pno) {
		return (ArrayList)session.selectList("player.pitcher2", pno);
	}

	public ArrayList<PlayerRecordDTO> batter2(int pno) {
		return (ArrayList)session.selectList("player.batter2", pno);
	}

	public int getTeamCnt(String teamname) {
		return (Integer)session.selectOne("player.getTeamCnt", teamname);
	}

	public ArrayList<PlayerInfoDTO> getTeamList(PlayerInfoDTO pDto) {
		return (ArrayList)session.selectList("player.getTeamList", pDto);
	}

	public ArrayList<PlayerRecordDTO> ining(int pno) {
		return (ArrayList)session.selectList("player.ining", pno);
	}

	public ArrayList<PlayerRecordDTO> iningCount(int pno) {
		return (ArrayList)session.selectList("player.iningCount", pno);
	}
	
	//선수 목록 가져오기(팀 무시)
	public List<PlayerInfoDTO> playerList(PlayerInfoDTO dto) {
		System.out.println("PlayerInfoDAO.playerList");
		return session.selectList("player.playerList", dto);
	}
	
	//선수 상세 정보 가져오기
	public PlayerInfoDTO playerDetail(PlayerInfoDTO playerInfoDTO) {
		return session.selectOne("player.playerDetail", playerInfoDTO);
	}
	
	//선수 정보 수정하기
	public int playerUpdate(PlayerInfoDTO playerDTO) {
		return session.update("player.playerUpdate", playerDTO);
	}
	
	//선수 경기 상세 보기
	public PlayerRecordDTO playerRecordDetail(PlayerRecordDTO playerRecordDTO) {
		return session.selectOne("player.playerRecordDetail", playerRecordDTO);
	}
	
	//선수 경기 기록 수정하기
	public int playerRecordUpdate(PlayerRecordDTO playerRecordDTO) {
		return session.update("player.playerRecordUpdate", playerRecordDTO);
	}

}
