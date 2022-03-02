package com.uni.cosmos.dao;

import com.uni.cosmos.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDao extends JpaRepository<Course,Long> {
}
