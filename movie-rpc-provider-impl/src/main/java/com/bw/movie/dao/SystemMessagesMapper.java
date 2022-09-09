package com.bw.movie.dao;

import com.bw.movie.rpc.pojo.SystemMessages;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: movie-rpc
 * @description: 系统消息推送
 * @author: Lzy
 * @create: 2018-08-10 09:18
 **/
public interface SystemMessagesMapper {

    /**
     * 查询系统消息列表
     *
     * @param userId
     * @param index
     * @param count
     * @return
     */
    List<SystemMessages> findAllSysMsgs(@Param("userId") int userId, @Param("index") int index, @Param("count") int count);

    /**
     * 添加系统消息
     *
     * @param systemMessages
     * @return
     */
    boolean addSysMsgs(SystemMessages systemMessages);

    /**
     * 系统消息读取状态修改
     *
     * @param id
     * @return
     */
    boolean sysMsgsStatusChange(int id);

    /**
     * 查看系统消息未读消息数
     *
     * @param userId
     * @return
     */
    int findSysMsgsStatus(int userId);

    /**
     * 通过id查看系统消息读取状态
     *
     * @param id
     * @return
     */
    int sysMsgStatus(int id);

    /**
     * 删除系统消息
     *
     * @param id
     * @return
     */
    boolean deleteSysMsgs(int id);


}
