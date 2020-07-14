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
	
	public int getKIACnt() {
		return (Integer)session.selectOne("player.getKIACnt");
	}

	public ArrayList getListKIA(PlayerInfoDTO pDto) {
		return (ArrayList)session.selectList("player.getListKIA", pDto);
	}

	public int getKTCnt() {
		return (Integer)session.selectOne("player.getKTCnt");
	}

	public ArrayList<PlayerInfoDTO> getListKT(PlayerInfoDTO pDto) {
		return (ArrayList)session.selectList("player.getListKT", pDto);
	}

	public int getLGCnt() {
		return (Integer)session.selectOne("player.getLGCnt");
	}

	public ArrayList<PlayerInfoDTO> getListLG(PlayerInfoDTO pDto) {
		return (ArrayList)session.selectList("player.getListLG", pDto);
	}

	public int getNCCnt() {
		return (Integer)session.selectOne("player.getNCCnt");
	}

	public ArrayList<PlayerInfoDTO> getListNC(PlayerInfoDTO pDto) {
		return (ArrayList)session.selectList("player.getListNC", pDto);
	}

	public int getSKCnt() {
		return (Integer)session.selectOne("player.getSKCnt");
	}

	public ArrayList<PlayerInfoDTO> getListSK(PlayerInfoDTO pDto) {
		return (ArrayList)session.selectList("player.getListSK", pDto);
	}

	public int getDSCnt() {
		return (Integer)session.selectOne("player.getDSCnt");
	}

	public ArrayList<PlayerInfoDTO> getListDS(PlayerInfoDTO pDto) {
		return (ArrayList)session.selectList("player.getListDS", pDto);
	}

	public int getLTCnt() {
		return (Integer)session.selectOne("player.getLTCnt");
	}

	public ArrayList<PlayerInfoDTO> getListLT(PlayerInfoDTO pDto) {
		return (ArrayList)session.selectList("player.getListLT", pDto);
	}

	public int getSSCnt() {
		return (Integer)session.selectOne("player.getSSCnt");
	}

	public ArrayList<PlayerInfoDTO> getListSS(PlayerInfoDTO pDto) {
		return (ArrayList)session.selectList("player.getListSS", pDto);
	}

	public int getKUCnt() {
		return (Integer)session.selectOne("player.getKUCnt");
	}

	public ArrayList<PlayerInfoDTO> getListKU(PlayerInfoDTO pDto) {
		return (ArrayList)session.selectList("player.getListKU", pDto);
	}

	public int getHHCnt() {
		return (Integer)session.selectOne("player.getHHCnt");
	}

	public ArrayList<PlayerInfoDTO> getListHH(PlayerInfoDTO pDto) {
		return (ArrayList)session.selectList("player.getListHH", pDto);
	}
	
	public int PlayerPage(int pno) {
		return (Integer)session.selectOne("player.PlayerPage", pno);
	}

	public ArrayList<PlayerRecordDTO> pitcher(PlayerRecordDTO prDto) {
		return (ArrayList)session.selectList("player.pitcher", prDto);
	}

	public ArrayList<PlayerRecordDTO> batter(PlayerRecordDTO prDto) {
		return (ArrayList)session.selectList("player.batter", prDto);
	}

}
