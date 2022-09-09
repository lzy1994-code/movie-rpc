package com.bw.movie.service.impl;

import com.bw.movie.dao.FeedBackMapper;
import com.bw.movie.rpc.pojo.FeedBack;
import com.bw.movie.service.FeedBackService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by xyj on 2018/7/18.
 */
@Service("feedBackService")
public class FeedBackServiceImpl implements FeedBackService {

    @Resource
    private FeedBackMapper feedBackMapper;

    @Override
    public int recordFeedBack(int userId, String content) {
        FeedBack feedBack = new FeedBack();
        feedBack.setContent(content);
        feedBack.setUserId(userId);
        return feedBackMapper.addFeedBack(feedBack);
    }

}
