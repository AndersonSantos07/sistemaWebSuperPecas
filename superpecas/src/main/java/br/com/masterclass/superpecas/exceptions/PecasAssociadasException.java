package br.com.masterclass.superpecas.exceptions;

public class PecasAssociadasException extends RuntimeException{

    public PecasAssociadasException(){super("Existem peças associadas ao Carro! ");}

    public PecasAssociadasException(String message){super();}

}
