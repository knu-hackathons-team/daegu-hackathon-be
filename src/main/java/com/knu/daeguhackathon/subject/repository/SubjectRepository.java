package com.knu.daeguhackathon.subject.repository;

import com.knu.daeguhackathon.subject.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
