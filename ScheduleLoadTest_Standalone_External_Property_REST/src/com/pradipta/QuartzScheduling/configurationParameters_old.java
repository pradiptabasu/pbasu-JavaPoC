package com.pradipta.QuartzScheduling;

import java.text.SimpleDateFormat;


@SuppressWarnings("oracle.jdeveloper.java.unrestricted-field-access")
public class configurationParameters_old {
    public configurationParameters_old() {
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

    public static String csvFilePath = "E:\\JDeveloperWorkspace\\JMeter_POC\\";
    public static String csvFileDefaultPayloadFileName = "PaymentsEnablement_ISA_final_load.csv";
    public static String csvFileDefaultPayloadFullFilePath = csvFilePath + csvFileDefaultPayloadFileName;

    public static int threadPoolSize = 5;
    public static int threadSleepTime = 5000;
    
    public static loadGenerationCategoryEnumeration loadGenerationCategory = loadGenerationCategoryEnumeration.DEFAULT;
    public static regionForDemoEnum regionForDemo = regionForDemoEnum.APAC;
    public static timeIntervalUnitEnum timeIntervalUnit = timeIntervalUnitEnum.MINUTE;
    
    public static int timeInterval = 10;
    
    public static String schedulerStartDateStr = "2016-05-09 12:25:00.0";
    public static String schedulerEndDateStr = "2016-06-09 13:30:00.0";
    public static String schedulerJobName = "defaultUser";
    
    public static SimpleDateFormat schedulerDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
}
