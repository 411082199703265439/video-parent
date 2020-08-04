package com.qf.videos.mapper;

import com.qf.videos.pojo.QueryVo;
import com.qf.videos.pojo.Speaker;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpeakerMapper {
    List<Speaker> selectAll();

    List<Speaker> selectSpeakerByQueryVo(QueryVo queryVo);

    Integer selectCountByQueryVo(QueryVo queryVo);

    Boolean deleteById(String id);

    Speaker selectSpeakerById(String id);

    Boolean insertSpeaker(Speaker speaker);

    Boolean updateSpeaker(Speaker speaker);
}
