package com.spring5.practice.controllers;

import com.spring5.practice.model.Course;
import com.spring5.practice.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping("/course/add")
    public String getAddCoursePage(Model model) {
        model.addAttribute("pageTitle", "Add Course");
        model.addAttribute("course", new Course());
        model.addAttribute("message", "Add a new Course");

        return "course/add";

    }

    @PostMapping("/course/add")
    public String addCourse(Model model, @ModelAttribute(name = "course") Course course) {
        courseService.addCourse(course);
        model.addAttribute("message", "Course added successfully");

        return "redirect:/course/show-all";

    }

    @GetMapping("/course/edit")
    public String editCourseByCourseCode(Model model, @RequestParam("courseId") long courseId) {

        model.addAttribute("pageTitle", "Edit Course");
        model.addAttribute("course", courseService.getCourseByCourseId(courseId));

        return "course/edit";
    }

    @PostMapping("/course/edit")
    public String saveEditedCourse(Model model, @ModelAttribute(name = "course") Course course) {
        courseService.saveEditedCourse(course);
        model.addAttribute("message", "Course saved successfully");

        return "redirect:/course/show-all";
    }

    @GetMapping("/course/delete")
    public String deleteCourseByCourseID(Model model, @RequestParam("courseId") long courseId) {

        courseService.deleteCourse(courseId);
        model.addAttribute("message", "Course deleted successfully");

        return "redirect:/course/show-all";
    }

    @GetMapping("/course/show-all")
    public String showAllCourse(Model model) {
        model.addAttribute("pageTitle", "Course List");
        model.addAttribute("courses", courseService.getAllCourses());
        model.addAttribute("message", "Showing all course...");

        return "/course/show-all";
    }

    @PostMapping("/course/search")
    public String searchCourseByCourseCode(Model model, @ModelAttribute(name = "course") Course course) {

        var courseList = new ArrayList();
        courseList.add(courseService.getCourseByCourseCode(course.getCourseCode()));
        model.addAttribute("course_list", courseList);

        return "course/courses";
    }

}
