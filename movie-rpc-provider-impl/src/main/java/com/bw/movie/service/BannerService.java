package com.bw.movie.service;

import com.bw.movie.rpc.vo.BannerVo;

import java.util.List;

/**
 * @Author: lzy
 * @Description:
 * @Date: Create in 9:23 2019/7/8
 */
public interface BannerService {

    List<BannerVo> bannerShow();
}
