package com.bw.movie.service;

import com.bw.movie.rpc.pojo.CinemaComment;
import com.bw.movie.rpc.vo.CinemaCommentVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CinemaCommentService {

    /**
     * 根据影院id查询所有影院评论
     *
     * @param cinemaId
     * @return
     */
    List<CinemaCommentVo> findAllCinemaComment(@Param("userId") int userId, @Param("cinemaId") int cinemaId, @Param("page") int page, @Param("count") int count);

    /**
     * 保存用户对影院的评论
     *
     * @param cinemaComment
     */
    int saveCinemaComment(CinemaComment cinemaComment);


    /**
     * 查找影院评论总数
     *
     * @param cinemaId
     * @return
     */
    int commentTotal(int cinemaId);

    /**
     * 通过Id查找评论内容
     *
     * @param userId
     * @param cinemaId
     * @return
     */
    CinemaComment findCommentById(int cinemaId, int userId);


}
