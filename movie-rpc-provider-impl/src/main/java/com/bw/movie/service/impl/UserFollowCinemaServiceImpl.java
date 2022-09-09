package com.bw.movie.service.impl;

import com.bw.movie.dao.UserFollowCinemaMapper;
import com.bw.movie.rpc.vo.UserFollowCinemaVo;
import com.bw.movie.service.UserFollowCinemaService;
import com.bw.movie.utils.Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lzy
 * @Description:
 * @Date: Create in 11:39 2019/8/10
 */

@Service("userFollowCinemaService")
public class UserFollowCinemaServiceImpl implements UserFollowCinemaService {

    @Resource
    private UserFollowCinemaMapper userFollowCinemaMapper;

    @Override
    public List<UserFollowCinemaVo> findFollowCinemaList(int userId, int page, int count) {
        List<UserFollowCinemaVo> followCinemaList = userFollowCinemaMapper.findFollowCinemaList(userId, Util.getPageIndex(page, count), count);
        if (followCinemaList.isEmpty()) {
            return new ArrayList<>();
        }
        return followCinemaList;
    }
}
