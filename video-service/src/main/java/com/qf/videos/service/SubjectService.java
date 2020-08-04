package com.qf.videos.service;

import com.qf.videos.pojo.Subject;

import java.util.List;

public interface SubjectService {
    List<Subject> selectAll();

    Subject selectSubjectById(String id);
}
