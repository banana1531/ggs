package com.ggs.mypage;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("mypage")
public class MyTeamScheduleController {

	@Autowired
	private MyTeamScheduleService myTeamScheduleService;
	
	//-------------------------------------------
		//마이팀 경기일정 보기
		@RequestMapping("/myTeamSchedule.gg")
		public String myTeamSchedule() {
			
			//파라미터
			//팀정보(이름)
			String team = "sk";
			//날짜계산을 위한 Calander 생성
			Calendar cal = Calendar.getInstance();
			
			//비즈니스
			//당월 경기일정 가져오기
			//팀 이름과 월정보를 주면 해당 자료를 기준으로 경기일정을 가져온다.
			myTeamScheduleService.getMonthlySchedule(team, cal.get(Calendar.MONTH));
			
			return "myPage/myTeamSchedule";
		}
		
		//마이팀 월단위 경기일정 가져오기 --> ajax로 구현
		@RequestMapping("/myTeamMonthlySchedule.gg")
		public void myTeamMonthlySchedule() {
			
			//파라미터
			//팀정보(이름)/ 선택된 기간(월)정보
			
			
			//비즈니스
			//당월 경기일정 가져오기
		}
}
