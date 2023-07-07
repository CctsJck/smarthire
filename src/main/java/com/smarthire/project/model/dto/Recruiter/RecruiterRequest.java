package com.smarthire.project.model.dto.Recruiter;

import com.smarthire.project.model.entity.Search;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecruiterRequest {

    @NotBlank(message = "Ingrese su nombre")
    private String name;
    @NotBlank(message = "Ingrese su apellido")
    private String surename;
    @NotBlank(message = "Ingrese su nomrbe de usuario")
    private String username;
    @NotBlank(message = "Ingrese su mail")
    private String email;
    @NotBlank(message = "Contraseña necesaria")
    private String pass;

    private List<SearchResponse> searches;

}
