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
    private String type;
    private String picture;
    private String video;
}
