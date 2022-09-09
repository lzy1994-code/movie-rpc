package com.bw.movie.service.impl;

import com.bw.movie.dao.UserExtendMapper;
import com.bw.movie.rpc.pojo.UserExtend;
import com.bw.movie.service.UserExtendService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by xyj on 2018/7/18.
 */
@Service("userExtendService")
public class UserExtendServiceImpl implements UserExtendService {

    @Resource
    private UserExtendMapper userExtendMapper;

    @Override
    public int addUserExtend(UserExtend userExtend) {
        return userExtendMapper.addUserExtend(userExtend);
    }
}
