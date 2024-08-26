package com.rfiot.itp.service;


import com.rfiot.itp.fromDB.entity.FromUser;

import java.util.List;


public interface IUserService {
    List<FromUser> getAllFromUser();

    void processUser(FromUser fromUser);
}
