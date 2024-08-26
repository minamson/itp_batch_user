package com.rfiot.itp.fromDB.entity;

import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.*;

@Entity
@Table(name = "itp_sollink_VWCAUserInfo")
@Embeddable // for fake id
@Data
@Immutable // for View
@Subselect("SELECT ROW_NUMBER() over (ORDER BY NAME,EMPCODE, DEPTCODE) AS ID," +
        "       NAME AS NAME," +
        "       EMPCODE AS EMPCODE," +
        "       DEPTCODE AS DEPTCODE" +
        " FROM itp_sollink_VWCAUserInfo")
public class FromUser {

    @Id
    @Column(name="ID")
    private long id;

    @Column(name="NAME")//, nullable = false, unique = false)
    private String username;

    @Column(name="EMPCODE")//, nullable=true, unique = false)
    private String empCode;

    @Column(name="DEPTCODE")//,nullable=true, unique = false)
    private String userDepartmentCode;
}
