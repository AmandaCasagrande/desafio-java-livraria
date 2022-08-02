package br.com.senior.livraria.mapper;

import br.com.senior.livraria.dto.LivroDto;
import br.com.senior.livraria.model.entity.LivroEntity;
import org.springframework.stereotype.Service;

@Service
public class LivroMapper {

    public LivroDto toDto(LivroEntity livro) {
        LivroDto dto = null;

        if (livro != null){
            dto = new LivroDto();
            dto.titulo = livro.getTitulo();
            dto.descrição = livro.getDescriçao();
            dto.preço = livro.getPreco();
            dto.dataLancamento = livro.getDataLancamento();
        }

        return dto;
    }

    public LivroEntity toEntity (LivroDto dto){
        LivroEntity livro = null;

        if (livro != null){
            livro = new LivroEntity();
            livro.setTitulo(dto.titulo);
            livro.setDescriçao(dto.descrição);
            livro.setPreco(dto.preço);
            livro.setDataLancamento(dto.dataLancamento);
        }

        return livro;
    }
}
