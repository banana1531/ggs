package com.ggs.ballcolumn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggs.DAO.BallColumnDAO;

@Service
public class BallColumnService {

	@Autowired
	BallColumnDAO bcDAO;
}
