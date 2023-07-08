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
    private String name;
    private String description;
    private LocalDateTime endDate;

    private List<QuestionResponse> questions;

}
