package com.qf.videos.service.impl;

import com.qf.videos.mapper.VideoMapper;
import com.qf.videos.pojo.QueryVo;
import com.qf.videos.pojo.Video;
import com.qf.videos.service.VideoService;
import com.qf.videos.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private   VideoMapper videoMapper;
    @Override
    public Video selectVideoById(String id) {
        return videoMapper.selectVideoById(id);
    }

    @Override
    public Boolean updateVideo(Video video) {
        if (video.getId() != null){
            return videoMapper.updateVideo(video);
        }
        else {
            return videoMapper.insertVideo(video);
        }
    }

    @Override
    public Page<Video>selectVideoByQueryVo(QueryVo queryVo) {
        queryVo.setStart((queryVo.getPage()-1)*queryVo.getSize());
        List<Video> videoList = videoMapper.selectVideoByQueryVo(queryVo);
        Integer count = videoMapper.selectCountByQueryVo(queryVo);

        Page<Video> page = new Page<>();

        page.setPage(queryVo.getPage());
        page.setRows(videoList);
        page.setTotal(count);
        page.setSize(queryVo.getSize());
        return page;
    }



    @Override
    public Boolean deleteById(String[] ids) {
        Boolean flag = true;
        for (String id : ids) {
            if (!videoMapper.deleteById(id)) {
                flag = false;
            }
        }
        return flag;
    }


}
