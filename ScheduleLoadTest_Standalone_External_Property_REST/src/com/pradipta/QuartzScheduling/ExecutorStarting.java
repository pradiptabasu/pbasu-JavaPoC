package com.pradipta.QuartzScheduling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.ws.rs.client.Client;

import model.GetPaymentID;

@SuppressWarnings("oracle.jdeveloper.java.nested-assignment")
public class ExecutorStarting {
    
    private int MYTHREADS = configurationParameters.threadPoolSize;
    private String csvFile = "";

    //
    public void callServicefromFilePayload() throws Exception {

        ExecutorService executor = Executors.newFixedThreadPool(MYTHREADS);

//        if (configurationParameters.loadGenerationCategory ==
//            configurationParameters.loadGenerationCategoryEnumeration.DEFAULT) {
//            csvFile = configurationParameters.csvFileDefaultPayloadFullFilePath;
//        //    System.out.println("@@@@@@@ : " + configurationParameters.csvFileDefaultPayloadFullFilePath);
//        }
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        Client getPaymentIdClient = GetPaymentID.createClient();
        GetPaymentID.Root getpaymentidroot = GetPaymentID.root(getPaymentIdClient);
        
        long paymentReqId;
        String CustomerToken;
        String FinTechID;
        String Region;
        String PaymentCategory;
        float RequiredFunds;
        String salesChannel;
        String technicalChannel;

        try {
            br = new BufferedReader(new InputStreamReader(ClassLoader.class.getResourceAsStream("/PaymentsEnablement_ISA_final_load.csv")));
            //skips the line with header columns
            if ((line = br.readLine()) != null) {
            }

            while ((line = br.readLine()) != null) {
                int counter = 0;
                
                for (; counter < MYTHREADS; counter++) {
                    String[] payload = line.split(cvsSplitBy);

                    paymentReqId = getpaymentidroot.getAsPaymentIdResponse().getPaymentId();
                    CustomerToken = payload[0];
                    RequiredFunds = Float.parseFloat(payload[1]);
                    FinTechID = payload[2];
                    PaymentCategory = payload[3];
                    salesChannel = payload[4];
                    technicalChannel = payload[5];
                    Region = payload[6];

                    Runnable worker =
                        new com.pradipta.QuartzScheduling.LoadTestConsole(paymentReqId, CustomerToken, RequiredFunds,
                                                                          FinTechID, PaymentCategory, salesChannel,
                                                                          technicalChannel, Region);
                    executor.execute(worker);

                    Thread.sleep(configurationParameters.threadSleepTime);

                    if (counter < MYTHREADS - 1) {
                        if ((line = br.readLine()) != null) {
                        }
                    }
                }

                executor.shutdown();
                // Wait until all threads are finish
                while (!executor.isTerminated()) {

                }
                executor = Executors.newFixedThreadPool(MYTHREADS);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
