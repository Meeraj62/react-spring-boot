package com.uni.cosmos.service;

import com.uni.cosmos.model.Course;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CourseService {
    public List<Course> getCourses();
}
