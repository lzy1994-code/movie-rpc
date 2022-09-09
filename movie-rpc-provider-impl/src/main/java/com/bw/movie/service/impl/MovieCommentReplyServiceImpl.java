package com.bw.movie.service.impl;

import com.bw.movie.dao.MovieCommentReplyMapper;
import com.bw.movie.rpc.pojo.MovieCommentReply;
import com.bw.movie.rpc.vo.MovieCommentReplyVo;
import com.bw.movie.service.MovieCommentReplyService;
import com.bw.movie.utils.Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("movieCommentReplyService")
public class MovieCommentReplyServiceImpl implements MovieCommentReplyService {
    @Resource
    MovieCommentReplyMapper movieCommentReplyMapper;


    @Override
    public List<MovieCommentReplyVo> findAllCommentReply(int commentId, int page, int count) {
        return movieCommentReplyMapper.findAllCommentReply(commentId, Util.getPageIndex(page, count), count);
    }

    @Override
    public boolean addCommentReply(MovieCommentReply movieCommentReply) {
        return movieCommentReplyMapper.addCommentReply(movieCommentReply);
    }

    @Override
    public MovieCommentReply findCommentReplyById(int commentId, int userId) {
        return movieCommentReplyMapper.findCommentReplyById(commentId, userId);
    }


}
