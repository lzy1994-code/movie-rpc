package com.bw.movie.service;

import com.bw.base.BaseTest;
import org.junit.Ignore;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @program: movie-rpc
 * @description: 购票测试类
 * @author: Lzy
 * @create: 2018-08-09 11:07
 **/

@Ignore
public class UserBuyTicketRecordServiceTest extends BaseTest {


    @Resource
    private UserBuyTicketRecordService service;

    @Test
    public void findUserBuyTicketRecordList() {
//        List<UserBuyTicketRecord> userBuyTicketRecords = service.findUserBuyTicketRecordList(5,1,5);
//        System.out.println(userBuyTicketRecords);
    }

    @Test
    public void modifyStatus() {
        int c = service.modifyStatus("20180806110120682", 2);
        System.out.println(c);
    }


}
