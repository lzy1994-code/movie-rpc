package com.bw.movie.service.impl;

import com.bw.movie.dao.CinemaHallMapper;
import com.bw.movie.rpc.pojo.CinemaHall;
import com.bw.movie.service.CinemaHallService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: lzy
 * @Description:
 * @Date: Create in 11:26 2019/8/17
 */
@Service("cinemaHallService")
public class CinemaHallServiceImpl implements CinemaHallService {

    @Resource
    private CinemaHallMapper cinemaHallMapper;

    @Override
    public CinemaHall findCinemaHallById(int hallId) {
        return cinemaHallMapper.findCinemaHallById(hallId);
    }

    @Override
    public CinemaHall findHallId(int cinemaId, String screeningHall) {
        return cinemaHallMapper.findHallId(cinemaId, screeningHall);
    }
}
