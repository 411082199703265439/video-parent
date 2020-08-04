package com.qf.videos.service;

import com.qf.videos.pojo.QueryVo;
import com.qf.videos.pojo.Speaker;
import com.qf.videos.utils.Page;

import java.util.List;

public interface SpeakerService {
    List<Speaker> selectAll();

    Page<Speaker> selectSpeakerByQueryVo(QueryVo queryVo);

    Boolean deleteById(String id);

    Speaker selectSpeakerById(String id);

    Boolean saveOrUpdate(Speaker speaker);
}
