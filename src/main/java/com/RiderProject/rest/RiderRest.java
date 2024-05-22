package com.RiderProject.rest;

import com.RiderProject.Model.Gender;
import com.RiderProject.Model.Rider;
import com.RiderProject.dao.RiderDao;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Map;


@RequestMapping(path = "/rider")
public interface RiderRest {

    ResponseEntity<String> signUp(Map<String, String> requestMap);

    @PostMapping("/signup")
    ResponseEntity<String> signup(@RequestBody Map<String, String> requestMap);

    @Autowired
    RiderDao riderDao = null;

    @PostMapping
    public default ResponseEntity<String> createRider(
            @RequestParam("name") String name,
            @RequestParam("dateOfBirth") LocalDate dateOfBirth,
            @RequestParam("address") String address,
            @RequestParam("mobileNumber") String mobileNumber,
            @RequestParam("password") String password,
            @RequestParam("emailAddress") String emailAddress,
            @RequestParam("drivingLicense") String drivingLicense,
            @RequestParam("accontNumber") String accontNumber,
            @RequestParam("ifscCode") String ifscCode,
            @RequestParam("benificiaryName") String benificiaryName,
            @RequestParam("city") String city,
            @RequestParam("state") String state,
            @RequestParam("bankName") String bankName,
            @RequestParam("branch") String branch,
            @RequestParam("gender") Gender gender,
            @RequestParam(value = "drivingLicenseFrontImage", required = false) MultipartFile drivingLicenseFrontImage,
            @RequestParam(value = "drivingLicenseBackImage", required = false) MultipartFile drivingLicenseBackImage,
            @RequestParam(value = "aadharCardFrontImage", required = false) MultipartFile aadharCardFrontImage,
            @RequestParam(value = "aadharCardBackImage", required = false) MultipartFile aadharCardBackImage,
            @RequestParam(value = "PCC", required = false) MultipartFile pcc,
            @RequestParam(value = "Photo", required = false) MultipartFile photo,
            @RequestParam("status") String status,
            @RequestParam("role") String role) throws IOException {

        Rider rider = new Rider(requestMap.get("email"), requestMap.get("password"));
        rider.setName(name);
        rider.setDateOfBirth(dateOfBirth);
        rider.setAddress(address);
        rider.setMobileNumber(mobileNumber);
        rider.setPassword(password);
        rider.setEmailAddress(emailAddress);
        rider.setDrivingLicense(drivingLicense);
        rider.setAccontNumber(accontNumber);
        rider.setIfscCode(ifscCode);
        rider.setBenificiaryName(benificiaryName);
        rider.setCity(city);
        rider.setState(state);
        rider.setBankName(bankName);
        rider.setBranch(branch);
        rider.setGender(gender);
        rider.setStatus(status);
        rider.setRole(role);

        processFile(drivingLicenseFrontImage, rider::setDrivingLicenseFrontImage);
        processFile(drivingLicenseBackImage, rider::setDrivingLicenseBackImage);
        processFile(aadharCardFrontImage, rider::setAadharCardFrontImage);
        processFile(aadharCardBackImage, rider::setAadharCardBackImage);
        processFile(pcc, rider::setPCC);
        processFile(photo, rider::setPhoto);

        riderDao.save(rider);

        return ResponseEntity.ok().body("Rider Registered Successfully");
    }

    default void processFile(MultipartFile file, java.util.function.Consumer<byte[]> consumer) throws IOException {
        if (file != null && !file.isEmpty()) {
            String filename = StringUtils.cleanPath(file.getOriginalFilename());
            Path tempFile = Files.createTempFile(Paths.get(System.getProperty("java.io.tmpdir")), "upload_", filename);
            file.transferTo(tempFile.toFile());
            byte[] fileData = Files.readAllBytes(tempFile);
            consumer.accept(fileData);
            Files.delete(tempFile);
        }
    }
}

