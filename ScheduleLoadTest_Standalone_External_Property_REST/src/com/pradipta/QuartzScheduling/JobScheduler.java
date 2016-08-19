package com.pradipta.QuartzScheduling;

import java.util.Date;
import java.util.List;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;

@SuppressWarnings("oracle.jdeveloper.java.semantic-warning")
public class JobScheduler {
    public static void main(String[] args) throws Exception {
    
//        configurationParameters.threadPoolSize = 1;
//        configurationParameters.threadSleepTime = 60000;
//        configurationParameters.schedulerStartDateStr = "2016-05-09 13:32:00.0";
//        configurationParameters.schedulerEndDateStr = "2016-06-09 13:30:00.0";
                      
        String startDateStr = configurationParameters.schedulerStartDateStr;
        String endDateStr = configurationParameters.schedulerEndDateStr;
        Date startDate = configurationParameters.schedulerDateFormat.parse(startDateStr);
        Date endDate = configurationParameters.schedulerDateFormat.parse(endDateStr);
        configurationParameters.timeIntervalUnit = configurationParameters.timeIntervalUnitEnum.HOUR;
        configurationParameters.timeInterval = 1;

        Trigger trigger = null;
        JobDetail job = JobBuilder.newJob(com.pradipta.QuartzScheduling.QuartzJobDefn.class).withDescription(configurationParameters.regionForDemo.toString()).withIdentity(configurationParameters.schedulerJobName,configurationParameters.loadGenerationCategory.toString()).build();
        
        if(configurationParameters.timeIntervalUnit == configurationParameters.timeIntervalUnitEnum.MINUTE) 
        {
            trigger = TriggerBuilder.newTrigger().withDescription(configurationParameters.regionForDemo.toString()).withIdentity(configurationParameters.schedulerJobName,configurationParameters.loadGenerationCategory.toString()).startAt(startDate).withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInMinutes(configurationParameters.timeInterval).repeatForever()).endAt(endDate).build();
        }  
        else if(configurationParameters.timeIntervalUnit == configurationParameters.timeIntervalUnitEnum.HOUR) 
        {
            trigger = TriggerBuilder.newTrigger().withDescription(configurationParameters.regionForDemo.toString()).withIdentity(configurationParameters.schedulerJobName,configurationParameters.loadGenerationCategory.toString()).startAt(startDate).withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInHours((configurationParameters.timeInterval)).repeatForever()).endAt(endDate).build();
        }
        else if(configurationParameters.timeIntervalUnit == configurationParameters.timeIntervalUnitEnum.SECOND) 
        {
            trigger = TriggerBuilder.newTrigger().withDescription(configurationParameters.regionForDemo.toString()).withIdentity(configurationParameters.schedulerJobName,configurationParameters.loadGenerationCategory.toString()).startAt(startDate).withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds((configurationParameters.timeInterval)).repeatForever()).endAt(endDate).build();
        }
        else if(configurationParameters.timeIntervalUnit == configurationParameters.timeIntervalUnitEnum.MILLISECOND) 
        {
            trigger = TriggerBuilder.newTrigger().withDescription(configurationParameters.regionForDemo.toString()).withIdentity(configurationParameters.schedulerJobName,configurationParameters.loadGenerationCategory.toString()).startAt(startDate).withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInMilliseconds((configurationParameters.timeInterval)).repeatForever()).endAt(endDate).build();
        }
        
        // schedule it
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
        scheduler.scheduleJob(job, trigger);
        
        for (String groupName : scheduler.getJobGroupNames()) {
            for (JobKey jobKey : scheduler.getJobKeys(GroupMatcher.jobGroupEquals(groupName))) {
                String jobName = jobKey.getName();
                String jobGroup = jobKey.getGroup();
                List triggers = (List) scheduler.getTriggersOfJob(jobKey);
                System.out.println(triggers.size());
                Trigger trig = (Trigger) triggers.get(0);

                System.out.println("Job groupName: " + groupName);
                System.out.println("Job Name: " + jobName);
                System.out.println("jobGroup : " + jobGroup);
                System.out.println("getDescription : " + trig.getDescription());
                System.out.println("getFinalFireTime : " + trig.getFinalFireTime());
                System.out.println("getNextFireTime : " + trig.getNextFireTime());
                System.out.println("getPreviousFireTime : " + trig.getPreviousFireTime());
                System.out.println("getPriority : " + trig.getPriority());
                System.out.println("getStartTime : " + trig.getStartTime());
            }
        }
    }
}
