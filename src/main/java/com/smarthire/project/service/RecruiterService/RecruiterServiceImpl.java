package com.smarthire.project.service.RecruiterService;

import com.smarthire.project.exception.UserNotUniqueException;
import com.smarthire.project.mapper.RecruiterMapper;
import com.smarthire.project.mapper.SearchMapper;
import com.smarthire.project.model.dto.Recruiter.RecruiterRequest;
import com.smarthire.project.model.dto.Recruiter.RecuiterResponse;
import com.smarthire.project.model.dto.Search.SearchRequest;
import com.smarthire.project.model.dto.Search.SearchResponse;
import com.smarthire.project.model.entity.Recruiter;
import com.smarthire.project.model.entity.Search;
import com.smarthire.project.repository.RecruiterRepository;
import com.smarthire.project.repository.SearchRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional
public class RecruiterServiceImpl implements RecruiterService{

    @Autowired
    private RecruiterRepository recruiterRepository;

    @Autowired
    private SearchRepository searchRepository;

    private final SearchMapper searchMapper = SearchMapper.INSTANCE;
    private final RecruiterMapper recruiterMapper = RecruiterMapper.INSTANCE;
    @Override
    public RecuiterResponse createAccount(RecruiterRequest r) {
        Recruiter recruiter = recruiterMapper.recruiterRequestToRecruiter(r);
        if(recruiterRepository.existsByUsername(recruiter.getUsername())){
            log.info("recruiter tiene el usuario en uso");
            throw new UserNotUniqueException("El nombre de usuario no es unico");
        }else if(recruiterRepository.existsByEmail(recruiter.getEmail())){
            log.info("recruiter tiene el mail en uso");
            throw new UserNotUniqueException("El email ingresado ya esta en uso");
        }else {
            log.info("id recruiter"+recruiter.getId());
            recruiter = recruiterRepository.save(recruiter);
            log.info("id del mapper: "+recruiterMapper.recruiterToRecruiterResponse(recruiter).getId());
            log.info("recruiter creado correctamente");
            return recruiterMapper.recruiterToRecruiterResponse(recruiter);
        }

    }

    @Override
    public RecuiterResponse update(RecruiterRequest r) {
        Recruiter recruiter = recruiterMapper.recruiterRequestToRecruiter(r);
        recruiter = recruiterRepository.save(recruiter);
        log.info("recruiter actualizado correctamente");
        return recruiterMapper.recruiterToRecruiterResponse(recruiter);
    }

    @Override
    public SearchResponse saveSearch(SearchRequest s) {
        Recruiter recruiter = recruiterRepository.findByUsername(s.getUsername());
        Search search = searchMapper.searchRequestToSearch(s);
        recruiter.getSearches().add(search);
        log.info("id search es"+search.getId());
        recruiterRepository.save(recruiter);
        searchRepository.save(search);
        log.info("Se creo la busqueda correctamente");
        log.info("Id del search mapeado es:" +searchMapper.searchToSearchResponse(search).getId());
        return searchMapper.searchToSearchResponse(search);
    }


}
