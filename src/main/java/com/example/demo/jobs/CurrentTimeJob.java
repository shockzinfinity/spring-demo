package com.example.demo.jobs;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.time.LocalDateTime;

@Slf4j // Lombok을 사용한 Logger 설정
public class CurrentTimeJob implements Job {

  @Override
  public void execute(JobExecutionContext context) throws JobExecutionException {
    // 현재 시간을 로그로 기록
    log.info("Current Time: {}", LocalDateTime.now());
  }
}