package com.qf.videos.pojo;

import java.io.Serializable;

public class QueryVo implements Serializable {
    private String title;
    private String speakerId;
    private String courseId;

    // 当前页码数
    private Integer page = 1;
    // 数据库从哪一条数据开始查
    private Integer start;
    // 每页显示数据条数
    private Integer size = 10;

    @Override
    public String toString() {
        return "QueryVo{" +
                "title='" + title + '\'' +
                ", speakerId='" + speakerId + '\'' +
                ", courseId='" + courseId + '\'' +
                ", page=" + page +
                ", start=" + start +
                ", size=" + size +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSpeakerId() {
        return speakerId;
    }

    public void setSpeakerId(String speakerId) {
        this.speakerId = speakerId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
