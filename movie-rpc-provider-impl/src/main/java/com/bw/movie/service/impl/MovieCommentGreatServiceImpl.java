package com.bw.movie.service.impl;

import com.bw.movie.dao.MovieCommentGreatMapper;
import com.bw.movie.rpc.pojo.MovieCommentGreat;
import com.bw.movie.service.MovieCommentGreatService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("movieCommentGreatService")
public class MovieCommentGreatServiceImpl implements MovieCommentGreatService {
    @Resource
    MovieCommentGreatMapper movieCommentGreatMapper;

    @Override
    public int whetherMovieGreat(int commentId, int userId) {
        return movieCommentGreatMapper.whetherMovieGreat(commentId, userId);
    }

    @Override
    public boolean saveMovieCommentGreat(MovieCommentGreat movieCommentGreat) {
        return movieCommentGreatMapper.saveMovieCommentGreat(movieCommentGreat);
    }
}
