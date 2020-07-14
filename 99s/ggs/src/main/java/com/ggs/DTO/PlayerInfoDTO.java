package com.ggs.DTO;

//선수정보테이블 DTO
public class PlayerInfoDTO {
	
	private int		pno;		//관리번호
	private String 	name;		//선수이름
	private int 	labelno;	//등번호
	private String 	birth;		//생년월일
	private String 	position;	//포지션
	private int 	height;		//키
	private int 	weight;		//몸무게
	private String 	joinday;	//입단일
	private String 	teamName;	//팀이름
	private int 	bmi;		//bmi지수
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
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public int getBmi() {
		return bmi;
	}
	public void setBmi(int bmi) {
		this.bmi = bmi;
	}
	@Override
	public String toString() {
		return "PlayerInfoDTO [pno=" + pno + ", name=" + name + ", labelno=" + labelno + ", birth=" + birth
				+ ", position=" + position + ", height=" + height + ", weight=" + weight + ", joinday=" + joinday
				+ ", teamName=" + teamName + ", bmi=" + bmi + "]";
	}
	
	
}
