package com.pradipta.QuartzScheduling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import java.util.Properties;

public class testPOC {
    public void printALL() throws Exception{
        Properties prop;
        InputStream is = null;
        try {
            prop = new Properties();
            is = ClassLoader.class.getResourceAsStream("/configurationParameters.properties");
            prop.load(is);
            System.out.println(prop.getProperty("csvFilePath"));
            System.out.println(ClassLoader.class.getResource("/configurationParameters.properties").toURI());
            System.out.println(ClassLoader.class.getResource("/PaymentsEnablement_ISA_final_load.csv").toURI());
            System.out.println(ClassLoader.class.getResource("/PaymentsEnablement_ISA_final_loadCopy.csv").toURI());
            System.out.println(ClassLoader.class.getResourceAsStream("/PaymentsEnablement_ISA_final_load.csv"));
            
            BufferedReader br = null;
            String line = "";
            String cvsSplitBy = ",";
        //            br = new BufferedReader(new FileReader(csvFile)));
        //            if ((line = br.readLine()) != null) {
        //                System.out.println(line);
        //            }
        //
        //            while ((line = br.readLine()) != null) {
        //                int counter = 0;
        //
        //                for (; counter < 10; counter++) {
        //                    String[] payload = line.split(cvsSplitBy);
        //
        //                    System.out.println(payload[0]);
        //                    System.out.println(Float.parseFloat(payload[1]));
        //                    System.out.println(payload[2]);
        //                    System.out.println(payload[3]);
        //                    System.out.println(payload[4]);
        //                    System.out.println(payload[5]);
        //                    System.out.println(payload[6]);
        //                }
        //            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args)throws Exception {
        testPOC testPOC = new testPOC();
        System.out.println("in main");
        testPOC.printALL();
    }
}
