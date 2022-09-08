package com.github.ropdias;

import javax.inject.Inject;

import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.github.ropdias.viacep.Address;
import com.github.ropdias.viacep.ViaCEPService;
import com.fasterxml.jackson.databind.ObjectMapper;

@QuarkusMain
public class Main implements QuarkusApplication {

    private String cep;
    private Address address;
    private String newAddress;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Inject
    @RestClient
    ViaCEPService viaCEPService;

    @Override
    public int run(String... args) throws Exception {
        if (args.length != 0) {
            cep = args[0];
        } else {
            cep = "01001000";
        }
        try {
            address = viaCEPService.getAddress(cep);
        } catch (Exception e) {
            System.out.println("{\"error\":\"" + e.getMessage() + "\"}");
            return 0;
        }
        newAddress = objectMapper.writeValueAsString(address);
        System.out.println(newAddress);
        return 0;
    }
}
