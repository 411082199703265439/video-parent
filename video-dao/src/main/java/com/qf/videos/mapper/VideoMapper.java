package com.qf.videos.mapper;

import com.qf.videos.pojo.QueryVo;
import com.qf.videos.pojo.Video;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoMapper {
    Video selectVideoById(String id);

    Boolean updateVideo(Video video);

    List<Video> selectVideoByQueryVo(QueryVo queryVo);

    Integer selectCountByQueryVo(QueryVo queryVo);

    Boolean deleteById(String id);

    Boolean insertVideo(Video video);
}
