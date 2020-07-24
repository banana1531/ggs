package com.ggs.column;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggs.DAO.ColumnDAO;
import com.ggs.DTO.BoardDTO;
import com.ggs.DTO.ReplyDTO;
import com.ggs.util.ColumnPageUtil;



@Service
public class ColumnService {

	@Autowired
	ColumnDAO cDAO;
	
	public ArrayList<ReplyDTO> cBoardReply(int writeno, ColumnPageUtil cPinfo) {
		int start = (cPinfo.getNowPage() - 1) * cPinfo.getLineCount() + 1;
		int end = start + cPinfo.getLineCount() - 1;
		ReplyDTO rDTO = new ReplyDTO();
		rDTO.setStart(start-1);
		rDTO.setEnd(end);
		rDTO.setWno(writeno);
		ArrayList<ReplyDTO> cBoardReply = cDAO.cBoardReply(rDTO);
		
		return cBoardReply;
	}

	//댓글추가
	public void replyAdd(String id, String content, int wno) {
		System.out.println("1column서비스 replyAdd 왔니");
		ReplyDTO rDTO = new ReplyDTO();
		rDTO.setId(id);
		rDTO.setContent(content);
		rDTO.setWno(wno);
		cDAO.replyAdd(rDTO);
		System.out.println("2column서비스 replyAdd 왔니");
	}

	public ColumnPageUtil replyPage(int nowPage2, int writeno) {
		int totalCount = cDAO.replyPage(writeno);
		ColumnPageUtil cPinfo = new ColumnPageUtil(nowPage2, totalCount);
		return cPinfo;
	}
	
	public ColumnPageUtil searchPage(String searchType, String keyword, int nowPage) {
		BoardDTO bDTO = new BoardDTO();
		bDTO.setSearchType(searchType);
		bDTO.setKeyword(keyword);
		int totalCount = cDAO.searchPage(bDTO);
		ColumnPageUtil cPinfo = new ColumnPageUtil(nowPage, totalCount);
		return cPinfo;
	}
	
	public ArrayList<BoardDTO> cBoardSearch(String searchType, String keyword, ColumnPageUtil cPinfo) {
		int start = (cPinfo.getNowPage() - 1) * cPinfo.getLineCount() + 1;
		int end = start + cPinfo.getLineCount() - 1;
		BoardDTO bDTO = new BoardDTO();
		bDTO.setStart(start-1);
		bDTO.setEnd(end);
		bDTO.setSearchType(searchType);
		bDTO.setKeyword(keyword);
		ArrayList<BoardDTO> cBoardSearch = cDAO.cBoardSearch(bDTO);
		
		return cBoardSearch;
	}
	
	public void hit(int views, int writeno) {
		BoardDTO bDTO = new BoardDTO();
		bDTO.setViews(views);
		bDTO.setWriteno(writeno);
		cDAO.hit(bDTO);
	}
	
	public void cBoardDelete(int writeno) {
		cDAO.cBoardDelete(writeno);
	}
	
	public ArrayList<BoardDTO> cBoardUpdateFrm(int writeno) {
		ArrayList<BoardDTO> cBoardUpdateFrm = cDAO.cBoardDetail(writeno);
		return cBoardUpdateFrm;
	}

	public void cBoardUpdate(int writeno, String title, String content) {
		BoardDTO bDTO = new BoardDTO();
		bDTO.setWriteno(writeno);
		bDTO.setTitle(title);
		bDTO.setContent(content);
		cDAO.cBoardUpdate(bDTO);
	}
	
	public ArrayList<BoardDTO> cBoardDetail(int writeno, int nowPage) {
		ArrayList<BoardDTO> cBoardDetail = cDAO.cBoardDetail(writeno);
		cBoardDetail.get(0).setNowPage(nowPage);
		return cBoardDetail;
	}
	
	//글쓰기
	public void cBoardWrite(String title, String content, HttpSession session) {
		BoardDTO bDTO = new BoardDTO();
		String id = (String)session.getAttribute("UID");
		System.out.println("1 columnService의 cBoardWrite() ="+id);
		bDTO.setTitle(title);
		bDTO.setContent(content);
		bDTO.setId(id);
		cDAO.cBoardWrite(bDTO);
		System.out.println("2 columnService의 cBoardWrite() ="+id);
	}
	
	public ColumnPageUtil cBoardPage(int nowPage) {
		int totalCount = cDAO.cBoardPage();
		ColumnPageUtil cPinfo = new ColumnPageUtil(nowPage, totalCount);
		return cPinfo;
	}

	public ArrayList<BoardDTO> cBoardList(ColumnPageUtil cPinfo) {
		int start = (cPinfo.getNowPage() - 1) * cPinfo.getLineCount() + 1;
		int end = start + cPinfo.getLineCount() - 1;
		BoardDTO bDTO = new BoardDTO();
		bDTO.setStart(start-1);
		bDTO.setEnd(end);
		ArrayList<BoardDTO> cBoardList = cDAO.cBoardList(bDTO);
		
		return cBoardList;
	}



	
}