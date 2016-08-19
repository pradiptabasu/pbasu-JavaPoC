package com.pradipta.QuartzScheduling;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Properties;


@SuppressWarnings("oracle.jdeveloper.java.unrestricted-field-access")
public class configurationParameters {
    public configurationParameters() {
        super();
    }

    public static enum loadGenerationCategoryEnumeration {
        DEFAULT("DEFAULT"),
        ERROR("ERROR"),
        SUCCESS("SUCCESS");
        String loadGenerationCategory;

        @SuppressWarnings("unused")
        private loadGenerationCategoryEnumeration(String value) {
            this.loadGenerationCategory = value;
        }
    }

    public static enum regionForDemoEnum {
        APAC("APAC"),
        US("US"),
        EMEA("EMEA");
        String regionForDemo;

        @SuppressWarnings("unused")
        private regionForDemoEnum(String value) {
            this.regionForDemo = value;
        }
    }

    public static enum timeIntervalUnitEnum {
        HOUR("HOUR"),
        MINUTE("MINUTE"),
        SECOND("SECOND"),
        MILLISECOND("MILLISECOND");
        String timeIntervalUnit;

        @SuppressWarnings("unused")
        private timeIntervalUnitEnum(String value) {
            this.timeIntervalUnit = value;
        }
    }

    public static String csvFilePath ;
    public static String csvFileDefaultPayloadFileName ;
    public static String csvFileDefaultPayloadFullFilePath ;
    public static int threadPoolSize;
    public static int threadSleepTime;
    public static loadGenerationCategoryEnumeration loadGenerationCategory ;
    public static regionForDemoEnum regionForDemo ;
    public static timeIntervalUnitEnum timeIntervalUnit ;
    public static int timeInterval;
    public static String schedulerStartDateStr ;
    public static String schedulerEndDateStr ;
    public static String schedulerJobName ;

    public static SimpleDateFormat schedulerDateFormat;

    private static Properties prop;

