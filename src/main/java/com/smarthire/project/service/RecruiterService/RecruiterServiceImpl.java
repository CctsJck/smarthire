package com.smarthire.project.service.RecruiterService;

import com.smarthire.project.exception.SearchNotFoundException;
import com.smarthire.project.exception.UserNotFoundException;
import com.smarthire.project.exception.UserNotUniqueException;
import com.smarthire.project.mapper.RecruiterMapper;
import com.smarthire.project.mapper.SearchMapper;
import com.smarthire.project.model.dto.Recruiter.RecruiterRequest;
import com.smarthire.project.model.dto.Recruiter.RecruiterResponse;
import com.smarthire.project.model.dto.Recruiter.RecruiterResponseEmail;
import com.smarthire.project.model.dto.Recruiter.RecruiterUpdateRequest;
import com.smarthire.project.model.entity.ConfirmationToken;
import com.smarthire.project.model.entity.Recruiter;
import com.smarthire.project.repository.ConfirmationTokenRepository;
import com.smarthire.project.repository.RecruiterRepository;
import com.smarthire.project.repository.SearchRepository;
import com.smarthire.project.service.EmailService.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@Transactional
public class RecruiterServiceImpl implements RecruiterService{

    @Autowired
    private RecruiterRepository recruiterRepository;

    @Autowired
    private SearchRepository searchRepository;
    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    @Autowired
    private EmailService emailService;

    private final SearchMapper searchMapper = SearchMapper.INSTANCE;
    private final RecruiterMapper recruiterMapper = RecruiterMapper.INSTANCE;
    @Override
    public RecruiterResponse createAccount(RecruiterRequest r) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        Recruiter recruiter = recruiterMapper.recruiterRequestToRecruiter(r);
        if(recruiterRepository.existsByUsername(recruiter.getUsername())){
            log.info("recruiter tiene el usuario en uso");
            throw new UserNotUniqueException("El nombre de usuario no es unico");
        }else if(recruiterRepository.existsByEmail(recruiter.getEmail())){
            log.info("recruiter tiene el mail en uso");
            throw new UserNotUniqueException("El email ingresado ya esta en uso");
        }else {
            log.info("id recruiter"+recruiter.getId());
            String pass = recruiter.getPass();
            recruiter.setPass(encoder.encode(pass));
            recruiter = recruiterRepository.save(recruiter);

            ConfirmationToken confirmationToken = new ConfirmationToken(recruiter);
            confirmationTokenRepository.save(confirmationToken);

            log.info("Mail del recruiter: " + recruiter.getEmail());

            emailService.sendEmail(recruiter.getEmail(),"Confirme su dirección de correo electronico",
                    "Haga click en el siguiente link para confirmar su mail: " +
                            //"http://localhost:5000/recruiter/confirmation/"+confirmationToken.getConfirmationToken()
                    "http://localhost:5173/createaccount/enable"
                    );


            log.info("id recruiter desp save"+recruiter.getId());
            log.info("id del mapper: "+recruiterMapper.recruiterToRecruiterResponse(recruiter).getId());
            log.info("recruiter creado correctamente");
            return recruiterMapper.recruiterToRecruiterResponse(recruiter);
        }

    }


    @Override
    public RecruiterResponse update(RecruiterUpdateRequest r) {
        log.info(String.valueOf(recruiterMapper.recruiterUpdateRequestToRecruiter(r).getName()));
        Recruiter recruiter = recruiterMapper.recruiterUpdateRequestToRecruiter(r);
        recruiter = recruiterRepository.save(recruiter);
        log.info("recruiter actualizado correctamente");
        return recruiterMapper.recruiterToRecruiterResponse(recruiter);
    }

    /*@Override
    public SearchResponse saveSearch(SearchRequest s) {
        Recruiter recruiter = recruiterRepository.findByUsername(s.getUsername());
        Search search = searchMapper.searchRequestToSearch(s);
        recruiter.getSearches().add(search);
        log.info("id search es"+search.getId());
        recruiterRepository.save(recruiter);
        //searchRepository.save(search);
        log.info("Se creo la busqueda correctamente");
        log.info("Id del search mapeado es:" +searchMapper.searchToSearchResponse(search).getId());
        return searchMapper.searchToSearchResponse(recruiter.getSearches().get(recruiter.getSearches().size()-1));
    }*/

    @Override
    public Recruiter findByIdEntity(long id) {
        if(recruiterRepository.findById(id).isPresent()){
            Recruiter recruiter = recruiterRepository.findById(id).get();
            return recruiter;
        }
        throw  new UserNotFoundException("Usuario no encontrado");
    }

    @Override
    public RecruiterResponse findByIdResponse(long id) {
        if(recruiterRepository.findById(id).isPresent()){
            Recruiter recruiter = recruiterRepository.findById(id).get();
            return recruiterMapper.recruiterToRecruiterResponse(recruiter);
        }
        throw  new UserNotFoundException("Usuario no encontrado");
    }

    @Override
    public List<RecruiterResponse> getAllRecruiters() {
        List<Recruiter> recruiters = recruiterRepository.findAll();
        List<RecruiterResponse> recruiterResponses = new ArrayList<RecruiterResponse>();
        for(Recruiter r: recruiters){
            recruiterResponses.add(recruiterMapper.recruiterToRecruiterResponse(r));
        }
        return recruiterResponses;
    }

    @Override
    public void confirmToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenRepository.findByConfirmationToken(token);

        if (confirmationToken != null &&  recruiterRepository.findByEmail(confirmationToken.getRecruiter().getEmail()).isPresent()){
            Recruiter recruiter = recruiterRepository.findByEmail(confirmationToken.getRecruiter().getEmail()).get();
            recruiter.setEnabled(true);
            recruiterRepository.save(recruiter);
        }else {
            throw  new SearchNotFoundException("El link utilizado esta dañado o expiró");
        }
    }

    @Override
    public RecruiterResponseEmail findByMail(String mail) {
        if (recruiterRepository.findByEmail(mail).isPresent()){
            Recruiter recruiter = recruiterRepository.findByEmail(mail).get();
            return recruiterMapper.recruiterToRecruiterResponseEmail(recruiter);
        }else {
            throw new UserNotFoundException("El mail ingresado no existe!");
        }
    }


}
