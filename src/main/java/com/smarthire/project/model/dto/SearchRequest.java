package com.smarthire.project.model.dto;

import com.smarthire.project.model.entity.Question;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class SearchRequest {

    @NotBlank(message = "ingrese un nombre de busqueda")
    private String name;

    @NotBlank(message = "ingrese una descripcion")
    private String description;

    @NotNull(message = "Introducir una fecha válida")
    private Date endDate;

    private List<QuestionRequest> questions;

}
