package com.aquweak.demo.CatFact;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.aquweak.demo.Query;
import com.aquweak.demo.CatFact.Model.CatFact;
import com.aquweak.demo.CatFact.Model.CatFactDTO;

@Service
public class CatFactQueryHandler implements Query<Void,CatFactDTO>{

    private final RestTemplate restTemplate;

    public CatFactQueryHandler(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public ResponseEntity<CatFactDTO> execute(Void input) {
        CatFact catFact = restTemplate.getForObject("https://catfact.ninja/fact", CatFact.class);
        CatFactDTO catFactDTO = new CatFactDTO(catFact.getFact());
        return ResponseEntity.ok(catFactDTO);
    }
    
}
