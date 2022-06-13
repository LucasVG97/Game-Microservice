package com.lucas.crudspring.dto;


import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class GameRequest {

    @NotNull
    private String name;

    @NotNull
    private String genre;
}
