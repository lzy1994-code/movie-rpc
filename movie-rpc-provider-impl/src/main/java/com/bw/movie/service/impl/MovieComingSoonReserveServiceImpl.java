package com.bw.movie.service.impl;

import com.bw.movie.dao.MovieComingSoonReserveMapper;
import com.bw.movie.rpc.vo.UserReserveVo;
import com.bw.movie.service.MovieComingSoonReserveService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lzy
 * @Description:
 * @Date: Create in 10:46 2019/7/8
 */
@Service("movieComingSoonReserveService")
public class MovieComingSoonReserveServiceImpl implements MovieComingSoonReserveService {

    @Resource
    private MovieComingSoonReserveMapper movieComingSoonReserveMapper;

    @Override
    public int reserve(int userId, int movieId) {
        int i = whetherReserve(userId, movieId);
        if (i == 1) {
            //已预约
            return 2;
        }
        return movieComingSoonReserveMapper.addReserve(userId, movieId);
    }

    @Override
    public int whetherReserve(int userId, int movieId) {
        int i = movieComingSoonReserveMapper.whetherReserve(userId, movieId);
        if (i == 0) {
            return 2;
        }
        return 1;
    }

    @Override
    public int reserveNum(int movieId) {
        return movieComingSoonReserveMapper.reserveNum(movieId);
    }

    @Override
    public List<UserReserveVo> findUserReserve(int userId) {
        List<UserReserveVo> userReserve = movieComingSoonReserveMapper.findUserReserve(userId);
        if (userReserve.isEmpty()) {
            return new ArrayList<>();
        } else {
            for (UserReserveVo userReserveVo : userReserve) {
                int num = reserveNum(userReserveVo.getMovieId());
                userReserveVo.setWantSeeNum(num);
            }
        }
        return userReserve;
    }
}
