package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.binding.Course;
import com.example.repo.CourseRepository;


@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseRepository courserepo;

	public String upsert(Course course) {
		courserepo.save(course);
		return "success";
	}
	
	public Course getByid(Integer cid) {
		Optional<Course> findById = courserepo.findById(cid);
		if(findById.isPresent())
			return findById.get();
		else
		return null;
	}

	public List<Course> getAllCourse() {
		 return courserepo.findAll();
			 
	}

	public String DeleteById(Integer cid) {
		if(courserepo.existsById(cid)) {
			courserepo.deleteById(cid);
			return "Delete Success...........";
		}
		else {
	    return "No Record Found..........";
		}
	}	
}
