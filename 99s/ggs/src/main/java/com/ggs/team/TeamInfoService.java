package com.ggs.team;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggs.DAO.TeamInfoDAO;
import com.ggs.DTO.TeamInfoDTO;
import com.ggs.DTO.TeamRecordDTO;
import com.ggs.util.PageUtil;

@Service
public class TeamInfoService {

	@Autowired
	TeamInfoDAO tDao;

	TeamRecordDTO trDto = new TeamRecordDTO();
	TeamInfoDTO tDto = new TeamInfoDTO();

	// KIA의 누적 승리수
	public ArrayList<TeamRecordDTO> getKIAWin() {
		ArrayList<TeamRecordDTO> KIAWin = tDao.getKIAWin(trDto);
		return KIAWin;
	}

	// KIA의 누적 무승부수
	public ArrayList<TeamRecordDTO> getKIADraw() {
		ArrayList<TeamRecordDTO> KIADraw = tDao.getKIADraw(trDto);
		return KIADraw;
	}

	// KIA의 누적 패배수
	public ArrayList<TeamRecordDTO> getKIALose() {
		ArrayList<TeamRecordDTO> KIALose = tDao.getKIALose(trDto);
		return KIALose;
	}

	// KIA의 누적 득점
	public ArrayList<TeamRecordDTO> getKIAScore() {
		ArrayList<TeamRecordDTO> KIAScore = tDao.getKIAScore(trDto);
		return KIAScore;
	}

	// KIA의 누적 실점
	public ArrayList<TeamRecordDTO> getKIALoss() {
		ArrayList<TeamRecordDTO> KIALoss = tDao.getKIALoss(trDto);
		return KIALoss;
	}

	public ArrayList<TeamRecordDTO> getKTWin() {
		ArrayList<TeamRecordDTO> KTWin = tDao.getKTWin(trDto);
		return KTWin;
	}

	public ArrayList<TeamRecordDTO> getKTDraw() {
		ArrayList<TeamRecordDTO> KTDraw = tDao.getKTDraw(trDto);
		return KTDraw;
	}

	public ArrayList<TeamRecordDTO> getKTLose() {
		ArrayList<TeamRecordDTO> KTLose = tDao.getKTLose(trDto);
		return KTLose;
	}

	public ArrayList<TeamRecordDTO> getKTScore() {
		ArrayList<TeamRecordDTO> KTScore = tDao.getKTScore(trDto);
		return KTScore;
	}

	public ArrayList<TeamRecordDTO> getKTLoss() {
		ArrayList<TeamRecordDTO> KTLoss = tDao.getKTLoss(trDto);
		return KTLoss;
	}

	public ArrayList<TeamRecordDTO> getLGWin() {
		ArrayList<TeamRecordDTO> LGWin = tDao.getLGWin(trDto);
		return LGWin;
	}

	public ArrayList<TeamRecordDTO> getLGDraw() {
		ArrayList<TeamRecordDTO> LGDraw = tDao.getLGDraw(trDto);
		return LGDraw;
	}

	public ArrayList<TeamRecordDTO> getLGLose() {
		ArrayList<TeamRecordDTO> LGLose = tDao.getLGLose(trDto);
		return LGLose;
	}

	public ArrayList<TeamRecordDTO> getLGScore() {
		ArrayList<TeamRecordDTO> LGScore = tDao.getLGScore(trDto);
		return LGScore;
	}

	public ArrayList<TeamRecordDTO> getLGLoss() {
		ArrayList<TeamRecordDTO> LGLoss = tDao.getLGLoss(trDto);
		return LGLoss;
	}

	public ArrayList<TeamRecordDTO> getNCWin() {
		ArrayList<TeamRecordDTO> NCWin = tDao.getNCWin(trDto);
		return NCWin;
	}

	public ArrayList<TeamRecordDTO> getNCDraw() {
		ArrayList<TeamRecordDTO> NCDraw = tDao.getNCDraw(trDto);
		return NCDraw;
	}

