package com.bw.movie.service.impl;

import com.bw.movie.dao.CinemaCommentGreatMapper;
import com.bw.movie.dao.CinemaCommentMapper;
import com.bw.movie.rpc.pojo.CinemaComment;
import com.bw.movie.rpc.pojo.CinemaCommentGreat;
import com.bw.movie.rpc.vo.CinemaCommentGreatVo;
import com.bw.movie.rpc.vo.CinemaCommentVo;
import com.bw.movie.service.CinemaCommentService;
import com.bw.movie.utils.CopyBean;
import com.bw.movie.utils.Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("cinemaCommentService")
public class CinemaCommentServiceImpl implements CinemaCommentService {

    @Resource
    CinemaCommentMapper cinemaCommentMapper;
    @Resource
    CinemaCommentGreatMapper greatMapper;


    @Override
    public List<CinemaCommentVo> findAllCinemaComment(int userId, int cinemaId, int page, int count) {
        List<CinemaCommentVo> cinemaCommentVoList = new ArrayList<>();
        List<CinemaCommentVo> cinemaCommentVos = cinemaCommentMapper.findAllCinemaComment(cinemaId, Util.getPageIndex(page, count), count);
        for (CinemaCommentVo cinemaComment : cinemaCommentVos) {
            cinemaComment.setGreatNum(greatMapper.getCinemaGreatNum(cinemaComment.getCommentId()));
            //判断登录状态下是否点过赞
            if (userId > 0) {
                cinemaComment.setIsGreat(greatMapper.whetherCinemaGreat(cinemaComment.getCommentId(), userId));
            }

            //点赞者信息
            List<CinemaCommentGreatVo> cinemaCommentGreat = greatMapper.findCinemaCommentGreat(cinemaComment.getCommentId());
            List<String> list = new ArrayList<>();
            for (CinemaCommentGreatVo cinemaCommentGreatVo : cinemaCommentGreat) {
                String greatHeadPic = cinemaCommentGreatVo.getGreatHeadPic();
                list.add(greatHeadPic);
            }
            cinemaComment.setGreatHeadPic(list);
            cinemaCommentVoList.add(cinemaComment);
        }
        return cinemaCommentVoList;
    }

    @Override
    public int saveCinemaComment(CinemaComment cinemaComment) {
        CinemaComment comment = findCommentById(cinemaComment.getCinemaId(), cinemaComment.getCommentUserId());
        if (comment != null) {
            return 2;
        }
        return cinemaCommentMapper.saveCinemaComment(cinemaComment);
    }

    @Override
    public int commentTotal(int cinemaId) {
        return cinemaCommentMapper.commentTotal(cinemaId);
    }

    @Override
    public CinemaComment findCommentById(int cinemaId, int userId) {
        return cinemaCommentMapper.findCommentById(cinemaId, userId);
    }


}
