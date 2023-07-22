package com.smarthire.project.service.RecruiterService;

import com.smarthire.project.model.dto.Recruiter.RecruiterRequest;
import com.smarthire.project.model.dto.Recruiter.RecruiterResponse;
import com.smarthire.project.model.entity.ConfirmationToken;
import com.smarthire.project.model.entity.Recruiter;

import java.util.List;

public interface RecruiterService {
    RecruiterResponse createAccount(RecruiterRequest r);
    RecruiterResponse update(RecruiterRequest r);
   // SearchResponse saveSearch(SearchRequest s);

    Recruiter findByIdEntity(long id);

    RecruiterResponse findByIdResponse(long id);

    List<RecruiterResponse> getAllRecruiters();

    void confirmToken(String token);


}
