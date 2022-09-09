package com.bw.movie.service;

import com.bw.movie.rpc.vo.UserFollowCinemaVo;

import java.util.List;

/**
 * @Author: lzy
 * @Description:
 * @Date: Create in 11:38 2019/8/10
 */
public interface UserFollowCinemaService {

    List<UserFollowCinemaVo> findFollowCinemaList(int userId, int page, int count);


}
