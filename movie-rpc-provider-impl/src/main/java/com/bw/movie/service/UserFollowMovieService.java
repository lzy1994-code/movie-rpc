package com.bw.movie.service;

import com.bw.movie.rpc.vo.UserFollowMovieVo;

import java.util.List;

/**
 * @Author: lzy
 * @Description:
 * @Date: Create in 11:24 2019/8/10
 */
public interface UserFollowMovieService {

    List<UserFollowMovieVo> findFollowMovieList(int userId, int page, int count);

}
