package com.bw.movie.rpc.api;

import com.bw.movie.rpc.pojo.AppVersion;
import com.bw.movie.rpc.pojo.SystemMessages;
import com.bw.movie.rpc.vo.BannerVo;
import com.bw.movie.rpc.vo.RegionVo;

import java.util.List;

/**
 * Created by xyj on 2018/7/18.
 */
public interface ToolRpcService {

    /**
     * 记录用户反馈
     *
     * @param userId
     * @param content
     * @return
     */
    int recordFeedBack(int userId, String content);

    /**
     * 查询最新AK
     *
     * @return
     */
    AppVersion findNewAk();

    /**
     * 检查登陆状态
     *
     * @param userId
     * @param sessionId
     * @return
     */
    boolean checkUserLoginStatus(int userId, String sessionId);

    /**
     * 查询系统消息列表
     *
     * @param userId
     * @param page
     * @param count
     * @return
     */
    List<SystemMessages> findAllSysMsgs(int userId, int page, int count);

    /**
     * 系统消息读取状态修改
     *
     * @param id
     * @param userId
     * @return
     */
    boolean sysMsgsStatusChange(int userId, int id);

    /**
     * 查看系统消息读取状态（用于判断是否有未读消息）
     *
     * @param userId
     * @return
     */
    int findSysMsgsStatus(int userId);

    /**
     * 上传用户推送token
     *
     * @param userId
     * @param token
     * @param os
     * @return
     */
    int uploadPushToken(int userId, String token, int os);


    /**
     * 2.0 banner展示
     */
    List<BannerVo> bannerShow();


    /**
     * 2.0 查询区域列表
     *
     * @return
     */
    List<RegionVo> findRegionList();

    /**
     * 2.0 排期时间列表
     *
     * @return
     */
    List<String> dateList();


}
