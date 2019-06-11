package br.com.nlj.userregister.exception;

public class UserExistsException extends RuntimeException {


    public UserExistsException() {
        super("Usuario ja cadastrado");
    }

}
