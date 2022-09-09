package com.bw.movie.service.impl;

import com.bw.movie.dao.CinemaHallSeatMapper;
import com.bw.movie.rpc.vo.CinemaHallSeatVo;
import com.bw.movie.service.CinemaHallSeatService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: lzy
 * @Description:
 * @Date: Create in 9:40 2019/7/17
 */
@Service("cinemaHallSeatService")
public class CinemaHallSeatServiceImpl implements CinemaHallSeatService {

    @Resource
    private CinemaHallSeatMapper cinemaHallSeatMapper;

    @Override
    public List<CinemaHallSeatVo> findSeatInfo(int hallId) {
        return cinemaHallSeatMapper.findSeatInfo(hallId);
    }

    @Override
    public int updateSeatStatus(int hallId, int row, int seat, int status) {
        return cinemaHallSeatMapper.updateSeatStatus(hallId, row, seat, status);
    }
}
