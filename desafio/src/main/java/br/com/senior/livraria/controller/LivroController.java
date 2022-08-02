package br.com.senior.livraria.controller;

import br.com.senior.livraria.dto.LivroDto;
import br.com.senior.livraria.mapper.LivroMapper;
import br.com.senior.livraria.model.entity.LivroEntity;
import br.com.senior.livraria.model.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/livro")
public class LivroController {

    @Autowired
    private LivroService service;

    private LivroMapper mapper;

    @GetMapping(path = "api/livro/{idLivro}")
    public ResponseEntity<LivroDto> findById(@PathVariable String idLivro){
        UUID id = UUID.fromString(idLivro);
        LivroDto body = mapper.toDto(service.getLivro(id));

        return ResponseEntity.ok().body(body);
    }

    @GetMapping(path = "api/livro")
    public ResponseEntity<List<LivroDto>> findAll(){
        List<LivroDto> livroDtos = service.getAllLivros()
                .stream()
                .map(e -> mapper.toDto(e)).collect(Collectors.toList());

        return ResponseEntity.ok().body(livroDtos);
    };

    @GetMapping(path = "api/livro/{titulo}")
    public ResponseEntity<LivroDto> findByTitulo(@PathVariable String titulo){
        LivroDto body = mapper.toDto(service.getTitulo(titulo));

        return ResponseEntity.ok().body(body);
    }

    @GetMapping(path = "api/livro/{preco}")
    public ResponseEntity<LivroDto> findByPreco(@PathVariable BigDecimal preco){
        LivroDto body = mapper.toDto(service.getPreco(preco));

        return ResponseEntity.ok().body(body);
    }

    @GetMapping(path = "api/livro/{dataLancamento}")
    public ResponseEntity<LivroDto> findByDataLancamento(@PathVariable LocalDate dataLancamento){
        LivroDto body = mapper.toDto(service.getDataLancamento(dataLancamento));

        return ResponseEntity.ok().body(body);
    }

    @PostMapping(path = "api/livro")
    public ResponseEntity<LivroDto> cadastrarLivro (@RequestBody LivroDto livroDto){
        LivroEntity livro = mapper.toEntity(livroDto);
        LivroDto body = mapper.toDto(service.createLivro(livro));

        return ResponseEntity.ok().body(body);
    }

    @PutMapping(path = "api/atualizar/{idLivro}")
    public ResponseEntity<LivroDto> atualizarAutor(@PathVariable String idLivro,
                                                   @RequestBody LivroDto livroDto){
        UUID id = UUID.fromString(idLivro);
        LivroEntity livro = mapper.toEntity(livroDto);
        LivroDto body = mapper.toDto(service.updateLivro(id, livro));

        return  ResponseEntity.ok().body(body);
    }

    @DeleteMapping(path = "api/deletar/{idLivro}")
    public ResponseEntity<Void> deletarAutor(String idLivro){
        UUID id = UUID.fromString(idLivro);
        service.deleteLivro(id);

        return ResponseEntity.ok().build();
    }
}
