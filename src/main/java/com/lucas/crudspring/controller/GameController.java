package com.lucas.crudspring.controller;

import com.lucas.crudspring.dto.GameRequest;
import com.lucas.crudspring.dto.GameResponse;
import com.lucas.crudspring.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/games")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @GetMapping("/{id}")
    public ResponseEntity<GameResponse> findById(@PathVariable Long id){

        return ResponseEntity.status(HttpStatus.OK).body(gameService.FindById(id));
    }

    @GetMapping
    public ResponseEntity<List<GameResponse>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(gameService.FindAll());
    }

    @PostMapping
    public ResponseEntity<GameResponse> save(@Valid @RequestBody GameRequest gameRequest){

        return ResponseEntity.status(HttpStatus.CREATED).body(gameService.save(gameRequest));
    }

    @PutMapping(
            value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GameResponse> update(@PathVariable Long id, @Valid @RequestBody GameRequest gameRequest){

        return ResponseEntity.status(HttpStatus.OK).body(gameService.update(gameRequest, id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        gameService.delete(id);
    }
}
