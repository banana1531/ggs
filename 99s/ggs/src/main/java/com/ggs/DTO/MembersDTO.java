package com.ggs.DTO;

import java.util.Date;

//회원 테이블 DTO
public class MembersDTO {
	
	private String id;  	//아이디
	private String name;   	//이름
	private String birth;	//생년월일
	private String team;	//선호팀
	private String pw;		//비밀번호
	private String gender;	//성별
	private String email;	//이메일
	private int boardM;		//게시판 조작 권한
	private int boardV;		//게시판 조회 권한
	private int login;		//로그인권한
	private int ppoint;     //승부예측 누적 포인트
	private Date joindate;  //가입일
	private int start;		//리스트 시작 번호
	private int totalcnt;	//전체 회원수
	
	public int getTotalcnt() {
		return totalcnt;
	}
	public void setTotalcnt(int totalcnt) {
		this.totalcnt = totalcnt;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getBoardM() {
		return boardM;
	}
	public void setBoardM(int boardM) {
		this.boardM = boardM;
	}
	public int getBoardV() {
		return boardV;
	}
	public void setBoardV(int boardV) {
		this.boardV = boardV;
	}
	public int getLogin() {
		return login;
	}
	public void setLogin(int login) {
		this.login = login;
	}
	public int getPpoint() {
		return ppoint;
	}
	public void setPpoint(int ppoint) {
		this.ppoint = ppoint;
	}
	public Date getJoindate() {
		return joindate;
	}
	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}
	@Override
	public String toString() {
		return "MembersDTO [id=" + id + ", name=" + name + ", birth=" + birth + ", team=" + team + ", pw=" + pw
				+ ", gender=" + gender + ", email=" + email + ", boardM=" + boardM + ", boardV=" + boardV + ", login="
				+ login + ", ppoint=" + ppoint + ", joindate=" + joindate + ", start=" + start + ", totalcnt="
				+ totalcnt + "]";
	}
		
}
