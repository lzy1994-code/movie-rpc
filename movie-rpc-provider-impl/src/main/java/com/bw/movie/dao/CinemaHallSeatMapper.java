package com.bw.movie.dao;

import com.bw.movie.rpc.vo.CinemaHallSeatVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: lzy
 * @Description:
 * @Date: Create in 16:53 2019/7/16
 */
public interface CinemaHallSeatMapper {


    /**
     * 2.0 根据影厅id 查询座位信息
     *
     * @param hallId
     * @return
     */
    List<CinemaHallSeatVo> findSeatInfo(int hallId);

    /**
     * 2.0 修改座位状态
     *
     * @param hallId
     * @param row
     * @param seat
     * @return
     */
    int updateSeatStatus(@Param("hallId") int hallId, @Param("row") int row, @Param("seat") int seat, @Param("status") int status);


}
