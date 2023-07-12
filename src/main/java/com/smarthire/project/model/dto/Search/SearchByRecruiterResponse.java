package com.smarthire.project.model.dto.Search;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchByRecruiterResponse {

    private long id;
    private String name;
    private String description;

}
