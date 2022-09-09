package com.bw.movie.service;

import com.bw.movie.rpc.pojo.SystemMessages;

import java.util.List;

/**
 * @program: movie-rpc
 * @description: 推送消息service
 * @author: Lzy
 * @create: 2018-08-10 10:25
 **/
public interface SystemMessagesService {
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
     * 添加系统消息
     *
     * @param userId
     * @param title
     * @param content
     * @return
     */
    boolean addSysMsgs(int userId, String title, String content);

    /**
     * 系统消息读取状态修改
     *
     * @param id
     * @param userId
     * @return
     */
    boolean sysMsgsStatusChange(int userId, int id);


    /**
     * 查看系统消息未读消息数
     *
     * @param userId
     * @return
     */
    int findSysMsgsStatus(int userId);


    /**
     * 删除系统消息
     *
     * @param id
     * @return
     */
    boolean deleteSysMsgs(int id);
}
