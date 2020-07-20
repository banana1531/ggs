package com.ggs.notice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggs.DAO.NoticeDAO;
import com.ggs.DTO.NoticeDTO;
import com.ggs.DTO.ReplyDTO;
import com.ggs.util.NoticePageUtil;

@Service
public class NoticeService {
	
	@Autowired
	NoticeDAO nDAO;

	public NoticePageUtil noticePage(int nowPage) {
		int totalCount = nDAO.noticePage();
		NoticePageUtil pInfo = new NoticePageUtil(nowPage, totalCount);
		return pInfo;
	}

	public ArrayList<NoticeDTO> noticeList(NoticePageUtil pInfo) {
		int start = (pInfo.getNowPage() - 1) * pInfo.getLineCount() + 1;
		int end = start + pInfo.getLineCount() - 1;
		NoticeDTO nDTO = new NoticeDTO();
		nDTO.setStart(start-1);
		nDTO.setEnd(end);
		ArrayList<NoticeDTO> noticeList = nDAO.noticeList(nDTO); 
		return noticeList;
	}

	public ArrayList<NoticeDTO> noticeDetail(int writeno, int nowPage) {
		ArrayList<NoticeDTO> NoticeDetail = nDAO.noticeDetail(writeno);
		NoticeDetail.get(0).setNowPage(nowPage);
		return NoticeDetail;
	}

	public void noticeWrite(String id, String title, String content) {
		NoticeDTO nDTO = new NoticeDTO();
		nDTO.setId(id);
		nDTO.setTitle(title);
		nDTO.setContent(content);
		nDAO.noticeWrite(nDTO);
	}

	public ArrayList<NoticeDTO> noticeUpdateForm(int writeno) {
		ArrayList<NoticeDTO> noticeUpdateForm = nDAO.noticeDetail(writeno);
		return noticeUpdateForm;
	}

	public void noticeUpdate(int writeno, String title, String content) {
		NoticeDTO nDTO = new NoticeDTO();
		nDTO.setWriteno(writeno);
		nDTO.setTitle(title);
		nDTO.setContent(content);
		nDAO.noticeUpdate(nDTO);
	}

	public void noticeDelete(int writeno) {
		nDAO.noticeDelete(writeno);
	}

	public void hit(int views, int writeno) {
		NoticeDTO nDTO = new NoticeDTO();
		nDTO.setViews(views);
		nDTO.setWriteno(writeno);
		nDAO.hit(nDTO);
	}

	public ArrayList<NoticeDTO> noticeSearch(String searchType, String keyword, NoticePageUtil pInfo) {
		int start = (pInfo.getNowPage() - 1) * pInfo.getLineCount() + 1;
		int end = start + pInfo.getLineCount() - 1;
		NoticeDTO nDTO = new NoticeDTO();
		nDTO.setStart(start-1);
		nDTO.setEnd(end);
		nDTO.setSearchType(searchType);
		nDTO.setKeyword(keyword);
		ArrayList<NoticeDTO> noticeSearch = nDAO.noticeSearch(nDTO);
		return noticeSearch;
	}

	public NoticePageUtil SearchPage(String searchType, String keyword, int nowPage) {
		NoticeDTO nDTO = new NoticeDTO();
		nDTO.setSearchType(searchType);
		nDTO.setKeyword(keyword);
		int totalCount = nDAO.SearchPage(nDTO);
		System.out.println(totalCount);
		NoticePageUtil pInfo = new NoticePageUtil(nowPage, totalCount);
		return pInfo;
	}

	public ArrayList<ReplyDTO> noticeReply(int writeno, NoticePageUtil pInfo) {
		int start = (pInfo.getNowPage() - 1) * pInfo.getLineCount() + 1;
		int end = start + pInfo.getLineCount() - 1;
		ReplyDTO rDTO = new ReplyDTO();
		rDTO.setStart(start-1);
		rDTO.setEnd(end);
		rDTO.setWno(writeno);
		ArrayList<ReplyDTO> noticeReply = nDAO.noticeReply(rDTO);
		return noticeReply;
	}

	public void replyAdd(String id, String content, int wno) {
		ReplyDTO rDTO = new ReplyDTO();
		rDTO.setId(id);
		rDTO.setContent(content);
		rDTO.setWno(wno);
		nDAO.replyAdd(rDTO);
	}

	public NoticePageUtil ReplyPage(int nowPage2, int writeno) {
		int totalCount = nDAO.ReplyPage(writeno);
		NoticePageUtil pInfo = new NoticePageUtil(nowPage2, totalCount);
		return pInfo;
	}

}
