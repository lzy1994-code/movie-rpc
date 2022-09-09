package com.bw.movie.service;

import com.bw.base.BaseTest;
import org.junit.Ignore;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by xyj on 2018/7/24.
 */
@Ignore
public class CinemaServiceTest extends BaseTest {

    @Resource
    private CinemaService cinemaService;

    @Resource
    private CinemaCommentService cinemaCommentService;

    @Test
    public void findCinemaListByUserId() {
    }

    @Test
    public void findRecommendCinemas() {
//        CinemasInfoVo cinemasInfoVo = cinemaService.findRecommendCinemas(5,"116.30551391385724","40.04571807462411",3,10);
//        List<CinemasVo> followCinemas =  cinemasInfoVo.getFollowCinemas();
//        List<CinemasVo> nearbyCinemas = cinemasInfoVo.getNearbyCinemaList();
//        System.out.println(followCinemas);
//        System.out.println("*********");
//        System.out.println(nearbyCinemas);
    }

    @Test
    public void findCinemaInfo() {
    }

    @Test
    public void findAllCinemas() {

        System.out.println(cinemaService.findAllCinemas(1, 10, "青春光线"));

    }

    @Test
    public void findCinemaPageList() {
    }

    @Test
    public void followCinema() {
    }

    @Test
    public void cancelFollowCinema() {
    }

    @Test
    public void findCommentById() {
        System.out.println(cinemaCommentService.findCommentById(1, 5));
    }

  /*  @Test
    public void findNearbyCinemaList(){
      List<CinemasVo> cinemasVoList = cinemaService.findNearbyCinemaList("116.30551391385724","40.04571807462411");
        System.out.println(cinemasVoList);
    }*/

}