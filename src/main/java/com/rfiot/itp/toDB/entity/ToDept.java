package com.rfiot.itp.toDB.entity;


import lombok.Data;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Data
@Table(name = "tb_assets_department_management")
public class ToDept {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SEQ", nullable = false)
    private Long seq;

    @Column(name = "NATIONAL_CODE", nullable = false)
    private String nationalCode;

    @Column(name = "CORPORATION_CODE", nullable = false)
    private String corporationCode;

    @Column(name = "DEPARTMENT_CODE", nullable = false)
    private String departmentCode;

    @Column(name = "DEPARTMENT_NAME", nullable = false)
    private String departmentName;

    @Column(name = "USE_YN", nullable = false)
    private Character useYn;

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

    @Column(name = "ITP_DEPT_CODE")
    private String orgDeptCode;

}