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
    @NotBlank(message = "Ingrese el tiempo para responder")
    private Integer time;

    private String type;

    @NotBlank(message = "id de la busqueda necesario")
    private long idSearch;
}
