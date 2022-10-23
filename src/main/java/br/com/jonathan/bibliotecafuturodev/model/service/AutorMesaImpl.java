package br.com.jonathan.bibliotecafuturodev.model.service;

import br.com.jonathan.bibliotecafuturodev.model.entity.Autor;
import br.com.jonathan.bibliotecafuturodev.model.repository.AutorRepository;
import br.com.jonathan.bibliotecafuturodev.model.service.interfaces.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class AutorMesaImpl implements AutorService {

    @Autowired
     private AutorRepository autorRepository;

    @Override
    public Autor salvar(Autor autor) {
        return this.autorRepository.save(autor);
    }

    @Override
    public Autor atualizar(Autor object) {
        return null;
    }

    @Override
    public Autor buscar(Long id) {
        Optional<Autor> autorPesquisado = this.autorRepository.findById(id);

        if (autorPesquisado.isEmpty()){
            throw new EntityNotFoundException("Não foi possível encontrar o autor com id " +id);
        }
        return autorPesquisado.get();
    }

    @Override
    public List<Autor> listar() {

        return this.autorRepository.findAll();
    }

    @Override
    public Autor buscarPorNome(String nome) {

        return this.autorRepository.findByNome(nome).orElseThrow(() -> {
            throw new EntityNotFoundException("Não foi possível encontrar um prato com o nome: " + nome);
        });
    }

    @Override
    public void deletar(Long id) {
        this.autorRepository.deleteById(id);

    }
}
