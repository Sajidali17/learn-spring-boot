package com.springboot.learnspringboot.courses.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.learnspringboot.courses.bean.Course;
import com.springboot.learnspringboot.courses.repository.CourseRepository;

@RestController
public class CourseController {
	
	@Autowired
	private CourseRepository repository;
	
	@GetMapping("/courses")
	public List<Course> getAllCourses(){
		
		return repository.findAll();
//		return Arrays.asList(new Course(1, "Learn microservices","in28minutes"),
//				new Course(2, "Learn spring boot","in28minutes"));
	}
	
	@GetMapping("/courses/{id}")
	public Course getCourse1(@PathVariable long id){
		Optional<Course> course = repository.findById(id);
		if(course.isEmpty()) {
			throw new RuntimeException("Course not found: "+id);
		}
		return course.get();
	}
	
	@GetMapping("/courses/2")
	public List<Course> getCourse2(){
		return Arrays.asList(new Course(22, "Learn microservices + spring in java","in28minutes"));
	}
	
	//post 
	@PostMapping("/courses")
	public void createCourse(@RequestBody Course course) {
		repository.save(course);
	}
	
	//put
	@PutMapping("/courses/{id}")
	public void updateCourse(@PathVariable long id, @RequestBody Course course) {
		repository.save(course);
	}
	
	//delete
	@DeleteMapping("/courses/{id}")
	public void deleteCourse(@PathVariable long id) {
		repository.deleteById(id);
	}
}
