package com.bw.movie.service;

import com.bw.movie.rpc.pojo.CinemaCommentGreat;

public interface CinemaCommentGreatService {

    /**
     * 保存点赞信息
     *
     * @param cinemaCommentGreat
     */
    boolean saveCinemaCommentGreat(CinemaCommentGreat cinemaCommentGreat);

    /**
     * 判断影院评论是否点赞
     *
     * @param commentId
     * @param userId
     * @return
     */
    int whetherCinemaGreat(int commentId, int userId);


}
