package com.RiderProject.restimpl1;

import com.RiderProject.constents.GenderConstents;
import com.RiderProject.rest.GenderRest;
import com.RiderProject.service.GenderService;
import com.RiderProject.utils.GenderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class GenderRestImpl implements GenderRest {

    @Autowired
    GenderService genderService;

    @Override
    public ResponseEntity<String> addGender(Map<String, String> requestMap) {
        try {
            return genderService.addGender(requestMap);
        } catch (Exception ex) {
            ex.printStackTrace();
            return GenderUtils.getResponseEntity(GenderConstents.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<String> updateGender(Map<String, String> requestMap) {
        try {
            return genderService.updateGender(requestMap);
        } catch (Exception ex) {
            ex.printStackTrace();
            return GenderUtils.getResponseEntity(GenderConstents.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<String> deleteGender(Map<String, String> requestMap) {
        try {
            return genderService.deleteGender(requestMap);
        } catch (Exception ex) {
            ex.printStackTrace();
            return GenderUtils.getResponseEntity(GenderConstents.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<String> getGender(Map<String, String> requestMap) {
        try {
            return genderService.getGender(requestMap);
        } catch (Exception ex) {
            ex.printStackTrace();
            return GenderUtils.getResponseEntity(GenderConstents.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        try {
            if (requestMap == null || requestMap.isEmpty()) {
                throw new Exception("Request map is empty");
            }

            String name = requestMap.get("name");
            String email = requestMap.get("email");
            String password = requestMap.get("password");

            if (name == null || name.isEmpty() || email == null || email.isEmpty() || password == null || password.isEmpty()) {
                throw new Exception("Name, email, and password are required");
            }

            com.RiderProject.Model.Gender gender = new com.RiderProject.Model.Gender();
            gender.setName(name);
            gender.setEmail(email);
            gender.setPassword(password);

            Map<String, String> genderRequestMap = new HashMap<>();
            genderRequestMap.put("gender", "Female");
            ResponseEntity<String> response = addGender(genderRequestMap);
            System.out.println(response.getBody());

            gender.setGender("Male");
            gender = genderService.saveGender(gender);
            return GenderUtils.getResponseEntity(GenderConstents.SIGNUP_SUCCESSFUL, HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return GenderUtils.getResponseEntity(GenderConstents.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<String> signup(Map<String, String> requestMap) {
        return null;
    }
}