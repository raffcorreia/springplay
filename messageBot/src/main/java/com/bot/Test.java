package com.bot;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Test {

    private int someValidation(int i) {
        double test = Math.pow(i , 2);
        String result = String.valueOf(Math.floorMod((long)test, i));
        return Integer.parseInt(String.valueOf(result));
    }

    public static void main(String[] args) throws IOException, InterruptedException {

        // fazer uma conexão HTTP e buscar o top 250 filmes

        String url = "https://alura-filmes.herokuapp.com/conteudos";
        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        System.out.println(body);





        // pegar só os dados que interessam (título, pôster, classificação)

        // exibir e manipular os dados
    }
}
