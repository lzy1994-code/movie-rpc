package com.bw.movie.service;

import com.bw.base.BaseTest;
import com.bw.movie.rpc.pojo.UserMessagePush;
import org.junit.Ignore;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by xyj on 2018/8/14.
 */
@Ignore
public class UserMessagePushServiceTest extends BaseTest {

    @Resource
    private UserMessagePushService userMessagePushService;

    @Test
    public void saveUserMessagePush() {
        UserMessagePush userMessagePush = new UserMessagePush();
        userMessagePush.setOs(1);
        userMessagePush.setToken("123");
        userMessagePush.setUserId(5);
        userMessagePushService.saveUserMessagePush(userMessagePush);
    }

    @Test
    public void getUserMessagePush() {
        userMessagePushService.getUserMessagePush(5);
    }

    @Test
    public void findUserMessagePush() {

        userMessagePushService.findUserMessagePush(5, "123");

    }

    @Test
    public void deleteUserMessagePush() {

        userMessagePushService.deleteUserMessagePush(1);

    }
}