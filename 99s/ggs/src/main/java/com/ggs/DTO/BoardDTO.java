package com.ggs.DTO;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;



//자유게시판 테이블  DTO
public class BoardDTO {
	
	private int 	writeno; 		//글 관리번호
	private String 	id; 		//글쓴이
	private String 	title;		//제목
	private String 	content;	//내용
	private Timestamp 	writedate;	//작성일
	private int 	views;		//조회수
	private int 	isvisible;	//노출,비노출
	private String 	boardname;	//게시판 이름
	
	//------------------강동혁-------------------------------
	
	private int		rno;
	
	private int		start; 		//시작글번호
	private	int		end;		//끝글번호
	
	private int		nowPage;	//보고싶은페이지

	private String searchType;		//검색분야
	private String keyword;		//검색어
	
	public String getwDate2() {
		//필요한 조작을 하면 된다
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy년 MM-dd");
		return fmt.format(writedate);
	}
	//----------------------------------------------

	public int getWriteno() {
		return writeno;
	}

	public void setWriteno(int writeno) {
		this.writeno = writeno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getWritedate() {
		return writedate;
	}

	public void setWritedate(Timestamp writedate) {
		this.writedate = writedate;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public int getIsvisible() {
		return isvisible;
	}

	public void setIsvisible(int isvisible) {
		this.isvisible = isvisible;
	}

	public String getBoardname() {
		return boardname;
	}

	public void setBoardname(String boardname) {
		this.boardname = boardname;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "BoardDTO [writeno=" + writeno + ", id=" + id + ", title=" + title + ", content=" + content
				+ ", writedate=" + writedate + ", views=" + views + ", isvisible=" + isvisible + ", boardname="
				+ boardname + ", rno=" + rno + ", start=" + start + ", end=" + end + ", nowPage=" + nowPage
				+ ", searchType=" + searchType + ", keyword=" + keyword + "]";
	}





	}

	
	
	
	
