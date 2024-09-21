package com.knu.daeguhackathon.subject.repository;

import com.knu.daeguhackathon.member.Member;
import com.knu.daeguhackathon.subject.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

    List<Subject> findAllByMember(Member member);

    List<Subject> findAllByCourseName(String courseName);
}
