package com.pradipta.QuartzScheduling;


public class tester101 {
    public static void main(String[] args) throws Exception 
    {
//        configurationParameters.regionForDemo = configurationParameters.regionForDemoEnum.APAC;
//        configurationParameters.setCsvFileDefaultPayloadFileName("paymentValidation_moreThan1000_javaLoad.csv");
//        configurationParameters.csvFileDefaultPayloadFileName = "paymentValidation_moreThan1000_javaLoad.csv";
//        configurationParameters.threadPoolSize = 5;
//        configurationParameters.threadSleepTime = 0;
        System.out.println("############# : " + configurationParameters.getCsvFileDefaultPayloadFullFilePath());
        com.pradipta.QuartzScheduling.ExecutorStarting obj = new com.pradipta.QuartzScheduling.ExecutorStarting();
        obj.callServicefromFilePayload();
    }
}
