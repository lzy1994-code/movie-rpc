package com.bw.movie.service;

import com.bw.base.BaseTest;
import org.junit.Ignore;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by xyj on 2018/7/27.
 */
@Ignore
public class MovieScheduleServiceTest extends BaseTest {

    @Resource
    private MovieScheduleService movieScheduleService;

    @Test
    public void findMovieScheduleList() {
        System.out.println(movieScheduleService.findMovieScheduleList(1, 1));
    }

    @Test
    public void findMovieScheduleById() {
        System.out.println(movieScheduleService.findMovieScheduleById(1));
    }

    @Test
    public void findCinemasByMovieId() {
        System.out.println(movieScheduleService.findCinemasByMovieId(1));
    }

    @Test
    public void findMoviesByCinemaId() {
        System.out.println(movieScheduleService.findMoviesByCinemaId(1));
    }
}