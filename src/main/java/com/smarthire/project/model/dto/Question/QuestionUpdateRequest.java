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
    @NotBlank(message = "Ingrese el tipo de pregunta")
    private String type;
    private String picture;
    private String video;
}
