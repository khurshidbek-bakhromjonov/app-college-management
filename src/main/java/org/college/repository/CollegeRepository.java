package org.college.repository;

import org.college.entity.College;
import org.college.exception.CollegeException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollegeRepository extends JpaRepository<College, Integer> {

    List<College> findByCourseName(String courseName) throws CollegeException;
}
