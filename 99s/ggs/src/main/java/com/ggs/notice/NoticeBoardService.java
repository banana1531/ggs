package com.ggs.notice;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggs.utill.PageUtil;

//이 클래스는  공지게시판의 요청처리를 하는 서비스클래스이다
//NoticeBoardDAO<->SQL.xml->DB

@Service
public class NoticeBoardService {
	
	@Autowired
	private NoticeBoardDAO nbDAO;

	//페이징관련 정보
	public PageUtil getPageInfo(int nowPage) {
		System.out.println("페이징관련 service");
		int totalCount = nbDAO.getTotalCnt();
//		System.out.println(totalCount);
		PageUtil pInfo = new PageUtil(nowPage, totalCount);
		return pInfo;
	}

	// 해당 페이지에 출력할 목록조회
	public ArrayList<NoticeBoardDTO> getListView(PageUtil pInfo) {
		System.out.println("목록조회 service");

		int start = (pInfo.getNowPage() - 1) * pInfo.getLineCount() + 1;
		int end = start + pInfo.getLineCount() - 1;

		PageUtil pg = new PageUtil(start, end);
		pg.setStartPage(start);
		pg.setEndPage(end);
		
		NoticeBoardDTO nbDTO = new NoticeBoardDTO();

		ArrayList<NoticeBoardDTO> list = nbDAO.getListView(nbDTO);
		return list;
	}

	//상세보기
	public NoticeBoardDTO detailView(int writeno) {
		NoticeBoardDTO nbDTO = nbDAO.detailView(writeno);
		return nbDTO;
	}
}
