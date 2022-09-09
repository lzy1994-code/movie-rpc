package com.bw.movie.service.impl;

import com.bw.movie.dao.UserSignMapper;
import com.bw.movie.service.UserSignService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by xyj on 2018/7/19.
 */
@Service("userSignService")
public class UserSignServiceImpl implements UserSignService {

    @Resource
    private UserSignMapper userSignMapper;

    @Override
    public int addUserSign(int userId) {
        return userSignMapper.addUserSign(userId);
    }

    @Override
    public int getUserDaySign(int userId) {
        return userSignMapper.getUserSign(userId);
    }
}
