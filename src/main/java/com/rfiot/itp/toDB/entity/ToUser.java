package com.rfiot.itp.toDB.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Data
@Table(name = "tb_assets_user_management")
public class ToUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SEQ", nullable = false)
    private long seq;

    @Column(name = "NATIONAL_CODE", nullable = false)
    private String nationalCode;

    @Column(name = "CORPORATION_CODE", nullable = false)
    private String corporationCode;

    @Column(name = "USER_ID", nullable = false)
    private String userId;

    @Column(name = "USER_PW", nullable = false)
    private String userPw;

    @Column(name = "USER_NAME", nullable = false)
    private String userName;

    @Column(name = "USER_GRADE_CODE", nullable = false)
    private String userGradeCode;

    @Column(name = "ROLE_GRADE_CODE", nullable = false)
    private String roleGradeCode;

    @Column(name = "USER_DEPARTMENT_CODE", nullable = false)
    private String userDepartmentCode;

    @Column(name = "EMPLOYMENT_YN", nullable = false)
    private String employmentYn;

    @Column(name = "RESIGN_DATE")
    private String resignDate;

    @Column(name = "MOBILE")
    private String mobile;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "DELETE_YN", nullable = false)
    private Character deleteYn;

    @Column(name = "REG_ID", nullable = false)
    private String regId;

    @Column(name = "REG_DATE", nullable = false)
    private Instant regDate;

    @Column(name = "MOD_ID", nullable = false)
    private String modId;

    @Column(name = "MOD_DATE", nullable = false)
    private Instant modDate;

}

