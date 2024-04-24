package com.aquweak.demo.CatFactEntity;

import com.aquweak.demo.CatFact.Model.CatFact;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.RuntimeJsonMappingException;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cat_facts")
@AllArgsConstructor
@NoArgsConstructor
public class CatFactEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name = "catfactJSON")
    private String catFactJSON;

    public CatFactEntity(CatFact catFact){
        this.catFactJSON = covertToJSON(catFact);
    }

    private String covertToJSON(CatFact catFact) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(catFact);
        } catch (Exception e) {         
            throw new RuntimeJsonMappingException("Json Parse ERROR");
           
        }
    }

    public CatFact convertToCatFact(){
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(catFactJSON, CatFact.class);
        }
        catch(Exception e){
            throw new RuntimeJsonMappingException("Json Parse ERROR");
        }
    }
}