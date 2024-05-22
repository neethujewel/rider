package com.RiderProject.dao;

import com.RiderProject.Model.Gender;
import org.hibernate.query.criteria.JpaCoalesce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderDao {
    public interface GenderRepository extends JpaRepository<Gender,Integer>{
       Gender findByGenderName(String genderName);

    }
}
