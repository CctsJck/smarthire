package com.smarthire.project.model.dto.Question;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionRequest {

    @NotBlank(message = "Ingrese la pregunta!(titulo)")
    private String name;
    @NotBlank(message = "Ingrese el tipo de pregunta")
    private String type;
    private String picture;

    @NotBlank(message = "id de la busqueda necesario")
    private long idSearch;
}
