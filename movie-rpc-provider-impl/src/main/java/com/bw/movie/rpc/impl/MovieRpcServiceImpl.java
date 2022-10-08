package com.bw.movie.rpc.impl;

import com.bw.movie.rpc.api.MovieRpcService;
import com.bw.movie.rpc.pojo.*;
import com.bw.movie.rpc.vo.*;
import com.bw.movie.service.*;
import com.bw.movie.utils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by xyj on 2018/7/16.
 */
@Service("movieRpcService")
public class MovieRpcServiceImpl implements MovieRpcService {

    private Logger logger = LoggerFactory.getLogger(MovieRpcService.class);

    @Resource
    private MovieService movieService;
    @Resource
    private MovieCommentService movieCommentService;
    @Resource
    private MovieCommentReplyService movieCommentReplyService;
    @Resource
    private MovieCommentGreatService commentGreatService;

    @Resource
    private MovieScheduleService movieScheduleService;

    @Resource
    private CinemaService cinemaService;

    @Resource
    private UserBuyTicketRecordService userBuyTicketRecordService;

    @Resource
    private UserService userService;

    @Resource
    private SystemMessagesService systemMessagesService;

    @Resource
    private MovieComingSoonReserveService movieComingSoonReserveService;

    @Resource
    private CinemaHallSeatService cinemaHallSeatService;

    @Resource
    private UserBuyTicketDetailService userBuyTicketDetailService;

    @Resource
    private CinemaHallService cinemaHallService;


    @Override
    public List<MovieVo> findHotMovieList(int userId, int page, int count) {
        return movieService.findHotMovieList(userId, page, count);
    }

    @Override
    public List<MovieVo> findReleaseMovieList(int userId, int page, int count) {
        return movieService.findReleaseMovieList(userId, page, count);
    }

    @Override
    public List<MovieVo> findComingSoonMovieList(int userId, int page, int count) {
        return movieService.findComingSoonMovieList(userId, page, count);
    }

    @Override
    public Movies findMoviesById(int movieId) {
        return movieService.findMoviesById(movieId);
    }

    @Override
    public MovieVo findMoviesDetail(int userId, int movieId) {
        return movieService.findMoviesDetail(userId, movieId);
    }

    @Override
    public List<MovieListVo> findMoviePageList(int userId, int page, int count) {
        return movieService.findMoviePageList(userId, page, count);
    }

    @Override
    public int followMovie(int userId, int movieId) {
        return movieService.followMovie(userId, movieId);
    }

    @Override
    public int cancelFollowMovie(int userId, int movieId) {
        return movieService.cancelFollowMovie(userId, movieId);
    }

    @Override
    public List<MovieListVo> findMovieListByCinemaId(int cinemaId) {
        List<Integer> moviesByCinemaId = movieScheduleService.findMoviesByCinemaId(cinemaId);

        if (moviesByCinemaId == null || moviesByCinemaId.size() == 0) {
            return null;
        }

        return movieService.findMoviesByIds(moviesByCinemaId);
    }

    @Override
    public List<CinemasVo> findCinemasListByMovieId(int movieId) {

        List<Integer> cinemaIds = movieScheduleService.findCinemasByMovieId(movieId);

        if (cinemaIds == null || cinemaIds.size() == 0) {
            return null;
        }
        return cinemaService.findCinemasByIds(cinemaIds);
    }

    @Override
    public List<MovieScheduleVo> findMovieScheduleList(int movieId, int cinemasId) {
        return movieScheduleService.findMovieScheduleList(movieId, cinemasId);
    }

