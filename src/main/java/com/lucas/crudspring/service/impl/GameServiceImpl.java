package com.lucas.crudspring.service.impl;

import com.lucas.crudspring.dto.GameRequest;
import com.lucas.crudspring.dto.GameResponse;
import com.lucas.crudspring.exceptions.GameIdNotFoundException;
import com.lucas.crudspring.model.Game;
import com.lucas.crudspring.repository.GameRepository;
import com.lucas.crudspring.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    @Override
    public GameResponse save(GameRequest gameRequest) {
        Game game = new Game(gameRequest);
        Game savedGame = gameRepository.save(game);
        return new GameResponse(savedGame);
    }

    @Override
    public GameResponse FindById(Long id) {
        Game game = gameRepository.findById(id).orElseThrow(()-> new GameIdNotFoundException(id));
        return new GameResponse(game);
    }

    @Override
    public GameResponse update(GameRequest gameRequest, Long id) {
        Game game = gameRepository.findById(id).orElseThrow(()-> new GameIdNotFoundException(id));
        game.setName(gameRequest.getName());
        game.setGenre(gameRequest.getGenre());
        Game updatedGame = gameRepository.save(game);
        return new GameResponse(updatedGame);
    }

    @Override
    public List<GameResponse> FindAll() {
        return gameRepository.findAll().stream().map(GameResponse::new).collect(Collectors.toList());
    }


    @Override
    public void delete(Long id) {
        Game game = gameRepository.findById(id).orElseThrow(()-> new GameIdNotFoundException(id));
        gameRepository.delete(game);
    }
}
