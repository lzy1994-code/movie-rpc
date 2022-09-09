package com.bw.movie.service.impl;

import com.bw.movie.dao.MovieDirectorMapper;
import com.bw.movie.rpc.vo.MovieDirectorVo;
import com.bw.movie.service.MovieDirectorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: lzy
 * @Description:
 * @Date: Create in 9:05 2019/7/10
 */
@Service("movieDirectorService")
public class MovieDirectorServiceImpl implements MovieDirectorService {

    @Resource
    private MovieDirectorMapper movieDirectorMapper;

    @Override
    public List<MovieDirectorVo> findMovieDirector(int movieId) {
        return movieDirectorMapper.findMovieDirector(movieId);
    }
}
