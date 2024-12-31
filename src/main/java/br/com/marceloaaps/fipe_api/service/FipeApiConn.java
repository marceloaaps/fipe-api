package br.com.marceloaaps.fipe_api.service;


import br.com.marceloaaps.fipe_api.model.BrandData;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class FipeApiConn {

    public String obterDados(String endereco) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (
                IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return response.body();
    }

    public static String findBrandCode(List<BrandData> brandDataList, String brandCode) {
        return brandDataList.stream()
                .filter(brandData -> brandData.code().equals(brandCode))
                .findFirst()
                .map(BrandData::code)
                .orElse("Argumento não encontrado");
    }
}
