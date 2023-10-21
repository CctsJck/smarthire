package com.smarthire.project.service.QuestionService;

import com.smarthire.project.exception.QuestionNotFoundException;
import com.smarthire.project.mapper.QuestionMapper;
import com.smarthire.project.model.dto.Question.QuestionRequest;
import com.smarthire.project.model.dto.Question.QuestionResponse;
import com.smarthire.project.model.dto.Question.QuestionUpdateRequest;
import com.smarthire.project.model.entity.Question;
import com.smarthire.project.model.entity.Search;
import com.smarthire.project.repository.QuestionRepository;
import com.smarthire.project.repository.RecruiterRepository;
import com.smarthire.project.repository.SearchRepository;
import com.smarthire.project.service.SearchService.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private SearchService searchService;

    private final QuestionMapper questionMapper = QuestionMapper.INSTANCE;
    @Override
    public void save(List<QuestionRequest> questionRequestList) {
        for (QuestionRequest questionRequest : questionRequestList){
            Question question = questionMapper.questionRequestToQuestion(questionRequest);
            Search search = searchService.findById(questionRequest.getIdSearch());
            question.setSearch(search);
            questionRepository.save(question);
        }
    }

    @Override
    public QuestionResponse update(QuestionUpdateRequest questionUpdateRequest) {
        Question auxQuestion = questionRepository.findById(questionMapper.questionUpdateRequestToQuestion(questionUpdateRequest).getId()).get();
        log.info(String.valueOf(auxQuestion.getTime()));
        Question question = questionMapper.questionUpdateRequestToQuestion(questionUpdateRequest);
        log.info(String.valueOf(question.getTime()));
        question.setSearch(searchService.findById(auxQuestion.getSearch().getId()));
        questionRepository.save(question);
        return questionMapper.questionToQuestionResponse(question);
    }

    @Override
    public void delete(Long id) {
        Question question= this.findById(id);
        questionRepository.delete(question);
    }

    @Override
    public Question findById(Long id) {
        return questionRepository.findById(id)
                .orElseThrow(() -> new QuestionNotFoundException("Question not found with ID " + id));
    }

    @Override
    public QuestionResponse getQuestionResponseById(Long id) {
         Question question = questionService.findById(id);
         return questionMapper.questionToQuestionResponse(question);
    }

    @Override
    public List<QuestionResponse> getQuestionByName(String name) {
        return null;
    }
}
