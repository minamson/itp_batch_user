package com.rfiot.itp.toDB.repository;


import com.rfiot.itp.toDB.entity.ToDept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IToDeptRepository extends JpaRepository<ToDept,Long> {
    List<ToDept> findByOrgDeptCode(String fromDeptCode);

}
