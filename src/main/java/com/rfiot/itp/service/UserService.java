package com.rfiot.itp.service;


import com.rfiot.itp.fromDB.entity.FromUser;
import com.rfiot.itp.fromDB.repository.IFromUserRepository;
import com.rfiot.itp.toDB.entity.ToDept;
import com.rfiot.itp.toDB.entity.ToUser;
import com.rfiot.itp.toDB.repository.IToDeptRepository;
import com.rfiot.itp.toDB.repository.IToUserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    final IFromUserRepository fromUserRepository;
    final IToUserRepository toUserRepository;
    final IToDeptRepository toDeptRepository;

    public UserService(IFromUserRepository fromUserRepository, IToUserRepository toUserRepository,
                       IToDeptRepository toDeptRepository) {
        this.fromUserRepository = fromUserRepository;
        this.toUserRepository = toUserRepository;
        this.toDeptRepository = toDeptRepository;
    }

    @Override
    public List<FromUser> getAllFromUser(){

        List<FromUser> fromUsers = fromUserRepository.findAll();

/*        for (FromUser fromUser : fromUsers) {
            System.out.print(" "+fromUser.getId());
            System.out.print(" "+fromUser.getUsername());
            System.out.print(" "+fromUser.getUserDepartmentCode());
            System.out.println(" "+fromUser.getEmpCode());
        }*/

        for (FromUser fromUser : fromUsers) {
            processUser(fromUser);
        }

        return fromUsers;
    }

    @Override
    @Transactional
    public void processUser(FromUser fromUser) {

        List<ToUser> users = toUserRepository.findByUserId(fromUser.getEmpCode().trim());
        if (!users.isEmpty()) {
            //System.out.println(" skip user.isPresent() "+ fromUser.getEmpCode().trim());
            return;
        }

        List<ToDept> toDepts = toDeptRepository.findByOrgDeptCode(fromUser.getUserDepartmentCode());
        String dept_code = "";
        if(!toDepts.isEmpty()) {
            dept_code = toDepts.get(0).getDepartmentCode();
            //System.out.println("toDepts count = "+toDepts.stream().count());
        }

        try {
            ToUser toUser = new ToUser();
            toUser.setNationalCode("KOREA");
            toUser.setCorporationCode("ITP");
            toUser.setUserId(fromUser.getEmpCode());
            toUser.setUserPw("asset02466$");
            toUser.setUserName(fromUser.getUsername());

            toUser.setUserGradeCode("C00066");//직급
            toUser.setRoleGradeCode("RG00001");//권한

            toUser.setUserDepartmentCode(dept_code);
            toUser.setEmploymentYn("C00011");

            toUser.setMobile(null);
            toUser.setEmail(null);
            toUser.setDeleteYn('N');

            toUser.setRegId("admin");
            toUser.setRegDate(Instant.now());
            toUser.setModId("admin");
            toUser.setModDate(Instant.now());

            toUserRepository.save(toUser);
        }
        catch (Exception e) {
            throw e;
        }
    }

}
