package com.ggs.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ggs.DTO.DeclarationDTO;
import com.ggs.admin.DecService;

@Controller
public class DecInsertController {

	@Autowired
	private DecService decService;
	
	
	//신고글 접수
		@RequestMapping("/decInsert.gg")
		public String decInsert(DeclarationDTO declarationDTO, Model model, int nowPage, int views) {
			System.out.println("DecController.decInsert");
			System.out.println("declarationDTO="+declarationDTO);
			if(decService.decInsert(declarationDTO)>0)
				model.addAttribute("decl", 1);
			else model.addAttribute("ecl", 2);
			
			if(declarationDTO.getBoardname().equals("freeboard"))
				return "redirect:/freeboard/list";
			else
				return "redirect:/inforerrorboard/list";
		}
}
