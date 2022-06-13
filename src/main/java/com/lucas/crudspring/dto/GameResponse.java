package com.lucas.crudspring.dto;

import com.lucas.crudspring.model.Game;
import lombok.Data;

@Data
public class GameResponse {

    private Long id;
    private String name;
    private String genre;

    public GameResponse(Game game){
        this.id = game.getId();
        this.name = game.getName();
        this.genre = game.getGenre();
    }
}
