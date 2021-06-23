package com.thegreatapi.ahundreddaysofjava.day021;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.ok;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day021Test {

    private WireMockServer server;

    @BeforeEach
    void setUp() {
        server = new WireMockServer(WireMockConfiguration.wireMockConfig().dynamicPort());
        server.start();
    }

    @Test
    void test() throws Exception {
        mockWebServer();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                                         .uri(URI.create("http://localhost:" + server.port() + "/my/resource"))
                                         .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        assertEquals("TheGreatAPI.com", response.body());
    }

    private void mockWebServer() {
        server.stubFor(get("/my/resource")
                .willReturn(ok()
                        .withBody("TheGreatAPI.com")));
    }

    @AfterEach
    void tearDown() {
        server.shutdownServer();
    }
}