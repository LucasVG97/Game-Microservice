package com.lucas.crudspring.service;

import com.lucas.crudspring.dto.GameRequest;
import com.lucas.crudspring.dto.GameResponse;

import java.util.List;

public interface GameService {

    GameResponse save(GameRequest gameRequest);

    GameResponse FindById(Long id);

    GameResponse update(GameRequest gameRequest, Long id);

    List<GameResponse> FindAll();

    void delete(Long id);
}
