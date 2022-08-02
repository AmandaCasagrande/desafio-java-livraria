package br.com.senior.livraria.model.entity;

import br.com.senior.livraria.model.enumerado.GeneroEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Table
@Getter
@Setter
@Entity(name = "autor")
public class AutorEntity implements Serializable {

    @Id
    @Column(name = "idAutor")
    private UUID idAutor;

    @Column(length = 100)
    private String nomeAutor;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GeneroEnum genero;

    @ManyToMany(mappedBy = "autores")
    List<LivroEntity> livros;

}
