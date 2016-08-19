package com.pradipta.QuartzScheduling;

import java.io.BufferedWriter;
import java.io.File;

import java.io.FileWriter;

import java.text.SimpleDateFormat;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class QuartzJobDefn implements Job {
    public QuartzJobDefn() {
        super();
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        // TODO Implement this method
        try 
        {
            Date dNow = new Date();
            SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
            System.out.println("Current Date: " + ft.format(dNow));
//            File file = new File("D:\\WorkSpace\\PaymentEnablement_ISA_v1\\Payments_LoadTest_UI\\jobDetails.txt");
//            if (!file.exists()) {
//                file.createNewFile();
//            }
//
//            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
//            BufferedWriter bw = new BufferedWriter(fw);
//            bw.write("Current Date: " + ft.format(dNow));
//            bw.close();
//            fw.close();
            com.pradipta.QuartzScheduling.ExecutorStarting obj = new com.pradipta.QuartzScheduling.ExecutorStarting();
            obj.callServicefromFilePayload();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
