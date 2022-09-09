package com.bw.movie.utils;

import java.text.SimpleDateFormat;

/**
 * Created by xyj on 2018/8/3.
 */
public class SendEmailThread implements Runnable {

    /**
     * 生成二维码的数量
     */
    private int num;

    /**
     * 发送的邮箱地址
     */
    private String email;

    private String nickName;
    private String movieName;
    private String beginTime;
    private String endTime;

    public SendEmailThread() {
    }

    public SendEmailThread(int num, String email, String nickName, String movieName, String beginTime, String endTime) {
        this.num = num;
        this.email = email;
        this.nickName = nickName;
        this.movieName = movieName;
        this.beginTime = beginTime;
        this.endTime = endTime;
    }

    @Override
    public void run() {

        //生成兑换码
        StringBuffer sb = new StringBuffer();
        String code = "";
        for (int i = 0; i < this.num; i++) {
            code = Util.create_nonce_str(8);
            sb.append(code + "\n");
        }
        //TODO 兑换码的入库
        String title = String.format(Constants.EMAIL_TITLE, this.nickName, this.movieName);
        String content = String.format(Constants.EMAIL_CONTENT, this.movieName, this.beginTime, this.endTime);

        //发送邮箱
        QRcodeUtil.createQRcodeToEmail(sb.toString(), title, content, this.email);
    }

}
