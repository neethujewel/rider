package com.RiderProject.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
@RequestMapping(path = "/gender")
public interface GenderRest
{
    ResponseEntity<String> updateGender(Map<String, String> requestMap);

    ResponseEntity<String> deleteGender(Map<String, String> requestMap);

    ResponseEntity<String> getGender(Map<String, String> requestMap);

    ResponseEntity<String> signUp(Map<String, String> requestMap);

        @PostMapping("/signup")
        public  ResponseEntity<String>signup(@RequestBody(required = true)Map<String,String>requestMap);


    ResponseEntity<String> addGender(Map<String, String> requestMap);
}
