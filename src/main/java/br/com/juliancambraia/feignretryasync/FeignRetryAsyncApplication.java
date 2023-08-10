package br.com.juliancambraia.feignretryasync;

import br.com.juliancambraia.feignretryasync.dto.response.Cep;
import br.com.juliancambraia.feignretryasync.services.ConsultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Optional;

@SpringBootApplication
@EnableFeignClients
public class FeignRetryAsyncApplication implements CommandLineRunner {

  @Autowired
  private ConsultService service;

  public static void main(String[] args) {
    SpringApplication.run(FeignRetryAsyncApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    /*Optional<Cep> cep = service.consultaCep("30750170");
    cep.ifPresent(System.out::println);*/
    System.out.println("teste");
  }
}
