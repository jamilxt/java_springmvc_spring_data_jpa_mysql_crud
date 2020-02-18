package com.spring5.practice.controllers;

import com.spring5.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    UserService userService;

//    @GetMapping("/course/add")
//    public String getAddCoursePage(Model model) {
//        model.addAttribute("pageTitle", "Add Course");
//        model.addAttribute("course", new Course());
//        model.addAttribute("message", "Add a new Course");
//
//        return "course/add";
//
//    }
//
//    @PostMapping("/course/add")
//    public String addCourse(Model model, @ModelAttribute(name = "course") Course course) {
//        courseService.addCourse(course);
//        model.addAttribute("message", "Course added successfully");
//
//        return "redirect:/course/show-all";
//
//    }

    @GetMapping("/user/show-all")
    public String showAllUser(Model model) {
        model.addAttribute("pageTitle", "Users List");
        model.addAttribute("users", userService.showAll());
        model.addAttribute("message", "Showing all users...");

        return "/user/show-all";
    }

//    @GetMapping("/course/courses")
//    public String coursesPage(Model model) {
//
//        model.addAttribute("course_list", courseService.getAllCourses());
//        model.addAttribute("course", new Course());
//        model.addAttribute("message", "Showing all course...");
//
//        return "course/courses";
//
//    }
//
//    @GetMapping("/course/edit")
//    public String editCourseByCourseCode(Model model, @RequestParam("courseId") long courseId) {
//
//        model.addAttribute("pageTitle", "Edit Course");
//        model.addAttribute("course", courseService.getCourseByCourseId(courseId));
//        // model.addAttribute("course", new Course());
//
//        return "course/edit";
//    }

//    @PostMapping("/course/edit")
//    public String saveEditedCourse(Model model, @ModelAttribute(name = "course") Course course) {
//        courseService.saveEditedCourse(course);
//        model.addAttribute("message", "Course saved successfully");
//
//        return "redirect:/course/show-all";
//    }

//    @GetMapping("/course/delete")
//    public String deleteCourseByCourseCode(Model model, @RequestParam("courseCode") String courseCode) {
//
//        // courseService.deleteCourseByCourseCode(courseCode);
//        model.addAttribute("message", "Course deleted successfully");
//
//        return "redirect:/course/courses";
//    }

//    @PostMapping("/course/search")
//    public String searchCourseByCourseCode(Model model, @ModelAttribute(name = "course") Course course) {
//
//        var courseList = new ArrayList();
//        courseList.add(courseService.getCourseByCourseCode(course.getCourseCode()));
//        model.addAttribute("course_list", courseList);
//
//        return "course/courses";
//    }

}
