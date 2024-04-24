package com.aquweak.demo.CatFact;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aquweak.demo.CatFact.Model.CatFact;
import com.aquweak.demo.CatFact.Model.CatFactDTO;
import com.aquweak.demo.CatFactEntity.CatFactEntity;
import com.aquweak.demo.CatFactEntity.CatFactRepository;

@RestController
@RequestMapping("/catfact")
public class CatFactController {
    
    @Autowired
    private CatFactQueryHandler catFactQueryHandler;

    @Autowired
    private CatFactRepository catFactRepository;

    @GetMapping
    public ResponseEntity<CatFactDTO> getCatFact(){
        return catFactQueryHandler.execute(null);
    }

    @GetMapping("/local")
    public ResponseEntity<List<CatFact>> getSavedCatFacts(){
        List<CatFact> catFactEntities = catFactRepository.findAll().stream()
        .map(catFact -> {
            return catFact.convertToCatFact();
        })
        .collect(Collectors.toList());

        return ResponseEntity.ok(catFactEntities);
    }
}
