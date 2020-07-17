package com.ggs.DTO;

//선수 경기 기록 DTO
public class PlayerRecordDTO {
	
	private int pgno;			//기록관리번호
	private int pno;			//선수번호
	private String teamname;	//소속팀
	private String ptype;		//포지션
	private String gdate;		//경기일자
	private String vs;			//상대팀
	private String gresult;		//경기결과
	private String sunbal;		//선발유무
	private String ining;		//이닝
	private String siljum;		//실점		
	private String jachak;		//자책점
	private String taja;		//상대한 타자수
	private String tasu;		//상대한 타수
	private String anta;		//피안타
	private String eta;			//피2루타
	private String samta;		//피3루타
	private String home_run;	//피홈런
	private String ball4;		//볼넷
	private String go4;			//고의4구
	private String sagu;		//사구
	private String samjin;		//삼진
	private String tugu;		//투구수
	private String whip;		//
	private String tayul;		//
	private String culu;		//
	private String ops;			//
	private String era;			//
	private String avli;		//
	private String re24;		//
	private String wpa;			//
	private String gsc;			//
	private String gdec;		//
	private String gangyuk;		//
	private String tasun;		//
	private String p;			//
	private String djum;		//
	private String ruta;		//
	private String tajum;		//
	private String doru;		//
	private String dosil;		//
	private String byungsal;	//
	private String hita;		//
	private String hibi;		//
	private String jangta;		//
	
	private String name;
	private int start;	        //페이지 시작번호
	private int end;            
	private int totalcnt;       //전체 튜플수
	
