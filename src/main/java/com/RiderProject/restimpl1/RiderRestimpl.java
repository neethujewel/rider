package com.RiderProject.restimpl1;

import com.RiderProject.constents.RiderConstents;
import com.RiderProject.rest.RiderRest;
import com.RiderProject.service.RiderService;
import com.RiderProject.utils.RiderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

public class RiderRestimpl {
       @RestController
    public class RiderRestImpl implements RiderRest {
        @Autowired
        RiderService riderService;


        @Override
        public ResponseEntity<String> signUp(Map<String, String> requestMap) {

            try {
                return  riderService.signUp(requestMap);

            }catch (Exception ex){
                ex.printStackTrace();
            }
            return RiderUtils.getResponseEntity(RiderConstents.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        @Override
        public ResponseEntity<String> signup(Map<String, String> requestMap) {
            return null;
        }
    }

}
