package br.com.marceloaaps.fipe_api.service;

import com.fasterxml.jackson.core.type.TypeReference;

public interface IDataConverter {

    <T> T obterDados(String json, TypeReference<T> typeReference);
}