    static {
        InputStream is = null;
        InputStream is1 = null;
        try {
            prop = new Properties();
            is = ClassLoader.class.getResourceAsStream("/configurationParameters.properties");
            prop.load(is);
            System.out.println(prop.getProperty("csvFilePath"));
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        csvFilePath = prop.getProperty("csvFilePath", "D:\\WorkSpace\\JMeter_POC\\");
        csvFileDefaultPayloadFileName = prop.getProperty("csvFileDefaultPayloadFileName", "PaymentsEnablement_ISA_final_load.csv");
        csvFileDefaultPayloadFullFilePath = csvFilePath + csvFileDefaultPayloadFileName;
        threadPoolSize = Integer.parseInt(prop.getProperty("threadPoolSize", "5"));
        threadSleepTime = Integer.parseInt(prop.getProperty("threadSleepTime", "5000"));
        timeInterval = Integer.parseInt(prop.getProperty("timeInterval", "1"));
        schedulerStartDateStr = prop.getProperty("schedulerStartDateStr", "2016-05-26 00:30:00.0");
        schedulerEndDateStr = prop.getProperty("schedulerEndDateStr", "2016-06-01 23:59:59.0");
        schedulerJobName = prop.getProperty("schedulerJobName", "defaultUser");
        
        String schedulerDateFormatPropValue = prop.getProperty("schedulerDateFormat", "yyyy-MM-dd HH:mm:ss.S");
        schedulerDateFormat = new SimpleDateFormat(schedulerDateFormatPropValue);
        
        String loadGenerationCategoryPropValue = prop.getProperty("loadGenerationCategory", "DEFAULT");
        if(loadGenerationCategoryPropValue.equalsIgnoreCase("DEFAULT")) {
            loadGenerationCategory = loadGenerationCategoryEnumeration.DEFAULT;
        }
        else if(loadGenerationCategoryPropValue.equalsIgnoreCase("ERROR")) {
            loadGenerationCategory = loadGenerationCategoryEnumeration.ERROR;
        }
        else if(loadGenerationCategoryPropValue.equalsIgnoreCase("SUCCESS")) {
            loadGenerationCategory = loadGenerationCategoryEnumeration.SUCCESS;
        }
        else {
            loadGenerationCategory = loadGenerationCategoryEnumeration.DEFAULT;
        }     
        
        String regionForDemoPropValue = prop.getProperty("regionForDemo", "APAC");
        if(regionForDemoPropValue.equalsIgnoreCase("APAC")) {
            regionForDemo = regionForDemoEnum.APAC;
        }
        else if(regionForDemoPropValue.equalsIgnoreCase("EMEA")) {
            regionForDemo = regionForDemoEnum.EMEA;
        }
        else if(regionForDemoPropValue.equalsIgnoreCase("US")) {
            regionForDemo = regionForDemoEnum.US;
        }
        else {
            regionForDemo = regionForDemoEnum.APAC;
        }
        
        String timeIntervalUnitPropValue = prop.getProperty("timeIntervalUnit", "HOUR");
        if(timeIntervalUnitPropValue.equalsIgnoreCase("HOUR")) {
            timeIntervalUnit = timeIntervalUnitEnum.HOUR;
        }
        else if(timeIntervalUnitPropValue.equalsIgnoreCase("MILLISECOND")) {
            timeIntervalUnit = timeIntervalUnitEnum.MILLISECOND;
        }
        else if(timeIntervalUnitPropValue.equalsIgnoreCase("MINUTE")) {
            timeIntervalUnit = timeIntervalUnitEnum.MINUTE;
        }
        else if(timeIntervalUnitPropValue.equalsIgnoreCase("SECOND")) {
            timeIntervalUnit = timeIntervalUnitEnum.SECOND;
        }
        else {
            timeIntervalUnit = timeIntervalUnitEnum.HOUR;
        }
    }

    public static void setCsvFilePath(String csvFilePathParam) {
        csvFilePath = csvFilePathParam;
    }

    public static String getCsvFilePath() {
        return csvFilePath;
    }

    public static void setCsvFileDefaultPayloadFileName(String csvFileDefaultPayloadFileNameParam) {
        csvFileDefaultPayloadFileName = csvFileDefaultPayloadFileNameParam;
    }

    public static String getCsvFileDefaultPayloadFileName() {
        return csvFileDefaultPayloadFileName;
    }

    public static void setCsvFileDefaultPayloadFullFilePath(String csvFileDefaultPayloadFullFilePath) {
        csvFileDefaultPayloadFullFilePath = csvFilePath + csvFileDefaultPayloadFileName;
    }

    public static String getCsvFileDefaultPayloadFullFilePath() {
        csvFileDefaultPayloadFullFilePath = csvFilePath + csvFileDefaultPayloadFileName;
        return csvFileDefaultPayloadFullFilePath;
    }

    public static void setThreadPoolSize(int threadPoolSize) {
        configurationParameters.threadPoolSize = threadPoolSize;
    }

    public static int getThreadPoolSize() {
        return threadPoolSize;
    }

    public static void setThreadSleepTime(int threadSleepTime) {
        configurationParameters.threadSleepTime = threadSleepTime;
    }

    public static int getThreadSleepTime() {
        return threadSleepTime;
    }

    public static void setLoadGenerationCategory(configurationParameters.loadGenerationCategoryEnumeration loadGenerationCategory) {
        configurationParameters.loadGenerationCategory = loadGenerationCategory;
    }

    public static configurationParameters.loadGenerationCategoryEnumeration getLoadGenerationCategory() {
        return loadGenerationCategory;
    }

    public static void setRegionForDemo(configurationParameters.regionForDemoEnum regionForDemo) {
        configurationParameters.regionForDemo = regionForDemo;
    }

    public static configurationParameters.regionForDemoEnum getRegionForDemo() {
        return regionForDemo;
    }

    public static void setTimeIntervalUnit(configurationParameters.timeIntervalUnitEnum timeIntervalUnit) {
        configurationParameters.timeIntervalUnit = timeIntervalUnit;
    }

    public static configurationParameters.timeIntervalUnitEnum getTimeIntervalUnit() {
        return timeIntervalUnit;
    }

    public static void setTimeInterval(int timeInterval) {
        configurationParameters.timeInterval = timeInterval;
    }

    public static int getTimeInterval() {
        return timeInterval;
    }

    public static void setSchedulerStartDateStr(String schedulerStartDateStr) {
        configurationParameters.schedulerStartDateStr = schedulerStartDateStr;
    }

    public static String getSchedulerStartDateStr() {
        return schedulerStartDateStr;
    }

    public static void setSchedulerEndDateStr(String schedulerEndDateStr) {
        configurationParameters.schedulerEndDateStr = schedulerEndDateStr;
    }

    public static String getSchedulerEndDateStr() {
        return schedulerEndDateStr;
    }

    public static void setSchedulerJobName(String schedulerJobName) {
        configurationParameters.schedulerJobName = schedulerJobName;
    }

    public static String getSchedulerJobName() {
        return schedulerJobName;
    }

    public static void setSchedulerDateFormat(SimpleDateFormat schedulerDateFormat) {
        configurationParameters.schedulerDateFormat = schedulerDateFormat;
    }

    public static SimpleDateFormat getSchedulerDateFormat() {
        return schedulerDateFormat;
    }
}
