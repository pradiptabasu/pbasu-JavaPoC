package com.pradipta.calcServiceLocator.ServiceDef;

import com.pradipta.calcServiceLocator.IO.*;

public class CalcDoubleInputService implements CalcService {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "CalcService1";
	}

	@Override
	public Object execute(Object inputObj) {
		// TODO Auto-generated method stub
		CalcInputSingle calcInputSingleReq = (CalcInputSingle) inputObj;
		CalcOutputInt calcOutputIntResp = new CalcOutputInt();
		calcOutputIntResp.setResultInt(calcInputSingleReq.getNum1() * 2);
		return calcOutputIntResp;
	}

}
