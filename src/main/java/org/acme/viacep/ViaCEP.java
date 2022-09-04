package org.acme.viacep;

public class ViaCEP {
  public String cep;
  public String logradouro;
  public String complemento;
  public String bairro;
  public String localidade;
  public String uf;
  public String ibge;
  public String gia;
  public String ddd;
  public String siafi;

  public ViaCEP() {
  }

  public String getLogradouro() {
    return logradouro;
  }

  public void setLogradouro(String logradouro) {
    this.logradouro = logradouro;
  }

}
