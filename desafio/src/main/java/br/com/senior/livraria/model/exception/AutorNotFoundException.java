package br.com.senior.livraria.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Autor não encontrado")
public class AutorNotFoundException extends RuntimeException{

    public AutorNotFoundException (String mensagem) { super (mensagem); }
}
