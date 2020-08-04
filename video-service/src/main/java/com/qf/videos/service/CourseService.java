package com.qf.videos.service;

import com.qf.videos.pojo.Course;

import java.util.List;

public interface CourseService {
    Course selectCourseById(String id);

    List<Course> selectAll();
}
