package br.com.jonathan.bibliotecafuturodev.model.service.interfaces;

import br.com.jonathan.bibliotecafuturodev.model.entity.Autor;

public interface AutorService extends DefaultCrud<Autor> {

    Autor buscarPorNome(String nome);
}
