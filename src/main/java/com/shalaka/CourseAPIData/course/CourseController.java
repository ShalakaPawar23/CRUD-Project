package com.shalaka.CourseAPIData.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    //create an instance of service
    @Autowired
    public CourseService courseService;
    @RequestMapping(method=RequestMethod.GET, value="/courses")
    public List<Course> getAllCourses(){

        return courseService.getAllCourses();
    }

    // returns single topic based on id
    @RequestMapping("/courses/{entered_id}")
    public Course getCourse(@PathVariable("entered_id") String id){

        return courseService.getCourseById(id);
    }

    @PostMapping(value = "/courses")
    public void addCourse(@RequestBody Course course){

        courseService.addCourse(course);
    }
    @PutMapping(value = "/courses/{id}")
    public void updateCourse(@PathVariable String id,@RequestBody Course course){

        courseService.updateCourse(id, course);
    }

    @DeleteMapping(value = "/courses/{id}")
    public void deleteCourse(@PathVariable String id){

        courseService.deleteCourse(id);
    }
}
