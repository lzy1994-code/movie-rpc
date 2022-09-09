package com.bw.movie.service;

import com.bw.movie.rpc.pojo.CinemaHall;

/**
 * @Author: lzy
 * @Description:
 * @Date: Create in 11:26 2019/8/17
 */
public interface CinemaHallService {

    /**
     * 根据影厅id查询放映厅
     *
     * @param hallId
     * @return
     */
    CinemaHall findCinemaHallById(int hallId);


    /**
     * 根据影院id，影厅查询影厅信息
     *
     * @param cinemaId
     * @param screeningHall
     * @return
     */
    CinemaHall findHallId(int cinemaId, String screeningHall);
}