	public ArrayList<TeamRecordDTO> getNCLose() {
		ArrayList<TeamRecordDTO> NCLose = tDao.getNCLose(trDto);
		return NCLose;
	}

	public ArrayList<TeamRecordDTO> getNCScore() {
		ArrayList<TeamRecordDTO> NCScore = tDao.getNCScore(trDto);
		return NCScore;
	}

	public ArrayList<TeamRecordDTO> getNCLoss() {
		ArrayList<TeamRecordDTO> NCLoss = tDao.getNCLoss(trDto);
		return NCLoss;
	}

	public ArrayList<TeamRecordDTO> getSKWin() {
		ArrayList<TeamRecordDTO> SKWin = tDao.getSKWin(trDto);
		return SKWin;
	}

	public ArrayList<TeamRecordDTO> getSKDraw() {
		ArrayList<TeamRecordDTO> SKDraw = tDao.getSKDraw(trDto);
		return SKDraw;
	}

	public ArrayList<TeamRecordDTO> getSKLose() {
		ArrayList<TeamRecordDTO> KLose = tDao.getSKLose(trDto);
		return KLose;
	}

	public ArrayList<TeamRecordDTO> getSKScore() {
		ArrayList<TeamRecordDTO> SKScore = tDao.getSKScore(trDto);
		return SKScore;
	}

	public ArrayList<TeamRecordDTO> getSKLoss() {
		ArrayList<TeamRecordDTO> SKLoss = tDao.getSKLoss(trDto);
		return SKLoss;
	}

	public ArrayList<TeamRecordDTO> getDSWin() {
		ArrayList<TeamRecordDTO> DSWin = tDao.getDSWin(trDto);
		return DSWin;
	}

	public ArrayList<TeamRecordDTO> getDSDraw() {
		ArrayList<TeamRecordDTO> DSDraw = tDao.getDSDraw(trDto);
		return DSDraw;
	}

	public ArrayList<TeamRecordDTO> getDSLose() {
		ArrayList<TeamRecordDTO> DSLose = tDao.getDSLose(trDto);
		return DSLose;
	}

	public ArrayList<TeamRecordDTO> getDSScore() {
		ArrayList<TeamRecordDTO> DSScore = tDao.getDSScore(trDto);
		return DSScore;
	}

	public ArrayList<TeamRecordDTO> getDSLoss() {
		ArrayList<TeamRecordDTO> DSLoss = tDao.getDSLoss(trDto);
		return DSLoss;
	}

	public ArrayList<TeamRecordDTO> getLTWin() {
		ArrayList<TeamRecordDTO> DSLoss = tDao.getLTWin(trDto);
		return DSLoss;
	}

	public ArrayList<TeamRecordDTO> getLTDraw() {
		ArrayList<TeamRecordDTO> DSLoss = tDao.getLTDraw(trDto);
		return DSLoss;
	}

	public ArrayList<TeamRecordDTO> getLTLose() {
		ArrayList<TeamRecordDTO> DSLoss = tDao.getLTLose(trDto);
		return DSLoss;
	}

	public ArrayList<TeamRecordDTO> getLTScore() {
		ArrayList<TeamRecordDTO> DSLoss = tDao.getLTScore(trDto);
		return DSLoss;
	}

	public ArrayList<TeamRecordDTO> getLTLoss() {
		ArrayList<TeamRecordDTO> DSLoss = tDao.getLTLoss(trDto);
		return DSLoss;
	}

	public ArrayList<TeamRecordDTO> getSSWin() {
		ArrayList<TeamRecordDTO> SSWin = tDao.getSSWin(trDto);
		return SSWin;
	}

	public ArrayList<TeamRecordDTO> getSSDraw() {
		ArrayList<TeamRecordDTO> SSDraw = tDao.getSSDraw(trDto);
		return SSDraw;
	}

