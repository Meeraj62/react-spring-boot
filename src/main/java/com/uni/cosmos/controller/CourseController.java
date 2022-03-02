package com.uni.cosmos.controller;

import com.uni.cosmos.model.ResponseHandler;
import com.uni.cosmos.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    // Getting all the courses
    @GetMapping("")
    public ResponseEntity<Object> getCourses(){
        return ResponseHandler.generateResponse("Course Fetched Successfully", HttpStatus.OK, courseService.getCourses());
    }
}
