package com.bw.movie.service.impl;

import com.bw.movie.dao.BannerMapper;
import com.bw.movie.rpc.vo.BannerVo;
import com.bw.movie.service.BannerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: lzy
 * @Description:
 * @Date: Create in 9:24 2019/7/8
 */
@Service("bannerService")
public class BannerServiceImpl implements BannerService {

    @Resource
    private BannerMapper bannerMapper;

    @Override
    public List<BannerVo> bannerShow() {
        return bannerMapper.bannerShow();
    }
}
