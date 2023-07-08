package com.smarthire.project.model.dto.Recruiter;

import lombok.*;

import javax.validation.constraints.NotBlank;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecruiterUpdateRequest {
    @NotBlank(message = "ID del recruiter necesario")
    private Long id;
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
}
