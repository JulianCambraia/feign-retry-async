package br.com.juliancambraia.feignretryasync.services;

import br.com.juliancambraia.feignretryasync.repositories.ResponseRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

@Component("scheduleService")
public class ScheduleService {
  @Value("${cronTimer.reprocess}")
  private String reprocess;
  @Autowired
  private ThreadPoolTaskScheduler taskScheduler;
  @Autowired
  private ResponseRepository repository;
  @Autowired
  private ConsultService consultService;

  @PostConstruct
  public void init() {
    taskScheduler.schedule(() -> {
      repository.findAllBySuccessIsFalse().ifPresent(cepList -> cepList.forEach(cep -> consultService.consultaCep(cep.getCep())));
    }, new CronTrigger(reprocess));
  }
}
