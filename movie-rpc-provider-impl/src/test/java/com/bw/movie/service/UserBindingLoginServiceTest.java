package com.bw.movie.service;

import com.bw.base.BaseTest;
import com.bw.movie.rpc.pojo.UserBindingLogin;
import org.junit.Ignore;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by xyj on 2018/8/10.
 */
@Ignore
public class UserBindingLoginServiceTest extends BaseTest {

    @Resource
    private UserBindingLoginService userBindingLoginService;

    @Test
    public void saveUserBindingLogin() {
        UserBindingLogin userBindingLogin = new UserBindingLogin();
        userBindingLogin.setOpenId("123");
        userBindingLogin.setUserId(1);
        userBindingLogin.setType(1);
        userBindingLogin.setUnionId("222");
        userBindingLoginService.saveUserBindingLogin(userBindingLogin);

    }

    @Test
    public void findUserBindingByOpenId() {

        System.out.println(userBindingLoginService.findUserBindingByOpenId("123"));

    }

    @Test
    public void findUserBindingByUserId() {
        System.out.println(userBindingLoginService.findUserBindingByUserId(1));
    }
}