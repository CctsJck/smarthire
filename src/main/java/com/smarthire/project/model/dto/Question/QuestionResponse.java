package com.smarthire.project.model.dto.Question;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionResponse {
    private long id;

    private String name;
    private Integer time;
}
