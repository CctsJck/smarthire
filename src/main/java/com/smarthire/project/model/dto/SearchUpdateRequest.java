package com.smarthire.project.model.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchUpdateRequest {

    private long id;
    private String name;
    private String description;
    private Date endDate;
    private List<QuestionRespose> questions;

}