  /*  @Override
    public String buyMovieTicket(int userId, int scheduleId, int amount, String sign) {
        //查询排期场次信息
        MovieSchedule movieSchedule = movieScheduleService.findMovieScheduleById(scheduleId);
        if (movieSchedule == null) {
            logger.error("buyMovieTicket={}", "movieSchedule为空");
            return "1";
        }

        //查询电影票价
        Movies movies = movieService.findMoviesById(movieSchedule.getMovieId());
        if (movies == null) {
            logger.error("buyMovieTicket={}", "movies为空");
            return null;
        }

        //查询影院信息
        CinemasVo cinema = cinemaService.findCinemaById(movieSchedule.getCinemasId());
        if (cinema == null) {
            logger.error("buyMovieTicket={}", "cinema未找到");
            return null;
        }

        //计算订单总价
        double totalPrice = CalculateUtil.multiply(movies.getFare(), amount, 2);

        //创建订单
        String orderId = moviePayRpcService.createOrder(1, totalPrice);
        if (orderId == null) {
            logger.error("buyMovieTicket,创建订单失败");
            return "2";
        }

        //增加用户购票记录
        UserBuyTicketRecord userBuyTicketRecord = new UserBuyTicketRecord();
        userBuyTicketRecord.setUserId(userId);
        userBuyTicketRecord.setAmount(amount);
        userBuyTicketRecord.setBeginTime(movieSchedule.getBeginTime());
        userBuyTicketRecord.setCinemaName(cinema.getName());
        userBuyTicketRecord.setEndTime(movieSchedule.getEndTime());
        userBuyTicketRecord.setMovieName(movies.getName());
        userBuyTicketRecord.setOrderId(orderId);
        userBuyTicketRecord.setPrice(movies.getFare());
        userBuyTicketRecord.setScreeningHall(movieSchedule.getScreeningHall());
        userBuyTicketRecord.setStatus(UserBuyTicketRecord.TYPE_NO_PAY);
        userBuyTicketRecordService.addUserBuyTicketRecord(userBuyTicketRecord);

        //增加系统消息
        systemMessagesService.addSysMsgs(userId, Constants.SYS_MSG_TITLE, Constants.BUY_MOVIETICKET_CONTENT);

        //给用户推送出票成功的通知
        MqUtil.sendMsg(Constants.MQ_ANDROID_QUEUES, userId, Constants.SYS_MSG_TITLE, Constants.BUY_MOVIETICKET_CONTENT);

        return orderId;
    }

    @Override
    public String pay(String orderId, int payType, String ip) {
        UserBuyTicketRecord buyTicketRecord = userBuyTicketRecordService.findBuyTicketRecordByOrderId(orderId);
        if (buyTicketRecord == null) {
            logger.error("pay={}", "订单未找到");
            return "1001";
        }
        Cinemas cinemas = cinemaService.findCinemasByName(buyTicketRecord.getCinemaName());
        if (cinemas == null) {
            logger.error("pay={}", "影院未找到");
            return null;
        }
        CinemaHall cinemaHall = cinemaHallService.findHallId(cinemas.getId(), buyTicketRecord.getScreeningHall());
        if (cinemaHall == null) {
            logger.error("pay={}", "座位信息未找到");
            return null;
        }
        String seat = buyTicketRecord.getSeat();
        String[] split = seat.split(",");
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            String[] str = s.split("-");
            int row = Integer.parseInt(str[0]);
            int seat1 = Integer.parseInt(str[1]);
            //修改座位状态
            updateSeatStatus(cinemaHall.getId(), row, seat1, 2);
        }
        String pay = moviePayRpcService.pay(orderId, payType, ip);
        return pay;
    }*/

    @Override
    public String ticketing(String orderId) {

        try {
            //查询未支付购票记录
            UserBuyTicketRecord buyTicketRecord = userBuyTicketRecordService.findBuyTicketRecordByOrderId(orderId);
            if (buyTicketRecord == null) {
                logger.error("ticketing,出票失败,原因buyTicketRecord为NULL");
                return null;
            }

            //查询用户信息
            User user = userService.findUserByUserId(buyTicketRecord.getUserId());
            if (user == null) {
                logger.error("ticketing,出票失败,原因user为NULL");
                return null;
            }
            //修改购票记录状态
            int num = userBuyTicketRecordService.modifyStatus(orderId, 2);
            if (num != 1) {
                logger.error("修改购票记录状态");
            }


            //给用户邮箱中发送电影票的二维码
            Thread sendEmail = new Thread(new SendEmailThread(buyTicketRecord.getAmount(), user.getEmail(), user.getNickName(), buyTicketRecord.getMovieName(), buyTicketRecord.getBeginTime(), buyTicketRecord.getEndTime()));
            sendEmail.start();

            //给用户推送出票成功的通知
            String content = String.format(Constants.EMAIL_CONTENT, buyTicketRecord.getMovieName(), buyTicketRecord.getBeginTime(), buyTicketRecord.getEndTime());
           // MqUtil.sendMsg(Constants.MQ_ANDROID_QUEUES, buyTicketRecord.getUserId(), Constants.PUSH_TICKETING_TITLE, content);

            logger.info("orderId={}出票成功", orderId);

            return "0000";
        } catch (Exception e) {
            logger.error("ticketing", e);
            return null;
        }
    }

    @Override
    public List<MovieCommentVo> findAllMovieComment(int userId, int movieId, int index, int count) {
        return movieCommentService.findAllMovieComment(userId, movieId, index, count);
    }


    @Override
    public int saveMovieComment(MovieComment movieComment) {
        return movieCommentService.saveMovieComment(movieComment);
    }


