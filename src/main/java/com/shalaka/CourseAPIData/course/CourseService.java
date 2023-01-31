package com.shalaka.CourseAPIData.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    private List<Course> courseList = new ArrayList<Course>(Arrays.asList(
            new Course("1", "Cpp", "Programming language"),
            new Course("2", "Dance", "Dancing style"),
            new Course("3", "Food", "Foodie")
    ));

    public List<Course> getAllCourses() {
        List<Course> tlist = new ArrayList<Course>();
        courseRepository.findAll().forEach(tlist::add);
        return tlist;
    }

    public Course getCourseById(String id) {
        System.out.println(courseRepository.findById(id).get());
        return courseList.stream().filter(t -> t.getcId().equals(id)).findFirst().get();
    }

    public void addCourse(Course course) {
        //System.out.println(topic.gettId() + " " + topic.gettName());

        courseRepository.save(course);
        //  System.out.println("Topic grasped");
    }

    public void updateCourse(String id, Course course) {
        courseRepository.save(course);
//        for (int i = 0; i < courseList.size(); i++) {
//            if (courseList.get(i).getcId().equals(id)) {
//                courseList.set(i, course);
//                return;
//            }
//        }
    }

    public void deleteCourse(String id) {
//        for (int i = 0; i < courseList.size(); i++) {
//            if (courseList.get(i).getcId().equals(id)) {
//                courseList.remove(i);
//                return;
//            }
//        }
        courseRepository.deleteById(id);
    }
}
