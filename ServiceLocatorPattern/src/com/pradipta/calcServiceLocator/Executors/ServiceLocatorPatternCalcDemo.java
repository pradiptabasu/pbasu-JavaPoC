package com.pradipta.calcServiceLocator.Executors;

import com.pradipta.calcServiceLocator.IO.CalcInputDouble;
import com.pradipta.calcServiceLocator.IO.CalcInputSingle;
import com.pradipta.calcServiceLocator.IO.CalcOutputInt;
import com.pradipta.calcServiceLocator.ServiceDef.CalcService;
import com.pradipta.calcServiceLocator.ServiceDef.CalcServiceLocator;

public class ServiceLocatorPatternCalcDemo {
	 public static void main(String[] args) {

		 CalcService service = null;
		 CalcInputSingle calcInputSingleReq = null;
		 CalcOutputInt calcOutputIntResp = null;
		 
		 service = CalcServiceLocator.getService("DoubleYourInput");
		 calcInputSingleReq = new CalcInputSingle(45);
		 calcOutputIntResp = new CalcOutputInt();
		 calcOutputIntResp = (CalcOutputInt) service.execute(calcInputSingleReq);
		 System.out.println("Doubled Response : " + calcOutputIntResp.getResultInt());
		 
		 service = CalcServiceLocator.getService("Sum");
		 CalcInputDouble calcInputDoubleReq = new CalcInputDouble(56,11);
		 calcOutputIntResp = new CalcOutputInt();
		 calcOutputIntResp.setResultInt(calcInputDoubleReq.getNum1() + calcInputDoubleReq.getNum2());
		 System.out.println("Sum Response : " + calcOutputIntResp.getResultInt());
			
//	     service = CalcServiceLocator.getService("Service2");
//	     response = service.execute();
//	     System.out.println(response);
//	     service = CalcServiceLocator.getService("Service1");
//	     response = service.execute();
//	     System.out.println(response);
//	     service = CalcServiceLocator.getService("Service2");
//	     response = service.execute();
//	     System.out.println(response);
//	     service = CalcServiceLocator.getService("Service3");
//	     response = service.execute();
//	     System.out.println(response);
	   }

}
