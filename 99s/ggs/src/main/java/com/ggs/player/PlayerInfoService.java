package com.ggs.player;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggs.DAO.PlayerInfoDAO;
import com.ggs.DTO.PlayerInfoDTO;
import com.ggs.DTO.PlayerRecordDTO;
import com.ggs.util.PageUtil;



@Service
public class PlayerInfoService {
	
	@Autowired
	PlayerInfoDAO pDao;

	public ArrayList<PlayerRecordDTO> pitcher(int pno, PageUtil pInfo) {
		int start = (pInfo.getNowPage() - 1) * pInfo.getLineCount() + 1;
		int end = start + pInfo.getLineCount() - 1;
		PlayerRecordDTO prDto = new PlayerRecordDTO();
		prDto.setPno(pno);
		prDto.setStart(start-1);
		prDto.setEnd(end);
		ArrayList<PlayerRecordDTO> pitcher = pDao.pitcher(prDto);
		return pitcher;
	}
	
	public ArrayList<PlayerRecordDTO> batter(int pno, PageUtil pInfo) {
		int start = (pInfo.getNowPage() - 1) * pInfo.getLineCount() + 1;
		int end = start + pInfo.getLineCount() - 1;
		PlayerRecordDTO prDto = new PlayerRecordDTO();
		prDto.setPno(pno);
		prDto.setStart(start-1);
		prDto.setEnd(end);
		ArrayList<PlayerRecordDTO> batter = pDao.batter(prDto);
		return batter;
	}

	public PageUtil PlayerPage(int nowPage, int pno) {
		int totalCount = pDao.PlayerPage(pno);
		PageUtil pInfo = new PageUtil(nowPage, totalCount);
		return pInfo;
	}

	public ArrayList<PlayerRecordDTO> Ranking() {
		ArrayList<PlayerRecordDTO> Ranking = pDao.Ranking();
		for(int i=0; i<=4; i++) {
			double beforetayul = Double.parseDouble(Ranking.get(i).getTayul());
			double tayul = Math.round(beforetayul*1000)/1000.0;
			Ranking.get(i).setTayul(Double.toString(tayul));
		}
		return Ranking;
	}

	public ArrayList<PlayerRecordDTO> Ranking2() {
		ArrayList<PlayerRecordDTO> Ranking2 = pDao.Ranking2();
		return Ranking2;
	}

	public ArrayList<PlayerRecordDTO> Ranking3() {
		ArrayList<PlayerRecordDTO> Ranking3 = pDao.Ranking3();
		return Ranking3;
	}

	public ArrayList<PlayerRecordDTO> Ranking4() {
		ArrayList<PlayerRecordDTO> Ranking4 = pDao.Ranking4();
		return Ranking4;
	}

	public ArrayList<PlayerRecordDTO> Ranking5() {
		ArrayList<PlayerRecordDTO> Ranking5 = pDao.Ranking5();
		return Ranking5;
	}

	public ArrayList<PlayerRecordDTO> Ranking6() {
		ArrayList<PlayerRecordDTO> Ranking6 = pDao.Ranking6();
		return Ranking6;
	}

	public ArrayList<PlayerInfoDTO> common(int pno) {
		ArrayList<PlayerInfoDTO> common = pDao.common(pno);
		return common;
	}

	public ArrayList<PlayerRecordDTO> pitcher2(int pno) {
		ArrayList<PlayerRecordDTO> pitcher2 = pDao.pitcher2(pno);
		ArrayList<PlayerRecordDTO> iningCount = pDao.iningCount(pno);
		ArrayList<PlayerRecordDTO> ining = pDao.ining(pno);
		
		int IC = Integer.parseInt(iningCount.get(0).getGsc());
		double ining3;
		double ining4;
		double sum = 0;
		for(int i=0; i<=IC-1; i++) {
			String ining2 = ining.get(i).getIning();
			
			if(ining2.contains(".1")) {
				ining3 = Double.parseDouble(ining2);
				ining4 = ining3 -0.1 + 0.333333333;
			}
			else if(ining2.contains(".2")) {
				ining3 = Double.parseDouble(ining2);
				ining4 = ining3 -0.2 + 0.666666666;
			}
			else {
				ining4 = Double.parseDouble(ining2);
			}
			sum += ining4;
		}
		String sum2 = Double.toString(sum);
		pitcher2.get(0).setIning(sum2);
		
		String jachak2 = pitcher2.get(0).getJachak();
		double jachak3 = Double.parseDouble(jachak2);
		double era = (jachak3)*9/sum;
		double era2 = Math.round(era*100)/100.0;
		String era3 = Double.toString(era2);
		pitcher2.get(0).setEra(era3);
		
		return pitcher2;
	}

	public ArrayList<PlayerRecordDTO> batter2(int pno) {
		ArrayList<PlayerRecordDTO> batter2 = pDao.batter2(pno);
		double beforetayul = Double.parseDouble(batter2.get(0).getTayul());
		double tayul = Math.round(beforetayul*1000)/1000.0;
		batter2.get(0).setTayul(Double.toString(tayul));	
		return batter2;
	}

	public PageUtil getTeamCnt(String teamname, int nowPage) {
		int totalCount = pDao.getTeamCnt(teamname);
		PageUtil pInfo = new PageUtil(nowPage, totalCount);
		return pInfo;
	}

	public ArrayList<PlayerInfoDTO> getTeamList(String teamname, PageUtil pInfo) {
		int start = (pInfo.getNowPage() - 1) * pInfo.getLineCount() + 1;
		int end = start + pInfo.getLineCount() - 1;
		PlayerInfoDTO pDto = new PlayerInfoDTO();
		pDto.setStart(start-1);
		pDto.setEnd(end);
		pDto.setTeamname(teamname);
		ArrayList<PlayerInfoDTO> getTeamList = pDao.getTeamList(pDto);
		return getTeamList;
	}
	
	//선수 목록 가져오기
	public List<PlayerInfoDTO> playerList(String pageNo, String option, String search) {
		System.out.println("PlayerInfoService.playerList");
		System.out.println("pageNo"+pageNo);
		System.out.println("option"+option);
		System.out.println("search"+search);
		PlayerInfoDTO dto = new PlayerInfoDTO();
		if(option.equals("name")) dto.setName(search);
		else if (option.equals("teamname")) dto.setTeamname(search);
		else if (option.equals("position")) dto.setPosition(search);
		int temp = Integer.parseInt(pageNo);
		int start = (temp-1)*10;
		dto.setStart(start);
		return pDao.playerList(dto);
	}

	//선수 상세 정보 가져오기
	public PlayerInfoDTO playerDetail(PlayerInfoDTO playerInfoDTO) {
		return pDao.playerDetail(playerInfoDTO);
	}
	
	//선수 정보 업데이트 하기
	public int playerUpdate(PlayerInfoDTO playerDTO) {
		
		return pDao.playerUpdate(playerDTO);
	}
	
	//선수 경기 상세 내용 보기
	public PlayerRecordDTO playerRecordDetail(PlayerRecordDTO playerRecordDTO) {
		return pDao.playerRecordDetail(playerRecordDTO);
	}

	//선수 경기 기록 수정하기
	public int playerRecordUpdate(PlayerRecordDTO playerRecordDTO) {
		return pDao.playerRecordUpdate(playerRecordDTO);
	}
	
	
}
