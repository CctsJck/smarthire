package com.smarthire.project.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConfirmationToken {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tokenId;
    private String confirmationToken;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @OneToOne(targetEntity = Recruiter.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "recruiter_id")
    private Recruiter recruiter;


    public ConfirmationToken(Recruiter recruiter) {
        this.recruiter = recruiter;
        createdDate = new Date();
        confirmationToken = UUID.randomUUID().toString();
    }





}
