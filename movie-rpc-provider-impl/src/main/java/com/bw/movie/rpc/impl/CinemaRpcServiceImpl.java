package com.bw.movie.rpc.impl;

import com.bw.movie.rpc.api.CinemaRpcService;
import com.bw.movie.rpc.pojo.CinemaComment;
import com.bw.movie.rpc.pojo.CinemaCommentGreat;
import com.bw.movie.rpc.pojo.Cinemas;
import com.bw.movie.rpc.vo.CinemaCommentVo;
import com.bw.movie.rpc.vo.CinemaScheduleVo;
import com.bw.movie.rpc.vo.CinemasVo;
import com.bw.movie.service.CinemaCommentGreatService;
import com.bw.movie.service.CinemaCommentService;
import com.bw.movie.service.CinemaService;
import com.bw.movie.service.MovieScheduleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xyj on 2018/7/17.
 */
@Service("cinemaRpcService")
public class CinemaRpcServiceImpl implements CinemaRpcService {

    @Resource
    private CinemaService cinemaService;
    @Resource
    private CinemaCommentService cinemaCommentService;
    @Resource
    private CinemaCommentGreatService commentGreatService;
    @Resource
    private MovieScheduleService movieScheduleService;

    @Override
    public List<CinemasVo> findRecommendCinemas(int userId, int page, int count) {
        return cinemaService.findRecommendCinemas(userId, page, count);
    }

    @Override
    public List<CinemasVo> findNearbyCinemas(int userId, String longitude, String latitude, int page, int count) {
        return cinemaService.findNearbyCinemas(userId, longitude, latitude, page, count);
    }

    @Override
    public CinemasVo findCinemaInfo(int userId, int cinemaId) {
        return cinemaService.findCinemaInfo(userId, cinemaId);
    }

    @Override
    public List<CinemasVo> findAllCinemas(int page, int count, String cinemaName) {
        return cinemaService.findAllCinemas(page, count, cinemaName);
    }

    @Override
    public List<CinemasVo> findCinemaPageList(int userId, int page, int count) {
        return cinemaService.findCinemaPageList(userId, page, count);
    }

    @Override
    public int followCinema(int userId, int cinemaId) {
        return cinemaService.followCinema(userId, cinemaId);
    }

    @Override
    public int cancelFollowCinema(int userId, int cinemaId) {
        return cinemaService.cancelFollowCinema(userId, cinemaId);
    }

    @Override
    public List<CinemaCommentVo> findAllCinemaComment(int userId, int cinemaId, int page, int count) {
        return cinemaCommentService.findAllCinemaComment(userId, cinemaId, page, count);
    }

    @Override
    public int saveCinemaComment(CinemaComment cinemaComment) {
        return cinemaCommentService.saveCinemaComment(cinemaComment);
    }

    @Override
    public int commentTotal(int cinemaId) {
        return cinemaCommentService.commentTotal(cinemaId);
    }

    @Override
    public CinemaComment findCommentById(int cinemaId, int userId) {
        return cinemaCommentService.findCommentById(cinemaId, userId);
    }


    @Override
    public boolean saveCinemaCommentGreat(CinemaCommentGreat commentGreat) {
        return commentGreatService.saveCinemaCommentGreat(commentGreat);
    }

    @Override
    public int whetherCinemaGreat(int commentId, int userId) {
        return commentGreatService.whetherCinemaGreat(commentId, userId);
    }

    @Override
    public List<Cinemas> findCinemaByRegion(int regionId) {
        return cinemaService.findCinemaByRegion(regionId);
    }

    @Override
    public List<CinemaScheduleVo> findCinemaScheduleList(int cinemaId, int page, int count) {
        return movieScheduleService.findCinemaScheduleList(cinemaId, page, count);
    }


}
