package com.bw.movie.dao;

import com.bw.movie.rpc.pojo.Cinemas;
import com.bw.movie.rpc.vo.CinemasVo;
import com.bw.movie.rpc.vo.MyCinemaCommentVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CinemasMapper {

    List<CinemasVo> findFollowCinemas(int userId);

    List<CinemasVo> findRecommendCinemas(@Param("index") int index, @Param("count") int count);

    CinemasVo findCinemaInfo(int cinemaId);

    List<CinemasVo> findAllCinemas(@Param("index") int index, @Param("count") int count, @Param("cinemaName") String cinemaName);

    List<CinemasVo> findCinemaListByUserId(int userId);

    List<CinemasVo> findCinemaPageList(@Param("index") int index, @Param("count") int count, @Param("userId") int userId);

    List<CinemasVo> findCinemasByIds(List<Integer> list);

    List<CinemasVo> findNearbyCinemaList();

    Cinemas findCinemasByName(String name);

    /**
     * 2.0 根据区域查询影院
     *
     * @param regionId
     * @return
     */
    List<Cinemas> findCinemaByRegion(int regionId);

    /**
     * 2.0 查询我的影院评论
     *
     * @param userId
     * @param index
     * @param count
     * @return
     */
    List<MyCinemaCommentVo> findMyCinemaCommentList(@Param("userId") int userId, @Param("index") int index, @Param("count") int count);

}