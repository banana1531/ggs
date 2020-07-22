package com.ggs.DTO;

public class PlayerInfoDTO {

	private int		pno;
	private String 	name;
	private int 	labelno;
	private String 	birth;
	private String 	position;
	private int 	height;
	private int 	weight;
	private String 	joinday;
	private String 	teamname;
	private int bmi;
	
	private int start;
	private int end;
	private int totalcnt;   //전체 선수
	
	private int cntBmiN; //bmi 정상
	private int cntBmiF; //bmi 비만
	private int cntBmiHF; //bmi 고도비만
	
	
	public int getCntBmiN() {
		return cntBmiN;
	}
	public void setCntBmiN(int cntBmiN) {
		this.cntBmiN = cntBmiN;
	}
	public int getCntBmiF() {
		return cntBmiF;
	}
	public void setCntBmiF(int cntBmiF) {
		this.cntBmiF = cntBmiF;
	}
	public int getCntBmiHF() {
		return cntBmiHF;
	}
	public void setCntBmiHF(int cntBmiHF) {
		this.cntBmiHF = cntBmiHF;
	}
	public int getTotalcnt() {
		return totalcnt;
	}
	public void setTotalcnt(int totalcnt) {
		this.totalcnt = totalcnt;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLabelno() {
		return labelno;
	}
	public void setLabelno(int labelno) {
		this.labelno = labelno;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getJoinday() {
		return joinday;
	}
	public void setJoinday(String joinday) {
		this.joinday = joinday;
	}
	public String getTeamname() {
		return teamname;
	}
	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}
	public int getBmi() {
		return bmi;
	}
	public void setBmi(int bmi) {
		this.bmi = bmi;
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
	
	@Override
	public String toString() {
		return "PlayerInfoDTO [pno=" + pno + ", name=" + name + ", labelno=" + labelno + ", birth=" + birth
				+ ", position=" + position + ", height=" + height + ", weight=" + weight + ", joinday=" + joinday
				+ ", teamname=" + teamname + ", bmi=" + bmi + ", start=" + start + ", end=" + end + ", totalcnt="
				+ totalcnt + ", cntBmiN=" + cntBmiN + ", cntBmiF=" + cntBmiF + ", cntBmiHF=" + cntBmiHF + "]";
	}
}
