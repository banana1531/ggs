package com.ggs.DTO;

import java.sql.Date;

//정보 오류 게시판테이블 DTO
public class InfoErrorBoardDTO {
	
	private int 	wno; 		//글 관리번호
	private String 	id; 		//글쓴이
	private String 	title;		//제목
	private String 	content;	//내용
	private Date 	wdate;		//작성일
	private int 	views;		//조회수
	private int 	isvisible;	//노출,비노출
	
	public int getWno() {
		return wno;
	}
	public void setWno(int wno) {
		this.wno = wno;
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
	public Date getWdate() {
		return wdate;
	}
	public void setWdate(Date wdate) {
		this.wdate = wdate;
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
	@Override
	public String toString() {
		return "freeBoardDTO [wno=" + wno + ", id=" + id + ", title=" + title + ", content=" + content + ", wdate="
				+ wdate + ", views=" + views + ", isvisible=" + isvisible + "]";
	}
	
	
}
