package br.com.senior.livraria.model.service;

import br.com.senior.livraria.model.entity.AutorEntity;
import br.com.senior.livraria.model.exception.AutorNotFoundException;
import br.com.senior.livraria.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutorService {

    @Autowired
    private AutorRepository repository;

    public List<AutorEntity> getAllAutores(){
        Optional<List<AutorEntity>> autores = Optional.of(repository.findAll());

        if (autores.isPresent()){
            return autores.get()
                    .stream()
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        }
        throw new AutorNotFoundException("Não foi encontrados autores.");
    }

    public AutorEntity getAutor(UUID id){
        Optional<AutorEntity> autor = repository.findByIdAutor(id);

        if (autor.isPresent()){
            return autor.get();
        }

        throw new  AutorNotFoundException("Não foi encontrado o autor.");
    }

    public AutorEntity updateAutor(UUID id, AutorEntity autor){
        AutorEntity novoAutor = this.getAutor(id);
        novoAutor.setNomeAutor(autor.getNomeAutor());
        novoAutor.setGenero(autor.getGenero());

        return this.createAutor(novoAutor);
    }

    public AutorEntity createAutor(AutorEntity autor){
        return repository.save(autor);
    }

    public void deleteAutor(UUID id) {
        if (!repository.existsByIdAutor(id)){
            throw new AutorNotFoundException("Autor não encontrado");
        }

        repository.deleteByIdAutor(id);
    }
}
