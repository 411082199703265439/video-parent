package com.qf.videos.service.impl;

import com.qf.videos.mapper.CourseMapper;
import com.qf.videos.pojo.Course;
import com.qf.videos.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;
    @Override
    public Course selectCourseById(String id) {
        return courseMapper.selectCourseById(id);
    }

    @Override
    public List<Course> selectAll() {
        return courseMapper.selectAll();
    }
}
