package com.bw.movie.dao;

import com.bw.movie.rpc.pojo.MovieCommentReply;
import com.bw.movie.rpc.vo.MovieCommentReplyVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MovieCommentReplyMapper {
    /**
     * 查询评论下的回复
     *
     * @param commentId
     * @param index
     * @param count
     * @return
     */
    List<MovieCommentReplyVo> findAllCommentReply(@Param("commentId") int commentId, @Param("index") int index, @Param("count") int count);

    /**
     * 增加评论回复
     *
     * @param movieCommentReply
     */
    boolean addCommentReply(MovieCommentReply movieCommentReply);

    /**
     * 查询评论下的回复总数
     *
     * @param commentId
     * @return
     */
    int findCommentReplyTotal(int commentId);

    /**
     * 通过id查询回复信息
     *
     * @param replyUserId
     * @return
     */
    MovieCommentReply findCommentReplyById(@Param("commentId") int commentId, @Param("replyUserId") int replyUserId);
}
