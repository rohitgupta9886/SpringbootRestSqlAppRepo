package com.example.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.binding.Course;

public interface CourseRepository extends JpaRepository<Course, Serializable> {

}
