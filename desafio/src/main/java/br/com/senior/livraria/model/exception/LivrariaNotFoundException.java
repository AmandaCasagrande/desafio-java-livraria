package br.com.senior.livraria.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Livraria não encontrada")
public class LivrariaNotFoundException extends RuntimeException{

    public LivrariaNotFoundException (String mensagem) { super (mensagem); }
}
