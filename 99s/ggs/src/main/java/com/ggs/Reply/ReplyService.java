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

	// 댓글 작성
	public void create(ReplyDTO rDTO) {
		rDAO.create(rDTO);
	}

	// 댓글 목록
	public List<ReplyDTO> list(int wno) {
		return rDAO.list(wno);
	}
	
	
	
}
