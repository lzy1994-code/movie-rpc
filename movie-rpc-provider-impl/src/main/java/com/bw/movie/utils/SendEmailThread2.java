package com.bw.movie.utils;


import com.bw.movie.cache.RedisPool;
import com.bw.movie.cache.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by xyj on 2018/8/3.
 */
public class SendEmailThread2 implements Runnable {

    private static Logger logger = LoggerFactory.getLogger("SendEmailThread2");
    /**
     * 发送的邮箱地址
     */
    private String email;


    public SendEmailThread2() {
    }

    public SendEmailThread2(String email) {
        this.email = email;
    }

    @Override
    public void run() {
        String nonceStr = Util.createCheckCode(6);
        String count = String.format(Constants.REGISTER_EMAIL_SEND_COUNT, nonceStr);
        try {
            SendEmailUtil sendEmailUtil = SendEmailUtil.init();
            boolean send = sendEmailUtil.sendEmail(email, "维度影院注册验证码", count);
            logger.info("SendEmailThread,send={}", send);
            if (send) {
                RedisPool redisPool = RedisUtil.getRedisPool(RedisConstant.POOL_NAME);
                String key = String.format(RedisConstant.EMAIL_CODE_KEY, email);
                redisPool.setAndExpire(key, nonceStr, 300);
            }
        } catch (Exception e) {
            logger.error("sendOutEmailCode={}", e);
        }
    }

}
