package com.pradipta.QuartzScheduling;

import java.text.SimpleDateFormat;


@SuppressWarnings("oracle.jdeveloper.java.unrestricted-field-access")
public class configurationParameters_no_PropFile {
    public configurationParameters_no_PropFile() {
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

    public static String csvFilePath = "D:\\WorkSpace\\JMeter_POC\\";
    public static String csvFileDefaultPayloadFileName = "PaymentsEnablement_ISA_final_load.csv";
    public static String csvFileDefaultPayloadFullFilePath = csvFilePath + csvFileDefaultPayloadFileName;

    public static int threadPoolSize = 10;
    public static int threadSleepTime = 5000;
    
    public static loadGenerationCategoryEnumeration loadGenerationCategory = loadGenerationCategoryEnumeration.DEFAULT;
    public static regionForDemoEnum regionForDemo = regionForDemoEnum.APAC;
    public static timeIntervalUnitEnum timeIntervalUnit = timeIntervalUnitEnum.HOUR;
    
    public static int timeInterval = 1;
    

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

    public static configurationParameters_no_PropFile.loadGenerationCategoryEnumeration getLoadGenerationCategory() {
        return loadGenerationCategory;
    }

    public static void setRegionForDemo(configurationParameters.regionForDemoEnum regionForDemo) {
        configurationParameters.regionForDemo = regionForDemo;
    }

    public static configurationParameters_no_PropFile.regionForDemoEnum getRegionForDemo() {
        return regionForDemo;
    }

    public static void setTimeIntervalUnit(configurationParameters.timeIntervalUnitEnum timeIntervalUnit) {
        configurationParameters.timeIntervalUnit = timeIntervalUnit;
    }

    public static configurationParameters_no_PropFile.timeIntervalUnitEnum getTimeIntervalUnit() {
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

    public static String schedulerStartDateStr = "2016-05-26 00:30:00.0";
    public static String schedulerEndDateStr = "2016-06-01 23:59:59.0";
    public static String schedulerJobName = "defaultUser";
    
    public static SimpleDateFormat schedulerDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
}
