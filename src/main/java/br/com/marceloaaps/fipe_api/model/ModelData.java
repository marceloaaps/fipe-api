package br.com.marceloaaps.fipe_api.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.exc.IgnoredPropertyException;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ModelData(@JsonAlias("modelos") List<BrandData> model) {

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Modelos:\n");
        for (BrandData brand : model) {
            result.append(brand).append("\n");
        }
        return result.toString();
    }
}
