package com.ggs.column;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggs.DAO.ColumnDAO;
import com.ggs.DTO.BoardDTO;
import com.ggs.util.ColumnPageUtil;


@Service
public class ColumnService {

	@Autowired
	ColumnDAO cDAO;
	

//	//검색
//	public ArrayList searchBoard(PageUtil pInfo, String target, String word) {
//		int	start = (pInfo.getNowPage() - 1) * pInfo.getLineCount() + 1;
//		int	end = start + pInfo.getLineCount() - 1;
//		
//		BoardDTO bDTO = new BoardDTO();
//		bDTO.setTarget(target);
//		bDTO.setWord(word);
//		bDTO.setStart(start);
//		bDTO.setEnd(end);
//		
//		ArrayList list = cDAO.searchBoard(bDTO);
//		
//		return list;
//	}
	
	//삭제하기
	public void delBoard(BoardDTO bDTO) {
		cDAO.delBoard(bDTO);
		System.out.println("서비스에 삭제요청함수 delBoard()");
	}
	

	
	//글 수정하기
	public void modifyBoard(BoardDTO bDTO) {
			cDAO.modifyBoard(bDTO);
			System.out.println("service 글수정 modifyBoard  "+bDTO.getWriteno());
		}
	

	
	// 상세보기
	public BoardDTO detailView(int writeno) {
		BoardDTO bDTO = cDAO.detailView(writeno);
		System.out.println("column service에 detailView()"+bDTO);
		return bDTO;
	}
	
//	조회수증가
	public void viewsUpdate(int writeno, HttpSession session) {

			boolean isUpdate = false;
			ArrayList viewsList = (ArrayList)session.getAttribute("VIEWSUPDATE");
	//  (아무글도안본상태에서)최초로  상세보기를 한 경우 -> Update 진행
			if(viewsList==null || viewsList.size()==0) {
				isUpdate = true;
				viewsList = new ArrayList();
				viewsList.add(writeno);
				session.setAttribute("VIEWSUPDATE", viewsList);
			}else if(!viewsList.contains(writeno)) {
//				상세보기를 한적이 있는경우
//				--해당글번호의 상세보기를 하지 않은 경우	-> Update 진행
				isUpdate = true;
				viewsList.add(writeno);
				session.setAttribute("VIEWSUPDATE", viewsList);
			}else {
//				--해당글번호의 상세보기를 한 경우 -> Update 진행x. DAO에서 업데이트함수 호출x
				isUpdate = false;
			}

				if(isUpdate==true) {
				cDAO.viewsUpdate(writeno);
			}
				System.out.println("cService에서 viewsUpdate() 함");
		}
	
	//목록보기
	public ArrayList<BoardDTO> getCBoard(ColumnPageUtil pInfo){
	
	int start = (pInfo.getNowPage()-1)*pInfo.getLineCount()+1 ; //+1->최소1페이지
	int end = start+pInfo.getLineCount()-1;			//2+3-1 
	
	BoardDTO bDTO = new BoardDTO();
	bDTO.setStart(start-1);
	
	ArrayList<BoardDTO> list = 
			cDAO.getCBoard(bDTO);
	
	return list;
	
	}
	
	//페이징관련정보를 세팅하는 함수
	public ColumnPageUtil getPageInfo(int nowPage) {
	int totalCount = cDAO.getTotalCnt();

	ColumnPageUtil pInfo = new ColumnPageUtil(nowPage, totalCount);

	return pInfo;  
	}
	
	
	//글쓰기 처리
	public void insertBoard(BoardDTO bDTO,HttpSession session) {
		System.out.println("columnService의 insertBoard() bDto="+bDTO);
		String id = (String)session.getAttribute("UID");
		
		bDTO.setId(id);
		cDAO.insertBoard(bDTO,"column");
		
	}
	
}