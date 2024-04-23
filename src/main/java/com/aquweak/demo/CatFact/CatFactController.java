package com.aquweak.demo.CatFact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aquweak.demo.CatFact.Model.CatFactDTO;

@RestController
@RequestMapping("/catfact")
public class CatFactController {
    
    @Autowired
    private CatFactQueryHandler catFactQueryHandler;

    public ResponseEntity<CatFactDTO> getCatFact(){
        return catFactQueryHandler.execute(null);
    }

}
