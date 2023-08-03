package com.example.service;

import java.util.List;

import com.example.binding.Course;

public interface CourseService {
	
	// This is to test git update

	public String upsert(Course course);
	public Course getByid(Integer cid);
    public List<Course> getAllCourse();
    public String DeleteById(Integer cid);
	

}
