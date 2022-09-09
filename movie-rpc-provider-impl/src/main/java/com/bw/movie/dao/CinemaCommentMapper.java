package com.bw.movie.dao;

import com.bw.movie.rpc.pojo.CinemaComment;
import com.bw.movie.rpc.vo.CinemaCommentVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CinemaCommentMapper {
    /**
     * 根据影院id查询所有影院评论
     *
     * @param cinemaId
     * @return
     */
    List<CinemaCommentVo> findAllCinemaComment(@Param("cinemaId") int cinemaId, @Param("index") int index, @Param("count") int count);

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
     * 通过用户查找评论内容
     *
     * @param commentUserId
     * @param cinemaId
     * @return
     */
    CinemaComment findCommentById(@Param("cinemaId") int cinemaId, @Param("commentUserId") int commentUserId);

}
