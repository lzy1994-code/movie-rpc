package com.bw.movie.dao;

import com.bw.movie.rpc.pojo.CinemaHall;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: lzy
 * @Description:
 * @Date: Create in 11:21 2019/8/17
 */
public interface CinemaHallMapper {

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
    CinemaHall findHallId(@Param("cinemaId") int cinemaId, @Param("screeningHall") String screeningHall);

}
