package com.ggs.column;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggs.DAO.ColumnDAO;
import com.ggs.DTO.BoardDTO;
import com.ggs.util.PageUtil;


@Service
public class ColumnService {

	@Autowired
	ColumnDAO cDAO;
	
	//파일검색- 페이지정보처리
	public PageUtil getSearchBoard(BoardDTO bDTO, int nowPage) {
		int cnt = cDAO.searchCount(bDTO);
		PageUtil pInfo = new PageUtil(nowPage, cnt);
		//PageUtil객체생성자에서는 내부적으로
		//	한페이지당 보여주고 싶은 게시물의 개수는 3
		//	페이지 이동 기능은 3개까지 지정
		return pInfo;
	}
	
	//파일정보 조회
	public BoardDTO getFileDown(int fno) {
		return (BoardDTO)cDAO.getFileDown(fno);
	}
	
	//검색
	public ArrayList searchBoard(PageUtil pInfo, String target, String word) {
		int	start = (pInfo.getNowPage() - 1) * pInfo.getLineCount() + 1;
		int	end = start + pInfo.getLineCount() - 1;
		
		BoardDTO bDTO = new BoardDTO();
		bDTO.setTarget(target);
		bDTO.setWord(word);
		bDTO.setStart(start);
		bDTO.setEnd(end);
		
		ArrayList list = cDAO.searchBoard(bDTO);
		
		return list;
	}
	
	//삭제하기
	public void delBoard(BoardDTO bDTO) {
		cDAO.delBoard(bDTO);
		System.out.println("서비스에 삭제요청함수 delBoard()");
	}
	
//	글수정하기- 기존 첨부파일정보 삭제 
	public void deleteFileInfo(int no) {
		cDAO.deleteFIleInfo(no);
	}
	
	//글 수정하기 - 기존의 첨부파일 등록 관련
	public void insertFileInfo(BoardDTO bDTO) {
			cDAO.insertBoard(bDTO, "fInfo");
		}
	
	//글 수정하기
	public void modifyBoard(BoardDTO bDTO) {
			cDAO.modifyBoard(bDTO);
		}
	
	//상세보기관련  첨부파일목록조회
	public ArrayList<BoardDTO> getFileInfo(int writeno) {
			ArrayList<BoardDTO> list =cDAO.getFileInfo(writeno);
			return list;
		}
	
	// 상세보기
	public BoardDTO detailView(int writeno) {
		BoardDTO bDTO = cDAO.detailView(writeno);
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
	public ArrayList<BoardDTO> getCBoard(PageUtil pInfo){
	
	int start = (pInfo.getNowPage()-1)*pInfo.getLineCount()+1 ; //+1->최소1페이지
	int end = start+pInfo.getLineCount()-1;			//2+3-1 
	
	BoardDTO bDTO = new BoardDTO();
	bDTO.setStart(start);
	bDTO.setEnd(end);
	
	ArrayList<BoardDTO> list = 
			cDAO.getCBoard(bDTO);
	
	return list;
	
	}
	
	//페이징관련정보를 세팅하는 함수
	public PageUtil getPageInfo(int nowPage) {
	int totalCount = cDAO.getTotalCnt();

	PageUtil pInfo = new PageUtil(nowPage, totalCount);

	return pInfo;  
	}
	
	
	//글쓰기 처리
	public void insertBoard(BoardDTO bDTO,HttpSession session,ArrayList list) {

		System.out.println("columnService의 insertBoard() bDto="+bDTO);
		
		String id = (String)session.getAttribute("ID");
		bDTO.setId(id);
		cDAO.insertBoard(bDTO,"column");

		for(int i=0;i<list.size();i++) {
		//하나의 첨부파일의 정보는 Map으로 저장되어있다
		HashMap map = (HashMap)list.get(i);
		/*map.put("path",    path);
		map.put("oriName", oriName);
		map.put("saveName",saveName);
		map.put("len", file.length()); 넣었으니..*/
		//컨트롤러에서 map.put으로 넣은것 받기
		//DAO에서는  정보는 FileBoardDTO로 받기로 했으므로
		//--> DTO의  setter()를 이용하여 세팅한다
		bDTO.setPath((String)map.get("path"));
		bDTO.setOriName((String)map.get("oriName"));
		bDTO.setSaveName((String)map.get("saveName"));
		bDTO.setLen((Long)map.get("len"));
			
		//DAO의 함수 호출시 
		//DAO에서는 모든 정보를 FileBoardDTO로 받기로 했으므로
		//-->DTO의 setter()를 이용하여 세팅한다
		//6개->6개로
		cDAO.insertBoard(bDTO,"fInfo");
		}
	}
	

	

	

	
	
}
