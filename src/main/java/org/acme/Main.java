package org.acme;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import java.util.Scanner;

import javax.inject.Inject;

import org.acme.viacep.Address;
import org.acme.viacep.AddressSerializer;
import org.acme.viacep.ViaCEPService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;


@QuarkusMain
public class Main implements QuarkusApplication {

  @Inject
  @RestClient
  ViaCEPService viaCEPService;

  @Override
  public int run(String... args) throws Exception {
    Scanner reader = new Scanner(System.in); // Reading from System.in
    ObjectMapper objectMapper = new ObjectMapper();
    SimpleModule module = new SimpleModule();
    module.addSerializer(Address.class, new AddressSerializer());
    objectMapper.registerModule(module);

    System.out.println("Enter CEP: ");
    String cep = reader.next();
    System.out.println("CEP to make a REST request: " + cep);
    Address address = viaCEPService.getAddress(cep);
    // String stringteste = "{\"cep\": \"01001-000\",\"logradouro\": \"Praça da Sé\",\"complemento\": \"lado ímpar\",\"bairro\": \"Sé\",\"localidade\": \"São Paulo\",\"uf\": \"SP\",\"ibge\": \"3550308\",\"gia\": \"1004\",\"ddd\":\"11\",\"siafi\": \"7107\"}";
    // Address newAddress = objectMapper.readValue(stringteste, Address.class);
    // System.out.println(newAddress.getLogradouro());

    String newAddress = objectMapper.writeValueAsString(address);
    System.out.println(newAddress);

    reader.close(); // once finished
    return 0;
  }
}
