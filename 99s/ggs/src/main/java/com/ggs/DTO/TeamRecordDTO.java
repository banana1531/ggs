package com.ggs.DTO;

import java.util.Date;

public class TeamRecordDTO {

	private int gno;
	private Date gdate;
	private String gtime;
	private String ateamname;
	private String ascore;
	private String bteamname;
	private String bscore;
	private String stadium;
	
	private String win;
	private String draw;
	private String lose;
	private String score;
	private String loss;
	
	public int getGno() {
		return gno;
	}
	public void setGno(int gno) {
		this.gno = gno;
	}
	public Date getGdate() {
		return gdate;
	}
	public void setGdate(Date gdate) {
		this.gdate = gdate;
	}
	public String getGtime() {
		return gtime;
	}
	public void setGtime(String gtime) {
		this.gtime = gtime;
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
	public String getStadium() {
		return stadium;
	}
	public void setStadium(String stadium) {
		this.stadium = stadium;
	}
	public String getWin() {
		return win;
	}
	public void setWin(String win) {
		this.win = win;
	}
	public String getDraw() {
		return draw;
	}
	public void setDraw(String draw) {
		this.draw = draw;
	}
	public String getLose() {
		return lose;
	}
	public void setLose(String lose) {
		this.lose = lose;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getLoss() {
		return loss;
	}
	public void setLoss(String loss) {
		this.loss = loss;
	}
	
	@Override
	public String toString() {
		return "TeamRecordDTO [gno=" + gno + ", gdate=" + gdate + ", gtime=" + gtime + ", ateamname=" + ateamname
				+ ", ascore=" + ascore + ", bteamname=" + bteamname + ", bscore=" + bscore + ", stadium=" + stadium
				+ ", win=" + win + ", draw=" + draw + ", lose=" + lose + ", score=" + score + ", loss=" + loss + "]";
	}

}