	public ArrayList<TeamRecordDTO> getSSLose() {
		ArrayList<TeamRecordDTO> SSLose = tDao.getSSLose(trDto);
		return SSLose;
	}

	public ArrayList<TeamRecordDTO> getSSScore() {
		ArrayList<TeamRecordDTO> SSScore = tDao.getSSScore(trDto);
		return SSScore;
	}

	public ArrayList<TeamRecordDTO> getSSLoss() {
		ArrayList<TeamRecordDTO> SSLoss = tDao.getSSLoss(trDto);
		return SSLoss;
	}

	public ArrayList<TeamRecordDTO> getKUWin() {
		ArrayList<TeamRecordDTO> KUWin = tDao.getKUWin(trDto);
		return KUWin;
	}

	public ArrayList<TeamRecordDTO> getKUDraw() {
		ArrayList<TeamRecordDTO> KUDraw = tDao.getKUDraw(trDto);
		return KUDraw;
	}

	public ArrayList<TeamRecordDTO> getKULose() {
		ArrayList<TeamRecordDTO> KULose = tDao.getKULose(trDto);
		return KULose;
	}

	public ArrayList<TeamRecordDTO> getKUScore() {
		ArrayList<TeamRecordDTO> KUScore = tDao.getKUScore(trDto);
		return KUScore;
	}

	public ArrayList<TeamRecordDTO> getKULoss() {
		ArrayList<TeamRecordDTO> KULoss = tDao.getKULoss(trDto);
		return KULoss;
	}

	public ArrayList<TeamRecordDTO> getHHWin() {
		ArrayList<TeamRecordDTO> HHWin = tDao.getHHWin(trDto);
		return HHWin;
	}

	public ArrayList<TeamRecordDTO> getHHDraw() {
		ArrayList<TeamRecordDTO> HHDraw = tDao.getHHDraw(trDto);
		return HHDraw;
	}

	public ArrayList<TeamRecordDTO> getHHLose() {
		ArrayList<TeamRecordDTO> HHLose = tDao.getHHLose(trDto);
		return HHLose;
	}

	public ArrayList<TeamRecordDTO> getHHScore() {
		ArrayList<TeamRecordDTO> HHScore = tDao.getHHScore(trDto);
		return HHScore;
	}

	public ArrayList<TeamRecordDTO> getHHLoss() {
		ArrayList<TeamRecordDTO> HHLoss = tDao.getHHLoss(trDto);
		return HHLoss;
	}

	public ArrayList<TeamInfoDTO> getInfoKIA() {
		ArrayList<TeamInfoDTO> InfoKIA = tDao.getInfoKIA(tDto);
		return InfoKIA;
	}

	public PageUtil getKIACnt(int nowPage) {
		int totalCount = tDao.getKIACnt();
		PageUtil pInfo = new PageUtil(nowPage, totalCount);
		return pInfo;
	}
	
	public ArrayList<TeamRecordDTO> getScheduleKIA(PageUtil pInfo) {
		int start = (pInfo.getNowPage() - 1) * pInfo.getLineCount() + 1;
		int end = start + pInfo.getLineCount() - 1;
		TeamRecordDTO trDto = new TeamRecordDTO();
		trDto.setStart(start);
		trDto.setEnd(end);
		ArrayList<TeamRecordDTO> ScheduleKIA = tDao.getScheduleKIA(trDto);
		return ScheduleKIA;
	}

	public ArrayList<TeamInfoDTO> getInfoKT() {
		ArrayList<TeamInfoDTO> InfoKT = tDao.getInfoKT(tDto);
		return InfoKT;
	}

	public PageUtil getKTCnt(int nowPage) {
		int totalCount = tDao.getKTCnt();
		PageUtil pInfo = new PageUtil(nowPage, totalCount);
		return pInfo;
	}
	
