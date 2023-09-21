package com.smarthire.project.service.ResultService;

import com.smarthire.project.model.dto.Result.ResultFilterResponse;
import com.smarthire.project.model.dto.Result.ResultRequest;
import com.smarthire.project.model.dto.Result.ResultResponse;

import java.util.List;

public interface ResultService {

    ResultResponse createResult (ResultRequest resultRequest, Long candidate, Long question);

    List<ResultFilterResponse> filterResults (Long question);
}
