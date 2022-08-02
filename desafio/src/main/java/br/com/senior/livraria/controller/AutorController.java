package br.com.senior.livraria.controller;

import br.com.senior.livraria.dto.AutorDto;
import br.com.senior.livraria.mapper.AutorMapper;
import br.com.senior.livraria.model.entity.AutorEntity;
import br.com.senior.livraria.model.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/autor")
public class AutorController {

    @Autowired
    private AutorService service;

    @Autowired
    private AutorMapper mapper;

    @GetMapping(path = "api/autor/{idAutor}")
    public ResponseEntity<AutorDto> findById(@PathVariable String idAutor){
        UUID id = UUID.fromString(idAutor);

        AutorDto body = mapper.toDto(service.getAutor(id));
        return ResponseEntity.ok().body(body);
    }

    @GetMapping(path = "api/autor")
    public ResponseEntity<List<AutorDto>> findAll(){
        List<AutorDto> autorDtos = service.getAllAutores()
                .stream()
                .map(e -> mapper.toDto(e)).collect(Collectors.toList());
        return ResponseEntity.ok().body(autorDtos);
    }

    @PostMapping(path = "api/autor")
    public ResponseEntity<AutorDto> cadastrarAutor(@RequestBody AutorDto autorDto){
        AutorEntity autor = mapper.toEntity(autorDto);
        AutorDto body = mapper.toDto(service.createAutor(autor));
        return ResponseEntity.ok().body(body);
    }

    @PutMapping(path = "api/atualizar/{idAutor}")
    public ResponseEntity<AutorDto> atualizarAutor(@PathVariable String idAutor,
                                                   @RequestBody AutorDto autorDto){
        UUID id = UUID.fromString(idAutor);
        AutorEntity autor = mapper.toEntity(autorDto);
        AutorDto body = mapper.toDto(service.updateAutor(id, autor));

        return ResponseEntity.ok().body(body);
    }

    @DeleteMapping(path = "api/deletar/{idAutor}")
    public ResponseEntity<Void> deletarAutor(String idAutor){
        UUID id = UUID.fromString(idAutor);
        service.deleteAutor(id);

        return ResponseEntity.ok().build();
    }

}
