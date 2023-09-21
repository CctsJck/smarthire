package com.smarthire.project.mapper;

import com.smarthire.project.model.dto.Result.ResultFilterResponse;
import com.smarthire.project.model.dto.Result.ResultRequest;
import com.smarthire.project.model.dto.Result.ResultResponse;
import com.smarthire.project.model.entity.Result;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ResultMapper {

    ResultMapper INSTANCE = Mappers.getMapper(ResultMapper.class);

    Result resultRequestToResult(ResultRequest resultRequest);

    ResultResponse resultToResultResponse(Result result);

    ResultFilterResponse resultToResultFilterResponse(Result result);

    List<ResultFilterResponse> resultToResultFilterResponse(List<Result> results);

}
