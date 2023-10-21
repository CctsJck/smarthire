package com.smarthire.project.model.dto.Question;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionUpdateRequest {

    @NotBlank(message = "Id de pregunta necesario")
    private long id;
    @NotBlank(message = "Ingrese la pregunta")
    private String name;
    @NotBlank(message = "Ingrese el tiempo para responder")
    private Integer time;
}
