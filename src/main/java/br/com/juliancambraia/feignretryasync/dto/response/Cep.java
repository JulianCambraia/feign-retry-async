package br.com.juliancambraia.feignretryasync.dto.response;

import lombok.Data;

@Data
public class Cep {
  private String logradouro;
  private String bairro;
  private String cidade;
  private String estado;
}
