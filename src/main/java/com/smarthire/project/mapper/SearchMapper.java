package com.smarthire.project.mapper;

import com.smarthire.project.model.dto.Search.SearchRequest;
import com.smarthire.project.model.dto.Search.SearchResponse;
import com.smarthire.project.model.dto.Search.SearchUpdateRequest;
import com.smarthire.project.model.entity.Search;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SearchMapper {
    SearchMapper INSTANCE = Mappers.getMapper(SearchMapper.class);

    Search searchRequestToSearch(SearchRequest searchRequest);

    SearchResponse searchToSearchResponse(Search search);

    Search searchUpdateRequestToSearch(SearchUpdateRequest searchUpdateRequest);

    List<SearchResponse> searchToSearchResponse(List<Search> search);
}
