package com.smarthire.project.service.RecruiterService;

import com.smarthire.project.mapper.RecruiterMapper;
import com.smarthire.project.model.dto.Recruiter.RecruiterRequest;
import com.smarthire.project.model.dto.Recruiter.RecuiterResponse;
import com.smarthire.project.model.entity.Recruiter;
import com.smarthire.project.repository.RecruiterRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class RecruiterServiceImpl implements RecruiterService{

    @Autowired
    private RecruiterRepository recruiterRepository;

    private final RecruiterMapper recruiterMapper = RecruiterMapper.INSTANCE;
    @Override
    public RecuiterResponse createAccount(RecruiterRequest r) {
        Recruiter recruiter = recruiterMapper.recruiterRequestToRecruiter(r);
        recruiter = recruiterRepository.save(recruiter);
        return recruiterMapper.recruiterToRecruiterResponse(recruiter);

    }
}
