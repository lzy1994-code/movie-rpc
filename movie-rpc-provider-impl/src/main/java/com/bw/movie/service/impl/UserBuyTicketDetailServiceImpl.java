package com.bw.movie.service.impl;

import com.bw.movie.dao.UserBuyTicketDetailMapper;
import com.bw.movie.rpc.pojo.*;
import com.bw.movie.rpc.vo.MySeenMovieCommentVo;
import com.bw.movie.rpc.vo.UserBuyTicketRecordVo;
import com.bw.movie.rpc.vo.UserSeenMovieRecordVo;
import com.bw.movie.service.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @program: movie-rpc
 * @description: 购票明细实现类
 * @author: Lzy
 * @create: 2018-08-09 12:01
 **/
@Service("/userBuyTicketDetailService")
public class UserBuyTicketDetailServiceImpl implements UserBuyTicketDetailService {

    @Resource
    private UserBuyTicketDetailMapper userBuyTicketDetailMapper;

    @Resource
    private UserBuyTicketRecordService userBuyTicketRecordService;

    @Resource
    private MovieCommentService movieCommentService;

    @Resource
    private CinemaCommentService cinemaCommentService;

    @Resource
    private CinemaService cinemaService;

    @Resource
    private MovieService movieService;


    @Override
    public int addUserBuyTicketDetail(UserBuyTicketDetail userBuyTicketDetail) {
        return userBuyTicketDetailMapper.addUserBuyTicketDetail(userBuyTicketDetail);
    }

    @Override
    public List<UserSeenMovieRecordVo> findSeenMovie(int userId) {
        List<UserSeenMovieRecordVo> seenMovie = userBuyTicketDetailMapper.findSeenMovie(userId);
        //是否评论
        for (UserSeenMovieRecordVo userSeenMovieRecordVo : seenMovie) {
            MovieComment comment = movieCommentService.findCommentById(userSeenMovieRecordVo.getMovieId(), userId);
            if (comment == null) {
                userSeenMovieRecordVo.setWhetherComment(1);
            } else {
                userSeenMovieRecordVo.setWhetherComment(2);
            }
        }
        return seenMovie;
    }

    @Override
    public List<UserBuyTicketRecord> findMyMovieTicket(int userId) {
        return userBuyTicketDetailMapper.findMyMovieTicket(userId);
    }

    @Override
    public UserBuyTicketDetail findExchangeCode(int userId, int id) {
        return userBuyTicketDetailMapper.findExchangeCode(userId, id);
    }

    @Override
    public int getTicket(String orderId) {
        UserBuyTicketRecord buyTicketRecord = userBuyTicketRecordService.findBuyTicketRecordByOrderId(orderId);
        return userBuyTicketDetailMapper.updateStatus(buyTicketRecord.getUserId(), buyTicketRecord.getId());
    }

    @Override
    public MySeenMovieCommentVo findSeenMovieComment(int userId, int recordId) {
        MySeenMovieCommentVo seenMovieComment = userBuyTicketDetailMapper.findSeenMovieComment(userId, recordId);
        MovieComment comment = movieCommentService.findCommentById(seenMovieComment.getMovieId(), userId);
        if (comment == null) {
            return null;
        }
        seenMovieComment.setMovieCommentContent(comment.getCommentContent());
        seenMovieComment.setScore(comment.getScore());
        CinemaComment cinemaComment = cinemaCommentService.findCommentById(seenMovieComment.getCinemaId(), userId);
        if (cinemaComment != null) {
            seenMovieComment.setCinemaCommentContent(cinemaComment.getCommentContent());
        }
        return seenMovieComment;
    }
}
