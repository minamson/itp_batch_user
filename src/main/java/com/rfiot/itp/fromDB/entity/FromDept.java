package com.rfiot.itp.fromDB.entity;

import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.Subselect;

import javax.persistence.*;

@Entity
@Table(name = "itp_sollink_VWDADept")
//@Embeddable // for fake id
@Data
@Immutable // for View
@Subselect("SELECT ROW_NUMBER() over (ORDER BY DEPTNAME, DEPTCODE, DEPTCODE, UPPERNAME, UPPERCODE,TOPNAME,TOPCODE) AS ID," +
        "       DEPTNAME AS DEPTNAME, " +
        "       DEPTCODE AS DEPTCODE, " +
        "       UPPERNAME AS UPPERNAME, " +
        "       UPPERCODE AS UPPERCODE, " +
        "       TOPNAME AS TOPNAME, " +
        "       TOPCODE AS TOPCODE" +
        "FROM itp_sollink_VWDADept")
public class FromDept {
    @Id
    @Column(name="ID")
    private long id;

    @Nationalized
    @Column(name = "DEPTNAME")
    private String departmentName;

    @Nationalized
    @Column(name = "DEPTCODE")
    private String departmentCode;

    @Nationalized
    @Column(name = "UPPERNAME")
    private String uppername;

    @Nationalized
    @Column(name = "UPPERCODE")
    private String uppercode;

    @Nationalized
    @Column(name = "TOPNAME")
    private String topname;

    @Nationalized
    @Column(name = "TOPCODE")
    private String topcode;

}
