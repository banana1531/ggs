package com.ggs.ballcolumn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ballColumn")
public class BallColumnController {

	@Autowired
	BallColumnService bcService;
	
	//글목록보기 요청.
}
