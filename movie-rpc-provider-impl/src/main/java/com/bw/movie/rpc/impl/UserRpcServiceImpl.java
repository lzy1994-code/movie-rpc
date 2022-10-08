package com.bw.movie.rpc.impl;

import com.bw.movie.cache.RedisPool;
import com.bw.movie.cache.RedisUtil;
import com.bw.movie.rpc.api.UserRpcService;
import com.bw.movie.rpc.pojo.*;
import com.bw.movie.rpc.vo.*;
import com.bw.movie.service.*;
import com.bw.movie.utils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xyj on 2018/7/18.
 */
@Service("userRpcService")
public class UserRpcServiceImpl implements UserRpcService {

    private Logger logger = LoggerFactory.getLogger(UserRpcService.class);

    @Resource
    private UserService userService;

    @Resource
    private UserExtendService userExtendService;

    @Resource
    private MovieService movieService;

    @Resource
    private CinemaService cinemaService;

    @Resource
    private UserIntegralService userIntegralService;

    @Resource
    private UserSignService userSignService;

    @Resource
    private UserBuyTicketRecordService userBuyTicketRecordService;

    @Resource
    private UserBindingLoginService userBindingLoginService;

    @Resource
    private UserMessagePushService userMessagePushService;

    @Resource
    private SystemMessagesService systemMessagesService;

    @Resource
    private MovieComingSoonReserveService movieComingSoonReserveService;

    @Resource
    private UserBuyTicketDetailService userBuyTicketDetailService;

    @Resource
    private UserFollowMovieService userFollowMovieService;

    @Resource
    private UserFollowCinemaService userFollowCinemaService;

    @Override
    public int register(UserRegisterVo userRegisterVo) {
        try {

            int num = userService.checkPhone(userRegisterVo.getPhone());
            if (num > 0) {
                return 2;
            }

            num = userService.checkNickName(userRegisterVo.getNickName());
            if (num > 0) {
                return 3;
            }

            User user = (User) CopyBean.getBean(new User(), userRegisterVo);
            num = userService.register(user);
            if (num == 0) {
                return 0;
            }

            UserExtend userExtend = (UserExtend) CopyBean.getBean(new UserExtend(), userRegisterVo);
            userExtend.setUserId(user.getId());
            userExtendService.addUserExtend(userExtend);

            //添加系统消息
            systemMessagesService.addSysMsgs(user.getId(), Constants.SYS_MSG_TITLE, Constants.USER_REGISTER_CONTENT);

            return 1;
        } catch (Exception e) {
            logger.error("register", e);
            return 0;
        }
    }

    @Override
    public int sendOutEmailCode(String email) {
        //给用户邮箱中发送验证码
        try {
            Thread sendEmail = new Thread(new SendEmailThread2(email));
            sendEmail.start();
        } catch (Exception e) {
            logger.error("sendOutEmailCode", e);
            return 0;
        }
        return 1;
    }

    @Override
    public int register(String nickName, String email, String pwd, String code) {

        int i = Util.checkCode(email, code);
        if (i == 1) {
            int num = userService.checkEmail(email);
            if (num > 0) {
                return 2;
            }

            num = userService.checkNickName(nickName);
            if (num > 0) {
                return 5;
            }
            User user = new User();
            user.setEmail(email);
            user.setNickName(nickName);
            user.setPwd(pwd);
            userService.register(user);
            //添加系统消息
            systemMessagesService.addSysMsgs(user.getId(), Constants.SYS_MSG_TITLE, Constants.USER_REGISTER_CONTENT);

        }
        return i;
    }

    @Override
    public UserLoginVo loginV2(String email, String pwd) {
        User user = userService.loginV2(email, pwd);
        if (user == null) {
            return null;
        }
        return cacheLoginInfo(user);
    }

    @Override
    public int checkCode(String email, String code) {
        return Util.checkCode(email, code);
    }

    @Override
    public List<UserReserveVo> findUserReserve(int userId) {
        return movieComingSoonReserveService.findUserReserve(userId);
    }

    @Override
    public List<UserBuyTicketRecordVo> findUserBuyTicketRecord(int userId, int page, int count, int status) {
        return userBuyTicketRecordService.findUserBuyTicketRecord(userId, page, count, status);
    }

    @Override
    public UserBuyTicketRecord findBuyTicketRecordByOrderId(int userId, String orderId) {
        return userBuyTicketRecordService.findBuyTicketRecordByOrderId(orderId);
    }

