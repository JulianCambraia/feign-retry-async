package br.com.juliancambraia.feignretryasync.services;

import br.com.juliancambraia.feignretryasync.client.CepClient;
import br.com.juliancambraia.feignretryasync.dto.response.Cep;
import br.com.juliancambraia.feignretryasync.model.Response;
import br.com.juliancambraia.feignretryasync.repositories.ResponseRepository;
import feign.FeignException;
import feign.RetryableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class ConsultService {
  @Autowired
  private CepClient client;

  @Autowired
  private ResponseRepository repository;

  public Optional<Cep> consultaCep(String cep) {
    try {
      Cep cepResponse = this.getByCep(cep).get();

      Response response = new Response();
      response.setCep(cep);
      response.setCreate_at(new Date());
      response.setLogradouro(cepResponse.getLogradouro());
      response.setBairro(cepResponse.getBairro());
      response.setCidade(cepResponse.getCidade());
      response.setEstado(cepResponse.getEstado());

      repository.save(response);

      return Optional.of(cepResponse);

    } catch (InterruptedException | ExecutionException | FeignException e) {
      Optional<Response> repositoryById = repository.findByCep(cep);
      Response response;

      if (repositoryById.isPresent()) {
        response = repositoryById.get();
        response.setUpdate_at(new Date());
      } else {
        response = new Response();
        response.setCep(cep);
        response.setCreate_at(new Date());
      }

      repository.save(response);
    }

    return Optional.empty();
  }

  @Async("threadPoolTaskAsyncExecutor")
  public CompletableFuture<Cep> getByCep(String cep) {
    return CompletableFuture.completedFuture(client.get(cep));
  }
}
