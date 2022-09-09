package com.bw.movie.dao;

import com.bw.movie.rpc.vo.RegionVo;

import java.util.List;

/**
 * @Author: lzy
 * @Description:
 * @Date: Create in 8:58 2019/7/11
 */
public interface RegionMapper {
    /**
     * 2.0 查询区域列表
     *
     * @return
     */
    List<RegionVo> findRegionList();

}
