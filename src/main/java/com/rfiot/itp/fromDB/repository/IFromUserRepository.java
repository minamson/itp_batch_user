package com.rfiot.itp.fromDB.repository;


import com.rfiot.itp.fromDB.entity.FromUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public interface IFromUserRepository extends JpaRepository<FromUser, Long> {



}
