package com.smarthire.project.model.dto.Search;

import com.smarthire.project.model.dto.Question.QuestionUpdateRequest;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchUpdateRequest {

    @NotBlank(message = "Id de la busqueda necesario")
    private long id;

    @NotBlank(message = "ingrese un nombre de busqueda")
    private String name;

    @NotBlank(message = "ingrese una descripcion")
    private String description;

    @NotNull(message = "Introducir una fecha válida")
    private LocalDateTime endDate;

    private List<QuestionUpdateRequest> questions;

}