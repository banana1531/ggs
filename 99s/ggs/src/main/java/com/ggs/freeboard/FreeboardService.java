package com.ggs.freeboard;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggs.DAO.FreeBoardDAO;
import com.ggs.DTO.FreeboardDTO;
import com.ggs.DTO.ReplyDTO;
import com.ggs.util.NoticePageUtil;

@Service
public class FreeboardService {

	@Autowired
	private FreeBoardDAO fbDAO;
	
	public NoticePageUtil freeboardPage(int nowPage) {
		int totalCount = fbDAO.freeboardPage();
		NoticePageUtil pInfo = new NoticePageUtil(nowPage, totalCount);
		return pInfo;
	}

	public ArrayList<FreeboardDTO> freeboardList(NoticePageUtil pInfo) {
		int start = (pInfo.getNowPage() - 1) * pInfo.getLineCount() + 1;
		int end = start + pInfo.getLineCount() - 1;
		FreeboardDTO fbDTO = new FreeboardDTO();
		fbDTO.setStart(start-1);
		fbDTO.setEnd(end);
		ArrayList<FreeboardDTO> freeboardList = fbDAO.freeboardList(fbDTO);
		return freeboardList;
	}

	public void hit(int views, int writeno) {
		FreeboardDTO fbDTO = new FreeboardDTO();
		fbDTO.setViews(views);
		fbDTO.setWriteno(writeno);
		fbDAO.hit(fbDTO);
	}

	public ArrayList<FreeboardDTO> freeboardDetail(int writeno, int nowPage) {
		ArrayList<FreeboardDTO> freeboardDetail = fbDAO.freeboardDetail(writeno);
		freeboardDetail.get(0).setNowPage(nowPage);
		return freeboardDetail;
	}

	public NoticePageUtil ReplyPage(int nowPage2, int writeno) {
		int totalCount = fbDAO.ReplyPage(writeno);
		NoticePageUtil pInfo = new NoticePageUtil(nowPage2, totalCount);
		return pInfo;
	}

	public ArrayList<ReplyDTO> freeboardReply(int writeno, NoticePageUtil pInfo) {
		int start = (pInfo.getNowPage() - 1) * pInfo.getLineCount() + 1;
		int end = start + pInfo.getLineCount() - 1;
		ReplyDTO rDTO = new ReplyDTO();
		rDTO.setStart(start-1);
		rDTO.setEnd(end);
		rDTO.setWno(writeno);
		ArrayList<ReplyDTO> freeboardReply = fbDAO.freeboardReply(rDTO);
		return freeboardReply;
	}

	public void replyAdd(String id, String content, int wno) {
		ReplyDTO rDTO = new ReplyDTO();
		rDTO.setId(id);
		rDTO.setContent(content);
		rDTO.setWno(wno);
		fbDAO.replyAdd(rDTO);
	}

	public NoticePageUtil SearchPage(String searchType, String keyword, int nowPage) {
		FreeboardDTO fbDTO = new FreeboardDTO();
		fbDTO.setSearchType(searchType);
		fbDTO.setKeyword(keyword);
		int totalCount = fbDAO.SearchPage(fbDTO);
		NoticePageUtil pInfo = new NoticePageUtil(nowPage, totalCount);
		return pInfo;
	}

	public ArrayList<FreeboardDTO> freeboardSearch(String searchType, String keyword, NoticePageUtil pInfo) {
		int start = (pInfo.getNowPage() - 1) * pInfo.getLineCount() + 1;
		int end = start + pInfo.getLineCount() - 1;
		FreeboardDTO fbDTO = new FreeboardDTO();
		fbDTO.setStart(start-1);
		fbDTO.setEnd(end);
		fbDTO.setSearchType(searchType);
		fbDTO.setKeyword(keyword);
		ArrayList<FreeboardDTO> freeboardSearch = fbDAO.freeboardSearch(fbDTO);
		return freeboardSearch;
	}

	public void freeboardWrite(String id, String title, String content) {
		FreeboardDTO fbDTO = new FreeboardDTO();
		fbDTO.setId(id);
		fbDTO.setTitle(title);
		fbDTO.setContent(content);
		fbDAO.freeboardWrite(fbDTO);
	}

	public ArrayList<FreeboardDTO> freeboardUpdateForm(int writeno) {
		ArrayList<FreeboardDTO> freeboardUpdateForm = fbDAO.freeboardDetail(writeno);
		return freeboardUpdateForm;
	}

	public void freeboardUpdate(int writeno, String title, String content) {
		FreeboardDTO fbDTO = new FreeboardDTO();
		fbDTO.setWriteno(writeno);
		fbDTO.setTitle(title);
		fbDTO.setContent(content);
		fbDAO.freeboardUpdate(fbDTO);
	}

	public void freeboardDelete(int writeno) {
		fbDAO.freeboardDelete(writeno);
	}

}
