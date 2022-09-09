package com.bw.movie.service.impl;

import com.bw.movie.dao.CinemaCommentGreatMapper;
import com.bw.movie.rpc.pojo.CinemaCommentGreat;
import com.bw.movie.service.CinemaCommentGreatService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("cinemaCommentGreatService")
public class CinemaCommentGreatServiceImpl implements CinemaCommentGreatService {
    @Resource
    CinemaCommentGreatMapper cinemaCommentGreatMapper;

    @Override
    public boolean saveCinemaCommentGreat(CinemaCommentGreat cinemaCommentGreat) {
        return cinemaCommentGreatMapper.saveCinemaCommentGreat(cinemaCommentGreat);
    }

    @Override
    public int whetherCinemaGreat(int commentId, int userId) {
        return cinemaCommentGreatMapper.whetherCinemaGreat(commentId, userId);
    }
}
