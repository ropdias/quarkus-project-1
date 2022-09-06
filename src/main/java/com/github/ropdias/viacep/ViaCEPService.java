package com.github.ropdias.viacep;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

// https://viacep.com.br/ws/01001000/json/

@Path("/{CEP}/json")
@RegisterRestClient(configKey="ViaCEP-api")
public interface ViaCEPService {

    @GET
    Address getAddress(@PathParam("CEP") String CEP);
}
