package com.bw.movie.service.impl;

import com.bw.movie.dao.AppVersionMapper;
import com.bw.movie.rpc.pojo.AppVersion;
import com.bw.movie.service.AppVersionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by xyj on 2018/7/18.
 */
@Service("appVersionService")
public class AppVersionServiceImpl implements AppVersionService {

    @Resource
    private AppVersionMapper appVersionMapper;

    @Override
    public AppVersion findNewAk() {
        return appVersionMapper.findNewAk();
    }
}
