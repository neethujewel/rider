package com.RiderProject.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
@Data
@Entity
@Table(name="rider")
public class Rider implements Serializable {
    private static final long seialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id ;

    @Column(name="name",nullable=false,length = 50)
    private  String name;

    @Column(name = "dateOfBirth",nullable = false)
    private LocalDate dateOfBirth;


    @Column(name="address",nullable = false)
    private  String address;

    @Column(name ="mobleNumber",nullable = false,length = 10)
    private String mobileNumber;

    @Column(name="password",nullable = false)
    private String password;

    @Column(name = "emailAddress",nullable = false,length = 100)
    private String emailAddress;

    @Column(name = "drivingLicense",nullable = false)
    private String drivingLicense;

    @Column(name="accountNumber",nullable = false)
    private String accontNumber;

    @Column(name = "ifscCode",nullable = false)
    private String ifscCode;

    @Column(name="benificiaryName",nullable = false)
    private String benificiaryName;

    @Column(name = "city",nullable = false)
    private String city;

    @Column(name= "state",nullable = false)
    private String state;

    @Column(name = "bankName",nullable = false)
    private String bankName;

    @Column(name = "branch",nullable = false)
    private String branch;

    @ManyToOne
    @JoinColumn(name = "gender_id")
    private String gender;

    @Column(name = "driving_license_front_image")
    private byte[] drivingLicenseFrontImage;

    @Column(name = "driving_license_back_image")
    private byte[] drivingLicenseBackImage;

    @Column(name = "aadhar_card_front_image")
    private byte[] aadharCardFrontImage;

    @Column(name = "aadhar_card_back_image")
    private byte[] aadharCardBackImage;

    @Column(name = "pcc")
    private byte[] PCC;

    @Column(name = "photo")
    private byte[] Photo;

     @Column(name = "status")
    private String status;

    @Column(name = "role")
    private  String role;

    public Rider(String email, String password) {
    }

    public String getGender() {
            return gender;
        }

        public void setGender(Gender gender) {
            this.gender = String.valueOf(gender);
        }
    }





