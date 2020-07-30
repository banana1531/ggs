package com.ggs.graph;

import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ggs.DTO.PlayerInfoDTO;
import com.ggs.graph.Graphservice;

@Controller
@RequestMapping("/datac")
public class DataCrawl {
	@Autowired
	Graphservice gService;

	@RequestMapping("/c.gg")
	public void datac(PlayerInfoDTO pidto) {
		System.out.println("요청 함수 datac()!");

		// 1.for 를 통해 차례대로 플레이어 인포에서 선수정보를 뽑아온다
		ArrayList<PlayerInfoDTO> list = gService.bmiList(pidto);

		String str = null;
		String str2 = null;
		for (int i = 0; i < 280; i++) {
			str = list.get(i).getName();
			str2 = list.get(i).getBirth();
			// 2.url주소를 만든다
			String url = "http://www.statiz.co.kr/player.php?opt=3&name=" + str + "&birth=" + str2;
			System.out.println(url);

			try {
				Document doc = Jsoup.connect(url).get();
				Element doc1 = doc.select("div.box-body.no-padding.table-responsive").first();
				if (doc1 != null) {
					// 3.크롤링 정보를 가져온다

					Elements doc2 = doc1.select("tr.oddrow_stz0");
					Elements doc3 = doc1.select("tr.evenrow_stz0");
					Elements doc4 = doc2.select("span"); 
					Elements doc5 = doc3.select("span");
					String span4 = doc4.text(); 
					String span5 = doc5.text(); 
					String span6 = span4 + " " + span5;
					//System.out.println("span6= "+span6);
				

					// 4. ptype(postion)에 따라 투수냐 타자냐 나눠서 넣어야한다
					String ptype = null;
					ptype = list.get(i).getPosition();

					if (ptype.contains("투수")) {
					// 5. 크롤링 정보를 리스트에 넣어야 한다.
						String[] arr = span6.split(" ");
						String str3 = null;
						ArrayList<String> list1 = new ArrayList<String>(30);
						for (int i1 = 1; i1 < arr.length + 1; i1++) {
							str3 = arr[i1 - 1];

							list1.add(str3);

							String pno = null;
							String teamname = null;
							String gdate = null;
	
							if (i1 % 30 == 0) {
	
								// 6. 30개씩 자른 정보 중 gdate로 [2][3] 합치기 + pno,teamname,ptype을 추가한 리스트를 만든다
								
								pno = Integer.toString(list.get(i).getPno());
								teamname = list.get(i).getTeamname();
								gdate = list1.get(2) + " " + list1.get(3);
	
								list1.add(pno);
								list1.add(teamname);
								list1.add(gdate);
								list1.remove(2);
								list1.remove(2);
								ptype = "투수";
								list1.add(ptype);
			
								// 7.리스트를 DB와 중복확인 한다
								int cntr = gService.precordChk(list1);
								// 8. 중복이 아닐 시 insert를 진행한다
								if (cntr == 0) {
									gService.prInsert(list1);	
								} 
								list1.clear();
							} 

						} 

					} 
					 else {//투수가 아닐 경우 
						 	String[] arr = span6.split(" ");
							String str3 = null;
							ArrayList<String> list1 = new ArrayList<String>(32);
							for (int i1 = 1; i1 < arr.length + 1; i1++) {
								str3 = arr[i1 - 1];
							
								list1.add(str3);

								String pno = null;
								String teamname = null;
								String gdate = null;
		
								if (i1 % 32 == 0) {
							
									// 6-2. 32개씩 자른 정보 중 gdate로 [2][3] 합치기 + pno,teamname,ptype을 추가한 리스트를 만든다
									
									pno = Integer.toString(list.get(i).getPno());
									teamname = list.get(i).getTeamname();
									gdate = list1.get(2) + " " + list1.get(3);
		
									list1.add(pno);
									list1.add(teamname);
									list1.add(gdate);
									list1.remove(2);
									list1.remove(2);
									ptype = "타자";
									list1.add(ptype);
	
									// 7-2.리스트를 DB와 중복확인 한다
									int cntr = gService.precordChkJ(list1);									
									// 8-2. 중복이 아닐 시 insert를 진행한다
									if (cntr == 0) {
										gService.prInsertJ(list1);	
									} 
									list1.clear();								
								} 

							} 

					}

				} 
				else {
					continue;
				} 

			} 
			catch (IOException e) {
				e.printStackTrace();
			} // end try=catch 
		} // end-for :선수정보 

	}// end-datac 

}
