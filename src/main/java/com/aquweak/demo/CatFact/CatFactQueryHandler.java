package com.aquweak.demo.CatFact;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.aquweak.demo.Query;
import com.aquweak.demo.CatFact.Model.CatFact;
import com.aquweak.demo.CatFact.Model.CatFactDTO;
import com.aquweak.demo.CatFactEntity.CatFactEntity;
import com.aquweak.demo.CatFactEntity.CatFactRepository;

@Service
public class CatFactQueryHandler implements Query<Void,CatFactDTO>{

    private final RestTemplate restTemplate;

    private final CatFactRepository catFactRepository;

    public CatFactQueryHandler(RestTemplate restTemplate,CatFactRepository catFactRepository){
        this.restTemplate = restTemplate;
        this.catFactRepository = catFactRepository;
    }

    @Override
    public ResponseEntity<CatFactDTO> execute(Void input) {
        try{
            CatFact catFact = restTemplate.getForObject("https://catfact.ninja/fact", CatFact.class);
            CatFactDTO catFactDTO = new CatFactDTO(catFact.getFact());
            CatFactEntity cFactEntity = new CatFactEntity(catFact);
            catFactRepository.save(cFactEntity);
            return ResponseEntity.ok(catFactDTO);
        }catch(Exception exception){
            CatFactDTO errorCatFactDTO = new CatFactDTO(exception.getMessage());
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(errorCatFactDTO);
        }
    }
    
}
