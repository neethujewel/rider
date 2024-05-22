package com.RiderProject.service;

import com.RiderProject.Model.Gender;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface GenderService
{

    ResponseEntity<String> addGender(Map<String, String> requestMap);

    ResponseEntity<String> updateGender(Map<String, String> requestMap);

    ResponseEntity<String> getResponseEntity(String somethingWentWrong, HttpStatus httpStatus);

    ResponseEntity<String> deleteGender(Map<String, String> requestMap);

    ResponseEntity<String> getGender(Map<String, String> requestMap);

    Gender saveGender(Gender gender);
}
