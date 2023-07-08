package com.smarthire.project.controller;

import com.smarthire.project.model.dto.Search.SearchRequest;
import com.smarthire.project.model.dto.Search.SearchResponse;
import com.smarthire.project.model.dto.Search.SearchUpdateRequest;
import com.smarthire.project.service.RecruiterService.RecruiterService;
import com.smarthire.project.service.SearchService.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @Autowired
    private RecruiterService recruiterService;

    @PostMapping("/")
    public ResponseEntity<SearchResponse> save(@RequestBody SearchRequest searchRequest){
        return new ResponseEntity<>(recruiterService.saveSearch(searchRequest), HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<SearchResponse> update(@RequestBody SearchUpdateRequest searchUpdateRequest){
      return new ResponseEntity<>(searchService.update(searchUpdateRequest), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteSearchById(@PathVariable Long id) {
        searchService.delete(id);
        return ResponseEntity.ok().build();
    }

}
