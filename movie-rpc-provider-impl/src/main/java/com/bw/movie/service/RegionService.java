package com.bw.movie.service;

import com.bw.movie.rpc.vo.RegionVo;

import java.util.List;

/**
 * @Author: lzy
 * @Description:
 * @Date: Create in 9:02 2019/7/11
 */
public interface RegionService {
    /**
     * 2.0 查询区域列表
     *
     * @return
     */
    List<RegionVo> findRegionList();
}