	public int getTotalcnt() {
		return totalcnt;
	}
	public void setTotalcnt(int totalcnt) {
		this.totalcnt = totalcnt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getTeamname() {
		return teamname;
	}
	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}
	public String getPtype() {
		return ptype;
	}
	public void setPtype(String ptype) {
		this.ptype = ptype;
	}
	public String getGdate() {
		return gdate;
	}
	public void setGdate(String gdate) {
		this.gdate = gdate;
	}
	public String getVs() {
		return vs;
	}
	public void setVs(String vs) {
		this.vs = vs;
	}
	public String getGresult() {
		return gresult;
	}
	public void setGresult(String gresult) {
		this.gresult = gresult;
	}
	public String getSunbal() {
		return sunbal;
	}
	public void setSunbal(String sunbal) {
		this.sunbal = sunbal;
	}
	public String getIning() {
		return ining;
	}
	public void setIning(String ining) {
		this.ining = ining;
	}
	public String getSiljum() {
		return siljum;
	}
	public void setSiljum(String siljum) {
		this.siljum = siljum;
	}
	public String getJachak() {
		return jachak;
	}
	public void setJachak(String jachak) {
		this.jachak = jachak;
	}
	public String getTaja() {
		return taja;
	}
	public void setTaja(String taja) {
		this.taja = taja;
	}
	public String getTasu() {
		return tasu;
	}
	public void setTasu(String tasu) {
		this.tasu = tasu;
	}
	public String getAnta() {
		return anta;
	}
	public void setAnta(String anta) {
		this.anta = anta;
	}
	public String getEta() {
		return eta;
	}
	public void setEta(String eta) {
		this.eta = eta;
	}
	public String getSamta() {
		return samta;
	}
	public void setSamta(String samta) {
		this.samta = samta;
	}
	public String getHome_run() {
		return home_run;
	}
	public void setHome_run(String home_run) {
		this.home_run = home_run;
	}
	public String getBall4() {
		return ball4;
	}
	public void setBall4(String ball4) {
		this.ball4 = ball4;
	}
	public String getGo4() {
		return go4;
	}
	public void setGo4(String go4) {
		this.go4 = go4;
	}
	public String getSagu() {
		return sagu;
	}
	public void setSagu(String sagu) {
		this.sagu = sagu;
	}
	public String getSamjin() {
		return samjin;
	}
	public void setSamjin(String samjin) {
		this.samjin = samjin;
	}
	public String getTugu() {
		return tugu;
	}
	public void setTugu(String tugu) {
		this.tugu = tugu;
	}
	public String getWhip() {
		return whip;
	}
	public void setWhip(String whip) {
		this.whip = whip;
	}
	public String getTayul() {
		return tayul;
	}
	public void setTayul(String tayul) {
		this.tayul = tayul;
	}
	public String getCulu() {
		return culu;
	}
	public void setCulu(String culu) {
		this.culu = culu;
	}
	public String getOps() {
		return ops;
	}
	public void setOps(String ops) {
		this.ops = ops;
	}
	public String getEra() {
		return era;
	}
	public void setEra(String era) {
		this.era = era;
	}
	public String getAvli() {
		return avli;
	}
	public void setAvli(String avli) {
		this.avli = avli;
	}
	public String getRe24() {
		return re24;
	}
	public void setRe24(String re24) {
		this.re24 = re24;
	}
	public String getWpa() {
		return wpa;
	}
	public void setWpa(String wpa) {
		this.wpa = wpa;
	}
	public String getGsc() {
		return gsc;
	}
	public void setGsc(String gsc) {
		this.gsc = gsc;
	}
	public String getGdec() {
		return gdec;
	}
	public void setGdec(String gdec) {
		this.gdec = gdec;
	}
	public String getGangyuk() {
		return gangyuk;
	}
	public void setGangyuk(String gangyuk) {
		this.gangyuk = gangyuk;
	}
	public String getTasun() {
		return tasun;
	}
	public void setTasun(String tasun) {
		this.tasun = tasun;
	}
	public String getP() {
		return p;
	}
	public void setP(String p) {
		this.p = p;
	}
	public String getDjum() {
		return djum;
	}
	public void setDjum(String djum) {
		this.djum = djum;
	}
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	public String getTajum() {
		return tajum;
	}
	public void setTajum(String tajum) {
		this.tajum = tajum;
	}
	public String getDoru() {
		return doru;
	}
	public void setDoru(String doru) {
		this.doru = doru;
	}
	public String getDosil() {
		return dosil;
	}
	public void setDosil(String dosil) {
		this.dosil = dosil;
	}
	public String getByungsal() {
		return byungsal;
	}
	public void setByungsal(String byungsal) {
		this.byungsal = byungsal;
	}
	public String getHita() {
		return hita;
	}
	public void setHita(String hita) {
		this.hita = hita;
	}
	public String getHibi() {
		return hibi;
	}
	public void setHibi(String hibi) {
		this.hibi = hibi;
	}
	public String getJangta() {
		return jangta;
	}
	public void setJangta(String jangta) {
		this.jangta = jangta;
	}
	
	@Override
	public String toString() {
		return "PlayerRecordDTO [pgno=" + pgno + ", pno=" + pno + ", teamname=" + teamname + ", ptype=" + ptype
				+ ", gdate=" + gdate + ", vs=" + vs + ", gresult=" + gresult + ", sunbal=" + sunbal + ", ining=" + ining
				+ ", siljum=" + siljum + ", jachak=" + jachak + ", taja=" + taja + ", tasu=" + tasu + ", anta=" + anta
				+ ", eta=" + eta + ", samta=" + samta + ", home_run=" + home_run + ", ball4=" + ball4 + ", go4=" + go4
				+ ", sagu=" + sagu + ", samjin=" + samjin + ", tugu=" + tugu + ", whip=" + whip + ", tayul=" + tayul
				+ ", culu=" + culu + ", ops=" + ops + ", era=" + era + ", avli=" + avli + ", re24=" + re24 + ", wpa="
				+ wpa + ", gsc=" + gsc + ", gdec=" + gdec + ", gangyuk=" + gangyuk + ", tasun=" + tasun + ", p=" + p
				+ ", djum=" + djum + ", ruta=" + ruta + ", tajum=" + tajum + ", doru=" + doru + ", dosil=" + dosil
				+ ", byungsal=" + byungsal + ", hita=" + hita + ", hibi=" + hibi + ", jangta=" + jangta + ", name="
				+ name + ", start=" + start + ", end=" + end + ", totalcnt=" + totalcnt + "]";
	}
}
