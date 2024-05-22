package com.RiderProject.ServiceImpl1;

import com.RiderProject.Model.Gender;
import com.RiderProject.Model.Rider;
import com.RiderProject.dao.GenderDao;
import com.RiderProject.dao.RiderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenderServiceImpl
{
    @Autowired
    private GenderDao.GenderRepository genderRepository;
    @Autowired
    private RiderDao riderDao;
    public Gender createGender(String genderName,boolean male,boolean female,boolean trandgender){
      Gender gender = new Gender();
      gender.setGenderName(genderName);
      gender.setMale(male);
      gender.setFemale(female);
      gender.setTransgender(trandgender);
      return genderRepository.save(gender);

    }
    public Rider createRider(Rider rider) {
        Gender gender = genderRepository.findByGenderName(rider.getGender().toUpperCase());
        if (gender == null) {
            throw new RuntimeException("Invalid gender");
        }
        rider.setGender(gender);
        return riderDao.save(rider);
    }


}
