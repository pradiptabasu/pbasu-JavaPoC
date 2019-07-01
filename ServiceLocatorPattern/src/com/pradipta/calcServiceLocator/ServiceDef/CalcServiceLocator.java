package com.pradipta.calcServiceLocator.ServiceDef;

public class CalcServiceLocator {
	   private static CalcCache cache;

	   static {
	      cache = new CalcCache();		
	   }

	   public static CalcService getService(String jndiName){

		   CalcService calcService = cache.getService(jndiName);

	      if(calcService != null){
	         return calcService;
	      }

	      InitialContext context = new InitialContext();
	      CalcService calcService1 = (CalcService)context.lookup(jndiName);
	      cache.addService(calcService1);
	      return calcService1;
	   }

}
