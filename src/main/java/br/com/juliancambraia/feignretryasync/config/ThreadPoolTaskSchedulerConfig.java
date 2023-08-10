package br.com.juliancambraia.feignretryasync.config;

import br.com.juliancambraia.feignretryasync.services.ScheduleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
@ComponentScan(basePackages = "br.com.juliancambraia.feignretryasync.service", basePackageClasses = {ScheduleService.class})
public class ThreadPoolTaskSchedulerConfig {

  @Bean
  public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
    ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
    threadPoolTaskScheduler.setPoolSize(5);
    threadPoolTaskScheduler.setThreadNamePrefix("ScheduleService");

    return threadPoolTaskScheduler;
  }
}
