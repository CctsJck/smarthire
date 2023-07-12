package com.smarthire.project.service.RecruiterService;

import com.smarthire.project.model.dto.Recruiter.RecruiterRequest;
import com.smarthire.project.model.dto.Recruiter.RecuiterResponse;
import com.smarthire.project.model.dto.Search.SearchRequest;
import com.smarthire.project.model.dto.Search.SearchResponse;
import com.smarthire.project.model.entity.Recruiter;

public interface RecruiterService {
    RecuiterResponse createAccount(RecruiterRequest r);
    RecuiterResponse update(RecruiterRequest r);
   // SearchResponse saveSearch(SearchRequest s);

    Recruiter findById(long id);
}
