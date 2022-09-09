package com.bw.movie.dao;

import com.bw.movie.rpc.vo.BannerVo;

import java.util.List;

/**
 * @Author: lzy
 * @Description:
 * @Date: Create in 9:14 2019/7/8
 */

public interface BannerMapper {

    List<BannerVo> bannerShow();

}
