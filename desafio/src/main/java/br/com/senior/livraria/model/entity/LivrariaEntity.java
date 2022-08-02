package br.com.senior.livraria.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Table
@Getter
@Setter
@Entity(name = "livraria")
public class LivrariaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idLivraria;

    @Column(length = 100, nullable = false)
    private String nomeLivraria;

    @Column
    private String localizacao;

    @Column
    private String email;

    @Column(length = 11)
    private String numeroTelefone;

    @Column(length = 14, nullable = false)
    private String cnpj;

    @OneToMany(mappedBy = "livraria")
    List<LivroEntity> livros;

}
