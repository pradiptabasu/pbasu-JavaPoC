package com.pradipta.calcServiceLocator.ServiceDef;

import com.pradipta.calcServiceLocator.IO.*;

public class CalcSumInputService implements CalcService {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "CalcService1";
	}

	@Override
	public Object execute(Object inputObj) {
		// TODO Auto-generated method stub
		CalcInputDouble calcInputDoubleReq = (CalcInputDouble) inputObj;
		CalcOutputInt calcOutputIntResp = new CalcOutputInt();
		calcOutputIntResp.setResultInt(calcInputDoubleReq.getNum1() + calcInputDoubleReq.getNum2());
		return calcOutputIntResp;
	}

}
