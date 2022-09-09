package com.bw.movie.dao;

import com.bw.movie.rpc.pojo.UserIntegral;
import org.apache.ibatis.annotations.Param;

/**
 * Created by xyj on 2018/7/19.
 */
public interface UserIntegralMapper {

    int addUserIntegral(@Param("userId") int userId, @Param("integral") int integral);

    int updateUserIntegral(@Param("userId") int userId, @Param("integral") int integral);

    UserIntegral getUserIntegralByUserId(int userId);

}
