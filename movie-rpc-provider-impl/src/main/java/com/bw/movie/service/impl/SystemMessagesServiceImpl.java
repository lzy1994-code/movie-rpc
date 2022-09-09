package com.bw.movie.service.impl;

import com.bw.movie.cache.RedisPool;
import com.bw.movie.cache.RedisUtil;
import com.bw.movie.dao.SystemMessagesMapper;
import com.bw.movie.rpc.pojo.SystemMessages;
import com.bw.movie.service.SystemMessagesService;
import com.bw.movie.utils.RedisConstant;
import com.bw.movie.utils.Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: movie-rpc
 * @description: 推送消息service实现类
 * @author: Lzy
 * @create: 2018-08-10 10:28
 **/
@Service("systemMessagesService")
public class SystemMessagesServiceImpl implements SystemMessagesService {

    @Resource
    private SystemMessagesMapper systemMessagesMapper;

    @Override
    public List<SystemMessages> findAllSysMsgs(int userId, int page, int count) {
        return systemMessagesMapper.findAllSysMsgs(userId, Util.getPageIndex(page, count), count);
    }

    @Override
    public boolean addSysMsgs(int userId, String title, String content) {
        SystemMessages systemMessage = new SystemMessages();
        systemMessage.setContent(content);
        systemMessage.setTitle(title);
        systemMessage.setUserId(userId);
        boolean boo = systemMessagesMapper.addSysMsgs(systemMessage);
        if (boo) {
            //获取redis连接池
            RedisPool redisPool = RedisUtil.getRedisPool(RedisConstant.POOL_NAME);
            String key = RedisConstant.SYS_NO_MSG;
            //field 的值进行加一操作
            redisPool.hincrby(key, String.valueOf(userId), 1);
        }
        return boo;
    }

    @Override
    public boolean sysMsgsStatusChange(int userId, int id) {
        boolean boo = false;
        //判断当前信息的读取状态
        int num = systemMessagesMapper.sysMsgStatus(id);
        if (num == 1) {
            boo = true;
        } else {
            boo = systemMessagesMapper.sysMsgsStatusChange(id);
            if (boo) {
                //获取redis连接池
                RedisPool redisPool = RedisUtil.getRedisPool(RedisConstant.POOL_NAME);
                String key = RedisConstant.SYS_NO_MSG;
                //field 的值进行减一操作
                redisPool.hincrby(key, String.valueOf(userId), -1);
            }
        }
        return boo;
    }

    @Override
    public int findSysMsgsStatus(int userId) {
        int num = 0;
        //获取redis连接池
        RedisPool redisPool = RedisUtil.getRedisPool(RedisConstant.POOL_NAME);
        String key = RedisConstant.SYS_NO_MSG;
        //key 中给定域 field 的值
        String temp = redisPool.hget(key, String.valueOf(userId));
        if (temp == null) {
            num = systemMessagesMapper.findSysMsgsStatus(userId);
        } else {
            num = Integer.parseInt(temp);
        }
        return num;
    }

    @Override
    public boolean deleteSysMsgs(int id) {
        return systemMessagesMapper.deleteSysMsgs(id);
    }
}
