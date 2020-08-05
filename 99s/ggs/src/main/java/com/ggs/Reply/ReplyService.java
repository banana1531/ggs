package com.ggs.Reply;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ggs.DAO.ReplyDAO;
import com.ggs.DTO.ReplyDTO;

@Service
public class ReplyService {

	@Inject
	ReplyDAO rDAO;

	//자유게시판 //댓글작성
	public void create(ReplyDTO rDTO) {
		rDAO.create(rDTO);
	}

	//자유게시판 //댓글목록
	public List<ReplyDTO> list(int wno) {
		return rDAO.list(wno);
	}

	//정보오류게시판 //댓글목록
	public List<ReplyDTO> list2(int wno) {
		return rDAO.list2(wno);
	}

	//정보오류게시판 //댓글작성
	public void create2(ReplyDTO rDTO) {
		rDAO.create2(rDTO);
	}
	
	//공지사항 //댓글목록
	public List<ReplyDTO> list3(int wno) {
		return rDAO.list3(wno);
	}
	
	//공지사항 //댓글작성
	public void create3(ReplyDTO rDTO) {
		rDAO.create3(rDTO);
	}
	
}
