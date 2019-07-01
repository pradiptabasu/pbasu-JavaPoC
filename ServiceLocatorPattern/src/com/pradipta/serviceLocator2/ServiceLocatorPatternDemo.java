package com.pradipta.serviceLocator2;

public class ServiceLocatorPatternDemo {
	 public static void main(String[] args) {
		 String response = null;
	     Service service = ServiceLocator.getService("Service1");
	     response = service.execute();
	     System.out.println(response);
	     service = ServiceLocator.getService("Service2");
	     response = service.execute();
	     System.out.println(response);
	     service = ServiceLocator.getService("Service1");
	     response = service.execute();
	     System.out.println(response);
	     service = ServiceLocator.getService("Service2");
	     response = service.execute();
	     System.out.println(response);
	     service = ServiceLocator.getService("Service3");
	     response = service.execute();
	     System.out.println(response);
	   }

}
