package com.github.ropdias;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;

import com.github.ropdias.resources.WireMockExtensions;
import com.github.ropdias.viacep.Address;
import com.github.ropdias.viacep.ViaCEPService;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.inject.Inject;

@QuarkusTest
@QuarkusTestResource(WireMockExtensions.class)
public class ViaCEPServiceTest {

    @Inject
    @RestClient
    ViaCEPService viaCEPService;

    @Test
    public void testGetAddress() {
        Address address = viaCEPService.getAddress("01001000");
        assertEquals("01001-000", address.getCep());
        // Fazer mais testes aqui
    }
}
