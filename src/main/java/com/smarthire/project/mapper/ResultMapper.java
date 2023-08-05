package com.smarthire.project.mapper;

import com.smarthire.project.model.dto.Result.ResultRequest;
import com.smarthire.project.model.dto.Result.ResultResponse;
import com.smarthire.project.model.entity.Result;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface ResultMapper {

    ResultMapper INSTANCE = Mappers.getMapper(ResultMapper.class);

    Result resultRequestToResult(ResultRequest resultRequest);

    ResultResponse resultToResultResponse(Result result);

}
