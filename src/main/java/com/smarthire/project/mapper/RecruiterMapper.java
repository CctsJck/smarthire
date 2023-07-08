package com.smarthire.project.mapper;

import com.smarthire.project.model.dto.Recruiter.RecruiterRequest;
import com.smarthire.project.model.dto.Recruiter.RecuiterResponse;
import com.smarthire.project.model.entity.Recruiter;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RecruiterMapper {

    RecruiterMapper INSTANCE = Mappers.getMapper(RecruiterMapper.class);

    Recruiter recruiterRequestToRecruiter(RecruiterRequest recruiterRequest);
    RecuiterResponse recruiterToRecruiterResponse(Recruiter recruiter);





}
