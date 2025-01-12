package br.com.marceloaaps.fipe_api.view;

import br.com.marceloaaps.fipe_api.model.BrandData;
import br.com.marceloaaps.fipe_api.model.CarData;
import br.com.marceloaaps.fipe_api.model.ModelData;
import br.com.marceloaaps.fipe_api.service.DataConverter;
import br.com.marceloaaps.fipe_api.service.FipeApiConn;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.*;

public class Menu {

    private static final String ENDERECO = "https://parallelum.com.br/fipe/api/v1/";
    private final FipeApiConn fipeApiConn = new FipeApiConn();
    private static final String MARCAS = "/marcas/";

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

        List<BrandData> brandDataList = dataConverter.obterDados(json, new TypeReference<>() {
        });

        brandDataList.forEach(System.out::println);

        System.out.println("Das Marcas acima, digite o código de qual você deseja: ");
        String brandCode = sc.next();

        String vehicleBrandCode = brandDataList.stream().filter(brandData -> brandData.code().equals(brandCode)).
                findFirst()
                .map(BrandData::code)
                .orElse("Marca não encontrada.");

        json = fipeApiConn.obterDados(ENDERECO + address + MARCAS + vehicleBrandCode + "/modelos");

        ModelData vehicleModelList = dataConverter.obterDados(json, new TypeReference<>() {
        });

        System.out.println(vehicleModelList);

        System.out.println("Digite o codigo desejado do veículo: ");
        String modelCode = sc.next();

        String vehicleModelCode = FipeApiConn.findBrandCode(vehicleModelList.model(), modelCode);

        System.out.println(vehicleModelCode);

        json = fipeApiConn.obterDados(ENDERECO + address + MARCAS + vehicleBrandCode + "/modelos/" + vehicleModelCode + "/anos");
        System.out.println(json);

        brandDataList = dataConverter.obterDados(json, new TypeReference<>() {
        });

        brandDataList.forEach(System.out::println);

        System.out.println("Dos anos acima  acima, digite o código de qual você deseja: ");
        String aBrandCode = sc.next();

        String vehicleYearCode = FipeApiConn.findBrandCode(brandDataList, aBrandCode);

        json = fipeApiConn.obterDados(ENDERECO + address + MARCAS + vehicleBrandCode + "/modelos/"
                + vehicleModelCode + "/anos/" + vehicleYearCode);

        CarData carInfo = dataConverter.obterDados(json, new TypeReference<>() {
        });

        System.out.println(carInfo);

    }
}
