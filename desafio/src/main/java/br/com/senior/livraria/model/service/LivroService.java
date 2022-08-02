package br.com.senior.livraria.model.service;

import br.com.senior.livraria.model.entity.LivroEntity;
import br.com.senior.livraria.model.exception.LivroNotFoundException;
import br.com.senior.livraria.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;

    public List<LivroEntity> getAllLivros(){
        Optional<List<LivroEntity>> livros = Optional.of(repository.findAll());

        if (livros.isPresent()){
            return livros.get()
                    .stream()
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        }
        throw new LivroNotFoundException("Não foi encontrados livros.");
    }

    public LivroEntity getLivro (UUID id){
        Optional<LivroEntity> livro = repository.findByIdLivro(id);

        if (livro.isPresent()){
            return livro.get();
        }

        throw new LivroNotFoundException("Não foi encontrado o livro.");
    }

    public LivroEntity getTitulo (String titulo){
        Optional<LivroEntity> livro = repository.findByTitulo(titulo);

        if (livro.isPresent()){
            return livro.get();
        }

        throw new LivroNotFoundException("Não foi encontrado o livro com este título.");
    }

    public LivroEntity getPreco (BigDecimal preco){
        Optional<LivroEntity> livro = repository.findByPreco(preco);

        if (livro.isPresent()){
            return livro.get();
        }

        throw new LivroNotFoundException("Não foi encontrado o livro com este preço.");
    }

    public LivroEntity getDataLancamento (LocalDate dataLancamento){
        Optional<LivroEntity> livro = repository.findByDataLancamento(dataLancamento);

        if (livro.isPresent()){
            return livro.get();
        }

        throw new LivroNotFoundException("Não foi encontrado o livro com esta data de lançamento.");
    }


    public LivroEntity updateLivro (UUID id, LivroEntity livro){
        LivroEntity novoLivro = this.getLivro(id);
        novoLivro.setTitulo(livro.getTitulo());
        novoLivro.setDescriçao(livro.getDescriçao());
        novoLivro.setPreco(livro.getPreco());
        novoLivro.setDataLancamento(livro.getDataLancamento());

        return this.createLivro(novoLivro);
    }

    public  LivroEntity createLivro (LivroEntity livro){
        return repository.save(livro);
    }

    public void deleteLivro (UUID id) {
        if (!repository.existsByIdLivro(id)){
            throw new LivroNotFoundException("Livro não encontrado");
        }

        repository.deleteByIdLivro(id);
    }

}
