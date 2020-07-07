package com.ggs.DTO;

import java.util.Date;

//선수 경기 기록 DTO
public class PlayerRecordDTO {
	
	private int pgno;			//기록관리번호
	private int pno;			//선수번호
	private String teamName;	//팀이름
	private Date gdate;			//경기일자
	private int win;			//승점
	private int	lose;			//실점
	private int	selected;		//선발
	private int	innings_pitched;//이닝수
	private int	runs_allowed;	//실점
	private int	earned_runs;	//자책		
	private int	batter;			//타자
	private int at_bat;			//타수
	private int hit;			//안타
	private int ddouble;		//2타
	private int triple;			//3타
	private int home_run;		//홈런
	private int base_on_balls;	//볼넷
	private int intentional_base_on_balls;	//고4
	private int deadball;		//사구
	private int strikeout;		//삼진
	private int pitch;			//투구
	public int getPgno() {
		return pgno;
	}
	public void setPgno(int pgno) {
		this.pgno = pgno;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public Date getGdate() {
		return gdate;
	}
	public void setGdate(Date gdate) {
		this.gdate = gdate;
	}
	public int getWin() {
		return win;
	}
	public void setWin(int win) {
		this.win = win;
	}
	public int getLose() {
		return lose;
	}
	public void setLose(int lose) {
		this.lose = lose;
	}
	public int getSelected() {
		return selected;
	}
	public void setSelected(int selected) {
		this.selected = selected;
	}
	public int getInnings_pitched() {
		return innings_pitched;
	}
	public void setInnings_pitched(int innings_pitched) {
		this.innings_pitched = innings_pitched;
	}
	public int getRuns_allowed() {
		return runs_allowed;
	}
	public void setRuns_allowed(int runs_allowed) {
		this.runs_allowed = runs_allowed;
	}
	public int getEarned_runs() {
		return earned_runs;
	}
	public void setEarned_runs(int earned_runs) {
		this.earned_runs = earned_runs;
	}
	public int getBatter() {
		return batter;
	}
	public void setBatter(int batter) {
		this.batter = batter;
	}
	public int getAt_bat() {
		return at_bat;
	}
	public void setAt_bat(int at_bat) {
		this.at_bat = at_bat;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getDdouble() {
		return ddouble;
	}
	public void setDdouble(int ddouble) {
		this.ddouble = ddouble;
	}
	public int getTriple() {
		return triple;
	}
	public void setTriple(int triple) {
		this.triple = triple;
	}
	public int getHome_run() {
		return home_run;
	}
	public void setHome_run(int home_run) {
		this.home_run = home_run;
	}
	public int getBase_on_balls() {
		return base_on_balls;
	}
	public void setBase_on_balls(int base_on_balls) {
		this.base_on_balls = base_on_balls;
	}
	public int getIntentional_base_on_balls() {
		return intentional_base_on_balls;
	}
	public void setIntentional_base_on_balls(int intentional_base_on_balls) {
		this.intentional_base_on_balls = intentional_base_on_balls;
	}
	public int getDeadball() {
		return deadball;
	}
	public void setDeadball(int deadball) {
		this.deadball = deadball;
	}
	public int getStrikeout() {
		return strikeout;
	}
	public void setStrikeout(int strikeout) {
		this.strikeout = strikeout;
	}
	public int getPitch() {
		return pitch;
	}
	public void setPitch(int pitch) {
		this.pitch = pitch;
	}
	@Override
	public String toString() {
		return "PlayerRecord [pgno=" + pgno + ", pno=" + pno + ", teamName=" + teamName + ", gdate=" + gdate + ", win="
				+ win + ", lose=" + lose + ", selected=" + selected + ", innings_pitched=" + innings_pitched
				+ ", runs_allowed=" + runs_allowed + ", earned_runs=" + earned_runs + ", batter=" + batter + ", at_bat="
				+ at_bat + ", hit=" + hit + ", ddouble=" + ddouble + ", triple=" + triple + ", home_run=" + home_run
				+ ", base_on_balls=" + base_on_balls + ", intentional_base_on_balls=" + intentional_base_on_balls
				+ ", deadball=" + deadball + ", strikeout=" + strikeout + ", pitch=" + pitch + "]";
	}

	
	
	
}
