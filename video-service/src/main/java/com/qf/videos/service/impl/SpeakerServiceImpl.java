package com.qf.videos.service.impl;

import com.qf.videos.mapper.SpeakerMapper;
import com.qf.videos.pojo.QueryVo;
import com.qf.videos.pojo.Speaker;
import com.qf.videos.service.SpeakerService;
import com.qf.videos.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SpeakerServiceImpl implements SpeakerService {
    @Autowired
    private SpeakerMapper speakerMapper;

    @Override
    public List<Speaker> selectAll() {
        return speakerMapper.selectAll();
    }

    @Override
    public Page<Speaker> selectSpeakerByQueryVo(QueryVo queryVo) {
        queryVo.setStart((queryVo.getPage()-1)*queryVo.getSize());

        List<Speaker> speakerList = speakerMapper.selectSpeakerByQueryVo(queryVo);
        Integer total = speakerMapper.selectCountByQueryVo(queryVo);

        Page<Speaker> page = new Page<>();
        page.setPage(queryVo.getPage());
        page.setSize(queryVo.getSize());
        page.setRows(speakerList);
        page.setTotal(total);
        return page;
    }

    @Override
    public Boolean deleteById(String id) {
        return speakerMapper.deleteById(id);
    }

    @Override
    public Speaker selectSpeakerById(String id) {
        return speakerMapper.selectSpeakerById(id);
    }

    @Override
    public Boolean saveOrUpdate(Speaker speaker) {
        if (speaker.getId()==null){
            return speakerMapper.insertSpeaker(speaker);
        }else {
            return speakerMapper.updateSpeaker(speaker);
        }

    }

}
