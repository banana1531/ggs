package com.ggs.DAO;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggs.DTO.BoardDTO;
import com.ggs.DTO.FreeboardDTO;
import com.ggs.DTO.ReplyDTO;

@Repository
public class FreeBoardDAO {
	
	@Autowired
	private SqlSessionTemplate session;
	
	
	public int nbPage() {
		return (Integer)session.selectOne("newboard.nbPage");
	}

	public ArrayList<FreeboardDTO> nbList(FreeboardDTO fbDTO) {
		return (ArrayList)session.selectList("newboard.nbList", fbDTO);
	}

	public FreeboardDTO nbDetail(int writeno) {
		return (FreeboardDTO)session.selectOne("newboard.nbDetail", writeno);
	}

	public void nbwrite(FreeboardDTO fbDTO) {
		session.insert("newboard.nbWrite", fbDTO);
	}

	public void nbupdate(FreeboardDTO fbDTO) {
		session.update("newboard.nbupdate", fbDTO);
	}

	public void nbdelete(int writeno) {
		session.update("newboard.nbdelete", writeno);
	}

	public int SearchPage(FreeboardDTO fbDTO) {
		return (Integer)session.selectOne("newboard.SearchPage", fbDTO);
	}

	public ArrayList<FreeboardDTO> Search(FreeboardDTO fbDTO) {
		return (ArrayList)session.selectList("newboard.Search", fbDTO);
	}

	public void hits(int writeno) {
		session.update("newboard.hits", writeno);
	}

	//최근 등록된 글 가져오기 - 자유게시판, 정보오류 게시판
	public List<BoardDTO> getBoardList() {
		return session.selectList("FreeBoard.getRecentList");
	}

	//게시판 글 노출/비노출 업데이트 하기
	public int updateBoard(BoardDTO dto) {
		if(dto.getBoardname().equals("freeboard"))
			return session.update("FreeBoard.updateFreeboard", dto);
		else 
			return session.update("FreeBoard.updateinforerrorboard", dto);
	}

	//최근 내가 쓴글 5개 가져오기
	public List<BoardDTO> getMyArticle(String uid) {
		List<BoardDTO> list = session.selectList("memberMapper.board",uid);
		System.out.println(list.toString());
		return list;
	}
	
	
}
