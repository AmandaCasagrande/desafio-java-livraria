package br.com.senior.livraria.controller;

import br.com.senior.livraria.dto.LivrariaDto;
import br.com.senior.livraria.mapper.LivrariaMapper;
import br.com.senior.livraria.model.entity.LivrariaEntity;
import br.com.senior.livraria.model.service.LivrariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/livraria")
public class LivrariaController {

    @Autowired
    private LivrariaService service;

    @Autowired
    private LivrariaMapper mapper;

    @GetMapping(path = "/pesquisar/{idLivraria}")
    public ResponseEntity<LivrariaDto> findById (@PathVariable String idLivraria){
        UUID id = UUID.fromString(idLivraria);
        LivrariaDto body = mapper.toDto(service.getLivraria(id));

        return ResponseEntity.ok().body(body);
    }
    @GetMapping(path = "/pesquisar")
    public ResponseEntity<List<LivrariaDto>> findAll(){
        List<LivrariaDto> livrariaDtos = service.getAllLivrarias()
                .stream()
                .map(e -> mapper.toDto(e)).collect(Collectors.toList());

        return ResponseEntity.ok().body(livrariaDtos);
    }

    @PostMapping(path = "/cadastrar")
    public ResponseEntity<LivrariaDto> cadastrarAutor(@RequestBody LivrariaDto livrariaDto){
        LivrariaEntity livraria = mapper.toEntity(livrariaDto);
        LivrariaDto body = mapper.toDto(service.createLivraria(livraria));

        return ResponseEntity.ok().body(body);
    };

    @PutMapping(path = "/alterar/{idLivraria}")
    public ResponseEntity<LivrariaDto> atualizarAutor(@PathVariable String idLivraria,
                                                      @RequestBody LivrariaDto livrariaDto){
        UUID id = UUID.fromString(idLivraria);
        LivrariaEntity livraria = mapper.toEntity(livrariaDto);
        LivrariaDto body = mapper.toDto(service.updateLivraria(id, livraria));

        return ResponseEntity.ok().body(body);
    }

    @DeleteMapping(path = "/deletar/{idLivraria}")
    public ResponseEntity<Void> deletarAutor(String idLivraria){
        UUID id = UUID.fromString(idLivraria);
        service.deleteLivraria(id);

        return ResponseEntity.ok().build();
    }
}
