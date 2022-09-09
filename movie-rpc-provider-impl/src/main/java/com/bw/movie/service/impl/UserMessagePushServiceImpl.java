package com.bw.movie.service.impl;

import com.bw.movie.dao.UserMessagePushMapper;
import com.bw.movie.rpc.pojo.UserMessagePush;
import com.bw.movie.service.UserMessagePushService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by xyj on 2018/8/13.
 */
@Service("userMessagePushService")
public class UserMessagePushServiceImpl implements UserMessagePushService {

    @Resource
    private UserMessagePushMapper userMessagePushMapper;

    @Override
    public int saveUserMessagePush(UserMessagePush userMessagePush) {
        return userMessagePushMapper.addUserMessagePush(userMessagePush);
    }

    @Override
    public UserMessagePush getUserMessagePush(int userId) {
        return userMessagePushMapper.getUserMessagePush(userId);
    }

    @Override
    public int findUserMessagePush(int userId, String token) {
        return userMessagePushMapper.findUserMessagePush(userId, token);
    }

    @Override
    public int deleteUserMessagePush(int userId) {
        return userMessagePushMapper.deleteByUserId(userId);
    }
}
