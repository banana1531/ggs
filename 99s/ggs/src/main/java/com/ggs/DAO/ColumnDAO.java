package com.ggs.DAO;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggs.DTO.BoardDTO;


@Repository
public class ColumnDAO {

	//자동주입
	@Autowired
	private SqlSessionTemplate session;
	

	
	//삭제하기
	public void delBoard(BoardDTO bDTO) {
		session.update("column.delBoard",bDTO);
		System.out.println("ColumnDAO에 삭제요청함수 delBoard() 왔니");
	}
	

	
//	글 수정하기
	public void modifyBoard(BoardDTO bDTO) {
			session.update("column.modifyBoard", bDTO);
			System.out.println("DAO 글수정 modifyBoard  "+bDTO.getWriteno());
	}
	

//	상세보기
	public BoardDTO detailView(int writeno) {
		System.out.println("columnDAO에 detailView"+writeno);
		return (BoardDTO)session.selectOne("column.detailView",writeno);
	}
	
//	조회수증가
	public void viewsUpdate(int writeno) {
		session.update("column.viewsUpdate",writeno);
		System.out.println("ColumnDAO 에서 viewsUpdate()진입");
	}
	
	//목록조회
	public ArrayList getCBoard(BoardDTO bDTO) {
		return (ArrayList)session.selectList("column.cBoard", bDTO); 			
		//파라미터:start와 end -> fbDTO에서 전달받아서 전해줌
	}
	
//	전체게시물 수 조회
	public int getTotalCnt() {
		//select 실행결과로 리턴받는행수가 한개이면 selectOne()
		//실행받는행수가한개이상이면 selectList()
		return (Integer)session.selectOne("column.totalCnt");
	}
	
	//글쓰기처리
	public void insertBoard(BoardDTO bDTO, String hint) {
		//session.insert(String 실행할 쿼리문);
		//session.insert(String 실행할 쿼리문, 쿼리문안의 parameter);
		//session.insert("네임스페이스명.쿼리문id값", Dto);
		if(hint.equals("column")) {
			session.insert("column.insertBoard", bDTO); //fileboard에 인서트
		}
		
	}
	
//	//검색- 페이지정보처리
//	public int searchCount(BoardDTO bDTO) {
//		return (Integer) getSqlSession().selectOne("column.searchCount", bDTO);
//	}
//
//
//	//검색
//	public ArrayList searchBoard(BoardDTO bDTO) {
//		return (ArrayList)session.selectList("column.boardSearch", bDTO);
//	}
	
	
}