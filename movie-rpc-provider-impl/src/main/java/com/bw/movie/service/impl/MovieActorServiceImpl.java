package com.bw.movie.service.impl;

import com.bw.movie.dao.MovieActorMapper;
import com.bw.movie.rpc.vo.MovieActorVo;
import com.bw.movie.service.MovieActorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: lzy
 * @Description:
 * @Date: Create in 9:16 2019/7/10
 */
@Service("movieActorService")
public class MovieActorServiceImpl implements MovieActorService {

    @Resource
    private MovieActorMapper movieActorMapper;

    @Override
    public List<MovieActorVo> findMovieActor(int movieId) {
        return movieActorMapper.findMovieActor(movieId);
    }
}
