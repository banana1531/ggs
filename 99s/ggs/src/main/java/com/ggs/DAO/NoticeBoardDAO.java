package com.ggs.notice;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeBoardDAO {

	@Autowired
	private SqlSessionTemplate session;
	// 목록조회
	public ArrayList getListView(NoticeBoardDTO nbDTO) {
		System.out.println("목록조회 DAO");
		return (ArrayList) session.selectList("NoticeBoard.listView", nbDTO);
	}

	// 전체게시물 수 조회
	public int getTotalCnt() {
		System.out.println("DAO--------------------------------------");
		int k = session.selectOne("NoticeBoard.totalCnt");
		return k;
	}
	
	// 상세보기
	public NoticeBoardDTO detailView(int writerno) {
		return (NoticeBoardDTO)session.selectOne("NoticeBoard.detailView", writerno);
	}

}