	public ArrayList<TeamRecordDTO> getScheduleKT(PageUtil pInfo) {
		int start = (pInfo.getNowPage() - 1) * pInfo.getLineCount() + 1;
		int end = start + pInfo.getLineCount() - 1;
		TeamRecordDTO trDto = new TeamRecordDTO();
		trDto.setStart(start);
		trDto.setEnd(end);
		ArrayList<TeamRecordDTO> ScheduleKT = tDao.getScheduleKT(trDto);
		return ScheduleKT;
	}

	public ArrayList<TeamInfoDTO> getInfoLG() {
		ArrayList<TeamInfoDTO> InfoLG = tDao.getInfoLG(tDto);
		return InfoLG;
	}

	public PageUtil getLGCnt(int nowPage) {
		int totalCount = tDao.getLGCnt();
		PageUtil pInfo = new PageUtil(nowPage, totalCount);
		return pInfo;
	}

	public ArrayList<TeamRecordDTO> getScheduleLG(PageUtil pInfo) {
		int start = (pInfo.getNowPage() - 1) * pInfo.getLineCount() + 1;
		int end = start + pInfo.getLineCount() - 1;
		TeamRecordDTO trDto = new TeamRecordDTO();
		trDto.setStart(start);
		trDto.setEnd(end);
		ArrayList<TeamRecordDTO> ScheduleLG = tDao.getScheduleLG(trDto);
		return ScheduleLG;
	}

	public ArrayList<TeamInfoDTO> getInfoNC() {
		ArrayList<TeamInfoDTO> InfoNC = tDao.getInfoNC(tDto);
		return InfoNC;
	}

	public PageUtil getNCCnt(int nowPage) {
		int totalCount = tDao.getNCCnt();
		PageUtil pInfo = new PageUtil(nowPage, totalCount);
		return pInfo;
	}

	public ArrayList<TeamRecordDTO> getScheduleNC(PageUtil pInfo) {
		int start = (pInfo.getNowPage() - 1) * pInfo.getLineCount() + 1;
		int end = start + pInfo.getLineCount() - 1;
		TeamRecordDTO trDto = new TeamRecordDTO();
		trDto.setStart(start);
		trDto.setEnd(end);
		ArrayList<TeamRecordDTO> ScheduleNC = tDao.getScheduleNC(trDto);
		return ScheduleNC;
	}

	public ArrayList<TeamInfoDTO> getInfoSK() {
		ArrayList<TeamInfoDTO> InfoSK = tDao.getInfoSK(tDto);
		return InfoSK;
	}

	public PageUtil getSKCnt(int nowPage) {
		int totalCount = tDao.getSKCnt();
		PageUtil pInfo = new PageUtil(nowPage, totalCount);
		return pInfo;
	}

	public ArrayList<TeamRecordDTO> getScheduleSK(PageUtil pInfo) {
		int start = (pInfo.getNowPage() - 1) * pInfo.getLineCount() + 1;
		int end = start + pInfo.getLineCount() - 1;
		TeamRecordDTO trDto = new TeamRecordDTO();
		trDto.setStart(start);
		trDto.setEnd(end);
		ArrayList<TeamRecordDTO> ScheduleSK = tDao.getScheduleSK(trDto);
		return ScheduleSK;
	}

	public ArrayList<TeamInfoDTO> getInfoDS() {
		ArrayList<TeamInfoDTO> InfoDS = tDao.getInfoDS(tDto);
		return InfoDS;
	}

	public PageUtil getDSCnt(int nowPage) {
		int totalCount = tDao.getDSCnt();
		PageUtil pInfo = new PageUtil(nowPage, totalCount);
		return pInfo;
	}

	public ArrayList<TeamRecordDTO> getScheduleDS(PageUtil pInfo) {
		int start = (pInfo.getNowPage() - 1) * pInfo.getLineCount() + 1;
		int end = start + pInfo.getLineCount() - 1;
		TeamRecordDTO trDto = new TeamRecordDTO();
		trDto.setStart(start);
		trDto.setEnd(end);
		ArrayList<TeamRecordDTO> ScheduleDS = tDao.getScheduleDS(trDto);
		return ScheduleDS;
	}

