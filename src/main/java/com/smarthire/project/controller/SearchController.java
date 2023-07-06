package com.smarthire.project.controller;

import com.smarthire.project.model.dto.SearchRequest;
import com.smarthire.project.model.dto.SearchResponse;
import com.smarthire.project.repository.SearchRepository;
import com.smarthire.project.service.SearchService.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/operators")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @PostMapping("/")
    public ResponseEntity<SearchResponse> save(@RequestBody SearchRequest searchRequest){
        return  new ResponseEntity<>(searchService.save(searchRequest), HttpStatus.OK);
    }

}
