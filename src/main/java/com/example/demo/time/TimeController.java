package com.example.demo.time;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
public class TimeController {

  @GetMapping("/time")
  public String getCurrentTime() {
    try {
      return "Current Time: " + LocalDateTime.now();
    } catch (Exception e) {
      return "Error retrieving time: " + e.getMessage();
    }
  }
}