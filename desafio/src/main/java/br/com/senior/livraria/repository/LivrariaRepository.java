package br.com.senior.livraria.repository;

import br.com.senior.livraria.model.entity.LivrariaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface LivrariaRepository extends JpaRepository<LivrariaEntity, Integer> {

    @Transactional
    Optional<LivrariaEntity> findByIdLivraria(UUID id);

    @Transactional
    boolean existsByIdLivraria(UUID id);

    @Transactional
    void deleteByIdLivraria(UUID id);

}
