package br.com.senior.livraria.mapper;

import br.com.senior.livraria.dto.LivrariaDto;
import br.com.senior.livraria.model.entity.LivrariaEntity;
import org.springframework.stereotype.Service;

@Service
public class LivrariaMapper {
    public LivrariaDto toDto (LivrariaEntity livraria) {

        LivrariaDto dto = null;

        if (livraria != null) {
            dto = new LivrariaDto();
            dto.nomeLivraria = livraria.getNomeLivraria();
            dto.cnpj = livraria.getCnpj();
            dto.email = livraria.getEmail();
            dto.localizacao = livraria.getLocalizacao();
            dto.numeroTelefone = livraria.getNumeroTelefone();
        }
        return dto;
    }

    public LivrariaEntity toEntity (LivrariaDto dto) {
        LivrariaEntity livraria = null;

        if (livraria != null) {
            livraria = new LivrariaEntity();
            livraria.setNomeLivraria(dto.nomeLivraria);
            livraria.setCnpj(dto.cnpj);
            livraria.setEmail(dto.email);
            livraria.setLocalizacao(dto.localizacao);
            livraria.setNumeroTelefone(dto.numeroTelefone);
        }

        return livraria;
    }
}
