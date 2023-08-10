package br.com.juliancambraia.feignretryasync.config;

import br.com.juliancambraia.feignretryasync.repositories.ResponseRepository;
import feign.RetryableException;
import feign.Retryer;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@NoArgsConstructor
public class CustomRetryer implements Retryer {

  @Value("${retryMaxAttempt}")
  private int retryMaxAttempt;

  @Value("${retryInterval}")
  private long retryInterval;

  private int attempt = 1;

  @Autowired
  private ResponseRepository repository;

  public CustomRetryer(int retryMaxAttempt, long retryInterval) {
    this.retryMaxAttempt = retryMaxAttempt;
    this.retryInterval = retryInterval;
  }

  @Override
  public void continueOrPropagate(RetryableException e) {
    log.info("Feign retry attempt {} due to {} ", attempt, e.getMessage());

    if (attempt++ == retryMaxAttempt) {
      throw e;
    }
    try {
      Thread.sleep(retryInterval);
    } catch (InterruptedException ignored) {
      Thread.currentThread().interrupt();
    }
  }

  @Override
  public Retryer clone() {
    return new CustomRetryer(retryMaxAttempt, retryInterval);
  }
}
