package br.com.juliancambraia.feignretryasync.controller;

import br.com.juliancambraia.feignretryasync.dto.response.Cep;
import br.com.juliancambraia.feignretryasync.services.ConsultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consultaCeps/")
public class ApiPostmonCepController {
  @Autowired
  private ConsultService service;

  @GetMapping("cep/{cep}")
  public Cep consultarCep(@PathVariable("cep") String cep) {
    var result = service.consultaCep(cep);
    return ResponseEntity.of(result).getBody();
  }
}

