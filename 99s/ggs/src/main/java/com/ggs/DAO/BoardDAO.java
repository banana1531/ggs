package com.ggs.DAO;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggs.DTO.BoardDTO;
import com.ggs.DTO.NoticeDTO;

@Repository
public class BoardDAO {
	
	@Autowired
	SqlSessionTemplate session;

	public int noticePage() {
		return (Integer)session.selectOne("notice.noticePage");
	}

	public ArrayList<BoardDTO> boardList(BoardDTO nDTO) {
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

}
