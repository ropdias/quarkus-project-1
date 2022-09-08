package com.github.ropdias;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Scanner;

import io.quarkus.test.junit.main.Launch;
import io.quarkus.test.junit.main.LaunchResult;
import io.quarkus.test.junit.main.QuarkusMainTest;
import io.quarkus.test.common.QuarkusTestResource;

import org.junit.jupiter.api.Test;

import com.github.ropdias.resources.WireMockExtensions;

@QuarkusMainTest
@QuarkusTestResource(WireMockExtensions.class)
public class MainTest {

    @Test
    @Launch("01001000")
    public void testCEP01001000(LaunchResult result) {
        String output = result.getOutput();
        Scanner scanner = new Scanner(output);
        String nextLineToRead = scanner.nextLine();
        while (nextLineToRead.substring(0, 1).matches("[0-9]")) {
            nextLineToRead = scanner.nextLine();
        }
        assertEquals("{\"cep\":\"01001-000\",\"nomeDaRua\":\"Praça da Sé\",\"complemento\":\"lado ímpar\",\"bairro\":\"Sé\",\"localidade\":\"São Paulo\",\"uf\":\"SP\",\"ibge\":\"3550308\",\"gia\":\"1004\",\"ddd\":\"11\",\"siafi\":\"7107\"}", nextLineToRead);
        assertEquals(0, result.exitCode());
        scanner.close();
    }
    
    @Test
    @Launch("01002000")
    public void testCEP01002000(LaunchResult result) {
        String output = result.getOutput();
        Scanner scanner = new Scanner(output);
        String nextLineToRead = scanner.nextLine();
        while (nextLineToRead.substring(0, 1).matches("[0-9]")) {
            nextLineToRead = scanner.nextLine();
        }
        assertEquals("{\"cep\":\"01002-000\",\"nomeDaRua\":\"Rua Direita\",\"complemento\":\"lado par\",\"bairro\":\"Sé\",\"localidade\":\"São Paulo\",\"uf\":\"SP\",\"ibge\":\"3550308\",\"gia\":\"1004\",\"ddd\":\"11\",\"siafi\":\"7107\"}", nextLineToRead);
        assertEquals(0, result.exitCode());
        scanner.close();
    }
    @Test
    @Launch("7761232151")
    public void testResponse400(LaunchResult result) {
        String output = result.getOutput();
        Scanner scanner = new Scanner(output);
        String nextLineToRead = scanner.nextLine();
        while (nextLineToRead.substring(0, 1).matches("[0-9]")) {
            nextLineToRead = scanner.nextLine();
        }
        assertEquals("{\"error\":\"The remote service responded with HTTP 400 !\"}", nextLineToRead);
        assertEquals(0, result.exitCode());
        scanner.close();
    }

}
