package com.bw.movie.service.impl;

import com.bw.movie.dao.UserBuyTicketRecordMapper;
import com.bw.movie.rpc.pojo.UserBuyTicketRecord;
import com.bw.movie.rpc.vo.UserBuyTicketRecordVo;
import com.bw.movie.service.UserBuyTicketRecordService;
import com.bw.movie.utils.Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xyj on 2018/7/27.
 */
@Service("userBuyTicketRecordService")
public class UserBuyTicketRecordServiceImpl implements UserBuyTicketRecordService {

    @Resource
    private UserBuyTicketRecordMapper userBuyTicketRecordMapper;

    @Override
    public int addUserBuyTicketRecord(UserBuyTicketRecord userBuyTicketRecord) {
        return userBuyTicketRecordMapper.addUserBuyTicketRecord(userBuyTicketRecord);
    }

    @Override
    public List<UserBuyTicketRecord> findUserBuyTicketRecordList(int userId, int page, int count, int status) {
        return userBuyTicketRecordMapper.findUserBuyTicketRecordList(userId, Util.getPageIndex(page, count), count, status);
    }


    @Override
    public int modifyStatus(String orderId, int status) {
        return userBuyTicketRecordMapper.modifyStatus(orderId, status);
    }

    @Override
    public UserBuyTicketRecord findBuyTicketRecordByOrderId(String orderId) {
        return userBuyTicketRecordMapper.findBuyTicketRecordByOrderId(orderId);
    }

    @Override
    public List<UserBuyTicketRecordVo> findUserBuyTicketRecord(int userId, int page, int count, int status) {
        return userBuyTicketRecordMapper.findUserBuyTicketRecord(userId, Util.getPageIndex(page, count), count, status);
    }
}
