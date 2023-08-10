package br.com.juliancambraia.feignretryasync.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
public class Response {

  @Id
  private String cep;
  private Date create_at;
  private Date update_at;
  private String logradouro;
  private String bairro;
  private String cidade;
  private String estado;
  private boolean success;
}
