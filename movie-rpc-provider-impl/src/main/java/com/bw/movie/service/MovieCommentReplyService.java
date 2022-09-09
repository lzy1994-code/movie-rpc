package com.bw.movie.service;

import com.bw.movie.dao.MovieCommentReplyMapper;
import com.bw.movie.rpc.pojo.MovieCommentReply;
import com.bw.movie.rpc.vo.MovieCommentReplyVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MovieCommentReplyService {
    /**
     * 查询评论下的回复
     *
     * @param commentId
     * @return
     */
    List<MovieCommentReplyVo> findAllCommentReply(@Param("commentId") int commentId, @Param("page") int page, @Param("count") int count);

    /**
     * 增加评论回复
     *
     * @param movieCommentReply
     */
    boolean addCommentReply(MovieCommentReply movieCommentReply);

    /**
     * 通过id查询回复信息
     *
     * @param userId
     * @param commentId
     * @return
     */
    MovieCommentReply findCommentReplyById(int commentId, int userId);
}
