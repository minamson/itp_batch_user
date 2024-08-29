package com.rfiot.itp.toDB.repository;

import com.rfiot.itp.toDB.entity.ToUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IToUserRepository extends JpaRepository<ToUser, Long> {
    List<ToUser> findByUserId(String userID);
}
