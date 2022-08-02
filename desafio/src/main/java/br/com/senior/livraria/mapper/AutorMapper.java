package br.com.senior.livraria.mapper;

import br.com.senior.livraria.dto.AutorDto;
import br.com.senior.livraria.model.entity.AutorEntity;
import org.springframework.stereotype.Service;

@Service
public class AutorMapper {

    public AutorDto toDto(AutorEntity autor){
        AutorDto dto = null;

        if (autor != null){
            dto = new AutorDto();
            dto.nomeAutor = autor.getNomeAutor();
            dto.generoAutor = autor.getGenero();
        }

        return dto;
    }

    public AutorEntity toEntity(AutorDto dto){
        AutorEntity autor = null;

        if (autor != null){
            autor = new AutorEntity();
            autor.setNomeAutor(dto.nomeAutor);
            autor.setGenero(dto.generoAutor);
        }

        return autor;
    }
}
