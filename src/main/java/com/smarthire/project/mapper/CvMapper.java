package com.smarthire.project.mapper;

import com.smarthire.project.model.dto.Cv.CvResponse;
import com.smarthire.project.model.entity.Cv;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CvMapper {

    CvMapper INSTANCE = Mappers.getMapper(CvMapper.class);

    @Mapping(source = "cv", target = "Cv") // Specify the mapping between field names
    CvResponse cvToCvResponse(Cv cv);
}
