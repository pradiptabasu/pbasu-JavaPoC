package com.pradipta.serviceLocator;

public class InitialContext {
	public Object lookup(String jndiName){
		   
	      if(jndiName.equalsIgnoreCase("SERVICE1")){
	         System.out.println("Looking up and creating a new Service1 object");
	         return new Service1();
	      }
	      else if (jndiName.equalsIgnoreCase("SERVICE2")){
	         System.out.println("Looking up and creating a new Service2 object");
	         return new Service2();
	      }
	      else if (jndiName.equalsIgnoreCase("SERVICE3")){
		         System.out.println("Looking up and creating a new Service3 object");
		         return new Service3();
		      }
	      return null;		
	   }

}
