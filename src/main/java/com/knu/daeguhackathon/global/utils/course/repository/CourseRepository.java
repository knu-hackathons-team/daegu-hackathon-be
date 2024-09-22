package com.knu.daeguhackathon.global.utils.course.repository;

import com.knu.daeguhackathon.global.utils.course.Course;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findAllByCourseName(String name);

}
