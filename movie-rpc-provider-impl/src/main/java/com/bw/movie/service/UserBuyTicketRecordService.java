package com.bw.movie.service;

import com.bw.movie.rpc.pojo.UserBuyTicketRecord;
import com.bw.movie.rpc.vo.UserBuyTicketRecordVo;

import java.util.List;

/**
 * Created by xyj on 2018/7/27.
 */
public interface UserBuyTicketRecordService {

    int addUserBuyTicketRecord(UserBuyTicketRecord userBuyTicketRecord);

    /**
     * 用户购票记录查询列表
     *
     * @param userId
     * @param page
     * @param count
     * @return
     */
    List<UserBuyTicketRecord> findUserBuyTicketRecordList(int userId, int page, int count, int status);

    /**
     * 支付成功后修改状态
     *
     * @param orderId
     * @param status
     * @return
     */
    int modifyStatus(String orderId, int status);

    /**
     * 2.0 查看订单详情
     *
     * @param orderId
     * @return
     */
    UserBuyTicketRecord findBuyTicketRecordByOrderId(String orderId);

    /**
     * 2.0 购票记录
     */
    List<UserBuyTicketRecordVo> findUserBuyTicketRecord(int userId, int page, int count, int status);


}
