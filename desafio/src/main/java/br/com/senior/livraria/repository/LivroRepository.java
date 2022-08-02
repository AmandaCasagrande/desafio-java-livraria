package br.com.senior.livraria.repository;

import br.com.senior.livraria.model.entity.LivroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface LivroRepository extends JpaRepository<LivroEntity, Integer> {

    @Transactional
    Optional<LivroEntity> findByIdLivro(UUID id);

    @Transactional
    boolean existsByIdLivro(UUID id);

    @Transactional
    void deleteByIdLivro(UUID id);

    @Transactional
    Optional<LivroEntity> findByTitulo(String titulo);

    @Transactional
    Optional<LivroEntity> findByPreco (BigDecimal preco);

    @Transactional
    Optional<LivroEntity> findByDataLancamento (LocalDate dataLancamento);

}
