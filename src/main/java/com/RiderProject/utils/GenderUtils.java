package com.RiderProject.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class GenderUtils
{
        public static ResponseEntity<String> getResponseEntity(String message, HttpStatus status) {
            return new ResponseEntity<>(message, status);
        }
    }