    @Override
    public List<UserSeenMovieRecordVo> findSeenMovie(int userId) {
        return userBuyTicketDetailService.findSeenMovie(userId);
    }

    @Override
    public List<UserBuyTicketRecord> findMyMovieTicket(int userId) {
        return userBuyTicketDetailService.findMyMovieTicket(userId);
    }

    @Override
    public UserBuyTicketDetail findExchangeCode(int userId, int id) {
        return userBuyTicketDetailService.findExchangeCode(userId, id);
    }

    @Override
    public int getTicket(String orderId) {
        return userBuyTicketDetailService.getTicket(orderId);
    }

    @Override
    public List<UserFollowMovieVo> findUserFollowMovieList(int userId, int page, int count) {
        return userFollowMovieService.findFollowMovieList(userId, page, count);
    }

    @Override
    public List<UserFollowCinemaVo> findUserFollowCinemaList(int userId, int page, int count) {
        return userFollowCinemaService.findFollowCinemaList(userId, page, count);
    }

    @Override
    public int updateUserPhone(int userId, String phone) {
        return userService.updateUserPhone(userId, phone);
    }

    @Override
    public int updateUserBirthday(int userId, String birthday) {
        return userService.updateUserBirthday(userId, birthday);
    }

    @Override
    public List<MyMovieCommentVo> findMyMovieCommentList(int userId, int page, int count) {
        return movieService.findMyMovieCommentList(userId, page, count);
    }

    @Override
    public List<MyCinemaCommentVo> findMyCinemaCommentList(int userId, String longitude, String latitude, int page, int count) {
        return cinemaService.findMyCinemaCommentList(userId, longitude, latitude, page, count);
    }

    @Override
    public MySeenMovieCommentVo findSeenMovieComment(int userId, int recordId) {
        return userBuyTicketDetailService.findSeenMovieComment(userId, recordId);
    }


    @Override
    public UserLoginVo login(String phone, String pwd) {
        User user = userService.login(phone, pwd);
        if (user == null) {
            return null;
        }

        return cacheLoginInfo(user);
    }

    @Override
    public UserInfoVo findUserHome(int userId) {

        try {
            UserInfoVo result = new UserInfoVo();

            User user = userService.findUserByUserId(userId);
            result = (UserInfoVo) CopyBean.getBean(result, user);

            int userIntegral = userIntegralService.getUserIntegral(userId);
            result.setIntegral(userIntegral);

            List<MovieListVo> movieList = movieService.findMoviePageList(userId, 1, 3);
            List<CinemasVo> cinemaList = cinemaService.findCinemaPageList(userId, 1, 3);

            result.setCinemasList(cinemaList);
            result.setMovieList(movieList);

            int num = userSignService.getUserDaySign(userId);
            if (num > 0) {
                result.setUserSignStatus(2);
            } else {
                result.setUserSignStatus(1);
            }

            return result;
        } catch (Exception e) {
            logger.error("findUserHome：", e);
            return null;
        }
    }

    @Override
    public int modifyUserInfo(User user) {
        return userService.updateUser(user);
    }

    @Override
    public int userSign(int userId) {
        try {
            int num = userSignService.getUserDaySign(userId);
            if (num > 0) {
                //已经签到
                return 2;
            }
            userSignService.addUserSign(userId);
            userIntegralService.addIntegral(userId, MovieConstants.USER_SIGN_AMOUNT);
            return 1;
        } catch (Exception e) {
            logger.error("userSign：", e);
            return 0;
        }
    }

    @Override
    public int updateUserHeadPic(int userId, String headPic) {
        return userService.updateUserHeadPic(userId, headPic);
    }

    @Override
    public int updateUserPwd(int userId, String newPwd, String oldPwd) {
        int num = userService.updateUserPwd(userId, newPwd, oldPwd);
      /*  if (num > 0) {
            //给用户推送出票成功的通知
          //  MqUtil.sendMsg(Constants.MQ_ANDROID_QUEUES, userId, Constants.SYS_MSG_TITLE, Constants.UPDATE_PWD_CONTENT);
        }*/
        systemMessagesService.addSysMsgs(userId, Constants.SYS_MSG_TITLE, Constants.UPDATE_PWD_CONTENT);
        return num;
    }

    @Override
    public User getUserInfoByUserId(int userId) {
        return userService.findUserByUserId(userId);
    }

