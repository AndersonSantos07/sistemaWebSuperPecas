package br.com.masterclass.superpecas.infra;

import br.com.masterclass.superpecas.exceptions.AtributosNulosException;
import br.com.masterclass.superpecas.exceptions.EntidadeEncontradaBaseDadosException;
import br.com.masterclass.superpecas.exceptions.EntidadeNaoEncontradaBaseDadosException;
import br.com.masterclass.superpecas.exceptions.PecasAssociadasException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AtributosNulosException.class)
    public ResponseEntity<RestErrorMessage> atributosNulosHandler(AtributosNulosException exception){
        RestErrorMessage respostaErro = new RestErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respostaErro);
    }

    @ExceptionHandler(EntidadeEncontradaBaseDadosException.class)
    public ResponseEntity<RestErrorMessage> entidadeEncontradaBaseDadosHandler(EntidadeEncontradaBaseDadosException exception){
        RestErrorMessage respostaErro = new RestErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respostaErro);
    }

    @ExceptionHandler(EntidadeNaoEncontradaBaseDadosException.class)
    public ResponseEntity<RestErrorMessage> entidadeNaoEncontradaBaseDadosHandler(EntidadeNaoEncontradaBaseDadosException exception){
        RestErrorMessage respostaErro = new RestErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respostaErro);
    }

    @ExceptionHandler(PecasAssociadasException.class)
    public ResponseEntity<RestErrorMessage> pecasAssociadasHandler(PecasAssociadasException exception){
        RestErrorMessage respostaErro = new RestErrorMessage(HttpStatus.BAD_REQUEST,exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respostaErro);
    }
}
