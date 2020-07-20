package com.ggs.DAO;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggs.DTO.NoticeDTO;
import com.ggs.DTO.ReplyDTO;

@Repository
public class NoticeDAO {
	
	@Autowired
	SqlSessionTemplate session;

	public int noticePage() {
		return (Integer)session.selectOne("notice.noticePage");
	}

	public ArrayList<NoticeDTO> noticeList(NoticeDTO nDTO) {
		return (ArrayList)session.selectList("notice.noticeList", nDTO);
	}

	public ArrayList<NoticeDTO> noticeDetail(int writeno) {
		return (ArrayList)session.selectList("notice.noticeDetail", writeno);
	}

	public void noticeWrite(NoticeDTO nDTO) {
		session.insert("notice.noticeWrite", nDTO);
	}

	public void noticeUpdate(NoticeDTO nDTO) {
		session.update("notice.noticeUpdate", nDTO);
	}

	public void noticeDelete(int writeno) {
		session.update("notice.noticeDelete", writeno);
	}

	public void hit(NoticeDTO nDTO) {
		session.update("notice.hit", nDTO);
	}

	public ArrayList<NoticeDTO> noticeSearch(NoticeDTO nDTO) {
		return (ArrayList)session.selectList("notice.noticeSearch", nDTO);
	}

	public int SearchPage(NoticeDTO nDTO) {
		return (Integer)session.selectOne("notice.SearchPage", nDTO);
	}

	public ArrayList<ReplyDTO> noticeReply(ReplyDTO rDTO) {
		return (ArrayList)session.selectList("notice.noticeReply", rDTO);
	}

	public void replyAdd(ReplyDTO rDTO) {
		session.insert("notice.replyAdd", rDTO);
	}

	public int ReplyPage(int writeno) {
		return (Integer)session.selectOne("notice.ReplyPage", writeno);
	}

}