    @Override
    public List<MovieCommentReplyVo> findAllCommentReply(int commentId, int index, int count) {
        return movieCommentReplyService.findAllCommentReply(commentId, index, count);
    }


    @Override
    public boolean addCommentReply(MovieCommentReply movieCommentReply) {
        return movieCommentReplyService.addCommentReply(movieCommentReply);
    }

    @Override
    public int movieCommentTotal(int movieId) {
        return movieCommentService.movieCommentTotal(movieId);
    }

    @Override
    public MovieComment findCommentById(int movieId, int userId) {
        return movieCommentService.findCommentById(movieId, userId);
    }

    @Override
    public MovieCommentReply findCommentReplyById(int commentId, int userId) {
        return movieCommentReplyService.findCommentReplyById(commentId, userId);
    }


    @Override
    public int whetherMovieGreat(int commentId, int userId) {
        return commentGreatService.whetherMovieGreat(commentId, userId);
    }

    @Override
    public boolean saveMovieCommentGreat(MovieCommentGreat commentGreat) {
        return commentGreatService.saveMovieCommentGreat(commentGreat);
    }

    @Override
    public List<MovieListVo> findSoonMovieByCinemaId(int cinemaId) {
        return movieService.findSoonMovieByCinemaId(cinemaId);
    }

    @Override
    public List<MovieInfoVo> findHotMovieInfoList(int page, int count) {
        return movieService.findHotMovieInfoList(page, count);
    }

    @Override
    public List<MovieInfoVo> findReleaseMovieInfoList(int page, int count) {
        return movieService.findReleaseMovieInfoList(page, count);
    }

    @Override
    public List<ComingSoonMovieVo> findComingSoonMovieInfoList(int userId, int page, int count) {
        List<ComingSoonMovieVo> comingSoonMovieInfoList = movieService.findComingSoonMovieInfoList(page, count);
        if (comingSoonMovieInfoList.isEmpty()) {
            return new ArrayList<>();
        }
        //预约数
        for (ComingSoonMovieVo comingSoonMovieVo : comingSoonMovieInfoList) {
            comingSoonMovieVo.setWantSeeNum(movieComingSoonReserveService.reserveNum(comingSoonMovieVo.getMovieId()));
            if (userId >= 0) {
                comingSoonMovieVo.setWhetherReserve(movieComingSoonReserveService.whetherReserve(userId, comingSoonMovieVo.getMovieId()));
            }
        }
        return comingSoonMovieInfoList;
    }

    @Override
    public int reserve(int userId, int movieId) {
        return movieComingSoonReserveService.reserve(userId, movieId);
    }

    @Override
    public MovieDetailVo findMoviesDetailById(int userId, int movieId) {
        return movieService.findMoviesDetailById(userId, movieId);
    }

    @Override
    public List<MovieCommentVos> findAllMovieCommentById(int userId, int movieId, int page, int count) {
        return movieCommentService.findAllMovieCommentById(userId, movieId, page, count);
    }

    @Override
    public List<CinemaVo> findCinemasInfo(int movieId, int regionId, int page, int count) {
        return movieService.findCinemasInfo(movieId, regionId, page, count);
    }

    @Override
    public List<CinemaVo> findCinemasInfoByDate(int movieId, int page, int count) {
        return movieService.findCinemasInfoByDate(movieId, page, count);
    }

    @Override
    public List<CinemaVo> findCinemasInfoByPrice(int movieId, int page, int count) {
        return movieService.findCinemasInfoByPrice(movieId, page, count);
    }

    @Override
    public List<CinemaHallSeatVo> findSeatInfo(int hallId) {
        return cinemaHallSeatService.findSeatInfo(hallId);
    }

    @Override
    public int updateSeatStatus(int hallId, int row, int seat, int status) {
        return cinemaHallSeatService.updateSeatStatus(hallId, row, seat, status);
    }

    @Override
    public List<MovieInfoVo> findMovieByKeyword(String keyword, int page, int count) {
        return movieService.findMovieByKeyword(keyword, page, count);
    }

