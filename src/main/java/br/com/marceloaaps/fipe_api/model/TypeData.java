package br.com.marceloaaps.fipe_api.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public record TypeData(@JsonAlias({"carros", "motos", "caminhoes"}) Integer vehicleType) {
}
