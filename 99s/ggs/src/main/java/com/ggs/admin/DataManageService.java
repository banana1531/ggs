package com.ggs.admin;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.python.core.PyFunction;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;
import org.springframework.stereotype.Service;

@Service
public class DataManageService {

	
	private static PythonInterpreter intPre;
	

	//팀 데이터 업데이트 하기
	public void teamDataUpdate(String month) {
		System.out.println("DataManageService.teamDataUpdate0");
		intPre = new PythonInterpreter();
		System.out.println("DataManageService.teamDataUpdate00");
		//intPre.exec("import sys\nsys.path.append('pathToModules if they are not there by default')\nimport yourModule");
		intPre.execfile("/clt/GameScheduleUpdate.py");
		System.out.println("DataManageService.teamDataUpdate1");
		intPre.exec("teamDataUpdate()");
		System.out.println("DataManageService.teamDataUpdate2");
		PyFunction pyFunction = (PyFunction)intPre.get("teamDataUpdate",PyFunction.class);
		System.out.println("DataManageService.teamDataUpdate3");
		int m = Integer.parseInt(month);
		PyObject pyObject = pyFunction.__call__(new PyInteger(m));
	}

}
