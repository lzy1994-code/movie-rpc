package com.bw.movie.rpc.api;

import com.bw.movie.rpc.pojo.User;
import com.bw.movie.rpc.pojo.UserBuyTicketDetail;
import com.bw.movie.rpc.pojo.UserBuyTicketRecord;
import com.bw.movie.rpc.vo.*;

import java.util.List;

/**
 * Created by xyj on 2018/7/18.
 */
public interface UserRpcService {


    /**
     * 注册
     *
     * @param userRegisterVo
     * @return
     */
    int register(UserRegisterVo userRegisterVo);


    /**
     * 登陆
     *
     * @param phone
     * @param pwd
     * @return
     */
    UserLoginVo login(String phone, String pwd);

    /**
     * 查看用户首页信息
     *
     * @param userId
     * @return
     */
    UserInfoVo findUserHome(int userId);

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    int modifyUserInfo(User user);

    /**
     * 用户签到
     *
     * @param userId
     * @return
     */
    int userSign(int userId);

    /**
     * 修改用户头像信息
     *
     * @param userId
     * @param headPic
     * @return
     */
    int updateUserHeadPic(int userId, String headPic);

    /**
     * 修改用户密码
     *
     * @param userId
     * @param newPwd
     * @param oldPwd
     * @return
     */
    int updateUserPwd(int userId, String newPwd, String oldPwd);

    /**
     * 根据用户ID查询用户信息
     *
     * @param userId
     * @return
     */
    User getUserInfoByUserId(int userId);

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
     * 微信登陆
     *
     * @param code
     * @return
     */
 //   UserLoginVo wxBindingLogin(String code);

    /**
     * 已注册账号绑定微信账号
     *
     * @param userId
     * @param code
     * @return
     */
 //   int bindWeChat(int userId, String code);

    /**
     * 是否绑定微信
     *
     * @param userId
     * @return
     */
   // int whetherToBindWeChat(int userId);

    /**
     * 2.0 发送邮箱验证码
     *
     * @param email
     */
    int sendOutEmailCode(String email);

    /**
     * 2.0 注册
     *
     * @param nickName
     * @param email
     * @param pwd
     * @param code
     * @return
     */
    int register(String nickName, String email, String pwd, String code);

    /**
     * 2.0 登陆
     *
     * @param email
     * @param pwd
     * @return
     */
    UserLoginVo loginV2(String email, String pwd);

    /**
     * 2.0 检验验证码
     *
     * @param email
     * @param code
     * @return
     */
    int checkCode(String email, String code);

    /**
     * 2.0 查询用户预约电影信息
     *
     * @param userId
     * @return
     */
    List<UserReserveVo> findUserReserve(int userId);

    /**
     * 2.0 购票记录
     *
     * @param userId
     * @param page
     * @param count
     * @param status
     * @return
     */
    List<UserBuyTicketRecordVo> findUserBuyTicketRecord(int userId, int page, int count, int status);

    /**
     * 2.0 查看订单详情
     *
     * @param userId
     * @param orderId
     * @return
     */
    UserBuyTicketRecord findBuyTicketRecordByOrderId(int userId, String orderId);


    /**
     * 2.0 查询看过的电影
     */
    List<UserSeenMovieRecordVo> findSeenMovie(int userId);

    /**
     * 2.0 我的电影票
     */
    List<UserBuyTicketRecord> findMyMovieTicket(int userId);

    /**
     * 2.0  查询取票码
     */
    UserBuyTicketDetail findExchangeCode(int userId, int id);

    /**
     * 2.0 取票
     *
     * @return
     */
    int getTicket(String orderId);

    /**
     * 查询用户关注电影列表
     *
     * @param userId
     * @param page
     * @param count
     * @return
     */
    List<UserFollowMovieVo> findUserFollowMovieList(int userId, int page, int count);

    /**
     * 查询用户关注影院列表
     *
     * @param userId
     * @param page
     * @param count
     * @return
     */
    List<UserFollowCinemaVo> findUserFollowCinemaList(int userId, int page, int count);


    /**
     * 修改用户手机号
     *
     * @param userId
     * @param phone
     * @return
     */
    int updateUserPhone(int userId, String phone);

    /**
     * 修改用户生日
     *
     * @param userId
     * @param birthday
     * @return
     */
    int updateUserBirthday(int userId, String birthday);

    /**
     * 2.0 查询我的电影评论
     *
     * @param userId
     * @param page
     * @param count
     * @return
     */
    List<MyMovieCommentVo> findMyMovieCommentList(int userId, int page, int count);

    /**
     * 2.0 查询我的影院评论
     *
     * @param userId
     * @param page
     * @param count
     * @return
     */
    List<MyCinemaCommentVo> findMyCinemaCommentList(int userId, String longitude, String latitude, int page, int count);


    /**
     * 2.0 查询用户看过的电影评论
     *
     * @param userId
     * @param recordId
     * @return
     */
    MySeenMovieCommentVo findSeenMovieComment(int userId, int recordId);


}