   /* @Override
    public String buyMovieTickets(int userId, int scheduleId, String seat, int amount) {
        //查询排期场次信息
        MovieSchedule movieSchedule = movieScheduleService.findMovieScheduleById(scheduleId);
        if (movieSchedule == null) {
            logger.error("buyMovieTicket={}", "movieSchedule为空");
            return "1";
        }
        //查询影厅信息
        CinemaHall cinemaHall = cinemaHallService.findCinemaHallById(movieSchedule.getHallId());
        if (cinemaHall == null) {
            logger.error("buyMovieTicket={}", "影厅为空");
            return null;
        }
        //查询电影票价
        Movies movies = movieService.findMoviesById(movieSchedule.getMovieId());
        if (movies == null) {
            logger.error("buyMovieTicket={}", "movies为空");
            return null;
        }

        //查询影院信息
        CinemasVo cinema = cinemaService.findCinemaById(movieSchedule.getCinemasId());
        if (cinema == null) {
            logger.error("buyMovieTicket={}", "cinema未找到");
            return null;
        }

        //计算订单总价
        double totalPrice = CalculateUtil.multiply(movies.getFare(), amount, 2);

        //创建订单
        String orderId = moviePayRpcService.createOrder(1, totalPrice);
        if (orderId == null) {
            logger.error("buyMovieTicket,创建订单失败");
            return "2";
        }

        //增加用户购票记录
        UserBuyTicketRecord userBuyTicketRecord = new UserBuyTicketRecord();
        userBuyTicketRecord.setUserId(userId);
        userBuyTicketRecord.setAmount(amount);
        userBuyTicketRecord.setBeginTime(movieSchedule.getBeginTime());
        userBuyTicketRecord.setCinemaName(cinema.getName());
        userBuyTicketRecord.setEndTime(movieSchedule.getEndTime());
        userBuyTicketRecord.setMovieName(movies.getName());
        userBuyTicketRecord.setOrderId(orderId);
        userBuyTicketRecord.setPrice(movies.getFare());
        userBuyTicketRecord.setScreeningHall(cinemaHall.getScreeningHall());
        userBuyTicketRecord.setStatus(UserBuyTicketRecord.TYPE_NO_PAY);
        userBuyTicketRecord.setSeat(seat);
        userBuyTicketRecordService.addUserBuyTicketRecord(userBuyTicketRecord);

        //增加系统消息
        systemMessagesService.addSysMsgs(userId, Constants.SYS_MSG_TITLE, Constants.BUY_MOVIETICKET_CONTENT);

        //给用户推送出票成功的通知
        MqUtil.sendMsg(Constants.MQ_ANDROID_QUEUES, userId, Constants.SYS_MSG_TITLE, Constants.BUY_MOVIETICKET_CONTENT);
        return orderId;

    }*/

    @Override
    public String outTicket(String orderId) throws Exception {

        try {
            logger.info("outTicket,orderId={}", orderId);
            //查询未支付购票记录
            UserBuyTicketRecord buyTicketRecord = userBuyTicketRecordService.findBuyTicketRecordByOrderId(orderId);
            if (buyTicketRecord == null) {
                logger.error("outTicket,出票失败,原因buyTicketRecord为NULL");
                return null;
            }

            //查询用户信息
            User user = userService.findUserByUserId(buyTicketRecord.getUserId());
            if (user == null) {
                logger.error("outTicket,出票失败,原因user为NULL");
                return null;
            }
            //修改购票记录状态
            int num = userBuyTicketRecordService.modifyStatus(orderId, 2);
            if (num != 1) {
                logger.error("修改购票记录状态");
            }
            String getTicket = ConfigInfo.getConfigInfo().getGetTicket();
            String content = getTicket + "?orderId=" + orderId;
            String uploadPath = String.format(ConfigInfo.getConfigInfo().getQRCodeUploadPath(), orderId);
            logger.info("outTicket:savePath={}", uploadPath);
            QRcodeUtil.createQRcode(content, 300, 300, uploadPath, "jpg");
            String savePath = String.format(ConfigInfo.getConfigInfo().getQRCodeAccessPath(), orderId);
            logger.info("outTicket:savePath={}", savePath);
            //添加兑换二维码
            UserBuyTicketDetail userBuyTicketDetail = new UserBuyTicketDetail();
            userBuyTicketDetail.setRecordId(buyTicketRecord.getId());
            userBuyTicketDetail.setCreateTime(new Date());
            userBuyTicketDetail.setExchangeCode(savePath);
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            Date date = sdf.parse(buyTicketRecord.getEndTime());
            userBuyTicketDetail.setExpiredTime(date);
            userBuyTicketDetail.setStatus(1);
            userBuyTicketDetailService.addUserBuyTicketDetail(userBuyTicketDetail);
            logger.info("outTicket={}出票成功", orderId);
            return "0000";
        } catch (Exception e) {
            logger.error("outTicket", e);
            return null;
        }
    }

    @Override
    public List<MovieCinemaScheduleVo> findMovieScheduleListV2(int movieId, int cinemasId) {
        List<MovieCinemaScheduleVo> movieScheduleList = movieScheduleService.findMovieScheduleListV2(movieId, cinemasId);
        if (movieScheduleList.isEmpty()) {
            return new ArrayList<>();
        }
        return movieScheduleList;
    }
}
