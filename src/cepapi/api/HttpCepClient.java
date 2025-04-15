package cepapi.api;

import cepapi.model.Cep;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpCepClient {

    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public Cep buscarCep(String cepDigitado) throws Exception {
        String url = "https://viacep.com.br/ws/" + cepDigitado + "/json/";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new RuntimeException("Erro ao buscar CEP. Codigo HTTP: " + response.statusCode());
        }


        String json = response.body();
        Cep cep = gson.fromJson(json, Cep.class);

        if (cep.cep() == null) {
            throw new RuntimeException("CEP inválido ou não encontrado.");
        }
        return cep;
    }
}

