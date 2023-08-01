package com.smarthire.project.service.ResultService;

import com.smarthire.project.mapper.ResultMapper;
import com.smarthire.project.mapper.SearchMapper;
import com.smarthire.project.model.dto.Result.ResultRequest;
import com.smarthire.project.model.dto.Result.ResultResponse;
import com.smarthire.project.model.entity.Candidate;
import com.smarthire.project.model.entity.Question;
import com.smarthire.project.model.entity.Result;
import com.smarthire.project.repository.ResultRepository;
import com.smarthire.project.service.CandidateService.CandidateService;
import com.smarthire.project.service.QuestionService.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional
public class ResultServiceImpl implements ResultService{


    @Autowired
    CandidateService candidateService;

    @Autowired
    QuestionService questionService;

    @Autowired
    ResultService resultService;

    @Autowired
    ResultRepository resultRepository;

    private final ResultMapper resultMapper = ResultMapper.INSTANCE;




    @Override
    public ResultResponse createResult(ResultRequest resultRequest, Long candidate, Long question) {
        Candidate candidateEntity = candidateService.findCandidateById(candidate);
        Question questionEntity = questionService.findById(question);
        Result result = resultMapper.resultRequestToResult(resultRequest);

        result.setCandidate(candidateEntity);
        result.setQuestion(questionEntity);

        resultRepository.save(result);

        return resultMapper.resultToResultResponse(result);

    }
}
