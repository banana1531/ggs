package com.ggs.DTO;

//회원 테이블 DTO
public class MembersDTO {
	
	private String id;  	//아이디
	private String name;   	//이름
	private String birth;	//생년월일
	private String fteam;	//선호팀
	private String password;//비밀번호
	private String gender;	//성별
	private String email;	//이메일
	private int boardM;		//게시판 조작 권한
	private int boardV;		//게시판 조회 권한
	private int login;		//로그인권한
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
	public String getFteam() {
		return fteam;
	}
	public void setFteam(String fteam) {
		this.fteam = fteam;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	@Override
	public String toString() {
		return "membersDTO [id=" + id + ", name=" + name + ", birth=" + birth + ", fteam=" + fteam + ", password="
				+ password + ", gender=" + gender + ", email=" + email + ", boardM=" + boardM + ", boardV=" + boardV
				+ ", login=" + login + "]";
	}
	
	
	
}
