package com.smarthire.project.controller;

import com.smarthire.project.model.dto.SearchRequest;
import com.smarthire.project.model.dto.SearchResponse;
import com.smarthire.project.model.dto.SearchUpdateRequest;
import com.smarthire.project.repository.SearchRepository;
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

    @PostMapping("/")
    public ResponseEntity<SearchResponse> save(@RequestBody SearchRequest searchRequest){
        return  new ResponseEntity<>(searchService.save(searchRequest), HttpStatus.OK);
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
