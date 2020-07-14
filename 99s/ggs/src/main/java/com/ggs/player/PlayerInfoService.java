package com.ggs.player;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggs.DAO.PlayerInfoDAO;
import com.ggs.DTO.PlayerInfoDTO;
import com.ggs.DTO.PlayerRecordDTO;
import com.ggs.DTO.TeamRecordDTO;
import com.ggs.util.PageUtil;



@Service
public class PlayerInfoService {
	
	@Autowired
	PlayerInfoDAO pDao;

	public PageUtil getKIACnt(int nowPage) {
		int totalCount = pDao.getKIACnt();
		PageUtil pInfo = new PageUtil(nowPage, totalCount);
		return pInfo;
	}

	public ArrayList<PlayerInfoDTO> getListKIA(PageUtil pInfo) {
		int start = (pInfo.getNowPage() - 1) * pInfo.getLineCount() + 1;
		int end = start + pInfo.getLineCount() - 1;
		PlayerInfoDTO pDto = new PlayerInfoDTO();
		pDto.setStart(start-1);
		pDto.setEnd(end);
		ArrayList<PlayerInfoDTO> getListKIA = pDao.getListKIA(pDto);
		for(int i=0; i<=4; i++) {
			float Height = (float)getListKIA.get(i).getHeight();
			float Weight = (float)getListKIA.get(i).getWeight();
			int bmi = (int)(Weight/((Height/100)*(Height/100)));
			getListKIA.get(i).setBmi(bmi);
		}
		return getListKIA;
	}

	public PageUtil getKTCnt(int nowPage) {
		int totalCount = pDao.getKTCnt();
		PageUtil pInfo = new PageUtil(nowPage, totalCount);
		return pInfo;
	}

	public ArrayList<PlayerInfoDTO> getListKT(PageUtil pInfo) {
		int start = (pInfo.getNowPage() - 1) * pInfo.getLineCount() + 1;
		int end = start + pInfo.getLineCount() - 1;
		PlayerInfoDTO pDto = new PlayerInfoDTO();
		pDto.setStart(start-1);
		pDto.setEnd(end);
		ArrayList<PlayerInfoDTO> getListKT = pDao.getListKT(pDto);
		for(int i=0; i<=4; i++) {
			float Height = (float)getListKT.get(i).getHeight();
			float Weight = (float)getListKT.get(i).getWeight();
			int bmi = (int)(Weight/((Height/100)*(Height/100)));
			getListKT.get(i).setBmi(bmi);
		}
		return getListKT;
	}

	public PageUtil getLGCnt(int nowPage) {
		int totalCount = pDao.getLGCnt();
		PageUtil pInfo = new PageUtil(nowPage, totalCount);
		return pInfo;
	}

	public ArrayList<PlayerInfoDTO> getListLG(PageUtil pInfo) {
		int start = (pInfo.getNowPage() - 1) * pInfo.getLineCount() + 1;
		int end = start + pInfo.getLineCount() - 1;
		PlayerInfoDTO pDto = new PlayerInfoDTO();
		pDto.setStart(start-1);
		pDto.setEnd(end);
		ArrayList<PlayerInfoDTO> getListLG = pDao.getListLG(pDto);
		for(int i=0; i<=4; i++) {
			float Height = (float)getListLG.get(i).getHeight();
			float Weight = (float)getListLG.get(i).getWeight();
			int bmi = (int)(Weight/((Height/100)*(Height/100)));
			getListLG.get(i).setBmi(bmi);
		}
		return getListLG;
	}

	public PageUtil getNCCnt(int nowPage) {
		int totalCount = pDao.getNCCnt();
		PageUtil pInfo = new PageUtil(nowPage, totalCount);
		return pInfo;
	}

	public ArrayList<PlayerInfoDTO> getListNC(PageUtil pInfo) {
		int start = (pInfo.getNowPage() - 1) * pInfo.getLineCount() + 1;
		int end = start + pInfo.getLineCount() - 1;
		PlayerInfoDTO pDto = new PlayerInfoDTO();
		pDto.setStart(start-1);
		pDto.setEnd(end);
		ArrayList<PlayerInfoDTO> getListNC = pDao.getListNC(pDto);
		for(int i=0; i<=4; i++) {
			float Height = (float)getListNC.get(i).getHeight();
			float Weight = (float)getListNC.get(i).getWeight();
			int bmi = (int)(Weight/((Height/100)*(Height/100)));
			getListNC.get(i).setBmi(bmi);
		}
		return getListNC;
	}

	public PageUtil getSKCnt(int nowPage) {
		int totalCount = pDao.getSKCnt();
		PageUtil pInfo = new PageUtil(nowPage, totalCount);
		return pInfo;
	}

	public ArrayList<PlayerInfoDTO> getListSK(PageUtil pInfo) {
		int start = (pInfo.getNowPage() - 1) * pInfo.getLineCount() + 1;
		int end = start + pInfo.getLineCount() - 1;
		PlayerInfoDTO pDto = new PlayerInfoDTO();
		pDto.setStart(start-1);
		pDto.setEnd(end);
		ArrayList<PlayerInfoDTO> getListSK = pDao.getListSK(pDto);
		for(int i=0; i<=4; i++) {
			float Height = (float)getListSK.get(i).getHeight();
			float Weight = (float)getListSK.get(i).getWeight();
			int bmi = (int)(Weight/((Height/100)*(Height/100)));
			getListSK.get(i).setBmi(bmi);
		}
		return getListSK;
	}

