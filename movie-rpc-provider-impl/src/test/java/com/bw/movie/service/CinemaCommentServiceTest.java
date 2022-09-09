package com.bw.movie.service;

import com.bw.base.BaseTest;
import com.bw.movie.dao.CinemaCommentGreatMapper;
import com.bw.movie.rpc.pojo.CinemaComment;
import com.bw.movie.rpc.pojo.CinemaCommentGreat;
import com.bw.movie.rpc.vo.CinemaCommentVo;
import org.junit.Ignore;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

@Ignore
public class CinemaCommentServiceTest extends BaseTest {

    @Resource
    private CinemaCommentService cinemaCommentService;

    @Resource
    private CinemaCommentGreatService cinemaCommentGreatService;

    @Resource
    private CinemaCommentGreatMapper cinemaCommentGreatMapper;

    @Test
    public void findAllCommentContent() {
        List<CinemaCommentVo> cinemaCommentVoList = cinemaCommentService.findAllCinemaComment(6, 7, 1, 5);
        System.out.println(cinemaCommentVoList);
    }


    @Test
    public void saveCinemaComment() {
        CinemaComment cinemaComment = new CinemaComment();
        cinemaComment.setCommentUserId(13466);
        cinemaComment.setCommentContent("测试数据！");
        cinemaComment.setCinemaId(8);
        // System.out.println("保存成功");
        int i = cinemaCommentService.saveCinemaComment(cinemaComment);
        System.out.println(i);

    }

    @Test
    public void savaGreat() {
        CinemaCommentGreat cinemaCommentGreat = new CinemaCommentGreat();
        cinemaCommentGreat.setCommentId(101);
        cinemaCommentGreat.setUserId(5);
        boolean b = cinemaCommentGreatService.saveCinemaCommentGreat(cinemaCommentGreat);
        System.out.println(b);
    }

    @Test
    public void whetherCinemaGreat() {
        int a = cinemaCommentGreatService.whetherCinemaGreat(34, 5);
        System.out.println(a);
    }

    @Test
    public void getCinemaGreatNum() {
        int num = cinemaCommentGreatMapper.getCinemaGreatNum(69);
        System.out.println(num);
    }

}
