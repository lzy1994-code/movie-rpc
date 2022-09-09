package com.bw.movie.service;

import com.bw.base.BaseTest;
import org.junit.Ignore;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by xyj on 2018/7/21.
 */
@Ignore
public class UserIntegralServiceTest extends BaseTest {

    @Resource
    private UserIntegralService userIntegralService;

    @Test
    public void addIntegral() {

        System.out.println(userIntegralService.addIntegral(5, 10));

    }

    @Test
    public void reduceIntegral() {

        System.out.println(userIntegralService.reduceIntegral(5, 20));

    }

    @Test
    public void getUserIntegral() {

        System.out.println(userIntegralService.getUserIntegral(5));

    }
}