package br.com.marceloaaps.fipe_api.model;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BrandData (@JsonAlias("nome") String vehicleName, @JsonAlias("codigo") String code){

}
