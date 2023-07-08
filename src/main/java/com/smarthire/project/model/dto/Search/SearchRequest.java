package com.smarthire.project.model.dto.Search;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.smarthire.project.model.dto.Question.QuestionRequest;
import com.smarthire.project.model.entity.Question;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class SearchRequest {


    @NotBlank(message = "ingrese un nombre de busqueda")
    private String name;

    @NotBlank(message = "ingrese una descripcion")
    private String description;

    @NotNull(message = "Introducir una fecha válida")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime endDate;

    @NotBlank(message = "username del recruiter necesario")
    private String username;

    private List<QuestionRequest> questions;

}

