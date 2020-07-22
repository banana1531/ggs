package com.ggs.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ggs.DTO.PlayerInfoDTO;
import com.ggs.DTO.PlayerRecordDTO;
import com.ggs.graph.Graphservice;




@Controller
@RequestMapping("/graph")
public class GraphController {
	
	@Autowired
	Graphservice gService;
	
	//페이지 보여주기  - 야구선수 BMI지수 표 
	@RequestMapping("/bmi.gg")	
	public ModelAndView bmiList(ModelAndView mv ,PlayerInfoDTO pidto){
		System.out.println("요청 함수 bmiList()!"); 
		//야구선수 BMI지수 표 
		ArrayList<PlayerInfoDTO> list = gService.bmiList(pidto);
		
		//팀별 비만 분포 그래프
		//정상범위
		ArrayList<PlayerInfoDTO> list2 =gService.tBmi(pidto);
		String str = null;
		int str2= 0;
		List<Integer> list3 = new ArrayList<Integer>(10);
		for (int i=0; i<10; i++) {
			str= list2.get(i).getTeamname();
			str2= list2.get(i).getCntBmiN();
			list3.add(str2);
			//System.out.println("정상"+str+"/"+str2);
		}
		//비만범위
		ArrayList<PlayerInfoDTO> list4 =gService.tBmi2(pidto);
		String str3 = null;
		int str4= 0;
		List<Integer> list5 = new ArrayList<Integer>(10);
		for (int i=0; i<10; i++) {
			str3= list4.get(i).getTeamname();
			str4= list4.get(i).getCntBmiF();
			list5.add(str4);
			//System.out.println("비만"+str3+"/"+str4);
		}
		
		//고도비만 범위
		ArrayList<PlayerInfoDTO> list6 =gService.tBmi3(pidto);
		System.out.println("list6="+list6);
		String str5 = null;
		int str6= 0;
		List<Integer> list7 = new ArrayList<Integer>(10);
		for (int i=0; i<10; i++) {
			str5= list6.get(i).getTeamname();
			str6= list6.get(i).getCntBmiHF();
			list7.add(str6);
			//System.out.println("고도비만"+str5+"/"+str6);
		}
		
		//모델 & 뷰
		//리스트
		mv.addObject("LIST",list);	
		//그래프
		mv.addObject("list3",list3);
		mv.addObject("list5",list5);
		mv.addObject("list7",list7);
		//이미지
		mv.addObject("img","../img/cor2.jpg");
		mv.setViewName("graph/bmi");
		return mv;
	}
	
}
