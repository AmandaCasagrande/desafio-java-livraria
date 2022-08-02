package br.com.senior.livraria.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Table
@Getter
@Setter
@Entity(name = "livro")
public class LivroEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idLivro;

    @Column(nullable = false)
    private String titulo;

    @Column
    private String descriçao;

    @Column(nullable = false)
    private BigDecimal preco;

    @Column
    private LocalDate dataLancamento;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "livraria", referencedColumnName = "idLivraria")
    LivrariaEntity livraria;

    @ManyToMany(mappedBy = "livros",fetch = FetchType.LAZY)
    List<AutorEntity> autores;

}
