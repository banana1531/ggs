package com.ggs.admin;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggs.DAO.MembersDAO;
import com.ggs.DAO.PlayerInfoDAO;
import com.ggs.DAO.PreResultDAO;
import com.ggs.DAO.TeamRecordDAO;
import com.ggs.DAO.UpdateDateDAO;
import com.ggs.DTO.PreResultDTO;
import com.ggs.DTO.TeamRecordDTO;

@Service
public class DataManageService {

	
	@Autowired
	private TeamRecordDAO teamRecordDAO;
	
	@Autowired
	private PreResultDAO preResultDAO;
	
	@Autowired
	private MembersDAO memberDAO;
	
	@Autowired
	private UpdateDateDAO updateDateDAO;
	
	@Autowired
	private PlayerInfoDAO playerInfoDAO;
	
	//경기 기록 업데이트 하기 (월단위)
	public int updateDBTeamRecord() {
		String temp;
		String gtime;
		String ateamname;
		String bteamname;
		String ascore;
		String bscore;
		String stadium;
		String gdate;
		String[] temp2 = new String[4];
		TeamRecordDTO teamRecordDTO;
		int r=0;
		
		try {
			Connection.Response response = Jsoup.connect(
					"https://sports.news.naver.com/kbaseball/schedule/index.nhn?date=20200701&month=7&year=2020&teamCode=")
					.method(Connection.Method.GET).execute();
			Document url = response.parse();
			Element div = url.select("div[class=tb_wrap]").first();
			Elements divs = div.select("div");
			for (Element d : divs) {
				Elements trs = d.select("tr");
				if (trs.size() > 0 && trs.size() < 20) {
					Elements tds = trs.get(0).select("td");

					temp = tds.get(0).text();
					gdate = "2020-" + temp.substring(0, temp.indexOf(".")) + "-"
							+ temp.substring(temp.indexOf(".") + 1, temp.length() - 4);
					if (tds.size() < 4) {
						gtime = tds.get(2).text();
						ateamname = "경기없음";
						bteamname = "경기 없음";
						stadium = "경기없음";
						ascore = "-1";
						bscore = "-1";
					} else if (tds.get(3).text().contains("취소")) {
						gtime = tds.get(1).text();
						temp2 = tds.get(2).text().split(" ");
						ateamname = temp2[0];
						bteamname = temp2[2];
						ascore = "-1";
						bscore = "-1";
						stadium = tds.get(4).text();
					} else {
						gtime = tds.get(1).text();
						temp2 = tds.get(2).text().split(" ");
						ateamname = temp2[0];
						bteamname = temp2[2];
						if (temp2[1].contains(":")) {
							temp = temp2[1];
							ascore = temp.substring(0, temp.indexOf(":"));
							bscore = temp.substring(temp.indexOf(":") + 1);
						} else {
							ascore = "0";
							bscore = "0";
						}
						stadium = tds.get(5).text();
					}

					System.out.println(gdate + " " + gtime + " " + ateamname + " " + ascore + ":" + bscore + " "
							+ bteamname + " " + stadium);
					teamRecordDTO = covertDTO(gtime, ateamname, ascore, bteamname, bscore, stadium, gdate);
					r+=teamRecordDAO.updateTeamRecord(teamRecordDTO);

					for (int i = 1; i < trs.size(); i++) {
						tds = trs.get(i).select("td");
						if (tds.get(2).text().contains("취")) {
							gtime = tds.get(0).text();
							temp2 = tds.get(1).text().split(" ");
							ateamname = temp2[0];
							bteamname = temp2[2];
							ascore = "-1";
							bscore = "-1";
							stadium = tds.get(3).text();
							System.out.println(gdate + " " + gtime + " " + ateamname + " " + ascore + ":" + bscore + " "
									+ bteamname + " " + stadium);
							teamRecordDTO = covertDTO(gtime, ateamname, ascore, bteamname, bscore, stadium, gdate);
							r+=teamRecordDAO.updateTeamRecord(teamRecordDTO);
						} else {
							gtime = tds.get(0).text();
							temp2 = tds.get(1).text().split(" ");
							ateamname = temp2[0];
							bteamname = temp2[2];
							if (temp2[1].contains(":")) {
								temp = temp2[1];
								ascore = temp.substring(0, temp.indexOf(":"));
								bscore = temp.substring(temp.indexOf(":") + 1);
							} else {
								ascore = "0";
								bscore = "0";
							}
							stadium = tds.get(4).text();
							System.out.println(gdate + " " + gtime + " " + ateamname + " " + ascore + ":" + bscore + " "
									+ bteamname + " " + stadium);
							teamRecordDTO = covertDTO(gtime, ateamname, ascore, bteamname, bscore, stadium, gdate);
							r+=teamRecordDAO.updateTeamRecord(teamRecordDTO);
						}
					}

				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}

		return r;
	}

	private TeamRecordDTO covertDTO(String gtime, String ateamname, String ascore, String bteamname, String bscore, String stadium, String gdate) {
		return new TeamRecordDTO(gtime, ateamname, ascore, bteamname, bscore, stadium, gdate);
	}

	//승부예측 포인트 계산
	public int calPoint() {
		int r=0;
		int r2=0;
		//각 경기 결과 가져오기
		List<PreResultDTO> list = preResultDAO.getList();
		for(PreResultDTO dto : list) {
			System.out.println("경기 결과 dto="+dto);
			if(!dto.getAteamname().equals("경기취소")) {
				System.out.println("if 진입");
				//경기별 포인트 계산
				int totalpoint = preResultDAO.totalPoint(dto);
				System.out.println("totalpoint="+totalpoint);
				dto.setPpoint(totalpoint);	
			}
			//해당 경기 포인트 지급 회원 목록 가져오기
			List<PreResultDTO> list2= preResultDAO.correctList(dto);
			for(PreResultDTO dto2 : list2) {
				if(!dto.getAteamname().equals("경기취소"))
					dto2.setPpoint(dto.getPpoint());
				else dto2.setPpoint(10);
				r+=preResultDAO.updatePPoint(dto2);
				r2+=memberDAO.updatePPoint(dto2);
			}
		}
		System.out.println("members 테이블에 총 "+r2+"건을 업데이트 하였습니다.");
		return r;
	}

	public Boolean checkUpdateDate() {
		
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		
		Date lastUpdate;
		Date today;
		try {
			lastUpdate = f.parse(f.format(updateDateDAO.checkDate()));
			today = f.parse(f.format(new Date()));

			System.out.println("lastUpdate="+lastUpdate);
			System.out.println("today="+today);
		
			if(lastUpdate.compareTo(today)<0) {
				updateDateDAO.insertUpdateDate();
				System.out.println("최종 업데이트 일자를 "+today+" 로 추가하였습니다.");	
				return true;
			}else {
				System.out.println("금일 데이터 업데이트는 이미 완료되었습니다.");
				return false;
			}
		} catch (ParseException e) {
			System.out.println("업데이트 진행 중 exception 발생");
			e.printStackTrace();
			return false;
		}
		
	}
	
	
	//playerRecord 중복데이터 체크 -투수
	public int precordChk(ArrayList<String> list1) {
		int cntr = playerInfoDAO.precordChk(list1);
		return cntr;
	}
	//playerRecord 중복데이터 체크 -타자
	public int precordChkJ(ArrayList<String> list1) {
		int cntr = playerInfoDAO.precordChkJ(list1);
		return cntr;
	}
	//playerRecord insert-투수
	public void prInsert(ArrayList<String> list1) {
		playerInfoDAO.prInsert(list1);
	}
	//playerRecord insert-타자
		public void prInsertJ(ArrayList<String> list1) {
			playerInfoDAO.prInsertJ(list1);
		}
		
}
