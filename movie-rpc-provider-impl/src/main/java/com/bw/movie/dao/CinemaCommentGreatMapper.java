package com.bw.movie.dao;

import com.bw.movie.rpc.pojo.CinemaCommentGreat;
import com.bw.movie.rpc.vo.CinemaCommentGreatVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CinemaCommentGreatMapper {

    /**
     * 获取影院评论点赞总数
     *
     * @param commentId
     * @return
     */
    Integer getCinemaGreatNum(int commentId);

    /**
     * 判断影院评论是否点赞
     *
     * @param commentId
     * @param userId
     * @return
     */
    int whetherCinemaGreat(@Param("commentId") int commentId, @Param("userId") int userId);

    /**
     * 保存点赞信息
     *
     * @param cinemaCommentGreato
     */
    boolean saveCinemaCommentGreat(CinemaCommentGreat cinemaCommentGreato);


    /**
     * 2.0 查询影院点赞用户头像
     *
     * @param commentId
     * @return
     */
    List<CinemaCommentGreatVo> findCinemaCommentGreat(int commentId);


}
