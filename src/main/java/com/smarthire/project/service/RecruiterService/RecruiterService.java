package com.smarthire.project.service.RecruiterService;

import com.smarthire.project.model.dto.Recruiter.RecruiterRequest;
import com.smarthire.project.model.dto.Recruiter.RecuiterResponse;

public interface RecruiterService {
    RecuiterResponse createAccount(RecruiterRequest r);
    RecuiterResponse update(RecruiterRequest r);
}
