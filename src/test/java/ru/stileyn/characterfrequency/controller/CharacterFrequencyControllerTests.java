package ru.stileyn.characterfrequency.controller;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CharacterFrequencyControllerTests {

    @Value("${local.server.port}")
    private int port;

    private final TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void testCharacterFrequency() {
        String input = "aaaaabcccc";
        String expectedResponse = "{\"a\":5,\"c\":4,\"b\":1}";

        String url = "http://localhost:" + port + "/character-frequency?input=" + input;
        String response = restTemplate.getForObject(url, String.class);

        assertEquals(expectedResponse, response);
    }
}
