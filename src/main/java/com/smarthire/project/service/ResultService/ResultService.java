package com.smarthire.project.service.ResultService;

import com.smarthire.project.model.dto.Result.ResultRequest;
import com.smarthire.project.model.dto.Result.ResultResponse;

public interface ResultService {

    ResultResponse createResult (ResultRequest resultRequest, Long candidate, Long question);
}
