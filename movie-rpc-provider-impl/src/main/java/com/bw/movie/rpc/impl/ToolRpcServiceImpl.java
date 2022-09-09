package com.bw.movie.rpc.impl;

import com.bw.movie.cache.RedisPool;
import com.bw.movie.cache.RedisUtil;
import com.bw.movie.rpc.api.ToolRpcService;
import com.bw.movie.rpc.pojo.AppVersion;
import com.bw.movie.rpc.pojo.SystemMessages;
import com.bw.movie.rpc.pojo.UserMessagePush;
import com.bw.movie.rpc.vo.BannerVo;
import com.bw.movie.rpc.vo.RegionVo;
import com.bw.movie.service.*;
import com.bw.movie.utils.RedisConstant;
import com.bw.movie.utils.Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xyj on 2018/7/18.
 */
@Service("toolRpcService")
public class ToolRpcServiceImpl implements ToolRpcService {

    @Resource
    private FeedBackService feedBackService;

    @Resource
    private AppVersionService appVersionService;

    @Resource
    private SystemMessagesService systemMessagesService;

    @Resource
    private UserMessagePushService userMessagePushService;

    @Resource
    private BannerService bannerService;

    @Resource
    private RegionService regionService;

    @Override
    public int recordFeedBack(int userId, String content) {
        return feedBackService.recordFeedBack(userId, content);
    }

    @Override
    public AppVersion findNewAk() {
        return appVersionService.findNewAk();
    }

    @Override
    public boolean checkUserLoginStatus(int userId, String sessionId) {
        RedisPool redisPool = RedisUtil.getRedisPool(RedisConstant.POOL_NAME);
        String key = String.format(RedisConstant.USER_SESSION_KEY, userId);
        String temp = redisPool.get(key);
        if (temp == null) {
            return false;
        }

        if (!sessionId.equals(temp)) {
            return false;
        }

        return true;
    }

    @Override
    public List<SystemMessages> findAllSysMsgs(int userId, int page, int count) {
        return systemMessagesService.findAllSysMsgs(userId, page, count);
    }

    @Override
    public boolean sysMsgsStatusChange(int userId, int id) {
        return systemMessagesService.sysMsgsStatusChange(userId, id);
    }

    @Override
    public int findSysMsgsStatus(int userId) {
        return systemMessagesService.findSysMsgsStatus(userId);
    }

    @Override
    public int uploadPushToken(int userId, String token, int os) {

        int num = userMessagePushService.findUserMessagePush(userId, token);
        if (num > 0) {
            return 1;
        }

        userMessagePushService.deleteUserMessagePush(userId);

        UserMessagePush userMessagePush = new UserMessagePush();
        userMessagePush.setUserId(userId);
        userMessagePush.setToken(token);
        userMessagePush.setOs(os);
        return userMessagePushService.saveUserMessagePush(userMessagePush);
    }

    @Override
    public List<BannerVo> bannerShow() {
        return bannerService.bannerShow();
    }

    @Override
    public List<RegionVo> findRegionList() {
        return regionService.findRegionList();
    }

    @Override
    public List<String> dateList() {
        return Util.getAfterDate7(7);
    }

}
