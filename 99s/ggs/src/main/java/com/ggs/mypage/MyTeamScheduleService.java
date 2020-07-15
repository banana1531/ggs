package com.ggs.mypage;

import org.springframework.stereotype.Service;

@Service
public class MyTeamScheduleService {

	// 월단위 경기 일정 가져오기
	// 받은 월 정보를 DB에 적용이 가능하도록 변환한다.
	public void getMonthlySchedule(String team, int i) {
		System.out.println("i=" + i);
	}

	// 내팀 경기일정 가져오기
}
