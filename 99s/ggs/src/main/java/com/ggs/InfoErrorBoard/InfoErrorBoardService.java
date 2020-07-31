package com.ggs.InfoErrorBoard;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggs.DAO.InfoErrorBoardDAO;
import com.ggs.DTO.FreeboardDTO;
import com.ggs.DTO.InfoErrorBoardDTO;
import com.ggs.DTO.ReplyDTO;
import com.ggs.util.NoticePageUtil;

@Service
public class InfoErrorBoardService {

	@Autowired
	InfoErrorBoardDAO ieDAO;

	public NoticePageUtil InfoErrorBoardPage(int nowPage) {
		int totalCount = ieDAO.InfoErrorBoardPage();
		NoticePageUtil pInfo = new NoticePageUtil(nowPage, totalCount);
		return pInfo;
	}

	public ArrayList<InfoErrorBoardDTO> InfoErrorBoardList(NoticePageUtil pInfo) {
		int start = (pInfo.getNowPage() - 1) * pInfo.getLineCount() + 1;
		int end = start + pInfo.getLineCount() - 1;
		InfoErrorBoardDTO ieDTO = new InfoErrorBoardDTO();
		ieDTO.setStart(start-1);
		ieDTO.setEnd(end);
		ArrayList<InfoErrorBoardDTO> InfoErrorBoardList = ieDAO.InfoErrorBoardList(ieDTO);
		return InfoErrorBoardList;
	}

	public void hit(int views, int writeno) {
		InfoErrorBoardDTO ieDTO = new InfoErrorBoardDTO();
		ieDTO.setViews(views);
		ieDTO.setWriteno(writeno);
		ieDAO.hit(ieDTO);
	}

	public ArrayList<InfoErrorBoardDTO> InfoErrorBoardDetail(int writeno, int nowPage) {
		ArrayList<InfoErrorBoardDTO> InfoErrorBoardDetail = ieDAO.InfoErrorBoardDetail(writeno);
		InfoErrorBoardDetail.get(0).setNowPage(nowPage);
		return InfoErrorBoardDetail;
	}

	public NoticePageUtil ReplyPage(int nowPage2, int writeno) {
		int totalCount = ieDAO.ReplyPage(writeno);
		NoticePageUtil pInfo = new NoticePageUtil(nowPage2, totalCount);
		return pInfo;
	}

	public ArrayList<ReplyDTO> InfoErrorBoardReply(int writeno, NoticePageUtil pInfo) {
		int start = (pInfo.getNowPage() - 1) * pInfo.getLineCount() + 1;
		int end = start + pInfo.getLineCount() - 1;
		ReplyDTO rDTO = new ReplyDTO();
		rDTO.setStart(start-1);
		rDTO.setEnd(end);
		rDTO.setWno(writeno);
		ArrayList<ReplyDTO> freeboardReply = ieDAO.InfoErrorBoardReply(rDTO);
		return freeboardReply;
	}

	public void replyAdd(String id, String content, int wno) {
		ReplyDTO rDTO = new ReplyDTO();
		rDTO.setId(id);
		rDTO.setContent(content);
		rDTO.setWno(wno);
		ieDAO.replyAdd(rDTO);
	}

	public NoticePageUtil SearchPage(String searchType, String keyword, int nowPage) {
		InfoErrorBoardDTO ieDTO = new InfoErrorBoardDTO();
		ieDTO.setSearchType(searchType);
		ieDTO.setKeyword(keyword);
		int totalCount = ieDAO.SearchPage(ieDTO);
		NoticePageUtil pInfo = new NoticePageUtil(nowPage, totalCount);
		return pInfo;
	}

	public ArrayList<InfoErrorBoardDTO> InfoErrorBoardSearch(String searchType, String keyword, NoticePageUtil pInfo) {
		int start = (pInfo.getNowPage() - 1) * pInfo.getLineCount() + 1;
		int end = start + pInfo.getLineCount() - 1;
		InfoErrorBoardDTO ieDTO = new InfoErrorBoardDTO();
		ieDTO.setStart(start-1);
		ieDTO.setEnd(end);
		ieDTO.setSearchType(searchType);
		ieDTO.setKeyword(keyword);
		ArrayList<InfoErrorBoardDTO> InfoErrorBoardSearch = ieDAO.freeboardSearch(ieDTO);
		return InfoErrorBoardSearch;
	}

	public void InfoErrorBoardWrite(String id, String title, String content) {
		InfoErrorBoardDTO ieDTO = new InfoErrorBoardDTO();
		ieDTO.setId(id);
		ieDTO.setTitle(title);
		ieDTO.setContent(content);
		ieDAO.InfoErrorBoardWrite(ieDTO);
	}

	public ArrayList<InfoErrorBoardDTO> InfoErrorBoardUpdateForm(int writeno) {
		ArrayList<InfoErrorBoardDTO> InfoErrorBoardUpdateForm = ieDAO.InfoErrorBoardDetail(writeno);
		return InfoErrorBoardUpdateForm;
	}

	public void InfoErrorBoardUpdate(int writeno, String title, String content) {
		InfoErrorBoardDTO ieDTO = new InfoErrorBoardDTO();
		ieDTO.setWriteno(writeno);
		ieDTO.setTitle(title);
		ieDTO.setContent(content);
		ieDAO.InfoErrorBoardUpdate(ieDTO);
	}

	public void InfoErrorBoardDelete(int writeno) {
		ieDAO.InfoErrorBoardDelete(writeno);
	}
	
}
