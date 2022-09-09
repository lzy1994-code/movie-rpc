package com.bw.movie.service.impl;

import com.bw.movie.dao.RegionMapper;
import com.bw.movie.rpc.vo.RegionVo;
import com.bw.movie.service.RegionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: lzy
 * @Description:
 * @Date: Create in 9:02 2019/7/11
 */
@Service("regionService")
public class RegionServiceImpl implements RegionService {

    @Resource
    private RegionMapper regionMapper;

    @Override
    public List<RegionVo> findRegionList() {
        return regionMapper.findRegionList();
    }
}
