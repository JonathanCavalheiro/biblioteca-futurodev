package br.com.jonathan.bibliotecafuturodev.model.service.interfaces;

import java.util.List;

public interface DefaultCrud <T> {

    T salvar(T object);

    T atualizar(T object);

    T buscar(Long id);

    List<T> listar();

    T buscarPorNome(String nome);

    void deletar(Long id);

}
