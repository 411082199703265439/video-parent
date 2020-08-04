package com.qf.videos.service;

import com.qf.videos.pojo.QueryVo;
import com.qf.videos.pojo.Video;
import com.qf.videos.utils.Page;

public interface VideoService {
    Video selectVideoById(String id);

    Boolean updateVideo(Video video);

    Page<Video> selectVideoByQueryVo(QueryVo queryVo);



    Boolean deleteById(String[] ids);

}
