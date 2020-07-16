package com.ggs.DAO;

import java.util.ArrayList;

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

}
