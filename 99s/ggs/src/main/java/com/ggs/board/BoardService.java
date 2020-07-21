package com.ggs.board;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggs.DAO.FreeBoardDAO;
import com.ggs.DAO.InforErrorBoardDAO;
import com.ggs.DAO.NoticeDAO;
import com.ggs.DTO.BoardDTO;
import com.ggs.DTO.NoticeDTO;
import com.ggs.util.NoticePageUtil;

@Service
public class BoardService {
	
	@Autowired
	private FreeBoardDAO freeBoardDAO;
	
	@Autowired
	private InforErrorBoardDAO inforErrorboardDAO;
	
	@Autowired
	private NoticeDAO nDAO;
	
	//목록 가져오기
	public List<BoardDTO> boardList(int nowPage, String boardname) {
		BoardDTO dto = new BoardDTO();		
		dto.setStart((nowPage-1)*10);
		dto.setBoardname(boardname);
		if(boardname.equals("freeboard"))
			return freeBoardDAO.boardList(dto);
		else
			return inforErrorboardDAO.boardList(dto);
	}
	
	
	//글 상세 내용 가져오기
	public BoardDTO boardDetail(BoardDTO boardDTO, String hit) {
		System.out.println("boardDTO="+boardDTO);
		if(boardDTO.getBoardname().equals("freeboard"))
			return freeBoardDAO.boardDetail(boardDTO);
		else
			return inforErrorboardDAO.boardDetail(boardDTO);
	}
	
	
	// 글 등록하기
	public int boardWrite(BoardDTO boardDTO) {
		if(boardDTO.getBoardname().equals("freeboard"))
			return freeBoardDAO.boardWrite(boardDTO);
		else
			return inforErrorboardDAO.boardWrite(boardDTO);
	}
	
	//글 수정하기
	public int boardUpdate(BoardDTO boardDTO) {
		if(boardDTO.getBoardname().equals("freeboard"))
			return freeBoardDAO.boardUpdate(boardDTO);
		else
			return inforErrorboardDAO.boardUpdate(boardDTO);
	}
	
	//글 삭제
	public int boardDelete(BoardDTO boardDTO) {
		if(boardDTO.getBoardname().equals("freeboard"))
			return freeBoardDAO.boardDelete(boardDTO);
		else
			return inforErrorboardDAO.boardDelete(boardDTO);
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

}
