package com.bw.movie.service.impl;

import com.bw.movie.dao.CinemaCommentMapper;
import com.bw.movie.dao.CinemasMapper;
import com.bw.movie.dao.UserFollowCinemaMapper;
import com.bw.movie.rpc.pojo.Cinemas;
import com.bw.movie.rpc.vo.CinemasVo;
import com.bw.movie.rpc.vo.MyCinemaCommentVo;
import com.bw.movie.service.CinemaService;
import com.bw.movie.utils.BaiDuMapUtil;
import com.bw.movie.utils.Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xyj on 2018/7/18.
 */
@Service("cinemaService")
public class CinemaServiceImpl implements CinemaService {

    @Resource
    private CinemasMapper cinemasMapper;

    @Resource
    private UserFollowCinemaMapper userFollowCinemaMapper;

    @Resource
    private CinemaCommentMapper cinemaCommentMapper;

    @Override
    public List<CinemasVo> findCinemaListByUserId(int userId) {
        return cinemasMapper.findCinemaListByUserId(userId);
    }

    @Override
    public List<CinemasVo> findRecommendCinemas(int userId, int page, int count) {

        List<Integer> followCinemaIdList = null;

        //若用户登陆,则查询用户已关注的影院
        if (userId > 0) {
            //查询已关注影院ID集合
            followCinemaIdList = userFollowCinemaMapper.findFollowCinemaIdList(userId);
        }

        List<CinemasVo> recommendCinemas = cinemasMapper.findRecommendCinemas(Util.getPageIndex(page, count), count);
        disNearByCinemas(null, null, followCinemaIdList, recommendCinemas);

        return recommendCinemas;
    }

    @Override
    public List<CinemasVo> findNearbyCinemas(int userId, String longitude, String latitude, int page, int count) {
        List<Integer> followCinemaIdList = null;

        //若用户登陆,则查询用户已关注的影院
        if (userId > 0) {
            //查询已关注影院ID集合
            followCinemaIdList = userFollowCinemaMapper.findFollowCinemaIdList(userId);
        }
        List<CinemasVo> nearbyCinemas = cinemasMapper.findNearbyCinemaList();
        if (null != latitude && !latitude.equals("") && null != longitude && !longitude.equals("")) {
            disNearByCinemas(longitude, latitude, followCinemaIdList, nearbyCinemas);
            if (nearbyCinemas.isEmpty()) {
                nearbyCinemas = cinemasMapper.findRecommendCinemas(Util.getPageIndex(page, count), count);
                disNearByCinemas(longitude, latitude, followCinemaIdList, nearbyCinemas);
            }
            sortCinemas(page, count, nearbyCinemas);
        } else {
            nearbyCinemas = cinemasMapper.findRecommendCinemas(Util.getPageIndex(page, count), count);
            disNearByCinemas(longitude, latitude, followCinemaIdList, nearbyCinemas);
        }
        return nearbyCinemas;
    }

    private void sortCinemas(int page, int count, List<CinemasVo> nearbyCinemas) {
        //排序
        Collections.sort(nearbyCinemas, new Comparator<CinemasVo>() {
            @Override
            public int compare(CinemasVo o1, CinemasVo o2) {
                if (o1.getDistance() > o2.getDistance()) {
                    return 1;
                }
                if (o1.getDistance() == o2.getDistance()) {
                    return 0;
                }
                return -1;
            }
        });

        int number = page * count;
        if (number > nearbyCinemas.size()) {
            number = nearbyCinemas.size();
        }
        int fromIndex = Util.getPageIndex(page, count);
        if (fromIndex > nearbyCinemas.size()) {
            fromIndex = nearbyCinemas.size();
        }
        nearbyCinemas = nearbyCinemas.subList(fromIndex, number);
    }

    private void disNearByCinemas(String longitude, String latitude, List<Integer> followCinemaIdList, List<CinemasVo> nearbyCinemas) {
        for (CinemasVo temp : nearbyCinemas) {
            if (null != latitude && !latitude.equals("") && null != longitude && !longitude.equals("")) {
                int dis = BaiDuMapUtil.getDistance(latitude, longitude, temp.getLatitude(), temp.getLongitude());
                temp.setDistance(dis);
            }
            temp.setLatitude(null);
            temp.setLongitude(null);
            temp.setCommentTotal(cinemaCommentMapper.commentTotal(temp.getId()));
            if (followCinemaIdList != null && followCinemaIdList.contains(temp.getId())) {
                temp.setFollowCinema(1);
            } else {
                temp.setFollowCinema(2);
            }
        }
    }

    @Override
    public CinemasVo findCinemaInfo(int userId, int cinemaId) {
        CinemasVo cinemaInfo = cinemasMapper.findCinemaInfo(cinemaId);
        if (cinemaInfo == null) {
            return null;
        }
        if (userId <= 0) {
            cinemaInfo.setFollowCinema(2);
        } else {
            int num = userFollowCinemaMapper.findFollowCinema(userId, cinemaId);
            if (num > 0) {
                cinemaInfo.setFollowCinema(1);
            } else {
                cinemaInfo.setFollowCinema(2);
            }
        }
        return cinemaInfo;
    }

    @Override
    public List<CinemasVo> findAllCinemas(int page, int count, String cinemaName) {
        return cinemasMapper.findAllCinemas(Util.getPageIndex(page, count), count, cinemaName);
    }

    @Override
    public List<CinemasVo> findCinemaPageList(int userId, int page, int count) {
        return cinemasMapper.findCinemaPageList(Util.getPageIndex(page, count), count, userId);
    }

    @Override
    public int followCinema(int userId, int cinemaId) {
        int num = userFollowCinemaMapper.findFollowCinema(userId, cinemaId);
        if (num > 0) {
            return 2;
        }
        return userFollowCinemaMapper.followCinema(userId, cinemaId);
    }

    @Override
    public int cancelFollowCinema(int userId, int cinemaId) {
        return userFollowCinemaMapper.cancelFollowCinema(userId, cinemaId);
    }

    @Override
    public List<CinemasVo> findCinemasByIds(List<Integer> list) {
        return cinemasMapper.findCinemasByIds(list);
    }

    @Override
    public CinemasVo findCinemaById(int cinemaId) {
        return cinemasMapper.findCinemaInfo(cinemaId);
    }

    @Override
    public Cinemas findCinemasByName(String name) {
        return cinemasMapper.findCinemasByName(name);
    }

    @Override
    public List<Cinemas> findCinemaByRegion(int regionId) {
        return cinemasMapper.findCinemaByRegion(regionId);
    }

    @Override
    public List<MyCinemaCommentVo> findMyCinemaCommentList(int userId, String longitude, String latitude, int page, int count) {
        List<MyCinemaCommentVo> myCinemaCommentList = cinemasMapper.findMyCinemaCommentList(userId, Util.getPageIndex(page, count), count);

        for (MyCinemaCommentVo myCinemaComment : myCinemaCommentList) {

            if (null != latitude && !latitude.equals("") && null != longitude && !longitude.equals("")) {
                int distance = BaiDuMapUtil.getDistance(latitude, longitude, myCinemaComment.getLatitude(), myCinemaComment.getLongitude());
                myCinemaComment.setDistance(distance);
            }
            myCinemaComment.setLongitude(null);
            myCinemaComment.setLatitude(null);
        }
        return myCinemaCommentList;

    }


}
