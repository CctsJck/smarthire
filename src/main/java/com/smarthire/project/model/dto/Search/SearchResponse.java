package com.smarthire.project.model.dto.Search;

import com.smarthire.project.model.dto.Question.QuestionResponse;
import com.smarthire.project.model.entity.Question;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class SearchResponse {

    private long id;
    @NotBlank(message = "ingrese un nombre de busqueda")
    private String name;

    @NotBlank(message = "ingrese una descripcion")
    private String description;

    @NotNull(message = "Introducir una fecha válida")
    private LocalDateTime endDate;

    private List<QuestionResponse> questions;

}
