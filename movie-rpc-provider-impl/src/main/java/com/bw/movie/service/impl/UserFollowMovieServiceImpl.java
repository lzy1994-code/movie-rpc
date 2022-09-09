package com.bw.movie.service.impl;

import com.bw.movie.dao.UserFollowMovieMapper;
import com.bw.movie.rpc.vo.UserFollowMovieVo;
import com.bw.movie.service.UserFollowMovieService;
import com.bw.movie.utils.Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lzy
 * @Description:
 * @Date: Create in 11:25 2019/8/10
 */

@Service("userFollowMovieService")
public class UserFollowMovieServiceImpl implements UserFollowMovieService {
    @Resource
    private UserFollowMovieMapper userFollowMovieMapper;

    @Override
    public List<UserFollowMovieVo> findFollowMovieList(int userId, int page, int count) {
        List<UserFollowMovieVo> followMovieList = userFollowMovieMapper.findFollowMovieList(userId, Util.getPageIndex(page, count), count);
        if (followMovieList.isEmpty()) {
            return new ArrayList<>();
        }
        return followMovieList;
    }
}
