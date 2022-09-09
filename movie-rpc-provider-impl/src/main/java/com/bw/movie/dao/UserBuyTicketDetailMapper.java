package com.bw.movie.dao;

import com.bw.movie.rpc.pojo.UserBuyTicketDetail;
import com.bw.movie.rpc.pojo.UserBuyTicketRecord;
import com.bw.movie.rpc.vo.MySeenMovieCommentVo;
import com.bw.movie.rpc.vo.UserBuyTicketRecordVo;
import com.bw.movie.rpc.vo.UserSeenMovieRecordVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by xyj on 2018/7/28.
 */
public interface UserBuyTicketDetailMapper {

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
     * 2.0查询取票码
     */
    UserBuyTicketDetail findExchangeCode(@Param("userId") int userId, @Param("id") int id);

    /**
     * 2.0 修改兑换码状态
     *
     * @param userId
     * @param id
     * @return
     */
    int updateStatus(@Param("userId") int userId, @Param("id") int id);

    /**
     * 查询已观看影片的评论
     *
     * @param userId
     * @param recordId
     * @return
     */
    MySeenMovieCommentVo findSeenMovieComment(@Param("userId") int userId, @Param("recordId") int recordId);

}
