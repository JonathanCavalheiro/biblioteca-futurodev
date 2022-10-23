package br.com.jonathan.bibliotecafuturodev.controller;

import br.com.jonathan.bibliotecafuturodev.model.entity.Autor;
import br.com.jonathan.bibliotecafuturodev.model.service.interfaces.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/autores")

public class AutorController {

    @Autowired
    private AutorService autorService;

    @PostMapping
    public ResponseEntity<Autor> salvar(@RequestBody Autor autor) {
        return ResponseEntity.
                status(HttpStatus.CREATED).
                body(this.autorService.salvar(autor));
    }

    @GetMapping
    public List<Autor> listar() {
        List<Autor> t = this.autorService.listar();
        return t;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> buscar(@PathVariable Long id) {
        Autor autor = this.autorService.buscar(id);

        if (autor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(this.autorService.buscar(id));
    }

    @GetMapping("/buscar-por-nome")
    public ResponseEntity<Autor> buscarPorNome(@PathParam("nome") String nome) {
        return ResponseEntity.ok(this.autorService.buscarPorNome(nome));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        this.autorService.deletar(id);
        return ResponseEntity.ok("Excluido com sucesso!");
    }
}
