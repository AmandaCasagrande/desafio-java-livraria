package br.com.senior.livraria.repository;

import br.com.senior.livraria.model.entity.AutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AutorRepository extends JpaRepository<AutorEntity, Integer> {

    @Transactional
    Optional<AutorEntity> findByIdAutor(UUID idAutor);

    @Transactional
    boolean existsByIdAutor(UUID idAutor);

    @Transactional
    void deleteByIdAutor(UUID idAutor);
}
