package com.RiderProject.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

    public class RiderUtils {

        public static ResponseEntity<String> getResponseEntity(String message, HttpStatus status) {
            return new ResponseEntity<>(message, status);
        }
    }



