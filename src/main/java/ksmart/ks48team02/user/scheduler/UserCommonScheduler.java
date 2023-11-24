package ksmart.ks48team02.user.scheduler;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class UserCommonScheduler {



    /**
     * ("0 0 * * * *") : 매일 매시 정각
     * ("* /10 * * * * *") : 0, 10, 20, 30, 40, 50 초
     * ("0 0 8-10 * * *") : 매일 8시, 9시, 10시 정각
     * ("0 0/30 8-10 * * *") : 매일 8시, 8시 30분, 9시, 9시 30분, 10시
     * ("0 0 9-18 * * 1-5") : 매주 월요일부터 금요일의 9시부터 오후 6시까지 매시
     */
    @Scheduled(cron = "0 0 1 * * ?") // 초, 분, 시, 일, 월, 년
    public void alertScheduledCron(){
        System.out.println("알림서비스 혹은 이메일 전송");
    }
}
