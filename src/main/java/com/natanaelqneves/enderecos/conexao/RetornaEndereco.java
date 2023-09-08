package com.natanaelqneves.enderecos.conexao;

import com.google.gson.Gson;
import com.natanaelqneves.enderecos.modelo.Endereco;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RetornaEndereco {
    public static Endereco cep(String cep) throws IOException, InterruptedException {
                URI endereco = URI.create("https://viacep.com.br/ws/" + cep + "/json");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        HttpResponse<String> response = HttpClient
                .newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());
        return new Gson().fromJson(response.body(), Endereco.class);
    }
}
