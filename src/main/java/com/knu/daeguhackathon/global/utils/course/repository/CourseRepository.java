package com.knu.daeguhackathon.global.utils.course.repository;

import com.knu.daeguhackathon.global.utils.course.Course;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("SELECT c FROM Course c WHERE c.courseName LIKE %:name%")
    List<Course> findAllByCourseNameContaining(@Param("name") String name);
}
