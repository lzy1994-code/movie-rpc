package com.bw.movie.service;

import com.bw.movie.rpc.vo.CinemaHallSeatVo;

import java.util.List;

/**
 * @Author: lzy
 * @Description:
 * @Date: Create in 9:40 2019/7/17
 */
public interface CinemaHallSeatService {

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
     * @param status
     * @return
     */
    int updateSeatStatus(int hallId, int row, int seat, int status);

}
