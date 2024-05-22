package com.RiderProject.dao;

import RiderWrapper.RiderWrapper;
import com.RiderProject.Model.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public interface RiderDao extends JpaRepository<Rider,Integer>
{
  Rider findByEmailId(@Param("email")String email);



}



