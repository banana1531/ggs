package com.ggs.DAO;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggs.DTO.BoardDTO;

@Repository
public class InforErrorBoardDAO {
	
	@Autowired
	private SqlSessionTemplate session;
	
	
	//최근 등록된 글 가져오기 - 자유게시판, 정보오류 게시판
	public List<BoardDTO> getBoardList(){
			
		return session.selectList("FreeBoard.getRecentList");
	}
	
	//최근 내가 쓴글 5개 가져오기
	public List<BoardDTO> getMyArticle(String uid) {			
		List<BoardDTO> list = session.selectList("memberMapper.board",uid);
		System.out.println(list.toString());
				
		return list;
	}
	
	//게시판 글 노출/비노출 업데이트 하기
	public int updateBoard(BoardDTO dto) {
		if(dto.getBoardname().equals("freeboard"))
			return session.update("FreeBoard.updateFreeboard", dto);
		else 
			return session.update("FreeBoard.updateinforerrorboard", dto);	
	}

	//글 목록 가져오기
	public ArrayList<BoardDTO> boardList(BoardDTO dto) {
		return null;
	}
	
	//글 상세 내용 가져오기
	public BoardDTO boardDetail(BoardDTO boardDTO) {
		System.out.println("InforErrorBoardDAO.boardDetail");
		return session.selectOne("inforErrorBoard.boardDetail", boardDTO);
	}

	//글 등록하기
	public int boardWrite(BoardDTO boardDTO) {
		return session.insert("inforErrorBoard.boardWrite", boardDTO);
	}
	
	//글 수정하기
	public int boardUpdate(BoardDTO boardDTO) {
		return session.update("inforErrorBoard.boardUpdate", boardDTO);
	}
	
	//글 삭제
		public int boardDelete(BoardDTO boardDTO) {
			return session.delete("inforErrorBoard.boardDelete", boardDTO);
		}
}
