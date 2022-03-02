package com.uni.cosmos.service;

import com.uni.cosmos.dao.CourseDao;
import com.uni.cosmos.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;

    @Override
    public List<Course> getCourses(){
        return this.courseDao.findAll();
    }
}
