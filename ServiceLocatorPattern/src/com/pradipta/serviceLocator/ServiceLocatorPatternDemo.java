package com.pradipta.serviceLocator;

public class ServiceLocatorPatternDemo {
	 public static void main(String[] args) {
	      Service service = ServiceLocator.getService("Service1");
	      service.execute();
	      service = ServiceLocator.getService("Service2");
	      service.execute();
	      service = ServiceLocator.getService("Service1");
	      service.execute();
	      service = ServiceLocator.getService("Service2");
	      service.execute();
	      service = ServiceLocator.getService("Service3");
	      service.execute();
	   }

}
