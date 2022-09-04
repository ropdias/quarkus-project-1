package org.acme;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import java.util.Scanner;
import org.acme.viacep.ViaCEP;
import org.acme.viacep.ViaCEPService;
import com.fasterxml.jackson.databind.ObjectMapper;

@QuarkusMain
public class Main implements QuarkusApplication {

  @RestClient
  ViaCEPService viaCEPService;

  @Override
  public int run(String... args) throws Exception {
    Scanner reader = new Scanner(System.in); // Reading from System.in
    System.out.println("Enter CEP: ");
    String cep = reader.next();
    System.out.println("CEP to make a REST request: " + cep);
    ViaCEP resultado = viaCEPService.getByCEP(cep);
    // String stringteste = "{\"cep\": \"01001-000\",\"logradouro\": \"Praça da
    // Sé\",\"complemento\": \"lado ímpar\",\"bairro\": \"Sé\",\"localidade\": \"São
    // Paulo\",\"uf\": \"SP\",\"ibge\": \"3550308\",\"gia\": \"1004\",\"ddd\":
    // \"11\",\"siafi\": \"7107\"}";

    // System.out.println(resultado.cep);
    // System.out.println(resultado.logradouro);

    final var objectMapper = new ObjectMapper();
    final var newCEP = objectMapper.writeValueAsString(resultado);
    System.out.println(newCEP);
    reader.close(); // once finished
    return 0;
  }
}
