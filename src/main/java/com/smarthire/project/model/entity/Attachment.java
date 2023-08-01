package com.smarthire.project.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Attachment {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String filename;
    private String fileType;

    @Lob
    private byte[] data;



}
