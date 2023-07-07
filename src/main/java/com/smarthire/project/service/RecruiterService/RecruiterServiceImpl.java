package com.smarthire.project.service.RecruiterService;

import com.smarthire.project.exception.UserNotUniqueException;
import com.smarthire.project.mapper.RecruiterMapper;
import com.smarthire.project.model.dto.Recruiter.RecruiterRequest;
import com.smarthire.project.model.dto.Recruiter.RecuiterResponse;
import com.smarthire.project.model.entity.Recruiter;
import com.smarthire.project.repository.RecruiterRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
@Transactional
public class RecruiterServiceImpl implements RecruiterService{

    @Autowired
    private RecruiterRepository recruiterRepository;

    private final RecruiterMapper recruiterMapper = RecruiterMapper.INSTANCE;
    @Override
    public RecuiterResponse createAccount(RecruiterRequest r) {
        Recruiter recruiter = recruiterMapper.recruiterRequestToRecruiter(r);
        if(recruiterRepository.existsByUsername(recruiter.getUsername())){
            throw new UserNotUniqueException("El nombre de usuario no es unico");
        }else if(recruiterRepository.existsByEmail(recruiter.getEmail())){
            throw new UserNotUniqueException("El email ingresado ya esta en uso");
        }else {
            recruiter = recruiterRepository.save(recruiter);
            return recruiterMapper.recruiterToRecruiterResponse(recruiter);
        }

    }

    @Override
    public RecuiterResponse update(RecruiterRequest r) {
        Recruiter recruiter = recruiterMapper.recruiterRequestToRecruiter(r);
        recruiter = recruiterRepository.save(recruiter);
        return recruiterMapper.recruiterToRecruiterResponse(recruiter);
    }


}
