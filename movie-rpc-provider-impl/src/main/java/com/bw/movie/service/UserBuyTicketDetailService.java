package com.bw.movie.service;

import com.bw.movie.rpc.pojo.UserBuyTicketDetail;
import com.bw.movie.rpc.pojo.UserBuyTicketRecord;
import com.bw.movie.rpc.vo.MySeenMovieCommentVo;
import com.bw.movie.rpc.vo.UserSeenMovieRecordVo;

import java.util.List;

/**
 * Created by xyj on 2018/7/28.
 */
public interface UserBuyTicketDetailService {

    int addUserBuyTicketDetail(UserBuyTicketDetail userBuyTicketDetail);


    /**
     * 2.0 查询看过的电影
     */
    List<UserSeenMovieRecordVo> findSeenMovie(int userId);

    /**
     * 2.0 我的电影票
     */
    List<UserBuyTicketRecord> findMyMovieTicket(int userId);

    /**
     * 2.0  查询取票码
     */
    UserBuyTicketDetail findExchangeCode(int userId, int id);

    /**
     * 2.0 取票
     *
     * @return
     */
    int getTicket(String orderId);

    /**
     * 观看后的电影的评论
     */
    MySeenMovieCommentVo findSeenMovieComment(int userId, int recordId);
}
