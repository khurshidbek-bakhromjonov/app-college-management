package org.college.controller;

import lombok.RequiredArgsConstructor;
import org.college.entity.College;
import org.college.exception.CollegeException;
import org.college.repository.CollegeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/colleges")
public class CollegeController {

    private final CollegeRepository collegeRepository;

    //API to save College with all Details
    @PostMapping
    public ResponseEntity<String> createCollege(@RequestBody College college) {
        collegeRepository.save(college);
        return ResponseEntity.ok("College details saved successfully....");
    }

    //API to get the List of College with all Details
    @GetMapping
    public ResponseEntity<List<College>> getAllColleges() {
        return new ResponseEntity<>(collegeRepository.findAll(), HttpStatus.OK);
    }

    //API to get the College details with Course Name
    @GetMapping("/{courseName}")
    public ResponseEntity<List<College>> getCollegeByCourseName(@PathVariable String courseName) throws CollegeException {
        return new ResponseEntity<>(collegeRepository.findByCourseName(courseName), HttpStatus.OK);
    }
}
