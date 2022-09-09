package com.bw.movie.service.impl;

import com.bw.movie.dao.UserIntegralMapper;
import com.bw.movie.rpc.pojo.UserIntegral;
import com.bw.movie.service.UserIntegralService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by xyj on 2018/7/19.
 */
@Service("userIntegralService")
public class UserIntegralServiceImpl implements UserIntegralService {

    @Resource
    private UserIntegralMapper userIntegralMapper;

    @Override
    public int addIntegral(int userId, int integral) {
        UserIntegral userIntegral = userIntegralMapper.getUserIntegralByUserId(userId);

        if (userIntegral == null) {
            return userIntegralMapper.addUserIntegral(userId, integral);
        }
        return userIntegralMapper.updateUserIntegral(userId, integral);
    }

    @Override
    public int reduceIntegral(int userId, int integral) {

        UserIntegral userIntegral = userIntegralMapper.getUserIntegralByUserId(userId);

        if (userIntegral == null) {
            userIntegralMapper.addUserIntegral(userId, 0);
            //积分不足
            return 2;
        }
        if (userIntegral.getBalance() < integral) {
            return 2;
        }

        return userIntegralMapper.updateUserIntegral(userId, -integral);
    }

    @Override
    public int getUserIntegral(int userId) {

        UserIntegral userIntegral = userIntegralMapper.getUserIntegralByUserId(userId);

        if (userIntegral == null) {
            userIntegralMapper.addUserIntegral(userId, 0);
            return 0;
        }

        return userIntegral.getBalance();
    }
}
