package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.binding.Course;
import com.example.service.CourseService;


@RestController
public class CourseRestController {
	
	@Autowired
	CourseService courseservice;
	
	@PostMapping("/course")
	public ResponseEntity<String> createCourse(@RequestBody Course course) {
		
		System.out.println(course);
		String status = courseservice.upsert(course);
		return new ResponseEntity<>(status,HttpStatus.CREATED);
	}
	
	@GetMapping("/course/{cid}")
	public ResponseEntity<Course> getCourse(@PathVariable Integer cid) {
		Course course = courseservice.getByid(cid);
		return new ResponseEntity<>(course,HttpStatus.OK);	
		}
	@GetMapping("/courses")
	public ResponseEntity<List<Course>> getAllCourses(){
		List<Course> allCourse = courseservice.getAllCourse();
		return new ResponseEntity<>(allCourse,HttpStatus.OK);		
	}
	
	@PutMapping("/course")
	public ResponseEntity<String> updateCourse(@RequestBody Course course) {
		String status = courseservice.upsert(course);
		return new ResponseEntity<>(status,HttpStatus.OK);	
		}

		
	@DeleteMapping("/course/{cid}")
	public ResponseEntity<String> DeleteCourse(@PathVariable Integer cid) {
		String status = courseservice.DeleteById(cid);
		return new ResponseEntity<>(status,HttpStatus.OK);	
		}

}
