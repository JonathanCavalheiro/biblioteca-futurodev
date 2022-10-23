package br.com.jonathan.bibliotecafuturodev.model.repository;

import br.com.jonathan.bibliotecafuturodev.model.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

    Optional<Autor> findByNome(String nome);
}
