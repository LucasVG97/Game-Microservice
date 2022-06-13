package com.lucas.crudspring.repository;

import com.lucas.crudspring.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository <Game, Long>{
}
