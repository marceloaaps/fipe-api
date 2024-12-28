package br.com.marceloaaps.fipe_api.view;

import br.com.marceloaaps.fipe_api.model.TypeData;
import br.com.marceloaaps.fipe_api.service.DataConverter;
import br.com.marceloaaps.fipe_api.service.FipeApiConn;

import java.util.Scanner;

public class Menu {

    //https://parallelum.com.br/fipe/api/v1/carros/marcas/59/modelos
    private final String ENDERECO = "https://parallelum.com.br/fipe/api/v1/";
    private final FipeApiConn fipeApiConn = new FipeApiConn();

    private Scanner sc = new Scanner(System.in);

    public void showMenu(){

        System.out.println("Bem-vindo(a) a FIPE API");

        DataConverter dataConverter = new DataConverter();


        var json = fipeApiConn.obterDados(fipeApiConn.obterDados(ENDERECO + "carros/marcas/"));

        System.out.println(dataConverter.obterDados(json, TypeData.class));







    }


}
