package br.com.masterclass.superpecas.exceptions;

public class AtributosNulosException extends RuntimeException{

    public AtributosNulosException() {
        super("Nenhum atributo pode ser nulo!");
    }

    public AtributosNulosException(String message) {
        super(message);
    }

}
