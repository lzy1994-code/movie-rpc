package com.bw.movie.service;

import com.bw.base.BaseTest;
import org.junit.Ignore;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by xyj on 2018/7/21.
 */
@Ignore
public class UserSignServiceTest extends BaseTest {

    @Resource
    private UserSignService userSignService;

    @Test
    public void addUserSign() {

        System.out.println(userSignService.addUserSign(5));

    }

    @Test
    public void getUserDaySign() {

        System.out.println(userSignService.getUserDaySign(5));

    }
}