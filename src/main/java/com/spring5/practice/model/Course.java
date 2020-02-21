package com.spring5.practice.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tbl_course")
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private long courseId;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "course_code")
    private String courseCode;
    @Column(name = "is_active")
    private Boolean active = true;

    public Course() {
        super();
    }

    public Course(long courseId, String courseName) {
        super();
        this.courseId = courseId;
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Course [courseId=" + courseId + ", courseName=" + courseName + "]";
    }

}
