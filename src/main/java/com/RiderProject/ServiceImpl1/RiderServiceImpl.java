package com.RiderProject.ServiceImpl1;

import com.RiderProject.JWT.JWTTokenUtil;
import com.RiderProject.Model.Rider;
import com.RiderProject.constents.RiderConstents;
import com.RiderProject.dao.RiderDao;
import com.RiderProject.service.RiderService;
import com.RiderProject.utils.RiderUtils;
import lombok.extern.slf4j.Slf4j;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;

@Service
@Slf4j
public class RiderServiceImpl implements RiderService {
    @Autowired
    private RiderDao riderDao;

    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        log.info("Attempting to sign up with details:{}", requestMap);
        try {
            if (validateSignUpMap(requestMap)) {
                Rider rider = riderDao.findByEmailId(requestMap.get("email"));
                if (Objects.isNull(rider)) {
                    riderDao.save(mapToRider(requestMap));
                    String token = new JWTTokenUtil().generateToken(new Rider(requestMap.get("email"), requestMap.get("password")));
                     return RiderUtils.getResponseEntity("Successfully registered. Token: " + token, HttpStatus.OK);
                } else {
                    return RiderUtils.getResponseEntity("Email already exists.", HttpStatus.BAD_REQUEST);
                }
            } else {
                return RiderUtils.getResponseEntity(RiderConstents.INVALID_DATA, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception ex) {
            log.error("Error during sign up: ", ex);
        }
        return RiderUtils.getResponseEntity(RiderConstents.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }




    private Rider mapToRider(Map<String, String> requestMap) {
        Rider rider = new Rider(requestMap.get("email"), requestMap.get("password"));
        rider.setName(requestMap.get("name"));
        rider.setDateOfBirth(LocalDate.parse(requestMap.get("dateOfBirth")));
        rider.setAddress(requestMap.get("address"));
        rider.setDrivingLicense(requestMap.get("drivingLicense"));
        rider.setAccontNumber(requestMap.get("accountNumber"));
        rider.setIfscCode(requestMap.get("ifscCode"));
        rider.setBenificiaryName(requestMap.get("benificiaryName"));
        rider.setCity(requestMap.get("city"));
        rider.setState(requestMap.get("state"));
        rider.setBankName(requestMap.get("bankName"));
        rider.setBranch(requestMap.get("branch"));
        rider.setMobileNumber(requestMap.get("mobileNumber"));
        rider.setEmailAddress(requestMap.get("emailAddress"));
        rider.setPassword(requestMap.get("password"));
        rider.setStatus("true");
        rider.setRole("rider");
        return  rider;
    }
    private boolean validateSignUpMap(Map<String, String> requestMap) {
        String[] requiredKeys = {
                "name", "dateOfBirth", "address", "drivingLicense", "accountNumber",
                "ifscCode", "beneficiaryName", "city", "state", "bankName", "branch",
                "mobileNumber", "emailAddress", "password"
        };
        return Stream.of(requiredKeys).allMatch(requestMap::containsKey);
    }

    private record JWTTokenUtil() {
        public String generateToken(Rider rider) {
            return null;
        }
    }
}



