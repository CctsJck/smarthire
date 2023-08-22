package com.smarthire.project.mapper;

import com.smarthire.project.model.dto.Cv.CvResponse;
import com.smarthire.project.model.entity.Cv;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CvMapper {

    CvMapper INSTANCE = Mappers.getMapper(CvMapper.class);

    CvResponse CvToCvResponse(Cv cv);
}
