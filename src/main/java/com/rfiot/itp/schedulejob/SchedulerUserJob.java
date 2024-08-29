package com.rfiot.itp.schedulejob;


import com.rfiot.itp.fromDB.entity.FromUser;
import com.rfiot.itp.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@Component
public class SchedulerUserJob {

    private final IUserService userService;

    public SchedulerUserJob(IUserService userService) {
        this.userService = userService;
    }

//    @Scheduled(fixedDelay = 1000) // 1초마다 실행
    @Scheduled(cron = "0 0 4 * * *") // am 4:00
    public void cron() {
        try
        {
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String str = format.format(date);

            log.info(" =============== Batch begin =============== ");
            log.info("         Batch running at " + str );

            List<FromUser> list = userService.getAllFromUser();
            for(FromUser u : list){
                log.debug("id "+ u.getId());
                log.debug("getUsername "+ u.getUsername());
            }

            log.info("                          Batch total: " + list.size() );
            log.info(" =============== Batch end================== \n\n\n\n");

        }catch (Exception e){
            e.getStackTrace();
        }
    }
}


