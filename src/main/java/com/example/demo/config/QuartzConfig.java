package com.example.demo.config;

import com.example.demo.jobs.CurrentTimeJob;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.CronScheduleBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {

    // application.yml에서 설정 불러오기
    @Value("${quartz.job.name}")
    private String jobName;

    @Value("${quartz.trigger.name}")
    private String triggerName;

    @Value("${quartz.cron.expression}")
    private String cronExpression;

    // JobDetail 설정
    @Bean
    public JobDetail jobDetail() {
        return JobBuilder.newJob(CurrentTimeJob.class)
                .withIdentity(jobName)
                .storeDurably()
                .build();
    }

    // Trigger 설정
    @Bean
    public Trigger trigger(JobDetail jobDetail) {
        return TriggerBuilder.newTrigger()
                .forJob(jobDetail)
                .withIdentity(triggerName)
                .withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))
                .build();
    }
}