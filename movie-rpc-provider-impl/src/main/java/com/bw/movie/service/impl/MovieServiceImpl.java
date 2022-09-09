package com.bw.movie.service.impl;

import com.bw.movie.dao.MoviePosterMapper;
import com.bw.movie.dao.MovieShortFilmMapper;
import com.bw.movie.dao.MoviesMapper;
import com.bw.movie.dao.UserFollowMovieMapper;
import com.bw.movie.rpc.pojo.Movies;
import com.bw.movie.rpc.vo.*;
import com.bw.movie.service.MovieActorService;
import com.bw.movie.service.MovieCommentService;
import com.bw.movie.service.MovieDirectorService;
import com.bw.movie.service.MovieService;
import com.bw.movie.utils.CopyBean;
import com.bw.movie.utils.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by xyj on 2018/7/18.
 */
@Service("movieService")
public class MovieServiceImpl implements MovieService {

    private Logger logger = LoggerFactory.getLogger(MovieService.class);

    @Resource
    private MoviesMapper moviesMapper;

    @Resource
    private MoviePosterMapper moviePosterMapper;

    @Resource
    private MovieShortFilmMapper movieShortFilmMapper;

    @Resource
    private UserFollowMovieMapper userFollowMovieMapper;

    @Resource
    private MovieDirectorService movieDirectorService;

    @Resource
    private MovieActorService movieActorService;

    @Resource
    private MovieCommentService movieCommentService;

    @Override
    public List<MovieListVo> findMovieListByUserId(int userId) {
        return moviesMapper.findMovieListByUserId(userId);
    }

    @Override
    public List<MovieVo> findHotMovieList(int userId, int page, int count) {
        List<MovieVo> hotMovieList = moviesMapper.findHotMovieList(Util.getPageIndex(page, count), count);
        for (MovieVo movieVo : hotMovieList) {
            Random rd = new Random();
            movieVo.setType(rd.nextInt(2) + 1);
            int followMovie = userFollowMovieMapper.findFollowMovie(userId, movieVo.getId());
            if (followMovie > 0) {
                movieVo.setFollowMovie(1);
            } else {
                movieVo.setFollowMovie(2);
            }
        }
        return hotMovieList;
    }

    @Override
    public List<MovieVo> findReleaseMovieList(int userId, int page, int count) {
        List<MovieVo> releaseMovieList = moviesMapper.findReleaseMovieList(Util.getPageIndex(page, count), count);
        for (MovieVo movieVo : releaseMovieList) {
            Random rd = new Random();
            movieVo.setType(rd.nextInt(2) + 1);
            int followMovie = userFollowMovieMapper.findFollowMovie(userId, movieVo.getId());
            if (followMovie > 0) {
                movieVo.setFollowMovie(1);
            } else {
                movieVo.setFollowMovie(2);
            }

        }
        return releaseMovieList;
    }

    @Override
    public List<MovieVo> findComingSoonMovieList(int userId, int page, int count) {
        List<MovieVo> comingSoonMovieList = moviesMapper.findComingSoonMovieList(Util.getPageIndex(page, count), count);
        for (MovieVo movieVo : comingSoonMovieList) {
            Random rd = new Random();
            movieVo.setType(rd.nextInt(2) + 1);
            int followMovie = userFollowMovieMapper.findFollowMovie(userId, movieVo.getId());
            if (followMovie > 0) {
                movieVo.setFollowMovie(1);
            } else {
                movieVo.setFollowMovie(2);
            }
        }
        return comingSoonMovieList;
    }

    @Override
    public Movies findMoviesById(int movieId) {
        return moviesMapper.findMoviesById(movieId);
    }

    @Override
    public MovieVo findMoviesDetail(int userId, int movieId) {

        try {
            //查询电影信息
            Movies movies = findMoviesById(movieId);
            MovieVo result = (MovieVo) CopyBean.getBean(new MovieVo(), movies);

            //查看电影类型
            List<String> movieType = moviesMapper.findMovieType(movieId);
            String types = Util.processMovieType(movieType);
            result.setMovieTypes(types);

            //查询电影海报
            List<String> listPoster = moviePosterMapper.findMoviePosters(movieId);
            if (listPoster != null) {
                result.setPosterList(listPoster);
            }

            //查询电影预告片
            List<ShortFilmVo> listShortFilm = movieShortFilmMapper.findMovieShortFilms(movieId);

            if (listPoster != null && listShortFilm != null && listShortFilm.size() > 0) {
                int[] randoms = Util.generateRandomNumber(listShortFilm.size());
                int index = 0;
                for (ShortFilmVo shortFilmVo : listShortFilm) {
                    shortFilmVo.setImageUrl(listPoster.get(randoms[index]));
                    index++;
                }
                result.setShortFilmList(listShortFilm);
            }

            //查看用户是否关注电影
            if (userId <= 0) {
                result.setFollowMovie(2);
            } else {
                int count = userFollowMovieMapper.findFollowMovie(userId, movieId);
                if (count > 0) {
                    result.setFollowMovie(1);
                } else {
                    result.setFollowMovie(2);
                }
            }

            return result;
        } catch (Exception e) {
            logger.error("findMoviesDetail：={}", e);
            return null;
        }
    }

    @Override
    public List<MovieListVo> findMoviePageList(int userId, int page, int count) {
        return moviesMapper.findMoviePageList(Util.getPageIndex(page, count), count, userId);
    }

