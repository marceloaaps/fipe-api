package br.com.marceloaaps.fipe_api.model;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BrandData (@JsonAlias("codigo") String code, @JsonAlias("nome") String name){

    @Override
    public String toString() {
        return "Codigo: " + code + " - Nome: "  + name;
    }
}
