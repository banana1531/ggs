package com.ggs.DTO;

import java.sql.Date;

//승부예측 테이블DTO
public class PreResultDTO {
	
	private int 	ino;		//관리번호
	private String 	id;			//회원아이디
	private int 	gno;		//게임관리번호
	private String 	predict;	//예측값
	private int 	ppoint;		//포인트 증감
	private Date 	gdate;		//경기일자
	private String 	bteamname;	//홈팀번호
	private String 	bscore;		//홈팀점수
	private String 	ateamname;	//어웨이팀번호
	private String 	ascore;		//홈팀점수
	private int     totalcnt;	//내가 참여한 횟수
	private int 	totalpp;	//포인트 합계
	private int 	precount;	//투표수
	private int 	total;		//포인트 계산을 위한 임시 변수
	private int     start;		//목록 시작번호
	private int 	rate;		//적중률
		
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPrecount() {
		return precount;
	}
	public void setPrecount(int precount) {
		this.precount = precount;
	}
	public int getTotalpp() {
		return totalpp;
	}
	public void setTotalpp(int totalpp) {
		this.totalpp = totalpp;
	}
	public int getTotalcnt() {
		return totalcnt;
	}
	public void setTotalcnt(int totalcnt) {
		this.totalcnt = totalcnt;
	}
	public int getIno() {
		return ino;
	}
	public void setIno(int ino) {
		this.ino = ino;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getGno() {
		return gno;
	}
	public void setGno(int gno) {
		this.gno = gno;
	}
	public String getPredict() {
		return predict;
	}
	public void setPredict(String predict) {
		this.predict = predict;
	}
	public int getPpoint() {
		return ppoint;
	}
	public void setPpoint(int ppoint) {
		this.ppoint = ppoint;
	}
	public Date getGdate() {
		return gdate;
	}
	public void setGdate(Date gdate) {
		this.gdate = gdate;
	}
	public String getBteamname() {
		return bteamname;
	}
	public void setBteamname(String bteamname) {
		this.bteamname = bteamname;
	}
	public String getBscore() {
		return bscore;
	}
	public void setBscore(String bscore) {
		this.bscore = bscore;
	}
	public String getAteamname() {
		return ateamname;
	}
	public void setAteamname(String ateamname) {
		this.ateamname = ateamname;
	}
	public String getAscore() {
		return ascore;
	}
	public void setAscore(String ascore) {
		this.ascore = ascore;
	}
	@Override
	public String toString() {
		return "PreResultDTO [ino=" + ino + ", id=" + id + ", gno=" + gno + ", predict=" + predict + ", ppoint="
				+ ppoint + ", gdate=" + gdate + ", bteamname=" + bteamname + ", bscore=" + bscore + ", ateamname="
				+ ateamname + ", ascore=" + ascore + ", totalcnt=" + totalcnt + ", totalpp=" + totalpp + ", precount="
				+ precount + ", total=" + total + ", start=" + start + ", rate=" + rate + "]";
	}
	
	
}