	public PageUtil getDSCnt(int nowPage) {
		int totalCount = pDao.getDSCnt();
		PageUtil pInfo = new PageUtil(nowPage, totalCount);
		return pInfo;
	}

	public ArrayList<PlayerInfoDTO> getListDS(PageUtil pInfo) {
		int start = (pInfo.getNowPage() - 1) * pInfo.getLineCount() + 1;
		int end = start + pInfo.getLineCount() - 1;
		PlayerInfoDTO pDto = new PlayerInfoDTO();
		pDto.setStart(start-1);
		pDto.setEnd(end);
		ArrayList<PlayerInfoDTO> getListDS = pDao.getListDS(pDto);
		for(int i=0; i<=4; i++) {
			float Height = (float)getListDS.get(i).getHeight();
			float Weight = (float)getListDS.get(i).getWeight();
			int bmi = (int)(Weight/((Height/100)*(Height/100)));
			getListDS.get(i).setBmi(bmi);
		}
		return getListDS;
	}

	public PageUtil getLTCnt(int nowPage) {
		int totalCount = pDao.getLTCnt();
		PageUtil pInfo = new PageUtil(nowPage, totalCount);
		return pInfo;
	}

	public ArrayList<PlayerInfoDTO> getListLT(PageUtil pInfo) {
		int start = (pInfo.getNowPage() - 1) * pInfo.getLineCount() + 1;
		int end = start + pInfo.getLineCount() - 1;
		PlayerInfoDTO pDto = new PlayerInfoDTO();
		pDto.setStart(start-1);
		pDto.setEnd(end);
		ArrayList<PlayerInfoDTO> getListLT = pDao.getListLT(pDto);
		for(int i=0; i<=4; i++) {
			float Height = (float)getListLT.get(i).getHeight();
			float Weight = (float)getListLT.get(i).getWeight();
			int bmi = (int)(Weight/((Height/100)*(Height/100)));
			getListLT.get(i).setBmi(bmi);
		}
		return getListLT;
	}

	public PageUtil getSSCnt(int nowPage) {
		int totalCount = pDao.getSSCnt();
		PageUtil pInfo = new PageUtil(nowPage, totalCount);
		return pInfo;
	}

	public ArrayList<PlayerInfoDTO> getListSS(PageUtil pInfo) {
		int start = (pInfo.getNowPage() - 1) * pInfo.getLineCount() + 1;
		int end = start + pInfo.getLineCount() - 1;
		PlayerInfoDTO pDto = new PlayerInfoDTO();
		pDto.setStart(start-1);
		pDto.setEnd(end);
		ArrayList<PlayerInfoDTO> getListSS = pDao.getListSS(pDto);
		for(int i=0; i<=4; i++) {
			float Height = (float)getListSS.get(i).getHeight();
			float Weight = (float)getListSS.get(i).getWeight();
			int bmi = (int)(Weight/((Height/100)*(Height/100)));
			getListSS.get(i).setBmi(bmi);
		}
		return getListSS;
	}

	public PageUtil getKUCnt(int nowPage) {
		int totalCount = pDao.getKUCnt();
		PageUtil pInfo = new PageUtil(nowPage, totalCount);
		return pInfo;
	}

	public ArrayList<PlayerInfoDTO> getListKU(PageUtil pInfo) {
		int start = (pInfo.getNowPage() - 1) * pInfo.getLineCount() + 1;
		int end = start + pInfo.getLineCount() - 1;
		PlayerInfoDTO pDto = new PlayerInfoDTO();
		pDto.setStart(start-1);
		pDto.setEnd(end);
		ArrayList<PlayerInfoDTO> getListKU = pDao.getListKU(pDto);
		for(int i=0; i<=4; i++) {
			float Height = (float)getListKU.get(i).getHeight();
			float Weight = (float)getListKU.get(i).getWeight();
			int bmi = (int)(Weight/((Height/100)*(Height/100)));
			getListKU.get(i).setBmi(bmi);
		}
		return getListKU;
	}

	public PageUtil getHHCnt(int nowPage) {
		int totalCount = pDao.getHHCnt();
		PageUtil pInfo = new PageUtil(nowPage, totalCount);
		return pInfo;
	}

	public ArrayList<PlayerInfoDTO> getListHH(PageUtil pInfo) {
		int start = (pInfo.getNowPage() - 1) * pInfo.getLineCount() + 1;
		int end = start + pInfo.getLineCount() - 1;
		PlayerInfoDTO pDto = new PlayerInfoDTO();
		pDto.setStart(start-1);
		pDto.setEnd(end);
		ArrayList<PlayerInfoDTO> getListHH = pDao.getListHH(pDto);
		for(int i=0; i<=4; i++) {
			float Height = (float)getListHH.get(i).getHeight();
			float Weight = (float)getListHH.get(i).getWeight();
			int bmi = (int)(Weight/((Height/100)*(Height/100)));
			getListHH.get(i).setBmi(bmi);
		}
		return getListHH;
	}

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



}
