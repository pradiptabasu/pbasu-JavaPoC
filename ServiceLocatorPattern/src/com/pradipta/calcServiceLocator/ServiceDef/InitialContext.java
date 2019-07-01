package com.pradipta.calcServiceLocator.ServiceDef;

public class InitialContext {
	public Object lookup(String jndiName){
		   
	      if(jndiName.equalsIgnoreCase("DoubleYourInput")){
	         System.out.println("Looking up and creating a new CalcDoubleInputService object");
	         return new CalcDoubleInputService();
	      }
	      else if (jndiName.equalsIgnoreCase("Sum")){
	         System.out.println("Looking up and creating a new Service2 object");
	         return new CalcSumInputService();
	      }
//	      else if (jndiName.equalsIgnoreCase("SERVICE3")){
//		         System.out.println("Looking up and creating a new Service3 object");
//		         return new Service3();
//		      }
	      return null;		
	   }

}
