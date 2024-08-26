package com.rfiot.itp.schedulejob;


import com.rfiot.itp.fromDB.entity.FromUser;
import com.rfiot.itp.service.IUserService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SchedulerUserJob {

    private static final String CRON_EXPRESSION_EXAMPLE = "1 * * * * *";

    private final IUserService userService;

    public SchedulerUserJob(IUserService userService) {
        this.userService = userService;
    }

    @Scheduled(cron = "0 0 4 * * *") // am 4:00
    public void cron() {
        System.out.println(" Batch running at 04:00");
        readFromData();
    }

    public void readFromData(){
        System.out.println(" =============== Batch begin =============== ");
        List<FromUser> list = userService.getAllFromUser();
//        for(FromUser u : list){
//            System.out.println("id "+ u.getId());
//            System.out.println("getUsername "+ u.getUsername());
//        }
        System.out.println("                 Batch total: " + list.size() );
        System.out.println(" =============== Batch end =============== ");
    }

}


