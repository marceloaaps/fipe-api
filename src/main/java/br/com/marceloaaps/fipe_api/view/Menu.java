package br.com.marceloaaps.fipe_api.view;

import br.com.marceloaaps.fipe_api.model.BrandData;
import br.com.marceloaaps.fipe_api.service.DataConverter;
import br.com.marceloaaps.fipe_api.service.FipeApiConn;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.*;
import java.util.stream.Collectors;

public class Menu {

    //https://parallelum.com.br/fipe/api/v1/carros/marcas/59/modelos
    private final String ENDERECO = "https://parallelum.com.br/fipe/api/v1/";
    private final FipeApiConn fipeApiConn = new FipeApiConn();

    private Scanner sc = new Scanner(System.in);

    public void showMenu() {

        Map<String, String> validOptions = new HashMap<>();
        validOptions.put("1", "carros");
        validOptions.put("2", "motos");
        validOptions.put("3", "caminhoes");

        System.out.println();
        System.out.println("Bem-vindo(a) a FIPE API");
        System.out.print("Qual tipo de veículo é?\n1 - Carro\n2 - Moto\n3 - Caminhao");
        System.out.println();
        var address = sc.nextLine();

        if (!validOptions.containsKey(address)) {
            throw new IllegalArgumentException("Argumento ilegal encontrado.");
        }


        address = validOptions.getOrDefault(address, "seila");
        var json = fipeApiConn.obterDados(ENDERECO + address + "/marcas");

        DataConverter dataConverter = new DataConverter();
        ;
        List<BrandData> brandDataList = dataConverter.obterDados(json, new TypeReference<>() {
        });

        brandDataList.forEach(System.out::println);

        System.out.println("Das Marcas acima, digite o código de qual você deseja: ");
        String brandCode = sc.next();

        String x = brandDataList.stream().filter(brandData -> brandData.code().equals(brandCode)).
                findFirst()
                .map(BrandData::toString)
                .orElse("Marca não encontrada.");

        System.out.println(x);


    }
}
