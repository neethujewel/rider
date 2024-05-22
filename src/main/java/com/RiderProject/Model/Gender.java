package com.RiderProject.Model;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name="gender")

public class Gender implements Serializable {
    private static final long seialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Integer id;

    @Column(name="genderName",nullable=false,length = 50)
    private  String genderName;

    @Column(name = "male")
    private boolean male;

    @Column (name = "female")
    private boolean female;

    @Column(name = "transgender")
    private boolean transgender;

    @OneToMany(mappedBy = "gender")
    private Set<Rider> riders;


    public void setGender(String male) {
    }

    public void setName(String name) {
    }

    public void setEmail(String email) {
    }

    public void setPassword(String password) {
    }
}
