package com.ggs.NewBoard;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggs.DAO.NewBoardDAO;
import com.ggs.DTO.FreeboardDTO;
import com.ggs.util.NoticePageUtil;

@Service
public class NewBoardService {

	@Autowired
	NewBoardDAO nbDAO;
	
	public NoticePageUtil nbPage(int nowPage) {
		int totalCount = nbDAO.nbPage();
		NoticePageUtil pInfo = new NoticePageUtil(nowPage, totalCount);
		return pInfo;
	}

	public ArrayList<FreeboardDTO> nbList(NoticePageUtil pInfo) {
		int start = (pInfo.getNowPage() - 1) * pInfo.getLineCount() + 1;
		int end = start + pInfo.getLineCount() - 1;
		FreeboardDTO fbDTO = new FreeboardDTO();
		fbDTO.setStart(start-1);
		fbDTO.setEnd(end);
		ArrayList<FreeboardDTO> nbList = nbDAO.nbList(fbDTO);
		return nbList;
	}

	public FreeboardDTO nbDetail(int writeno) {
		FreeboardDTO nbDetail = nbDAO.nbDetail(writeno);
		return nbDetail;
	}

	public void write(String id, String title, String content) {
		FreeboardDTO fbDTO = new FreeboardDTO();
		fbDTO.setId(id);
		fbDTO.setTitle(title);
		fbDTO.setContent(content);
		nbDAO.nbwrite(fbDTO);
		
	}

	public FreeboardDTO nbUpdate(int writeno) {
		FreeboardDTO nbUpdate = nbDAO.nbDetail(writeno);
		return nbUpdate;
	}

	public void update(int writeno, String title, String content) {
		FreeboardDTO fbDTO = new FreeboardDTO();
		fbDTO.setWriteno(writeno);
		fbDTO.setTitle(title);
		fbDTO.setContent(content);
		nbDAO.nbupdate(fbDTO);
	}

	public void delete(int writeno) {
		nbDAO.nbdelete(writeno);
	}

	public NoticePageUtil SearchPage(String searchType, String keyword, int nowPage) {
		FreeboardDTO fbDTO = new FreeboardDTO();
		fbDTO.setSearchType(searchType);
		fbDTO.setKeyword(keyword);
		int totalCount = nbDAO.SearchPage(fbDTO);
		NoticePageUtil pInfo = new NoticePageUtil(nowPage, totalCount);
		return pInfo;
	}

	public ArrayList<FreeboardDTO> Search(String searchType, String keyword, NoticePageUtil pInfo) {
		int start = (pInfo.getNowPage() - 1) * pInfo.getLineCount() + 1;
		int end = start + pInfo.getLineCount() - 1;
		FreeboardDTO fbDTO = new FreeboardDTO();
		fbDTO.setStart(start-1);
		fbDTO.setEnd(end);
		fbDTO.setSearchType(searchType);
		fbDTO.setKeyword(keyword);
		ArrayList<FreeboardDTO> Search = nbDAO.Search(fbDTO);
		return Search;
	}

	public void hits(int writeno, HttpSession session) {
		//첫번째 파라미터 bno는 특정글만 조회수증가를 해야하므로 필요
		//2번째 파라미터 HttpSession는  조회수무한증가를 막기위해 필요
		//1,2,50,33번 게시물의 상세보기를 하였다면  글번호를 누적저장시켜야한다
		//==>ArrayList를 이용하여 관리  list.add(1);  list.add(2); ...
				
		//update진행여부를 기억하는 변수
		boolean isUpdate  = false;
		ArrayList cntList = (ArrayList)session.getAttribute("CNTUPDATE");
		
		//완전 찐최초로  상세보기를 한경우=>update진행
		if(cntList==null || cntList.size()==0) {
			isUpdate  = true;
			cntList = new ArrayList();
			cntList.add(writeno);
			session.setAttribute("CNTUPDATE", cntList);
		}else if( !cntList.contains(writeno) ) {//상세보기를 한적이 있는 경우
			//	해당글번호의 상세보기를 하지x 경우=>update진행
			isUpdate  = true;
			cntList.add(writeno);
			session.setAttribute("CNTUPDATE", cntList);
		}else {	//	해당글번호의 상세보기를 한 경우      =>update진행x
			isUpdate  = false;
		}
		
		if(isUpdate==true) {
			nbDAO.hits(writeno);
		}
	}

}
