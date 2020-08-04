package com.qf.videos.controller;

import com.qf.videos.pojo.QueryVo;
import com.qf.videos.pojo.Speaker;
import com.qf.videos.service.SpeakerService;
import com.qf.videos.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/speaker")
public class SpeakerController {
    @Autowired
    private SpeakerService speakerService;
    @RequestMapping("/showSpeakerList")
    public String showSpeakerList(QueryVo queryVo, Model model){
        model.addAttribute("queryVo",queryVo);
        Page<Speaker> page = speakerService.selectSpeakerByQueryVo(queryVo);
        model.addAttribute("page",page);
        return "/behind/speakerList";
    }
    @RequestMapping("/speakerDel")
    @ResponseBody
    public String speakerDel(String id){
        if (speakerService.deleteById(id)){
            return "success";
        }else {
            return "failed";
        }
    }
    @RequestMapping("/addSpeaker")
    public String addSpeaker() {

        return "/behind/addSpeaker";
    }
    @RequestMapping("/edit")
    public String edit(String id, Model model){
        Speaker speaker = speakerService.selectSpeakerById(id);
        model.addAttribute("speaker", speaker);
        return "/behind/addSpeaker";
    }
    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Speaker speaker){
        speakerService.saveOrUpdate(speaker);
        return "redirect:showSpeakerList";
    }
}
