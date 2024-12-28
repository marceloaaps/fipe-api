package br.com.marceloaaps.fipe_api.service;

public interface IDataConverter {

    <T> T obterDados(String json, Class<T> classe);
}
