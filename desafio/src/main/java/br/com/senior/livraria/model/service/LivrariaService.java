package br.com.senior.livraria.model.service;

import br.com.senior.livraria.model.entity.LivrariaEntity;
import br.com.senior.livraria.model.exception.LivrariaNotFoundException;
import br.com.senior.livraria.repository.LivrariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class LivrariaService {

    @Autowired
    private LivrariaRepository repository;

    public List<LivrariaEntity> getAllLivrarias() {
        Optional<List<LivrariaEntity>> livrarias = Optional.of(repository.findAll());

        if (livrarias.isPresent()){
            return livrarias.get()
                    .stream()
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        }

        throw new LivrariaNotFoundException("Não foi encontradas livrarias.");
    }

    public LivrariaEntity getLivraria(UUID id){
        Optional<LivrariaEntity> livraria = repository.findByIdLivraria(id);

        if (livraria.isPresent()){
            return livraria.get();
        }

        throw new LivrariaNotFoundException("Não foi encontrado a livraria.");
    }

    public LivrariaEntity updateLivraria(UUID id, LivrariaEntity livraria){
        LivrariaEntity novaLivraria = this.getLivraria(id);
        novaLivraria.setNomeLivraria(livraria.getNomeLivraria());
        novaLivraria.setLocalizacao(livraria.getLocalizacao());
        novaLivraria.setEmail(livraria.getEmail());
        novaLivraria.setNumeroTelefone(livraria.getNumeroTelefone());
        novaLivraria.setCnpj(livraria.getCnpj());

        return this.createLivraria(novaLivraria);
    }

    public LivrariaEntity createLivraria(LivrariaEntity livraria) { return repository.save(livraria); }

    public void deleteLivraria(UUID id) {
        if (!repository.existsByIdLivraria(id)){
            throw new LivrariaNotFoundException("Livraria não encontrada.");
        }

        repository.deleteByIdLivraria(id);
    }
}
