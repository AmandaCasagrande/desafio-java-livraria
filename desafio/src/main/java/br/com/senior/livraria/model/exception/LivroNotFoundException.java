package br.com.senior.livraria.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Livro não encontrado")
public class LivroNotFoundException extends RuntimeException{

    public LivroNotFoundException (String mensagem) { super (mensagem); }
}