    @Override
    public int followMovie(int userId, int movieId) {
        int count = userFollowMovieMapper.findFollowMovie(userId, movieId);
        if (count > 0) {
            return 2;
        }
        return userFollowMovieMapper.followMovie(userId, movieId);
    }

    @Override
    public int cancelFollowMovie(int userId, int movieId) {
        return userFollowMovieMapper.cancelFollowMovie(userId, movieId);
    }

    @Override
    public List<MovieListVo> findMoviesByIds(List<Integer> list) {
        return moviesMapper.findMoviesByIds(list);
    }

    @Override
    public List<MovieListVo> findSoonMovieByCinemaId(int cinemaId) {
        return moviesMapper.findSoonMovieByCinemaId(cinemaId);
    }

    @Override
    public List<MovieInfoVo> findHotMovieInfoList(int page, int count) {
        List<MovieInfoVo> hotMovieInfoList = moviesMapper.findHotMovieInfoList(Util.getPageIndex(page, count), count);
        if (hotMovieInfoList.isEmpty()) {
            return new ArrayList<>();
        }
        return hotMovieInfoList;
    }

    @Override
    public List<MovieInfoVo> findReleaseMovieInfoList(int page, int count) {
        List<MovieInfoVo> releaseMovieInfoList = moviesMapper.findReleaseMovieInfoList(Util.getPageIndex(page, count), count);
        if (releaseMovieInfoList.isEmpty()) {
            return new ArrayList<>();
        }
        return releaseMovieInfoList;
    }

    @Override
    public List<ComingSoonMovieVo> findComingSoonMovieInfoList(int page, int count) {
        return moviesMapper.findComingSoonMovieInfoList(Util.getPageIndex(page, count), count);
    }

    @Override
    public MovieDetailVo findMoviesDetailById(int userId, int movieId) {
        //查询电影信息
        MovieDetailVo movieDetail = moviesMapper.findMovieDetailById(movieId);
        //查询电影类型
        List<String> movieType = moviesMapper.findMovieType(movieId);
        String types = Util.processMovieType(movieType);
        movieDetail.setMovieType(types);
        //查询电影海报
        List<String> listPoster = moviePosterMapper.findMoviePosters(movieId);
        if (listPoster != null) {
            movieDetail.setPosterList(listPoster);
        }

        List<ShortFilmVo> listShortFilm = movieShortFilmMapper.findMovieShortFilms(movieId);

        if (listShortFilm != null && listShortFilm.size() > 0) {
            int[] randoms = Util.generateRandomNumber(listShortFilm.size());
            int index = 0;
            for (ShortFilmVo shortFilmVo : listShortFilm) {
                shortFilmVo.setImageUrl(listPoster.get(randoms[index]));
                index++;
            }
            movieDetail.setShortFilmList(listShortFilm);
        }
        if (userId <= 0) {
            movieDetail.setWhetherFollow(2);
        } else {
            int count = userFollowMovieMapper.findFollowMovie(userId, movieId);
            if (count > 0) {
                movieDetail.setWhetherFollow(1);
            } else {
                movieDetail.setWhetherFollow(2);
            }
        }
        //导演信息
        movieDetail.setMovieDirector(movieDirectorService.findMovieDirector(movieId));
        //演员信息
        movieDetail.setMovieActor(movieActorService.findMovieActor(movieId));
        //评论数
        movieDetail.setCommentNum(movieCommentService.movieCommentTotal(movieId));

        return movieDetail;
    }

    @Override
    public List<CinemaVo> findCinemasInfo(int movieId, int regionId, int page, int count) {
        List<CinemaVo> cinemasInfo = moviesMapper.findCinemasInfo(movieId, regionId, page, count);
        if (cinemasInfo.isEmpty()) {
            return new ArrayList<>();
        }
        return cinemasInfo;
    }

    @Override
    public List<CinemaVo> findCinemasInfoByDate(int movieId, int page, int count) {
        List<CinemaVo> cinemasInfo = moviesMapper.findCinemasInfoByDate(movieId, page, count);
        if (cinemasInfo.isEmpty()) {
            return new ArrayList<>();
        }
        return cinemasInfo;
    }

    @Override
    public List<CinemaVo> findCinemasInfoByPrice(int movieId, int page, int count) {
        List<CinemaVo> cinemasInfo = moviesMapper.findCinemasInfoByPrice(movieId, page, count);
        if (cinemasInfo.isEmpty()) {
            return new ArrayList<>();
        }
        return cinemasInfo;
    }

    @Override
    public List<MovieInfoVo> findMovieByKeyword(String keyword, int page, int count) {
        List<MovieInfoVo> movieByKeyword = moviesMapper.findMovieByKeyword(keyword, Util.getPageIndex(page, count), count);
        if (movieByKeyword.isEmpty()) {
            return new ArrayList<>();
        }
        return movieByKeyword;
    }

    @Override
    public List<MyMovieCommentVo> findMyMovieCommentList(int userId, int page, int count) {
        List<MyMovieCommentVo> myMovieCommentList = moviesMapper.findMyMovieCommentList(userId, Util.getPageIndex(page, count), count);
        if (myMovieCommentList.isEmpty()) {
            return new ArrayList<>();
        }
        return myMovieCommentList;
    }


}
