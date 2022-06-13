package com.lucas.crudspring.exceptions;

public class GameIdNotFoundException extends RuntimeException{
    public GameIdNotFoundException(Long id) {
        super("There is no game with id: " + id);
    }

}
