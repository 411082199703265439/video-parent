package com.qf.videos.controller;

import com.qf.videos.pojo.Course;
import com.qf.videos.pojo.QueryVo;
import com.qf.videos.pojo.Speaker;
import com.qf.videos.pojo.Video;
import com.qf.videos.service.CourseService;
import com.qf.videos.service.SpeakerService;
import com.qf.videos.service.VideoService;
import com.qf.videos.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/video")
public class VideoController{
    @Autowired
    private VideoService videoService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private SpeakerService speakerService;
    @RequestMapping("/list")
    public String list(QueryVo queryVo, Model model){
        model.addAttribute("queryVo", queryVo);
        Page<Video> page = videoService.selectVideoByQueryVo(queryVo);
        model.addAttribute("page", page);
        List<Course> courseList = courseService.selectAll();
        model.addAttribute("courseList", courseList);
        List<Speaker> speakerList = speakerService.selectAll();
        model.addAttribute("speakerList", speakerList);
        return "/behind/videoList";
    }
    @RequestMapping("/showVideo")
    public String showVideo(String videoId, String subjectName, Model model){
        Video video = videoService.selectVideoById(videoId);
        Course course = courseService.selectCourseById(video.getCourseId().toString());
        model.addAttribute("subjectName",subjectName);
        model.addAttribute("video",video);
        model.addAttribute(course);
        return "/before/section";
    }
    @RequestMapping("/updatePlayNum")
    @ResponseBody
    public String updatePlayNum(Video video){
        video.setPlayNum(video.getPlayNum()+1);
        videoService.updateVideo(video);
        return "success";
    }
    @RequestMapping("/delBatchVideos")
    public String delBatchVideos(String[] ids){
        videoService.deleteById(ids);
        return "redirect:list";
    }

    @RequestMapping("/videoDel")
    @ResponseBody
    public String videoDel(String id){
        String [] ids = new String [1];
        ids[0]=id;
        if (videoService.deleteById(ids)){
            return "success";
        }
        else {
            return "failed";
        }
    }
    @RequestMapping("/edit")
    public String edit(String id, Model model){
        Video video = videoService.selectVideoById(id);
        model.addAttribute("video",video);
        List<Course> courseList = courseService.selectAll();
        model.addAttribute("courseList", courseList);
        List<Speaker> speakerList = speakerService.selectAll();
        model.addAttribute("speakerList", speakerList);

        return "/behind/addVideo";
    }
    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Video video) {
        videoService.updateVideo(video);
        return "redirect:list";
    }
    @RequestMapping("/addVideo")
    public String addVideo(Model model) {
        List<Course> courseList = courseService.selectAll();
        model.addAttribute("courseList", courseList);
        List<Speaker> speakerList = speakerService.selectAll();
        model.addAttribute("speakerList", speakerList);
        return "/behind/addVideo";
    }
}
