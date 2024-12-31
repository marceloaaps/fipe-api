package br.com.marceloaaps.fipe_api.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CarData(@JsonAlias("TipoVeiculo") String vehicleType, @JsonAlias("Valor") String value,
                      @JsonAlias("Marca") String brand,  @JsonAlias("Modelo") String model,
                      @JsonAlias("AnoModelo") String yearModel, @JsonAlias("Combustivel") String fuel,
                      @JsonAlias("CodigoFipe") String fipeCode, @JsonAlias("MesReferencia") String monthReference,
                      @JsonAlias("SiglaCombustivel") String fuelAcronym) {

    @Override
    public String toString() {
        return "Tipo do veículo: " + vehicleType + "\n Valor do Veículo: " + value + "\n Modelo do Veículo: "
                + model + "\n Ano do Modelo: " + yearModel + "\n Tipo de Combustível: " + fuel
                + "\n Código da FIPE: " + fipeCode + "\n Mês de Referência " +  monthReference
                + "\n Sigla de Combustível: " + fuelAcronym;
    }
}
