package com.ggs.team;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggs.DAO.TeamInfoDAO;
import com.ggs.DTO.TeamRecordDTO;

@Service
public class TeamService {

	@Autowired
	TeamInfoDAO tDao;

	TeamRecordDTO trDto = new TeamRecordDTO();
	
	//KIA의 누적 승리수
	public ArrayList<TeamRecordDTO> getKIAWin() {
		ArrayList<TeamRecordDTO> KIAWin = tDao.getKIAWin(trDto);
		return KIAWin;
	}

	//KIA의 누적 무승부수
	public ArrayList<TeamRecordDTO> getKIADraw() {
		ArrayList<TeamRecordDTO> KIADraw = tDao.getKIADraw(trDto);
		return KIADraw;
	}

	//KIA의 누적 패배수
	public ArrayList<TeamRecordDTO> getKIALose() {
		ArrayList<TeamRecordDTO> KIALose = tDao.getKIALose(trDto);
		return KIALose;
	}

	//KIA의 누적 득점
	public ArrayList<TeamRecordDTO> getKIAScore() {
		ArrayList<TeamRecordDTO> KIAScore = tDao.getKIAScore(trDto);
		return KIAScore;
	}

	//KIA의 누적 실점
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

}
