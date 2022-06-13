package com.lucas.crudspring.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.lucas.crudspring.dto.GameRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Game {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column
  @NotNull
  private String name;

  @Column
  @NotNull
  private String genre;

  public Game(GameRequest gameRequest){
      this.name = gameRequest.getName();
      this.genre = gameRequest.getGenre();
  }

}
