package com.bw.movie.service;

import com.bw.base.BaseTest;
import com.bw.movie.rpc.pojo.SystemMessages;
import org.junit.Ignore;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: movie-rpc
 * @description: 推送消息测试单元
 * @author: Lzy
 * @create: 2018-08-10 10:41
 **/
@Ignore
public class SystemMessagesServiceTest extends BaseTest {

    @Resource
    private SystemMessagesService systemMessagesService;

    @Test
    public void findAllMessages() {
        List<SystemMessages> messages = systemMessagesService.findAllSysMsgs(5, 1, 5);
        System.out.println(messages);
    }

    @Test
    public void addSystemMessages() {
        boolean boo = systemMessagesService.addSysMsgs(7, "云烟", "百年修得");
        System.out.println(boo);
    }

    @Test
    public void findStatus() {
        int count = systemMessagesService.findSysMsgsStatus(5);
        System.out.println(count);
       /*boolean boo = systemMessagesService.sysMsgsStatusChange(5,45);
       System.out.println(boo);*/
    }

    @Test
    public void deleteMessages() {
        systemMessagesService.deleteSysMsgs(6);
    }

}
