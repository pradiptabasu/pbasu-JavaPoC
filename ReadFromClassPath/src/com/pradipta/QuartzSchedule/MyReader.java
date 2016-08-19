package com.pradipta.QuartzSchedule;

import java.io.*;
import java.net.URISyntaxException;
import java.util.*;

public class MyReader {

	public static void main(String[] args) throws URISyntaxException {
		// TODO Auto-generated method stub
        Properties prop;
        InputStream is = null;
        InputStream is1 = null;
        try {
            prop = new Properties();
            is = ClassLoader.class.getResourceAsStream("/configurationParameters.properties");
            prop.load(is);
            System.out.println(prop.getProperty("csvFilePath"));
//            is1 = ClassLoader.class.getResourceAsStream("/configurationParameters.txt");
//            System.out.println(is1.available());
            System.out.println(ClassLoader.class.getResource("/configurationParameters.properties").toURI());
            System.out.println(ClassLoader.class.getResource("/configurationParameters.txt").toURI());
            System.out.println(ClassLoader.class.getResource("/PaymentsEnablement_ISA_final_loadCopy.csv").toURI());
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

}