	public ArrayList<TeamInfoDTO> getInfoLT() {
		ArrayList<TeamInfoDTO> InfoLT = tDao.getInfoLT(tDto);
		return InfoLT;
	}

	public PageUtil getLTCnt(int nowPage) {
		int totalCount = tDao.getLTCnt();
		PageUtil pInfo = new PageUtil(nowPage, totalCount);
		return pInfo;
	}

	public ArrayList<TeamRecordDTO> getScheduleLT(PageUtil pInfo) {
		int start = (pInfo.getNowPage() - 1) * pInfo.getLineCount() + 1;
		int end = start + pInfo.getLineCount() - 1;
		TeamRecordDTO trDto = new TeamRecordDTO();
		trDto.setStart(start);
		trDto.setEnd(end);
		ArrayList<TeamRecordDTO> ScheduleLT = tDao.getScheduleLT(trDto);
		return ScheduleLT;
	}

	public ArrayList<TeamInfoDTO> getInfoSS() {
		ArrayList<TeamInfoDTO> InfoSS = tDao.getInfoSS(tDto);
		return InfoSS;
	}

	public PageUtil getSSCnt(int nowPage) {
		int totalCount = tDao.getSSCnt();
		PageUtil pInfo = new PageUtil(nowPage, totalCount);
		return pInfo;
	}

	public ArrayList<TeamRecordDTO> getScheduleSS(PageUtil pInfo) {
		int start = (pInfo.getNowPage() - 1) * pInfo.getLineCount() + 1;
		int end = start + pInfo.getLineCount() - 1;
		TeamRecordDTO trDto = new TeamRecordDTO();
		trDto.setStart(start);
		trDto.setEnd(end);
		ArrayList<TeamRecordDTO> ScheduleSS = tDao.getScheduleSS(trDto);
		return ScheduleSS;
	}

	public ArrayList<TeamInfoDTO> getInfoKU() {
		ArrayList<TeamInfoDTO> InfoKU = tDao.getInfoKU(tDto);
		return InfoKU;
	}

	public PageUtil getKUCnt(int nowPage) {
		int totalCount = tDao.getKUCnt();
		PageUtil pInfo = new PageUtil(nowPage, totalCount);
		return pInfo;
	}

	public ArrayList<TeamRecordDTO> getScheduleKU(PageUtil pInfo) {
		int start = (pInfo.getNowPage() - 1) * pInfo.getLineCount() + 1;
		int end = start + pInfo.getLineCount() - 1;
		TeamRecordDTO trDto = new TeamRecordDTO();
		trDto.setStart(start);
		trDto.setEnd(end);
		ArrayList<TeamRecordDTO> ScheduleKU = tDao.getScheduleKU(trDto);
		return ScheduleKU;
	}

	public ArrayList<TeamInfoDTO> getInfoHH() {
		ArrayList<TeamInfoDTO> InfoHH = tDao.getInfoHH(tDto);
		return InfoHH;
	}

	public PageUtil getHHCnt(int nowPage) {
		int totalCount = tDao.getHHCnt();
		PageUtil pInfo = new PageUtil(nowPage, totalCount);
		return pInfo;
	}

	public ArrayList<TeamRecordDTO> getScheduleHH(PageUtil pInfo) {
		int start = (pInfo.getNowPage() - 1) * pInfo.getLineCount() + 1;
		int end = start + pInfo.getLineCount() - 1;
		TeamRecordDTO trDto = new TeamRecordDTO();
		trDto.setStart(start);
		trDto.setEnd(end);
		ArrayList<TeamRecordDTO> ScheduleHH = tDao.getScheduleHH(trDto);
		return ScheduleHH;
	}

}
