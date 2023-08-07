package com.smarthire.project.model.dto.Recruiter;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecruiterResponseEmail {

    private long id;

    private String name;
    private String surename;
    private String username;
    private String email;

}
