package com.RiderProject.service;

import com.RiderProject.Model.Rider;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface RiderService {
    ResponseEntity<String>signUp(Map<String,String>requestMap);

}