    @Override
    public List<UserBuyTicketRecord> findUserBuyTicketRecordList(int userId, int page, int count, int status) {
        return userBuyTicketRecordService.findUserBuyTicketRecordList(userId, page, count, status);
    }

  /*  @Override
    public UserLoginVo wxBindingLogin(String code) {
        //根据code获取微信用户的openid
        WxLoginVo wxLogin = weChatRpcService.getOpenId(code, ProductConstants.PRODUCT_MOVIE);
        if (wxLogin == null) {
            logger.info("获取openId失败");
            return null;
        }

        //根据openId查询用户是否之前用微信登陆过
        UserBindingLogin userBindingInfo = userBindingLoginService.findUserBindingByOpenId(wxLogin.getOpenId());

        //如果用户用微信登陆过,则查询到用户信息并返回给用户
        if (userBindingInfo != null) {
            return login(userBindingInfo.getUserId());
        }

        //如果没用微信登陆过,则获取用户微信个人信息,并帮用户注册,返回用户登陆信息
        wxLogin = weChatRpcService.getWxUserInfo(wxLogin.getOpenId(), wxLogin.getToken(), ProductConstants.PRODUCT_MOVIE);
        if (wxLogin == null) {
            logger.info("wxBindingLogin登陆失败");
            return null;
        }

        //注册微信用户信息
        User user = new User();
        user.setNickName(wxLogin.getNickName() + "_" + Util.createNonceStr(3));
        user.setHeadPic(wxLogin.getHeadPic());
        user.setSex(wxLogin.getSex());
        user.setPwd(EncryptUtil.encrypt("123456"));
        userService.register(user);
        logger.info("微信用户绑定注册成功,userId={}", user.getId());

        //添加三方登陆信息关联
        UserBindingLogin userBindingLogin = new UserBindingLogin();
        userBindingLogin.setUserId(user.getId());
        userBindingLogin.setUnionId(wxLogin.getUnionId());
        userBindingLogin.setOpenId(wxLogin.getOpenId());
        userBindingLogin.setType(UserBindingLogin.TYPE_WECHAT);
        userBindingLoginService.saveUserBindingLogin(userBindingLogin);

        //登陆
        return login(user.getId());
    }

    @Override
    public int bindWeChat(int userId, String code) {
        //根据用户ID查询是否绑定
        UserBindingLogin userBinding = userBindingLoginService.findUserBindingByUserId(userId);
        if (userBinding != null) {
            return 2;
        }

        //根据code获取微信用户的openid
        WxLoginVo wxLogin = weChatRpcService.getOpenId(code, ProductConstants.PRODUCT_MOVIE);
        if (wxLogin == null) {
            logger.info("bindWeChat 绑定微信失败");
            return 0;
        }

        userBinding = userBindingLoginService.findUserBindingByOpenId(wxLogin.getOpenId());
        if (userBinding != null) {
            return 2;
        }

        userBinding = new UserBindingLogin();
        userBinding.setOpenId(wxLogin.getOpenId());

        wxLogin = weChatRpcService.getWxUserInfo(wxLogin.getOpenId(), wxLogin.getToken(), ProductConstants.PRODUCT_MOVIE);
        if (wxLogin == null) {
            logger.info("bindWeChat 绑定微信失败");
            return 0;
        }
        userBinding.setType(UserBindingLogin.TYPE_WECHAT);
        userBinding.setUnionId(wxLogin.getUnionId());
        userBinding.setUserId(userId);

        return userBindingLoginService.saveUserBindingLogin(userBinding);
    }

    @Override
    public int whetherToBindWeChat(int userId) {
        //根据用户ID查询是否绑定
        UserBindingLogin userBinding = userBindingLoginService.findUserBindingByUserId(userId);
        if (userBinding != null) {
            return 1;
        }
        return 2;
    }*/

    private UserLoginVo login(int userId) {
        User user = userService.login(userId);
        if (user == null) {
            return null;
        }

        return cacheLoginInfo(user);
    }

    private UserLoginVo cacheLoginInfo(User user) {
        UserLoginVo result = new UserLoginVo();
        result.setUserInfo(user);
        result.setUserId(user.getId());
        String uid = String.valueOf(user.getId());
        String sessionId = System.currentTimeMillis() + uid;
        result.setSessionId(sessionId);

        RedisPool redisPool = RedisUtil.getRedisPool(RedisConstant.POOL_NAME);
        String key = String.format(RedisConstant.USER_SESSION_KEY, uid);
        redisPool.setAndExpire(key, sessionId, 604800);

        return result;
    }


}
