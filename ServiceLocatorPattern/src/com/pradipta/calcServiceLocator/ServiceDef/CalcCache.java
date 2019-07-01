package com.pradipta.calcServiceLocator.ServiceDef;

import java.util.ArrayList;
import java.util.List;

public class CalcCache {
	private List<CalcService> calcServices;

	   public CalcCache(){
		   calcServices = new ArrayList<CalcService>();
	   }

	   public CalcService getService(String serviceName){
	   
	      for (CalcService calcService : calcServices) {
	         if(calcService.getName().equalsIgnoreCase(serviceName)){
	            System.out.println("Returning cached  " + serviceName + " object");
	            return calcService;
	         }
	      }
	      return null;
	   }

	   public void addService(CalcService newCalcService){
	      boolean exists = false;
	      
	      for (CalcService service : calcServices) {
	         if(service.getName().equalsIgnoreCase(newCalcService.getName())){
	            exists = true;
	         }
	      }
	      if(!exists){
	    	  calcServices.add(newCalcService);
	      }
	   }

}
