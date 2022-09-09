package com.bw.movie.dao;

import com.bw.movie.rpc.pojo.UserBuyTicketRecord;
import com.bw.movie.rpc.vo.UserBuyTicketRecordVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by xyj on 2018/7/27.
 */
public interface UserBuyTicketRecordMapper {
    /**
     * 添加购票记录
     *
     * @param userBuyTicketRecord
     * @return
     */
    int addUserBuyTicketRecord(UserBuyTicketRecord userBuyTicketRecord);

    /**
     * 用户购票记录查询列表
     *
     * @param userId
     * @param index
     * @param count
     * @return
     */
    List<UserBuyTicketRecord> findUserBuyTicketRecordList(@Param("userId") int userId, @Param("index") int index, @Param("count") int count, @Param("status") int status);

    int modifyStatus(@Param("orderId") String orderId, @Param("status") int status);

    UserBuyTicketRecord findBuyTicketRecordByOrderId(String orderId);

    /**
     * 2.0 购票记录
     */
    List<UserBuyTicketRecordVo> findUserBuyTicketRecord(@Param("userId") int userId, @Param("index") int index, @Param("count") int count, @Param("status") int status);


}
